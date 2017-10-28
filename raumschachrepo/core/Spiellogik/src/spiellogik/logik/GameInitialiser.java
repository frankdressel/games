package spiellogik.logik;

import spiellogik.provider.SpielProvider;

/**
 * This class is used for do the initialisation after a) a new game is started,
 * b) a game is loaded or c) a new player connected to the game.
 * 
 * @author frank
 * 
 */
public final class GameInitialiser {
    /**
     * Avoid instantiation.
     */
    private GameInitialiser() {

    }

    /**
     * Initialises a new game for the player.
     */
    public static void initialiseGame() {
        // Reset all the ViewBretts.
        SpielProvider.spiel.reset();
    }
}
