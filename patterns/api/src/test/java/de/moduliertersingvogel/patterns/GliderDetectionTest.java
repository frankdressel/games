package de.moduliertersingvogel.patterns;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.moduliertersingvogel.patterns.model.Cell;
import de.moduliertersingvogel.patterns.model.Coordinate;
import de.moduliertersingvogel.patterns.model.HexGrid;

class GliderDetectionTest {

	@Test
	void test() {
		List<Cell> cells1 = new ArrayList<>();
		
		cells1.add(new Cell(new Coordinate(1, -1, 0), "1", 1));
		cells1.add(new Cell(new Coordinate(0, -1, 1), "2", 1));
		cells1.add(new Cell(new Coordinate(-1, 0, 1), "3", 1));
		
		List<Cell> cells2 = Utils.createGridCells(3);
		HexGrid grid2 = new HexGrid(cells2);
		grid2.setCell(new Cell(new Coordinate(1, -2, 1), "1", 1));
		grid2.setCell(new Cell(new Coordinate(0, -2, 2), "2", 1));
		grid2.setCell(new Cell(new Coordinate(-1, -1, 2), "3", 1));
		
		assertTrue(Utils.gliderDetected(cells1, grid2));
	}
}
