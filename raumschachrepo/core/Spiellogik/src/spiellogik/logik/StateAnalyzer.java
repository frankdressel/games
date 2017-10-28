package spiellogik.logik;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import architecture.IStateAnalyzer;

import raumschachmodell.figures.FigurProvider;
import spielfeld.Farbe;
import spielfeld.Figur;
import spielfeld.Jump;
import spielfeld.Koordinate;
import spielfeld.SpielfeldFactory;
import spielfeld.StraightLine;
import spiellogik.provider.SpielProvider;

/**
 * This class is responsible for finding possible moves according to the rules
 * and check, if one of the parties is in check (restricts the possible moves).
 * 
 * @author frank
 * 
 */
public final class StateAnalyzer extends EObjectImpl implements IStateAnalyzer{
    /**
     * Avoid instantiation.
     */
    public StateAnalyzer() {

    }

    /**
     * Iterates over all the possible attack moves of the figure and checks if
     * the move leads to a valid field.
     * 
     * @param figure
     *            The figure, which should be moved.
     * @param figures
     *            A {@link Collection} of {@link Figur}s, which should be used
     *            for analysing the current state of the game and find the
     *            possible moves for the given {@link Figur}.
     * @return The {@link List} of {@link Koordinate}s, which can be attacked by
     *         the given {@link Figur}.
     */
    public static List<Koordinate> iterateAttackMoves(final Figur figure,
            final Collection<Figur> figures) {

        // Get the coordinates.
        final Koordinate pos = figure.getPosition();
        final int ebene = pos.getEbene();
        final int buchstabe = pos.getBuchstabe();
        final int zahl = pos.getZahl();

        // The list of coordinates beeing attacked by this figure.
        final List<Koordinate> attackList = new ArrayList<Koordinate>();

        // Do the jumps.
        for (final Jump jump : figure.getZugsetAngriff().getJumps()) {
            final Koordinate koordinate = jump.getPosition();
            final int ebeneNew = ebene + koordinate.getEbene();
            final int buchstabeNew = buchstabe + koordinate.getBuchstabe();
            final int zahlNew = zahl + koordinate.getZahl();
            if (StateAnalyzer.withinBounds(ebeneNew, buchstabeNew, zahlNew)) {
                // Check, if there is a figure at the field.
                final Figur fig = StateAnalyzer.checkFigure(ebeneNew,
                        buchstabeNew, zahlNew, figures);
                // Can it be attacked?
                if (fig != null && fig.getFarbe() != figure.getFarbe()) {
                    // Create a new Koordinate for the target field.
                    final Koordinate possible = SpielfeldFactory.eINSTANCE
                            .createKoordinate();
                    possible.setEbene(ebeneNew);
                    possible.setBuchstabe(buchstabeNew);
                    possible.setZahl(zahlNew);

                    // Store the move in the list.
                    attackList.add(possible);
                }
            }
        }

        // Do the straight lines.
        for (final StraightLine line : figure.getZugsetAngriff()
                .getStraightLine()) {
            // Iterate over all the fields of the straight line.
            for (int i = 1; i <= line.getMaxDist(); i++) {
                // The coordinates of the target move.
                final int ebeneNew = ebene + line.getPosition().getEbene() * i;
                final int buchstabeNew = buchstabe
                        + line.getPosition().getBuchstabe() * i;
                final int zahlNew = zahl + line.getPosition().getZahl() * i;
                // Check, if the move is valid.
                if (StateAnalyzer.withinBounds(ebeneNew, buchstabeNew, zahlNew)) {
                    // Check, if there is a figure at the field.
                    final Figur fig = StateAnalyzer.checkFigure(ebeneNew,
                            buchstabeNew, zahlNew, figures);
                    // Can it be attacked?
                    if (fig != null) {
                        if (fig.getFarbe() != figure.getFarbe()) {
                            // Create a new Koordinate for the target field.
                            final Koordinate possible = SpielfeldFactory.eINSTANCE
                                    .createKoordinate();
                            possible.setEbene(ebeneNew);
                            possible.setBuchstabe(buchstabeNew);
                            possible.setZahl(zahlNew);

                            // Store the move in the list.
                            attackList.add(possible);
                        }
                        // Stop the move here.
                        break;
                    }
                }
            }
        }

        return attackList;
    }

    /**
     * Checks, if the given coordinates are within the bounds of the board.
     * 
     * @param ebeneNew
     *            The new ebene-coordinate.
     * @param buchstabeNew
     *            The new buchstabe-coordinate.
     * @param zahlNew
     *            The new zahl-coordinate.
     * @return True, if the given coordinate is within the board bounds (that is
     *         between 0 and 4, inclusively).
     */
    private static boolean withinBounds(final int ebeneNew,
            final int buchstabeNew, final int zahlNew) {
        return ebeneNew >= 0 && ebeneNew < 5 && buchstabeNew >= 0
                && buchstabeNew < 5 && zahlNew >= 0 && zahlNew < 5;
    }

