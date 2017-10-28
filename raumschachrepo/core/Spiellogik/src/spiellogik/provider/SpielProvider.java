package spiellogik.provider;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import architecture.ISpielProvider;
import raumschachmodell.modell.RaumschachModellFactory;
import raumschachmodell.modell.Spiel;
import spiellogik.logik.ObjectSelected;

public class SpielProvider extends EObjectImpl implements ISpielProvider{

    /**
     * The list of games.
     */
    public static Spiel spiel = RaumschachModellFactory.eINSTANCE.createSpiel();

    public SpielProvider() {
        // Reset the new game.
        SpielProvider.spiel.reset();
        // Add a listener for the selections.
        new ObjectSelected(SpielProvider.spiel);
    }

    @Override
    public Spiel getSpiel() {
        return SpielProvider.spiel;
    }
}
