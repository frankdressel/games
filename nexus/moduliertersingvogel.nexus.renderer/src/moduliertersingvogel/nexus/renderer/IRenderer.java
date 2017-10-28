package moduliertersingvogel.nexus.renderer;

import java.util.List;

import moduliertersingvogel.nexus.model.Positioniert;
import moduliertersingvogel.nexus.model.Spiel;

public interface IRenderer {
	public Object renderebenen(Spiel spiel);
	
	public Object rendergestalten(Spiel spiel);
	
	public List<Positioniert> getPositioniertAtLocation(int x, int y);
}
