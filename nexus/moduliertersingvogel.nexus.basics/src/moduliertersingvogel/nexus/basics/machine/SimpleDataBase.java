package moduliertersingvogel.nexus.basics.machine;

import java.util.HashMap;
import java.util.Map;

import moduliertersingvogel.nexus.model.Spiel;

public enum SimpleDataBase {
	INSTANCE;
	
	private Map<String, Spiel> spiele=new HashMap<String, Spiel>();
	
	public void addSpiel(Spiel spiel){
		this.spiele.put(spiel.getId(),spiel);
	}
	
	public Spiel getSpiel(String id){
		return this.spiele.get(id);
	}
}