    /**
     * Iterates over all the possible normal moves of the figure and checks if
     * the move leads to a valid field.
     * 
     * @param figure
     *            The figure, which should be moved.
     * @return The {@link List} of {@link Koordinate}s, which are valid move
     *         targets for the given {@link Figur}.
     */
    static List<Koordinate> iterateNormalMoves(final Figur figure) {
        // Get the coordinates.
        final Koordinate pos = figure.getPosition();
        final int ebene = pos.getEbene();
        final int buchstabe = pos.getBuchstabe();
        final int zahl = pos.getZahl();

        // The list of coordinates where this figure can be moved to.
        final List<Koordinate> moveList = new ArrayList<Koordinate>();

        // Do the jumps.
        for (final Jump jump : figure.getZugsetNormal().getJumps()) {
            final Koordinate koordinate = jump.getPosition();
            final int ebeneNew = ebene + koordinate.getEbene();
            final int buchstabeNew = buchstabe + koordinate.getBuchstabe();
            final int zahlNew = zahl + koordinate.getZahl();
            if (StateAnalyzer.withinBounds(ebeneNew, buchstabeNew, zahlNew)) {
                // Check, if there is a figure at the field.
                final Figur fig = StateAnalyzer
                        .checkFigure(ebeneNew, buchstabeNew, zahlNew,
                                SpielProvider.spiel.getFigures());
                // The field is not empty, stop the line move.
                if (fig != null) {
                    continue;
                }
                // If there is no figure at the given position, add the
                // field to the move list.
                StateAnalyzer.addToMoveListIfEmpty(moveList, ebeneNew,
                        buchstabeNew, zahlNew);
            }
        }

        // Do the straight lines.
        for (final StraightLine line : figure.getZugsetNormal()
                .getStraightLine()) {
            // Iterate over all the fields of the straight line.
            for (int i = 1; i <= line.getMaxDist(); i++) {
                // The coordinates of the target move.
                final int ebeneNew = ebene + line.getPosition().getEbene() * i;
                final int buchstabeNew = buchstabe
                        + line.getPosition().getBuchstabe() * i;
                final int zahlNew = zahl + line.getPosition().getZahl() * i;
                if (StateAnalyzer.withinBounds(ebeneNew, buchstabeNew, zahlNew)) {
                    // Check, if there is a figure at the field.
                    final Figur fig = StateAnalyzer.checkFigure(ebeneNew,
                            buchstabeNew, zahlNew,
                            SpielProvider.spiel.getFigures());
                    // The field is not empty, stop the line move.
                    if (fig != null) {
                        break;
                    }
                    // If there is no figure at the given position, add
                    // the field to the move list.
                    StateAnalyzer.addToMoveListIfEmpty(moveList, ebeneNew,
                            buchstabeNew, zahlNew);
                }
            }
        }
        return moveList;
    }

    /**
     * Checks, if there is no figure at the given position (null) and if yes,
     * adds the field to the move list.
     * 
     * @param moveList
     *            The list of {@link Koordinate}s, which are valid move targets
     *            for the given {@link Figur}.
     * @param ebeneNew
     *            The new ebene-coordinate.
     * @param buchstabeNew
     *            The new buchstabe-coordinate.
     * @param zahlNew
     *            The new zahl-coordinate.
     */
    private static void addToMoveListIfEmpty(final List<Koordinate> moveList,
            final int ebeneNew, final int buchstabeNew, final int zahlNew) {
        // Is the field empty?
        // Create a new Koordinate for the target field.
        final Koordinate possible = SpielfeldFactory.eINSTANCE
                .createKoordinate();
        possible.setEbene(ebeneNew);
        possible.setBuchstabe(buchstabeNew);
        possible.setZahl(zahlNew);

        // Store the move in the list.
        moveList.add(possible);
    }

    /**
     * Checks, if there is a figure at the given position.
     * 
     * @param ebene
     *            The ebene-coordinate.
     * @param buchstabe
     *            The buchstabe-coordinate.
     * @param zahl
     *            The zahl-coordinate.
     * @param figures
     *            A {@link Collection} of {@link Figur}s, which should be used
     *            for analysing the current state of the game and find the
     *            possible moves for the given {@link Figur}.
     * @return The {@link Figur} at the given position or null if there is no
     *         {@link Figur} at the given position.
     */
    static Figur checkFigure(final int ebene, final int buchstabe,
            final int zahl, final Collection<Figur> figures) {
        // Check, if there is a figure at the field.
        for (final Figur other : figures) {
            // Is the figure active?
            if (!other.isActive()) {
                continue;
            }
            // The position.
            final Koordinate othersKoord = other.getPosition();
            if (othersKoord.getEbene() == ebene
                    && othersKoord.getBuchstabe() == buchstabe
                    && othersKoord.getZahl() == zahl) {
                return other;
            }
        }
        return null;
    }

