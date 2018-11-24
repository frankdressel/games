package de.moduliertersingvogel.patterns;

import java.util.ArrayList;
import java.util.List;

import de.moduliertersingvogel.patterns.model.Cell;
import de.moduliertersingvogel.patterns.model.Coordinate;
import de.moduliertersingvogel.patterns.model.HexGrid;

public class Utils {

	public static List<Cell> createGridCells(int radius) {
		List<Cell> cells = new ArrayList<>();
		for (int z = -radius; z <= radius; z = z + 1) {
			for (int x = -radius; x <= radius; x = x + 1) {
				int y = -(x + z);
				if (Math.abs(y) > radius) {
					continue;
				}
				Coordinate coordinate = new Coordinate(x, y, z);
				cells.add(new Cell(coordinate, x + "-" + y + "-" + z, 0));
			}
		}
		return cells;
	}
	
	public static boolean gliderDetected(List<Cell> pattern, HexGrid later) {
		for (Coordinate neigh : HexGrid.neighbors) {
			boolean match = true;
			for (Cell cell : pattern) {
				if(later.getCellAt(cell.coordinate.add(neigh)).state != cell.state) {
					match = false;
					break;
				}
			}
			if(match) {
				return true;
			}
		}
		
		return false;
	}

}
