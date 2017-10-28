package moduliertersingvogel.nexus.basics.generator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import moduliertersingvogel.nexus.model.Ebene;
import moduliertersingvogel.nexus.model.Ebenenfarbe;
import moduliertersingvogel.nexus.model.Ebenenstatus;
import moduliertersingvogel.nexus.model.Spiel;
import moduliertersingvogel.nexus.model.Spieler;
import moduliertersingvogel.nexus.model.Zug;

public class Generator {
	private Random randomGenerator;
	private List<Ebenenfarbe> farbValues;
	Map<String, Ebene> alreadyCreated = new HashMap<>();

	public Generator() {
		randomGenerator = new Random();
		farbValues = Ebenenfarbe.VALUES;
	}

	public Spiel generateRandom(final int radius) {
		Spiel spiel = new Spiel();

		for (int i = -radius; i < radius + 1; i++) {
			for (int j = 0; j < 2 * radius - Math.abs(i) + 1; j++) {
				Ebene ebene = createEbene(i, j);

				int leftJ[] = new int[2];
				if (i <= 0) {
					leftJ[0] = j - 1;
					leftJ[1] = j;
				}
				if (i > 0) {
					leftJ[0] = j + 1;
					leftJ[1] = j;
				}

				spiel.getEbenen().add(ebene);
			}
		}
		
		spiel.setId(randomGenerator.nextInt()+"");
				
		return spiel;
	}

	private String createKey(int i, int j) {
		return i + "-" + j;
	}

	private Ebene createEbene(int x, int y) {
		Ebene ebene = new Ebene();

		ebene.setX(x);
		ebene.setY(y);

		int randomNumber = randomGenerator.nextInt(farbValues.size());
		ebene.setFarbe(Ebenenfarbe.get(randomNumber));

		ebene.setStatus(Ebenenstatus.VOLL);

		alreadyCreated.put(createKey(x, y), ebene);

		return ebene;
	}

	public Spiel generateRandomDeleted(int radius, double threshold) {
		Spiel spiel = generateRandom(radius);
		for (Ebene ebene:spiel.getEbenen()){
				if(randomGenerator.nextFloat()<threshold){
					ebene.setStatus(Ebenenstatus.LEER);
				}
		}
		return spiel;
	}
}
