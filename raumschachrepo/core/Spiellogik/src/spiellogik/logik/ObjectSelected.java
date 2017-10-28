package spiellogik.logik;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.impl.EReferenceImpl;

import raumschachmodell.figures.FigurProvider;
import raumschachmodell.modell.Spiel;
import raumschachmodell.modell.Spieler;
import raumschachmodell.modell.State;
import spielfeld.Farbe;
import spielfeld.Field;
import spielfeld.Figur;
import spielfeld.Koordinate;
import spielfeld.SpielfeldFactory;
import spielfeld.Zug;
import spiellogik.provider.SpielProvider;

/**
 * A listener to react to selection events on a given {@link ViewBrett}.
 * 
 * @author frank
 * 
 */
public class ObjectSelected {

    /**
     * The {@link StateAnalyzer} used.
     */
    private final StateAnalyzer stateanalyzer;

    /**
     * Creates a new {@link ObjectSelected} object, which is listening for
     * selection events on the underlying {@link Spiel}.
     * 
     * @param spiel
     *            The {@link Spiel}, for which selection events should be
     *            processed.
     */
    public ObjectSelected(final Spiel spiel) {
        // Create a new StateAnalyzer.
        this.stateanalyzer = new StateAnalyzer();
        // Run over all the figures and attach a listener.
        for (final Figur figur : spiel.getFigures()) {
            figur.eAdapters().add(new AdapterImpl() {
                @Override
                public void notifyChanged(final Notification msg) {
                    if (msg.getFeature() instanceof EAttribute) {
                        final EAttribute attrib = (EAttribute) msg.getFeature();
                        if (attrib.getName().equalsIgnoreCase("selected")
                                && msg.getNewBooleanValue()) {
                            ObjectSelected.this.processFigure(figur);
                            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(
                                    "Selected: " + figur);
                        } else {
                            ObjectSelected.this.unhighlightFields();
                        }
                    }
                    // The figure was moved, create a new Zug.
                    if (msg.getFeature() instanceof EReferenceImpl) {
                        final EReferenceImpl attrib = (EReferenceImpl) msg
                                .getFeature();
                        if (attrib.getName().equalsIgnoreCase("position")
                                && figur.isActive()) {
                            final Zug zug = SpielfeldFactory.eINSTANCE
                                    .createZug();
                            zug.setFigur(figur);
                            zug.setStartPosition((Koordinate) msg.getOldValue());
                            zug.setEndPosition((Koordinate) msg.getNewValue());
                            // Add the zug.
                            spiel.getZuege().add(zug);
                        }
                    }
                }
            });
        }
        // Run over all the fields and attach a listener.
        for (final Field field : spiel.getFields()) {
            field.eAdapters().add(new AdapterImpl() {
                @Override
                public void notifyChanged(final Notification msg) {
                    if (msg.getFeature() instanceof EAttribute) {
                        final EAttribute attrib = (EAttribute) msg.getFeature();
                        if (attrib.getName().equalsIgnoreCase("selected")
                                && msg.getNewBooleanValue()) {
                            ObjectSelected.this.processField(field);
                            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(
                                    "Selected: " + field);
                            field.setSelected(false);
                        }
                    }
                }
            });
        }
    }

