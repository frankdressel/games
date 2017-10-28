package moduliertersingvogel.nexus.basics.exportimport.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import moduliertersingvogel.nexus.basics.exportimport.ExportImport;
import moduliertersingvogel.nexus.basics.generator.Generator;
import moduliertersingvogel.nexus.model.Ebene;
import moduliertersingvogel.nexus.model.Spiel;

import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Test;

public class ExportImportTest {
	private String fileName = "junittestFile.nexus";
	private ExportImport exportImport;
	private Spiel spiel;
	private String ebenenString;

	@Before
	public void init() {
		exportImport = new ExportImport();
		spiel = new Generator().generateRandom(3);
		ebenenString = createStringRepresentation();
	}

	private String createStringRepresentation() {
		StringBuffer stringBuffer = new StringBuffer();
		for (Ebene ebene:spiel.getEbenen()){
				stringBuffer.append(ebene.getFarbe()+"("+ebene.getX()+","+ebene.getY()+")-");
		}
		return stringBuffer.toString();
	}

	@Test
	public void testExport() {
		exportImport.export(fileName, spiel);
		assertTrue(new File(fileName).exists());
		
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {
				String nextLine = scanner.nextLine();
				assertEquals(ebenenString.toString(), nextLine);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		new File(fileName).delete();
	}

	@Test
	public void testLoad() {
		exportImport.export(fileName, spiel);
		Spiel loaded = exportImport.load(fileName);
		assertNotNull(loaded);
		List<Ebene> spielEntitaeten = spiel.getEbenen();
		List<Ebene> loadedEntitaeten = loaded.getEbenen();
		assertEquals(spielEntitaeten.size(), loadedEntitaeten.size());
		for (int i = 0; i < spielEntitaeten.size(); i++) {
			Ebene spielI = spielEntitaeten.get(i);
			Ebene loadedI = loadedEntitaeten.get(i);
			assertEquals(spielI.getFarbe(),loadedI.getFarbe());
			assertEquals(spielI.getX(),loadedI.getX());
			assertEquals(spielI.getY(),loadedI.getY());
		}
	}
}
