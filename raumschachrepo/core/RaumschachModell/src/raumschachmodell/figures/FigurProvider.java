package raumschachmodell.figures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import raumschachmodell.Messages;
import raumschachmodell.modell.Spiel;
import spielfeld.Farbe;
import spielfeld.Field;
import spielfeld.Figur;
import spielfeld.Jump;
import spielfeld.Koordinate;
import spielfeld.SpielfeldFactory;
import spielfeld.StraightLine;
import spielfeld.Zugset;

/**
 * This class provides access to the {@link Figur} instances, which are used in
 * the game.
 * 
 * @author frank
 * 
 */
public class FigurProvider {
    /**
     * Creates all the possible moves for the white pawn.
     * 
     * @return The {@link Zugset} for the white pawn.
     */
    private static Zugset createNormalZugSetForWhitePawn() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the move Zugset.
         */
        final Zugset pawnBlackNormalZugSet = factory.createZugset();
        // Normal forward move.
        final StraightLine forward = factory.createStraightLine();
        forward.setMaxDist(1);
        forward.setPosition(FigurProvider.createKoordinate(0, 0, 1));
        pawnBlackNormalZugSet.getStraightLine().add(forward);
        // Normal downward move.
        final StraightLine downward = factory.createStraightLine();
        downward.setMaxDist(1);
        downward.setPosition(FigurProvider.createKoordinate(0, 1, 0));
        pawnBlackNormalZugSet.getStraightLine().add(downward);

