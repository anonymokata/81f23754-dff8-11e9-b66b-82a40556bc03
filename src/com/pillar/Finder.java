package com.pillar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finder {

	private Keyword keyword;
	private String[][] grid;
	private List<Direction> directions;

	public Finder(Keyword keyword, String[][] grid) {
		super();
		this.keyword = keyword;
		this.grid = grid;
	}

	public Keyword getKeyword() {
		return keyword;
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	public String[][] getGrid() {
		return grid;
	}

	public List<Direction> getDirections() {
		return directions;
	}

	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}

	public void findPotentialStartingCoordinates() {
		List<Coordinates> potentials = new ArrayList<>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				if (keyword.getWord().startsWith(grid[row][col])) {
					potentials.add(new Coordinates(row, col));
				}
			}
		}
		keyword.setPotentialStartCoordinates(potentials);
	}

	public void checkSecondCoordinates(Coordinates coordinates) {
		List<Direction> tempDirections = new ArrayList<>();
		if (keyword.getWord().substring(1, 2).equals(grid[coordinates.getRow()][coordinates.getCol()+1])) {	
			tempDirections.add(Direction.HORIZONTAL);
		}
		setDirections(tempDirections);
	}
	
}
