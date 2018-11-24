package de.moduliertersingvogel.patterns.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HexGrid {
	private Map<Coordinate, Cell> grid;
	public static final Coordinate[] neighbors = new Coordinate[] { new Coordinate(1, 0, -1), new Coordinate(1, -1, 0),
			new Coordinate(0, -1, 1), new Coordinate(-1, 0, 1), new Coordinate(-1, 1, 0), new Coordinate(0, 1, -1), };

	public HexGrid(List<Cell> cells) {
		this.grid = new HashMap<>();
		for (Cell cell : cells) {
			this.grid.put(cell.coordinate, cell);
		}
	}
	
	public List<Cell> getCells() {
		return Collections.unmodifiableList(new ArrayList<>(grid.values()));
	}

	public Cell getCellAt(Coordinate coordinate) {
		return grid.get(coordinate);
	}
	
	public void setCell(Cell cell) {
		grid.put(cell.coordinate, cell);
	}

	public int numOfNeighbors(Cell cell, int state) {
		return (int) Arrays.stream(this.neighbors).map(n -> cell.coordinate.add(n)).filter(c -> grid.containsKey(c))
				.map(c -> grid.get(c)).filter(c -> c.state == state).count();
	}
}
