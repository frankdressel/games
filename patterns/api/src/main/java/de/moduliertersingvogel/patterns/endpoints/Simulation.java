package de.moduliertersingvogel.patterns.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.moduliertersingvogel.patterns.model.Cell;
import de.moduliertersingvogel.patterns.model.HexGrid;

@ApplicationScoped
@Path("simulation")
public class Simulation {
	private int[][] rules = new int[3][7];

	public Simulation() {
//		rules[0][2][0] = 2;
//		rules[1][1][0] = 1;
//		rules[1][4][0] = 1;
//		rules[1][3][0] = 1;
//		rules[0][1][2] = 1;
//		rules[2][2][0] = 1;
//		rules[1][2][0] = 1;
		//rules[0][0][1] = 2;
		rules[0][3] = 1;
		rules[0][2] = 1;
		rules[1][1] = 1;
	}
	
	public Simulation(int[][] rules) {
		this.rules = rules;
	}

	@POST
	@Path("/step")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response step(List<Cell> cells) {
		List<Cell> newCells = simulateOneStep(cells);

		return Response.ok(newCells).build();
	}

	public List<Cell> simulateOneStep(List<Cell> cells) {
		final HexGrid grid = new HexGrid(cells);

		List<Cell> newCells = new ArrayList<>();

		for (Cell cell : grid.getCells()) {
			int cellstate = cell.state;
			int neighbor1state = grid.numOfNeighbors(cell, 1);
			int neighbor2state = grid.numOfNeighbors(cell, 2);

			int newcellstate = this.rules[cellstate][neighbor1state];
			if (cellstate != newcellstate) {
				newCells.add(new Cell(cell.coordinate, cell.id, newcellstate));
			}
			else {
				newCells.add(new Cell(cell.coordinate, cell.id, cellstate));
			}
		}
		return newCells;
	}
}