    /**
     * Processes the selection of a {@link Figur}.
     * 
     * @param figur
     *            The selected {@link Figur}.
     */
    private void processFigure(final Figur figur) {
        final Figur previous = this.getSelectedOtherThan(figur);
        // Try to attack.
        boolean attackedsucessful = false;
        if (previous != null) {
            attackedsucessful = this.attackFigureIfPossible(previous, figur);
        }
        // Unselect previous.
        this.unselectOtherThan(figur);
        this.unhighlightFields();

        // If the selected figure was attacked sucessfully, it was also moved.
        // Thus, no further processing is needed.
        if (attackedsucessful) {
            return;
        }

        // There is no figure selected and the clicked figure has not the active
        // color.
        if (figur.getFarbe() != SpielProvider.spiel.getActive()) {
            return;
        }

        // Iterate the normal moves.
        final List<Koordinate> moveList = StateAnalyzer
                .iterateNormalMoves(figur);
        // Iterate over the list, highlight the fields and put the fields in the
        // list of possible target moves.
        for (final Koordinate koordinate : moveList) {

            final List<Figur> copied = SpielProvider.spiel.createCopy();
            final Figur selected = this.getSelected(SpielProvider.spiel);
            FigurProvider.findFigur(copied, selected.getId()).setPosition(
                    koordinate);
            if (StateAnalyzer.isCheck(SpielProvider.spiel.getActive(), copied)) {
                continue;
            }

            // Highlight the field.
            FigurProvider
                    .findField(SpielProvider.spiel.getFields(), koordinate)
                    .setPossible(true);
        }

        // Get the attack moves.
        final List<Koordinate> attackList = StateAnalyzer.iterateAttackMoves(
                figur, SpielProvider.spiel.getFigures());
        // Iterate over the list, highlight the fields and put the fields in the
        // list of possible target moves.
        for (final Koordinate koordinate : attackList) {
            // Get a copy of the actual figures with the respective positions
            // and states.
            final List<Figur> copied = SpielProvider.spiel.createCopy();
            // Simulate the taking out of the attacked figure.
            final Figur toBeTakenOut = StateAnalyzer.checkFigure(
                    koordinate.getEbene(), koordinate.getBuchstabe(),
                    koordinate.getZahl(), copied);
            toBeTakenOut.setActive(false);
            // Move the selected figure.
            FigurProvider.findFigur(copied,
                    this.getSelected(SpielProvider.spiel).getId()).setPosition(
                    koordinate);
            // Check for check.
            if (StateAnalyzer.isCheck(SpielProvider.spiel.getActive(), copied)) {
                continue;
            }

            // Highlight the field.
            FigurProvider
                    .findField(SpielProvider.spiel.getFields(), koordinate)
                    .setAttackable(true);
        }
    }

    /**
     * Returns <b>the first found</b> {@link Figur} which is selected and not
     * the given one.
     * 
     * @param figur
     *            The {@link Figur} which may be selected but should not be
     *            taken into account.
     * @return The first found {@link Figur} which is selected and not the given
     *         one.
     */
    private Figur getSelectedOtherThan(final Figur figur) {
        for (final Figur f : SpielProvider.spiel.getFigures()) {
            if (f != figur && f.isSelected()) {
                return f;
            }
        }
        return null;
    }

    /**
     * Select everything than the given {@link Figur}.
     * 
     * @param figur
     *            The figure, for which the selected flag should not be set to
     *            false. <b>Keep in mind: Maybe, it is already false.</b>
     */
    private void unselectOtherThan(final Figur figur) {
        for (final Figur f : SpielProvider.spiel.getFigures()) {
            if (f != figur && f.isSelected()) {
                f.setSelected(false);
            }
        }
    }

    /**
     * Returns the selected figure.
     * 
     * @param spiel
     *            The actual {@link Spiel}
     * @return The selected {@link Figur} or null, if there is no such
     *         {@link Figur}.
     */
    private Figur getSelected(final Spiel spiel) {
        for (final Figur f : spiel.getFigures()) {
            if (f.isSelected()) {
                return f;
            }
        }
        return null;
    }

    /**
     * Sets the highlight status of all fields to false.
     */
    private void unhighlightFields() {
        // Get the fields.
        final Collection<Field> fields = SpielProvider.spiel.getFields();
        // Unhighlight.
        for (final Field field : fields) {
            if (field.isAttackable()) {
                field.setAttackable(false);
            }
            if (field.isPossible()) {
                field.setPossible(false);
            }
        }
    }

    /**
     * Attacks a figure if possible. This means: Move the active figure, set the
     * active flag of the attacked figure to false, do a figure reset and switch
     * the active color.
     * 
     * @param attackWith
     *            The {@link Figur}, which attacks.
     * @param attackMe
     *            The {@link Figur}, which is attacked (possibly).
     * @return True, if the figure could be attacked.
     */
    private boolean attackFigureIfPossible(final Figur attackWith,
            final Figur attackMe) {
        // Check, if the figure can be attacked.
        if (attackWith.getFarbe() != attackMe.getFarbe()) {
            // The selected field.
            final Field field = FigurProvider.findField(
                    SpielProvider.spiel.getFields(), attackMe.getPosition());
            // Is the selected field in the list of possible moves?
            if (field.isAttackable()) {
                attackMe.setActive(false);
                this.moveFigureAndReset(attackWith, field);
                return true;
            }
        }
        return false;
    }

