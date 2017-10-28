package databasewrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;

import architecture.IDataBaseWrapper;

/**
 * This class is used to get data from the online database into the local game.
 * 
 * @author frank
 * 
 */
public class DatabaseWrapper extends EObjectImpl implements IDataBaseWrapper {
    
    /**
     * Default constructor.
     */
    public DatabaseWrapper(){
        super();
    }
    /**
     * Performs a given query on the database.
     * 
     * @param command
     *            The SQL-query, which should be done.
     */
    public static void performCommandOnDB(final String command) {
        final Browser browser = new Browser(Display.getCurrent()
                .getActiveShell(), SWT.NONE);
        // command=query;
        // System.out.println(command);
        browser.setUrl("http://www.s344813805.online.de/raumschach/html/insert.php?query="
                + command);
    }

    /**
     * Tries to perform a given query on the database.
     * 
     * @param query
     *            The query, which should be executed.
     * @return The {@link List} with rows returned from the database.
     */
    private static List<String> getResultsForQuery(final String query) {
        // The return string.
        final List<String> returnList = new ArrayList<String>();
        // Replace the characters.
        final String replaced = query.replaceAll(" ", "%20");
        try {
            final URL url = new URL(
                    "http://www.s344813805.online.de/raumschach/html/Select.phtml?query="
                            + replaced);
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                returnList.add(line.trim());
            }
            reader.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return returnList;
    }

    /**
     * Retrieves the actual name of the player based on the ip from the
     * database.
     * 
     * @return The name of the player.
     */
    @Override
    public String getNameForActualPlayer() {
        // The ip.
        final String ip = DatabaseWrapper.getActualIP();
        // The result list. Should be exactly 1.
        final List<String> names = DatabaseWrapper
                .getResultsForQuery("Select name from mapping where ip='" + ip
                        + "'");
        // If there is exactly one name, return it. Else return an empty string.
        return names.size() == 1 ? names.get(0) : "";
    }

    /**
     * Retrieves the actual description based on the ip from the database.
     * 
     * @return The name of the player.
     */
    public static String getDescription() {
        // The ip.
        final String ip = DatabaseWrapper.getActualIP();
        // The result list. Should be exactly 1.
        final List<String> descriptions = DatabaseWrapper
                .getResultsForQuery("Select description from mapping where ip='"
                        + ip + "'");
        // If there is exactly one name, return it. Else return an empty string.
        return descriptions.size() == 1 ? descriptions.get(0) : "";
    }

    /**
     * Tries to get the actual ip.
     * 
     * @return The actual ip or an empty string.
     */
    private static String getActualIP() {
        // Get the ip from the website.
        String ip = "";
        try {
            // Open the stream.
            final URL ipURL = new URL(
                    "http://www.s344813805.online.de/raumschach/html/ip.phtml");
            // Read and parse the data from the stream.
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(ipURL.openStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                ip = line;
            }
            reader.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return ip;
    }
}
