package moduliertersingvogel.nexus.basics.exportimport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import moduliertersingvogel.nexus.model.Ebene;
import moduliertersingvogel.nexus.model.Ebenenfarbe;
import moduliertersingvogel.nexus.model.Spiel;

public class ExportImport {
	public ExportImport(){
		
	}
	
	public void export(final String fileName, final Spiel spiel){
		try {
			File file = new File(fileName);
			BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
			StringBuffer ebenenString=new StringBuffer();
			for (Ebene ebene:spiel.getEbenen()){
					ebenenString.append(ebene.getFarbe()+"("+ebene.getX()+","+ebene.getY()+")-");
			}
			bufferedWriter.write(ebenenString.toString());
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Spiel load(final String fileName){
		Spiel spiel=new Spiel();
		
		try {
			Scanner scanner=new Scanner(new File(fileName));
			while(scanner.hasNext()){
				String nextLine=scanner.nextLine();
				String[] splitLine = nextLine.split("\\)-");
				for (String entitaetDescription : splitLine) {
					String[] split = entitaetDescription.split("\\(|\\)|,");
					
					Ebene ebene = new Ebene();
					ebene.setFarbe(Ebenenfarbe.get(split[0]));
					
					ebene.setX(Integer.valueOf(split[1]));
					ebene.setY(Integer.valueOf(split[2]));
					
					spiel.getEbenen().add(ebene);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return spiel;
	}
}
