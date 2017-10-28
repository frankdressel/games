package verwaltung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.rwt.RWT;
import org.eclipse.swt.widgets.Display;

import raumschachmodell.modell.RaumschachModellFactory;
import raumschachmodell.modell.Spieler;
import spielfeld.Farbe;
import architecture.IDisplayProvider;

/**
 * This class provides the {@link IDisplayProvider} functionality.
 * 
 * @author frank
 * 
 */
public final class DisplayProvider extends EObjectImpl implements
        IDisplayProvider {
    /**
     * Maps the {@link HttpSession#getId()} to a {@link Display}.
     */
    private static Map<String, Display> displays = new HashMap<String, Display>();

    /**
     * Avoids instantiation.
     */
    public DisplayProvider() {
        super();
    }

    @Override
    public Display getDisplay(final String id) {
        return DisplayProvider.displays.get(id);
    }

    @Override
    public List<Display> getAllDisplays() {
        return new ArrayList<Display>(DisplayProvider.displays.values());
    }

    @Override
    public void addDisplay(final String id, final Display display) {
        DisplayProvider.displays.put(id, display);
        // There is a new player: Add it.
        final Spieler spieler = RaumschachModellFactory.eINSTANCE
                .createSpieler();
        Activator.getSpielProvider().getSpiel().getSpieler().add(spieler);
        spieler.setFarbe(Farbe.BEIDE);
        // Set the player name.
        spieler.setName(Activator.getDatabaseWrapper().getNameForActualPlayer());
        // Set the session id.
        spieler.setId(RWT.getSessionStore().getHttpSession().getId());
    }
}
