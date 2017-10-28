package moduliertersingvogel.nexus.rcpcliente4.client;

import static org.junit.Assert.*;

import java.net.URI;

import moduliertersingvogel.nexus.model.Spiel;
import moduliertersingvogel.nexus.model.Zugliste;

import org.junit.Test;

public class SimpleClientTest {

	@Test
	public void testCreateNewGame() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetZuege() {
		SimpleClient simpleClient = new SimpleClient();
		URI newGame = simpleClient.createNewGame();
		
		String spielerName = "Frank";
		simpleClient.createNewSpieler(newGame, spielerName);
		
		Zugliste zuege = simpleClient.getZuege(newGame, spielerName);
		
		assertNotNull(zuege);
	}

	@Test
	public void testGetSpiel() {
		SimpleClient simpleClient = new SimpleClient();
		URI newGame = simpleClient.createNewGame();
		
		int numberOfCreatesGames=0;
		int numberOfWantedGames=10;
		for (int i = 0; i < numberOfWantedGames; i++) {
			Spiel spiel = simpleClient.getSpiel(newGame);
			assertNotNull(spiel);
			numberOfCreatesGames++;
		}
		
		assertEquals(numberOfWantedGames, numberOfCreatesGames);
	}

	@Test
	public void testCreateNewSpieler() {
		SimpleClient simpleClient = new SimpleClient();
		URI newGame = simpleClient.createNewGame();
		
		int numberOfNewSpieler=10;
		
		for (int i = 0; i < numberOfNewSpieler; i++) {
			simpleClient.createNewSpieler(newGame, "Frank"+i);
		}
		
		Spiel spiel = simpleClient.getSpiel(newGame);
		assertTrue(spiel.getBeteiligteSpieler().size()>=numberOfNewSpieler);
	}
}
