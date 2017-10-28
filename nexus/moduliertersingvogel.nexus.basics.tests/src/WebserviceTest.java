import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.Response.Status;
import static org.junit.Assert.*;
import moduliertersingvogel.nexus.model.Spiel;
import moduliertersingvogel.nexus.model.Zugliste;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class WebserviceTest {

	@Test
	public void testSpielCreation() {
		ClientResponse response = createNewGame();
		assertNotNull(response);

		String locationString = response.getLocation().toString();
		assertTrue(locationString
				.startsWith("http://localhost:8080/nexus/spiel/"));
		String[] split = locationString.split("spiel/");
		assertEquals(2, split.length);
		Integer spielID = null;
		try {
			spielID = Integer.valueOf(split[1]);
		} catch (NumberFormatException e) {
			fail();
		}
		assertNotNull(spielID);

		assertTrue(response.getStatus() == Status.CREATED.getStatusCode());

	}

	@Test
	public void testSpielRetrieval() {
		ClientResponse response = createNewGame();
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);

		try {
			Spiel spiel = createSpielFromNewGameResponse(response, client);
			assertTrue(spiel != null);
		} catch (UniformInterfaceException | ClientHandlerException
				| URISyntaxException | IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	private Spiel createSpielFromNewGameResponse(ClientResponse response,
			Client client) throws URISyntaxException, IOException,
			JsonParseException, JsonMappingException {
		String locationString = response.getLocation().toString();
		String spielString = client.resource(new URI(locationString)).get(
				String.class);
		Spiel spiel = new ObjectMapper().readValue(spielString, Spiel.class);
		return spiel;
	}

	@Test
	public void testSpielerCreation() {
		try {
			ClientResponse response = createNewGame();

			String locationString = response.getLocation().toString();
			ClientResponse clientResponse = addPlayer(locationString,
					"testMeAsPlayer");
			assertTrue("Return code: " + clientResponse.getStatus(),
					clientResponse.getStatus() == Status.CREATED
							.getStatusCode());

			clientResponse = addPlayer(locationString, "testMeAsPlayer");
			assertTrue("Return code: " + clientResponse.getStatus(),
					clientResponse.getStatus() == Status.CONFLICT
							.getStatusCode());
		} catch (UniformInterfaceException | ClientHandlerException
				| URISyntaxException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testZugGeneration() {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);

		// For whatever reasons, the spiel has to be retrieved from the
		// ClientResponse before ClientResponse.getLocation is called.
		// Otherwise, JaxB will complain.
		ClientResponse newGame = createNewGame();
		Spiel spiel = null;
		try {
			spiel = createSpielFromNewGameResponse(newGame, client);
			assertNotNull(spiel);
		} catch (URISyntaxException | IOException e1) {
			e1.printStackTrace();
			fail();
		}

		try {
			addPlayer(newGame.getLocation().toString(), "test");
		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail();
		}

		try {
			ClientResponse clientResponse = client.resource(
					new URI(
							"http://localhost:8080/nexus/spiel/"
									+ newGame.getLocation().toString()
											.split("spiel/")[1] + "/" + "test"
									+ "/zuege")).get(ClientResponse.class);

			assertTrue(clientResponse.getStatus() == Status.OK.getStatusCode());

			Zugliste zugListe = new ObjectMapper().readValue(
					clientResponse.getEntity(String.class), Zugliste.class);
			assertTrue(zugListe.getZuege().size() == spiel.getEbenen().size());

		} catch (UniformInterfaceException | ClientHandlerException
				| URISyntaxException | IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	private ClientResponse addPlayer(String locationString, String spielerName)
			throws URISyntaxException {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		ClientResponse clientResponse = client.resource(
				new URI(locationString + "/" + spielerName)).post(
				ClientResponse.class);
		return clientResponse;
	}

	private ClientResponse createNewGame() {
		ClientResponse response = null;
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		try {
			response = client.resource(
					new URI("http://localhost:8080/nexus/new")).post(
					ClientResponse.class);
		} catch (UniformInterfaceException | ClientHandlerException
				| URISyntaxException e) {
			e.printStackTrace();
		}
		return response;
	}

}
