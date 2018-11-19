package de.moduliertersingvogel.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import de.moduliertersingvogel.patterns.endpoints.Simulation;
import de.moduliertersingvogel.patterns.model.Cell;
import de.moduliertersingvogel.patterns.model.Coordinate;
import de.moduliertersingvogel.patterns.model.Grid;

public class Search {

	private static Random random = new Random();

	private static List<Cell> createGrid() {
		final int radius = 16;
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

	public static void main(String[] args) {
		final int states = 3;
		final int neighbors = 7;

		while (true) {
			int rules[][][] = new int[3][7][7];
			List<String> newrules = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				int oldstate = random.nextInt(3);
				int neighborsstate1 = random.nextInt(7);
				int neighborsstate2 = random.nextInt(7);
				int newstate = random.nextInt(3);
				rules[oldstate][neighborsstate1][neighborsstate2] = newstate;
				newrules.add(String.format("%d-%d-%d-%d", oldstate, neighborsstate1, neighborsstate2, newstate));
			}
			Simulation simulation = new Simulation(rules);

			boolean goodrules=false;
			for (int globalstate = 0; globalstate < Math.pow(3, 7); globalstate++) {
				List<Cell> cells = createGrid();

				final int innerradius = 1;
				List<Cell> innercells = cells.stream()
						.filter(c -> Math.max(Math.abs(c.coordinate.x),
								Math.max(Math.abs(c.coordinate.y), Math.abs(c.coordinate.z))) <= innerradius)
						.collect(Collectors.toList());

				int _globalstate=globalstate;
				int filledcells=0;
				for (int i = 0; i < innercells.size(); i++) {
					final Cell currentcell = innercells.get(i);
					cells.remove(currentcell);
					int remainder = _globalstate % 3;
					if(remainder>0) {
						filledcells++;
					}
					_globalstate = _globalstate / 3;
					cells.add(new Cell(currentcell.coordinate, currentcell.id, remainder));
				}

				List<Set<Coordinate>> livingcells = new ArrayList<>();
				for (int i = 0; i < 50; i++) {
					cells = simulation.simulateOneStep(cells);
					livingcells.add(cells.stream().filter(c -> c.state != 0).map(c -> c.coordinate)
							.collect(Collectors.toSet()));
				}
				Set<Coordinate> livingcellsatend = livingcells.get(livingcells.size() - 1);
				int numlivingcellsatend = livingcells.get(livingcells.size() - 1).size();
				float lower = filledcells*1.f/cells.size();
				float upper = 0.5f;
				if (numlivingcellsatend > 0) {
					boolean distinctFromEnd = true;
					boolean interesting = livingcellsatend.size() * 1. / cells.size() > lower
							&& livingcellsatend.size() * 1. / cells.size() < upper;
					for (int i = livingcells.size() - 2; i >= livingcells.size() - 6 && i >= 0; i--) {
						int size = CollectionUtils.disjunction(livingcellsatend, livingcells.get(i)).size();
						if (size == 0) {
							distinctFromEnd = false;
							break;
						}
						interesting = interesting && (livingcells.get(i).size() * 1. / cells.size() > lower
								&& livingcells.get(i).size() * 1. / cells.size() < upper);
					}
					if (distinctFromEnd && interesting) {
						goodrules = true;
					}
				}
			}
			if(goodrules) {
				System.out.println(newrules);
			}
		}
	}
}
