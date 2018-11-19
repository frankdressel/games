package de.moduliertersingvogel.patterns.model;

public class Cell {
	public final Coordinate coordinate;
	public final String id;
	public final int state;

	public Cell(Coordinate coordinate, String id, int state) {
		this.coordinate = coordinate;
		this.id = id;
		this.state = state;
	}
}
