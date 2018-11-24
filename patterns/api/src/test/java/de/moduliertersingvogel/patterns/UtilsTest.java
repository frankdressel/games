package de.moduliertersingvogel.patterns;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.moduliertersingvogel.patterns.model.Cell;

class UtilsTest {

	@Test
	void testNumberOfCells() {
		List<Cell> grid = Utils.createGridCells(0);
		assertEquals(1, grid.size());
		grid = Utils.createGridCells(1);
		assertEquals(7, grid.size());
		grid = Utils.createGridCells(16);
		assertEquals(817, grid.size());
	}
}