        return pawnBlackNormalZugSet;
    }

    /**
     * Creates all the possible attack moves for the white pawn.
     * 
     * @return The attack {@link Zugset} for the white pawn.
     */
    private static Zugset createOffensiveZugSetForWhitePawn() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the offensive Zugset.
         */
        final Zugset pawnBlackOffensiveZugSet = factory.createZugset();
        // Forward left move.
        final StraightLine forwardLeft = factory.createStraightLine();
        forwardLeft.setMaxDist(1);
        forwardLeft.setPosition(FigurProvider.createKoordinate(-1, 1, 0));
        pawnBlackOffensiveZugSet.getStraightLine().add(forwardLeft);
        // Forward right move.
        final StraightLine forwardRight = factory.createStraightLine();
        forwardRight.setMaxDist(1);
        forwardRight.setPosition(FigurProvider.createKoordinate(0, 1, 1));
        pawnBlackOffensiveZugSet.getStraightLine().add(forwardRight);
        // Downward forward move.
        final StraightLine downwardForward = factory.createStraightLine();
        downwardForward.setMaxDist(1);
        downwardForward.setPosition(FigurProvider.createKoordinate(1, 1, 0));
        pawnBlackOffensiveZugSet.getStraightLine().add(downwardForward);
        // Downward left move.
        final StraightLine downwardLeft = factory.createStraightLine();
        downwardLeft.setMaxDist(1);
        downwardLeft.setPosition(FigurProvider.createKoordinate(1, 0, 1));
        pawnBlackOffensiveZugSet.getStraightLine().add(downwardLeft);
        // Downward right move.
        final StraightLine downwardRight = factory.createStraightLine();
        downwardRight.setMaxDist(1);
        downwardRight.setPosition(FigurProvider.createKoordinate(-1, 0, 1));
        pawnBlackOffensiveZugSet.getStraightLine().add(downwardRight);

        return pawnBlackOffensiveZugSet;
    }

    /**
     * Creates all the possible moves for the black pawn.
     * 
     * @return The {@link Zugset} for the black pawn.
     */
    private static Zugset createNormalZugSetForBlackPawn() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the move Zugset.
         */
        final Zugset pawnBlackNormalZugSet = factory.createZugset();
        // Normal forward move.
        final StraightLine forward = factory.createStraightLine();
        forward.setMaxDist(1);
        forward.setPosition(FigurProvider.createKoordinate(0, 0, -1));
        pawnBlackNormalZugSet.getStraightLine().add(forward);
        // Normal downward move.
        final StraightLine downward = factory.createStraightLine();
        downward.setMaxDist(1);
        downward.setPosition(FigurProvider.createKoordinate(0, -1, 0));
        pawnBlackNormalZugSet.getStraightLine().add(downward);

        return pawnBlackNormalZugSet;
    }

    /**
     * Creates all the possible attack moves for the black pawn.
     * 
     * @return The attack {@link Zugset} for the black pawn.
     */
    private static Zugset createOffensiveZugSetForBlackPawn() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the offensive Zugset.
         */
        final Zugset pawnBlackOffensiveZugSet = factory.createZugset();
        // Forward left move.
        final StraightLine forwardLeft = factory.createStraightLine();
        forwardLeft.setMaxDist(1);
        forwardLeft.setPosition(FigurProvider.createKoordinate(-1, 0, -1));
        pawnBlackOffensiveZugSet.getStraightLine().add(forwardLeft);
        // Forward right move.
        final StraightLine forwardRight = factory.createStraightLine();
        forwardRight.setMaxDist(1);
        forwardRight.setPosition(FigurProvider.createKoordinate(1, 0, -1));
        pawnBlackOffensiveZugSet.getStraightLine().add(forwardRight);
        // Downward forward move.
        final StraightLine downwardForward = factory.createStraightLine();
        downwardForward.setMaxDist(1);
        downwardForward.setPosition(FigurProvider.createKoordinate(1, -1, 0));
        pawnBlackOffensiveZugSet.getStraightLine().add(downwardForward);
        // Downward left move.
        final StraightLine downwardLeft = factory.createStraightLine();
        downwardLeft.setMaxDist(1);
        downwardLeft.setPosition(FigurProvider.createKoordinate(-1, -1, 0));
        pawnBlackOffensiveZugSet.getStraightLine().add(downwardLeft);
        // Downward right move.
        final StraightLine downwardRight = factory.createStraightLine();
        downwardRight.setMaxDist(1);
        downwardRight.setPosition(FigurProvider.createKoordinate(0, -1, -1));
        pawnBlackOffensiveZugSet.getStraightLine().add(downwardRight);

        return pawnBlackOffensiveZugSet;
    }

    /**
     * Set up the game, which means: Create all the figures, assign names, ids,
     * positions, ...
     */
    public static void initialGameSetting(final Spiel spiel) {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        // The possible offensive moves for a black pawn.
        final Zugset pawnBlackOffensiveZugSet = createOffensiveZugSetForBlackPawn();
        // The possible normal moves for a black pawn.
        final Zugset pawnBlackNormalZugSet = createNormalZugSetForBlackPawn();
        // The possible offensive moves for a white pawn.
        final Zugset pawnWhiteOffensiveZugSet = createOffensiveZugSetForWhitePawn();
        // The possible normal moves for a white pawn.
        final Zugset pawnWhiteNormalZugSet = createNormalZugSetForWhitePawn();

        /*
         * The pawns.
         */
        // The black pawns.
        for (int i = 4; i > 2; i--) {
            for (int j = 0; j < 5; j++) {
                // Create a figur.
                final Figur blackPawn = factory.createFigur();
                // Add the figure to the figure array.
                spiel.getFigures().add(blackPawn);
                initFigure(blackPawn,Messages.blackPawn, Farbe.ORANGE, i, j,
                        3, spiel);
                // Add the zugsets.
                blackPawn.setZugsetAngriff(pawnBlackOffensiveZugSet);
                blackPawn.setZugsetNormal(pawnBlackNormalZugSet);
            }
        }

        // The white pawns.
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                // Create a figur.
                final Figur whitePawn = factory.createFigur();
                // Add the figure to the figure array.
                spiel.getFigures().add(whitePawn);
                initFigure(whitePawn,Messages.whitePawn, Farbe.GRAU, i, j, 1,
                        spiel);
                // Add the zugsets.
                whitePawn.setZugsetAngriff(pawnWhiteOffensiveZugSet);
                whitePawn.setZugsetNormal(pawnWhiteNormalZugSet);
            }
        }

        /*
         * The black castles.
         */
        // Create a figur.
        final Figur blackCastle1 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackCastle1);
        initFigure(blackCastle1,Messages.blackCastle, Farbe.ORANGE, 4, 0, 4,
                spiel);
        // Add the zugsets.
        final Zugset castleZugset = createCastleZugset();
        blackCastle1.setZugsetAngriff(castleZugset);
        blackCastle1.setZugsetNormal(castleZugset);

        // Create a figur.
        final Figur blackCastle2 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackCastle2);
        initFigure(blackCastle2,Messages.blackCastle, Farbe.ORANGE, 4, 4, 4,
                spiel);
        // Add the zugsets.
        blackCastle2.setZugsetAngriff(castleZugset);
        blackCastle2.setZugsetNormal(castleZugset);

        /*
         * The white castles.
         */
        // Create a figur.
        final Figur whiteCastle1 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteCastle1);
        initFigure(whiteCastle1,Messages.whiteCastle, Farbe.GRAU, 0, 0, 0,
                spiel);
        // Add the zugsets.
        whiteCastle1.setZugsetAngriff(castleZugset);
        whiteCastle1.setZugsetNormal(castleZugset);

        // Create a figur.
        final Figur whiteCastle2 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteCastle2);
        initFigure(whiteCastle2,Messages.whiteCastle, Farbe.GRAU, 0, 4, 0,
                spiel);
        // Add the zugsets.
        whiteCastle2.setZugsetAngriff(castleZugset);
        whiteCastle2.setZugsetNormal(castleZugset);

        /*
         * The white bishops.
         */
        // Create a figur.
        final Figur whiteBishop1 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteBishop1);
        initFigure(whiteBishop1,Messages.whiteBishop, Farbe.GRAU, 1, 1, 0,
                spiel);
        // Add the zugsets.
        final Zugset bishopZugset = createBishopZugset();
        whiteBishop1.setZugsetAngriff(bishopZugset);
        whiteBishop1.setZugsetNormal(bishopZugset);

        // Create a figur.
        final Figur whiteBishop2 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteBishop2);
        initFigure(whiteBishop2,Messages.whiteBishop, Farbe.GRAU, 1, 4, 0,
                spiel);
        // Add the zugsets.
        whiteBishop2.setZugsetAngriff(bishopZugset);
        whiteBishop2.setZugsetNormal(bishopZugset);

        /*
         * The black bishops.
         */
        // Create a figur.
        final Figur blackBishop1 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackBishop1);
        initFigure(blackBishop1,Messages.blackBishop, Farbe.ORANGE, 3, 1, 4,
                spiel);
        // Add the zugsets.
        blackBishop1.setZugsetAngriff(bishopZugset);
        blackBishop1.setZugsetNormal(bishopZugset);

        // Create a figur.
        final Figur blackBishop2 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackBishop2);
        initFigure(blackBishop2,Messages.blackBishop, Farbe.ORANGE, 3, 4, 4,
                spiel);
        // Add the zugsets.
        blackBishop2.setZugsetAngriff(bishopZugset);
        blackBishop2.setZugsetNormal(bishopZugset);

        /*
         * The white queen.
         */
        // Create a figur.
        final Figur whiteQueen = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteQueen);
        initFigure(whiteQueen,Messages.whiteQueen, Farbe.GRAU, 1, 2, 0,
                spiel);
        // Add the zugsets.
        final Zugset queenZugset = createQueenZugset();
        whiteQueen.setZugsetAngriff(queenZugset);
        whiteQueen.setZugsetNormal(queenZugset);

        /*
         * The black queen.
         */
        // Create a figur.
        final Figur blackQueen = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackQueen);
        initFigure(blackQueen,Messages.blackQueen, Farbe.ORANGE, 3, 2, 4,
                spiel);
        // Add the zugsets.
        blackQueen.setZugsetAngriff(queenZugset);
        blackQueen.setZugsetNormal(queenZugset);

        /*
         * The white king.
         */
        // Create a figur.
        final Figur whiteKing = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteKing);
        initFigure(whiteKing,Messages.whiteKing, Farbe.GRAU, 0, 2, 0,
                spiel);
        // Add the zugsets.
        final Zugset kingZugset = createKingZugset();
        whiteKing.setZugsetAngriff(kingZugset);
        whiteKing.setZugsetNormal(kingZugset);

        /*
         * The black king.
         */
        // Create a figur.
        final Figur blackKing = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackKing);
        initFigure(blackKing,Messages.blackKing, Farbe.ORANGE, 4, 2, 4,
                spiel);
        // Add the zugsets.
        blackKing.setZugsetAngriff(kingZugset);
        blackKing.setZugsetNormal(kingZugset);

        /*
         * The white knights.
         */
        // Create a figur.
        final Figur whiteKnight1 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteKnight1);
        initFigure(whiteKnight1,Messages.whiteKnight, Farbe.GRAU, 0, 1, 0,
                spiel);
        // Add the zugsets.
        final Zugset knightZugset = createKnightZugset();
        whiteKnight1.setZugsetAngriff(knightZugset);
        whiteKnight1.setZugsetNormal(knightZugset);

        // Create a figur.
        final Figur whiteKnight2 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteKnight2);
        initFigure(whiteKnight2,Messages.whiteKnight, Farbe.GRAU, 0, 3, 0,
                spiel);
        // Add the zugsets.
        whiteKnight2.setZugsetAngriff(knightZugset);
        whiteKnight2.setZugsetNormal(knightZugset);

        /*
         * The black knights.
         */
        // Create a figur.
        final Figur blackKnight1 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackKnight1);
        initFigure(blackKnight1,Messages.blackKnight, Farbe.ORANGE, 4, 1, 4,
                spiel);
        // Add the zugsets.
        blackKnight1.setZugsetAngriff(knightZugset);
        blackKnight1.setZugsetNormal(knightZugset);

        // Create a figur.
        final Figur blackKnight2 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackKnight2);
        initFigure(blackKnight2,Messages.blackKnight, Farbe.ORANGE, 4, 3, 4,
                spiel);
        // Add the zugsets.
        blackKnight2.setZugsetAngriff(knightZugset);
        blackKnight2.setZugsetNormal(knightZugset);

        /*
         * The white unicorns.
         */
        // Create a figur.
        final Figur whiteUnicorn1 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteUnicorn1);
        initFigure(whiteUnicorn1,Messages.whiteUnicorn, Farbe.GRAU, 1, 0, 0,
                spiel);
        // Add the zugsets.
        final Zugset unicornZugset = createUnicornZugset();
        whiteUnicorn1.setZugsetAngriff(unicornZugset);
        whiteUnicorn1.setZugsetNormal(unicornZugset);

        // Create a figur.
        final Figur whiteUnicorn2 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(whiteUnicorn2);
        initFigure(whiteUnicorn2,Messages.whiteUnicorn, Farbe.GRAU, 1, 3, 0,
                spiel);
        // Add the zugsets.
        whiteUnicorn2.setZugsetAngriff(unicornZugset);
        whiteUnicorn2.setZugsetNormal(unicornZugset);

        /*
         * The black unicorns.
         */
        // Create a figur.
        final Figur blackUnicorn1 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackUnicorn1);
        initFigure(blackUnicorn1,Messages.blackUnicorn, Farbe.ORANGE, 3, 0, 4,
                spiel);
        // Add the zugsets.
        blackUnicorn1.setZugsetAngriff(unicornZugset);
        blackUnicorn1.setZugsetNormal(unicornZugset);

        // Create a figur.
        final Figur blackUnicorn2 = factory.createFigur();
        // Add the figure to the figure array.
        spiel.getFigures().add(blackUnicorn2);
        initFigure(blackUnicorn2,Messages.blackUnicorn, Farbe.ORANGE, 3, 3, 4,
                spiel);
        // Add the zugsets.
        blackUnicorn2.setZugsetAngriff(unicornZugset);
        blackUnicorn2.setZugsetNormal(unicornZugset);
        
        //Create the fields.
        createFields(spiel);
    }
    
    /**
     * Resets the figures to their original positions.
     * @param spiel The {@link Spiel}, for which the figures should be reset.
     */
    public static void resetFigures(final Spiel spiel) {
        for (Figur figur : spiel.getFigures()) {
            figur.setActive(true);
            figur.setSelected(false);
            final int ebene=Integer.parseInt(figur.getId().substring(0, 1));
            final int buchstabe=Integer.parseInt(figur.getId().substring(1, 2));
            final int zahl=Integer.parseInt(figur.getId().substring(2, 3));
            setPosition(ebene, buchstabe, zahl, figur);
        }
    }
    
    /**
     * Resets the {@link Field}s.
     * @param spiel The {@link Spiel}, for which the {@link Field}s should be reset.
     */
    public static void resetFields(final Spiel spiel){
        for (Field field : spiel.getFields()) {
            field.setAttackable(false);
            field.setPossible(false);
        }
    }

    /**
     * Creates the fields.
     * @param spiel The {@link Spiel}, for which the fields should be created.
     */
    private static void createFields(Spiel spiel) {
        //Clear the list.
        spiel.getFields().clear();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    //Create a new Field.
                    Field f=SpielfeldFactory.eINSTANCE.createField();
                    final Koordinate pos=SpielfeldFactory.eINSTANCE.createKoordinate();
                    pos.setEbene(i);
                    pos.setBuchstabe(j);
                    pos.setZahl(k);
                    f.setPosition(pos);
                    f.setFarbe((i+j+k)%2==0?Farbe.ORANGE:Farbe.GRAU);
                    //Add the field.
                    spiel.getFields().add(f);
                }
            }
        }
    }

    /**
     * Creates all the possible moves for the unicorn.
     * 
     * @return The {@link Zugset} for the unicorn.
     */
    private static Zugset createUnicornZugset() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the move Zugset.
         */
        final Zugset unicornZugset = factory.createZugset();
        // Move along the space diagonals up to 4 fields. There are 8 space diagonals.
        final Koordinate koord1 = factory.createKoordinate();
        koord1.setBuchstabe(1);
        koord1.setEbene(1);
        koord1.setZahl(1);
        final StraightLine line1 = factory.createStraightLine();
        line1.setMaxDist(4);
        line1.setPosition(koord1);
        unicornZugset.getStraightLine().add(line1);

        final Koordinate koord2 = factory.createKoordinate();
        koord2.setBuchstabe(-1);
        koord2.setEbene(1);
        koord2.setZahl(1);
        final StraightLine line2 = factory.createStraightLine();
        line2.setMaxDist(4);
        line2.setPosition(koord2);
        unicornZugset.getStraightLine().add(line2);

        final Koordinate koord3 = factory.createKoordinate();
        koord3.setBuchstabe(1);
        koord3.setEbene(-1);
        koord3.setZahl(1);
        final StraightLine line3 = factory.createStraightLine();
        line3.setMaxDist(4);
        line3.setPosition(koord3);
        unicornZugset.getStraightLine().add(line3);

        final Koordinate koord4 = factory.createKoordinate();
        koord4.setBuchstabe(1);
        koord4.setEbene(1);
        koord4.setZahl(-1);
        final StraightLine line4 = factory.createStraightLine();
        line4.setMaxDist(4);
        line4.setPosition(koord4);
        unicornZugset.getStraightLine().add(line4);

        final Koordinate koord5 = factory.createKoordinate();
        koord5.setBuchstabe(-1);
        koord5.setEbene(-1);
        koord5.setZahl(1);
        final StraightLine line5 = factory.createStraightLine();
        line5.setMaxDist(4);
        line5.setPosition(koord5);
        unicornZugset.getStraightLine().add(line5);

        final Koordinate koord6 = factory.createKoordinate();
        koord6.setBuchstabe(-1);
        koord6.setEbene(1);
        koord6.setZahl(-1);
        final StraightLine line6 = factory.createStraightLine();
        line6.setMaxDist(4);
        line6.setPosition(koord6);
        unicornZugset.getStraightLine().add(line6);

        final Koordinate koord7 = factory.createKoordinate();
        koord7.setBuchstabe(1);
        koord7.setEbene(-1);
        koord7.setZahl(-1);
        final StraightLine line7 = factory.createStraightLine();
        line7.setMaxDist(4);
        line7.setPosition(koord7);
        unicornZugset.getStraightLine().add(line7);

        final Koordinate koord8 = factory.createKoordinate();
        koord8.setBuchstabe(-1);
        koord8.setEbene(-1);
        koord8.setZahl(-1);
        final StraightLine line8 = factory.createStraightLine();
        line8.setMaxDist(4);
        line8.setPosition(koord8);
        unicornZugset.getStraightLine().add(line8);

        return unicornZugset;
    }

    /**
     * Creates all the possible moves for the knight.
     * 
     * @return The {@link Zugset} for the knight.
     */
    private static Zugset createKnightZugset() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the move Zugset.
         */
        final Zugset knightZugset = factory.createZugset();

        // Move two in one direction.
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                for (int k = -2; k <= 2; k++) {
                    // Is the jump distance 3? Else try the next value.
                    if (Math.abs(i) + Math.abs(j) + Math.abs(k) != 3
                            || Math.abs(i) == Math.abs(j)
                            && Math.abs(j) == Math.abs(k)) {
                        continue;
                    }
                    final Koordinate koord = factory.createKoordinate();
                    koord.setEbene(i);
                    koord.setBuchstabe(j);
                    koord.setZahl(k);
                    final Jump jump=factory.createJump();
                    jump.setPosition(koord);
                    knightZugset.getJumps().add(jump);
                }
            }
        }

        return knightZugset;
    }

    /**
     * Creates all the possible moves for the king.
     * 
     * @return The {@link Zugset} for the king.
     */
    private static Zugset createKingZugset() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the move Zugset.
         */
        final Zugset kingZugset = factory.createZugset();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    final Koordinate koord = factory.createKoordinate();
                    koord.setEbene(i);
                    koord.setBuchstabe(j);
                    koord.setZahl(k);
                    final StraightLine line = factory.createStraightLine();
                    line.setMaxDist(1);
                    line.setPosition(koord);
                    kingZugset.getStraightLine().add(line);
                }
            }
        }

        return kingZugset;
    }

    /**
     * Creates all the possible moves for the queen.
     * 
     * @return The {@link Zugset} for the queen.
     */
    private static Zugset createQueenZugset() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the move Zugset.
         */
        final Zugset queenZugset = factory.createZugset();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    final Koordinate koord = factory.createKoordinate();
                    koord.setEbene(i);
                    koord.setBuchstabe(j);
                    koord.setZahl(k);
                    final StraightLine line = factory.createStraightLine();
                    line.setMaxDist(4);
                    line.setPosition(koord);
                    queenZugset.getStraightLine().add(line);
                }
            }
        }

        return queenZugset;
    }

    /**
     * Creates all the possible moves for the bishop.
     * 
     * @return The {@link Zugset} for the bishop.
     */
    private static Zugset createBishopZugset() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the move Zugset.
         */
        final Zugset bishopZugset = factory.createZugset();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (Math.abs(i) + Math.abs(j) + Math.abs(k) == 2) {
                        final Koordinate koord = factory.createKoordinate();
                        koord.setEbene(i);
                        koord.setBuchstabe(j);
                        koord.setZahl(k);
                        final StraightLine line = factory.createStraightLine();
                        line.setMaxDist(4);
                        line.setPosition(koord);
                        bishopZugset.getStraightLine().add(line);
                    }
                }
            }
        }

        return bishopZugset;
    }

    /**
     * Creates all the possible moves for the castle.
     * 
     * @return The {@link Zugset} for the castle.
     */
    private static Zugset createCastleZugset() {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        /*
         * Create the move Zugset.
         */
        final Zugset castleZugset = factory.createZugset();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (Math.abs(i) + Math.abs(j) + Math.abs(k) == 1) {
                        final Koordinate koord = factory.createKoordinate();
                        koord.setEbene(i);
                        koord.setBuchstabe(j);
                        koord.setZahl(k);
                        final StraightLine line = factory.createStraightLine();
                        line.setMaxDist(4);
                        line.setPosition(koord);
                        castleZugset.getStraightLine().add(line);
                    }
                }
            }
        }

        return castleZugset;
    }

    /**
     * Initializes the figures based on the standard positions at start of new
     * game.
     * 
     * @param name
     *            The name of the figure.
     * @param farbe
     *            The color of the figure.
     * @param ebene
     *            The ebene of the figure (with respect to the 3d space).
     * @param buchstabe
     *            The buchstabe (one of the three coordinates, see 2d chess) of
     *            the figure (with respect to the 3d space).
     * @param zahl
     *            The zahl (one of the three coordinates, see 2d chess) of the
     *            figure (with respect to the 3d space).
     */
    private static void initFigure(final Figur figure, final String name, final Farbe farbe,
            final int ebene, final int buchstabe, final int zahl,
            Spiel spiel) {
        // Assign the parameter.
        figure.setFarbe(farbe);
        figure.setName(name);
        figure.setActive(true);
        figure.setSelected(false);
        final String id = createFigureID(ebene, buchstabe, zahl);
        figure.setId(id);
        setPosition(ebene, buchstabe, zahl, figure);
    }

    /**
     * Creates a unique id for a figure given the start coordinates.
      * @param ebene
     *            The ebene of the figure (with respect to the 3d space).
     * @param buchstabe
     *            The buchstabe (one of the three coordinates, see 2d chess) of
     *            the figure (with respect to the 3d space).
     * @param zahl
     *            The zahl (one of the three coordinates, see 2d chess) of the
     *            figure (with respect to the 3d space).
     * @return The
     */
    private static String createFigureID(final int ebene, final int buchstabe,
            final int zahl) {
        final String id=""+ebene + buchstabe + zahl;
        return id;
    }

    /**
     * Sets the position of a {@link Figur}.
     * @param ebene The ebene-coordinate.
     * @param buchstabe The buchstabe-coordinate.
     * @param zahl The zahl-coordinate.
     * @param figure The {@link Figur}, which coordinate should be set.
     */
    private static void setPosition(final int ebene, final int buchstabe,
            final int zahl, final Figur figure) {
        // The factory.
        final SpielfeldFactory factory = SpielfeldFactory.eINSTANCE;
        // Set the initial position.
        final Koordinate position = factory.createKoordinate();
        position.setBuchstabe(buchstabe);
        position.setEbene(ebene);
        position.setZahl(zahl);
        figure.setPosition(position);
    }

    /**
     * A utility method for creating a new {@link Koordinate}.
     * 
     * @param buchstabe
     *            The buchstabe-coordinate.
     * @param ebene
     *            The ebene-coordinate.
     * @param zahl
     *            The zahl-coordinate.
     * @return The new {@link Koordinate} with the given coordinates.
     */
    private static Koordinate createKoordinate(final int buchstabe,
            final int ebene, final int zahl) {
        final Koordinate koordinate = SpielfeldFactory.eINSTANCE
                .createKoordinate();
        koordinate.setBuchstabe(buchstabe);
        koordinate.setEbene(ebene);
        koordinate.setZahl(zahl);
        return koordinate;
    }

    public static List<Figur> getCopied(final Spiel spiel) {
        final List<Figur> copied=new ArrayList<Figur>();
        for (Figur figur : spiel.getFigures()) {
            final Figur f=SpielfeldFactory.eINSTANCE.createFigur();
            f.setActive(figur.isActive());
            f.setFarbe(figur.getFarbe());
            f.setId(figur.getId());
            f.setName(figur.getName());
            final Koordinate pos=SpielfeldFactory.eINSTANCE.createKoordinate();
            pos.setBuchstabe(figur.getPosition().getBuchstabe());
            pos.setEbene(figur.getPosition().getEbene());
            pos.setZahl(figur.getPosition().getZahl());
            f.setPosition(pos);
            f.setZugsetAngriff(figur.getZugsetAngriff());
            f.setZugsetNormal(figur.getZugsetNormal());
            copied.add(f);
        }
        return copied;
    }
    
    /**
     * Finds a {@link Figur} with a given id in a list of figures.
     * @param copied The {@link List} of {@link Figur}s.
     * @param id The id of the {@link Figur}, which should be searched.
     * @return The {@link Figur} found or null, if there is no such {@link Figur}.
     */
    public static Figur findFigur(List<Figur> copied, String id) {
        for (Figur figur : copied) {
            if(figur.getId().equalsIgnoreCase(id)){
                return figur;
            }
        }
        return null;
    }

    /**
     * Finds a {@link Field} with a given position in a list of {@link Field}s.
     * @param copied The {@link List} of {@link Field}s.
     * @param id The position of the {@link Field}, which should be searched.
     * @return The {@link Field} found or null, if there is no such {@link Field}.
     */
    public static Field findField(List<Field> list,Koordinate position){
        for (Field field : list) {
            final boolean ebenenMatch=field.getPosition().getEbene()==position.getEbene();
            final boolean buchstabenMatch=field.getPosition().getBuchstabe()==position.getBuchstabe();
            final boolean zahlMatch=field.getPosition().getZahl()==position.getZahl();
            
            //Matching field found.
            if(ebenenMatch&&buchstabenMatch&&zahlMatch){
                return field;
            }
        }
        return null;
    }
}
