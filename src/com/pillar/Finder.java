package com.pillar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finder {

	private Keyword keyword;
	private String[][] grid;

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

	public void findPotentialStartingCoordinates() {
		List<PotentialStartCoordinates> potentials = new ArrayList<>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				if (keyword.getWord().startsWith(grid[row][col])) {
					potentials.add(new PotentialStartCoordinates(new Coordinates(row, col)));
				}
			}
		}
		keyword.setPotentialStartCoordinates(potentials);
	}

	public void getDirectionsForPotentialStartingCoordinates() {
		List<PotentialStartCoordinates> allKeywordPotentials = new ArrayList<>();
		for (int i = 0; i < keyword.getPotentialStartCoordinates().size(); i++) {
			Coordinates coordinates = keyword.getPotentialStartCoordinates().get(i).getStartCoordinates();
			PotentialStartCoordinates potentials;
			
			List<Direction> tempDirections = new ArrayList<>();
			if (checkHorizontal(coordinates)) {
				tempDirections.add(Direction.HORIZONTAL);
			}
			if (checkVertical(coordinates)) {
				tempDirections.add(Direction.VERTICAL);
			}
			if (checkDiagnalDown(coordinates)) {
				tempDirections.add(Direction.DIAGNAL_DOWN);
			}
			potentials = new PotentialStartCoordinates(coordinates, tempDirections);
			allKeywordPotentials.add(potentials);
		}
		keyword.setPotentialStartCoordinates(allKeywordPotentials);
	}

	private Boolean checkHorizontal(Coordinates coordinates) {
		return (keyword.getWord().substring(1, 2).equals(grid[coordinates.getRow()][coordinates.getCol() + 1]))
				&& keyword.getLength() <= grid.length - coordinates.getCol();
	}

	private Boolean checkVertical(Coordinates coordinates) {
		return (keyword.getWord().substring(1, 2).equals(grid[coordinates.getRow() + 1][coordinates.getCol()]))
				&& keyword.getLength() <= grid.length - coordinates.getRow();
	}

	private Boolean checkDiagnalDown(Coordinates coordinates) {
		return (keyword.getWord().substring(1, 2).equals(grid[coordinates.getRow() + 1][coordinates.getCol() + 1]))
				&& keyword.getLength() <= grid.length - coordinates.getRow();
	}

}