    /**
     * Moves the given {@link Figur} to the given {@link Field}, switchs the
     * activity flag of the game, unhighlights all fields and deselects the
     * {@link Figur}.
     * 
     * @param moveMe
     *            The {@link Figur}, which should be moved.
     * @param field
     *            The {@link Field}, at which the selected {@link Figur} should
     *            be moved.
     */
    private void moveFigureAndReset(final Figur moveMe, final Field field) {
        // Move the figure.
        final Koordinate newPos = SpielfeldFactory.eINSTANCE.createKoordinate();
        newPos.setEbene(field.getPosition().getEbene());
        newPos.setBuchstabe(field.getPosition().getBuchstabe());
        newPos.setZahl(field.getPosition().getZahl());
        moveMe.setPosition(newPos);

        this.switchActive();
        // Reset the checker board.
        this.unhighlightFields();
        // Reset the figure.
        moveMe.setSelected(false);
    }

    /**
     * Processes the selection of a given field. This can be a normal move or an
     * attack move, if another {@link Figur} is standing at the selected field.
     * 
     * @param field
     *            The {@link Field}, which is selected.
     */
    private void processField(final Field field) {
        // Is the selected field in the list of possible moves?
        if (field.isPossible() || field.isAttackable()) {
            // Search other figures at the selected coordinate.
            for (final Figur figure : SpielProvider.spiel.getFigures()) {
                if (figure.getPosition().equals(field.getPosition())) {
                    if (this.attackFigureIfPossible(
                            this.getSelected(SpielProvider.spiel), figure)) {
                        return;
                    }
                }
            }
            this.moveFigureAndReset(this.getSelected(SpielProvider.spiel),
                    field);
        }
    }

    /**
     * Switches the active player color from black to white and the other way
     * around.
     */
    private void switchActive() {
        // Count for both colors the number of controlled fields.
        this.stateanalyzer.analyzeStrength();
        // Switch the active flag.
        if (SpielProvider.spiel.getActive() == Farbe.GRAU) {
            SpielProvider.spiel.setActive(Farbe.ORANGE);
        } else {
            SpielProvider.spiel.setActive(Farbe.GRAU);
        }

        this.setStateFlag();
    }

    /**
     * Checks, if a {@link Spieler} is in chess/remis/matt and sets the flags
     * accoringly.
     */
    private void setStateFlag() {
        // Get the player.
        final Spieler spieler = this.getPlayerForColor(SpielProvider.spiel
                .getActive());
        // Check for check.
        if (StateAnalyzer.isCheck(SpielProvider.spiel.getActive(),
                SpielProvider.spiel.getFigures())) {
            // Set the chess flag.
            spieler.setState(State.SCHACH);
            // Game over?
            if (!StateAnalyzer.canCheckBeResolved(SpielProvider.spiel
                    .getActive())) {
                // Set the matt flag.
                spieler.setState(State.MATT);
                return;
            }
            return;
        }
        // Remis?
        if (!StateAnalyzer.canCheckBeResolved(SpielProvider.spiel.getActive())) {
            // Set the remis flag.
            spieler.setState(State.REMIS);
            return;
        }
        // Set the status to ok.
        spieler.setState(State.OK);
    }

    /**
     * Returns the {@link Spieler} for the actual {@link Farbe}.
     * 
     * @param farbe
     *            The {@link Farbe}, for which the player should be searched.
     * @return The {@link Spieler} with the given {@link Farbe}.
     */
    private Spieler getPlayerForColor(final Farbe farbe) {
        final List<Spieler> spielerListe = SpielProvider.spiel.getSpieler();
        for (final Spieler sp : spielerListe) {
            if (sp.getFarbe() == farbe || sp.getFarbe() == Farbe.BEIDE) {
                return sp;
            }
        }
        assert false : "There is no player found for: " + farbe;
        return null;
    }
}