    /**
     * Checks, if the king of a given {@link Farbe} is attacked by someone.
     * 
     * @param farbe
     *            The {@link Farbe}, for which the check should be checked.
     * @param figures
     *            A {@link List} of {@link Figur}s, which should be used for
     *            analysing the current state of the game and find the possible
     *            moves for the given {@link Figur}.
     * @return True, if the king is attacked.
     */
    static boolean isCheck(final Farbe farbe, final List<Figur> figures) {
        // Status.
        Logger.getLogger(log.Activator.LOGGERNAME).log(Level.FINEST,
                "Start checking for check");
        // Get the king.
        final Figur king = farbe == Farbe.GRAU ? FigurProvider.findFigur(
                figures, "020") : FigurProvider
                .findFigur(figures, "424");

        // The position of the king.
        final Koordinate kingPosition = king.getPosition();

        // Iterate over all figures.
        for (final Figur figur : figures) {
            // Check for opponent and active figures.
            if (figur.getFarbe() != farbe && figur.isActive()) {
                // Check the attack moves.
                final List<Koordinate> attackMoves = StateAnalyzer
                        .iterateAttackMoves(figur, figures);
                for (final Koordinate koordinate : attackMoves) {
                    if (koordinate.getEbene() == kingPosition.getEbene()
                            && koordinate.getBuchstabe() == kingPosition
                                    .getBuchstabe()
                            && koordinate.getZahl() == kingPosition.getZahl()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Counts the number of controlled fields for both {@link Farbe}n and
     * returns the corresponding number.
     * 
     * @return The strength for the two {@link Farbe}n. The key for the
     *         {@link Map} is the {@link Farbe} and the value is the strength.
     */
    @Override
    public Map<Farbe, Integer> analyzeStrength() {
        // Create a map, which maps for each color a map of controlled fields
        // (Koordinaten).
        final Map<Farbe, Set<Koordinate>> controlledBy = new HashMap<Farbe, Set<Koordinate>>();
        controlledBy.put(Farbe.ORANGE, new HashSet<Koordinate>());
        controlledBy.put(Farbe.GRAU, new HashSet<Koordinate>());
        // Run over all the figures and assign the controlled fields.
        for (final Figur figur : SpielProvider.spiel.getFigures()) {
            controlledBy.get(figur.getFarbe()).addAll(
                    StateAnalyzer.iterateAttackMoves(figur,
                            SpielProvider.spiel.getFigures()));
            controlledBy.get(figur.getFarbe()).addAll(
                    StateAnalyzer.iterateNormalMoves(figur));
        }

        final Map<Farbe, Integer> result = new HashMap<Farbe, Integer>();
        result.put(Farbe.ORANGE, controlledBy.get(Farbe.ORANGE).size());
        result.put(Farbe.GRAU, controlledBy.get(Farbe.GRAU).size());

        return result;
    }

    /**
     * This method checks, if the king or another figure can be moved in such a
     * way, that the check is resolved.
     * 
     * @param farbe
     *            The {@link Farbe}, for which the check should be checked.
     * @return True, if the check can be resolved.
     */
    public static boolean canCheckBeResolved(final Farbe farbe) {
        // Status.
        Logger.getLogger(log.Activator.LOGGERNAME).log(Level.FINEST,
                "Start checking for check resolving");
        // Test the moves of the figures.
        for (final Figur figur : SpielProvider.spiel.getFigures()) {
            // Check for active figures.
            if (figur.getFarbe() == farbe && figur.isActive()) {
                // There are moves.
                for (final Koordinate target : StateAnalyzer
                        .iterateAttackMoves(figur,
                                SpielProvider.spiel.getFigures())) {
                    final List<Figur> copied = SpielProvider.spiel.createCopy();
                    // Simulate the taking out of the attacked figure.
                    final Figur toBeTakenOut = StateAnalyzer.checkFigure(
                            target.getEbene(), target.getBuchstabe(),
                            target.getZahl(), copied);
                    toBeTakenOut.setActive(false);
                    FigurProvider.findFigur(copied, figur.getId()).setPosition(
                            target);
                    if (!StateAnalyzer.isCheck(farbe, copied)) {
                        return true;
                    }
                }
                // There are moves.
                for (final Koordinate target : StateAnalyzer
                        .iterateNormalMoves(figur)) {
                    final List<Figur> copied = SpielProvider.spiel.createCopy();
                    FigurProvider.findFigur(copied, figur.getId()).setPosition(
                            target);
                    if (!StateAnalyzer.isCheck(farbe, copied)) {
                        return true;
                    }
                }
            }
        }
        // No valid move found: Check can not be resolved.
        return false;
    }
}
