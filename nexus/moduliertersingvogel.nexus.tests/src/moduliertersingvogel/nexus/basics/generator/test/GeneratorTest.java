package moduliertersingvogel.nexus.basics.generator.test;

import static org.junit.Assert.*;

import java.util.List;

import moduliertersingvogel.nexus.basics.generator.Generator;
import moduliertersingvogel.nexus.model.Ebene;
import moduliertersingvogel.nexus.model.Ebenenstatus;
import moduliertersingvogel.nexus.model.Spiel;

import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Test;

public class GeneratorTest {

	private Generator generator;

	@Before
	public void init() {
		generator = new Generator();
	}

	@Test
	public void testGenerateRandom() {
		int radius = 3;
		Spiel generated = generator.generateRandom(radius);
		List<Ebene> ebenen = generated.getEbenen();

		assertEquals(Math.pow(radius, 2) * 2 + summedUp(1, radius + 1) * 2 + 2
				* radius + 1, ebenen.size(), 0.01);
	}

	@Test
	public void testGenerateRandomDeleted() {
		int radius = 4;
		Spiel generated = generator.generateRandomDeleted(radius, 0.1);
		boolean atLeastOneleer = false;
		for (Ebene ebene : generated.getEbenen()) {
			atLeastOneleer = atLeastOneleer
					|| ((Ebene) ebene).getStatus() == Ebenenstatus.LEER;
		}
		assertTrue(atLeastOneleer);
	}

	private int summedUp(int start, int stop) {
		int temp = 0;
		for (int i = start; i < stop; i++) {
			temp = temp + i;
		}

		return temp;
	}
}
