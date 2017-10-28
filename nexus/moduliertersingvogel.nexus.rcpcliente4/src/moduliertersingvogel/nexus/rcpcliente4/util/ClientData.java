package moduliertersingvogel.nexus.rcpcliente4.util;

public enum ClientData {
	INSTANCE;
	
	private String actualSpielID;
	
	public String getActualSpielID(){
		return this.actualSpielID;
	}

	public void setActualSpielID(String actualSpielID) {
		this.actualSpielID = actualSpielID;
	}
}
