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

	public void setPotentialStartCoordinatesWithDirections() {
		findPotentialStartingCoordinates();
		keyword.setPotentialStartCoordinates(getDirectionsForPotentialStartCoordinates());
	}

	public List<PotentialStartCoordinates> getDirectionsForPotentialStartCoordinates() {
		List<PotentialStartCoordinates> allKeywordPotentials = new ArrayList<>();
		for (int i = 0; i < keyword.getPotentialStartCoordinates().size(); i++) {
			Coordinates coordinates = keyword.getPotentialStartCoordinates().get(i).getStartCoordinates();
			PotentialStartCoordinates potentials = new PotentialStartCoordinates(coordinates,
					getDirections(coordinates));
			allKeywordPotentials.add(potentials);
		}
		return allKeywordPotentials;
	}

	private List<Direction> getDirections(Coordinates coordinates) {
		List<Direction> directions = new ArrayList<>();
		if (checkHorizontal(coordinates)) {
			directions.add(Direction.HORIZONTAL);
		}
		if (checkVertical(coordinates)) {
			directions.add(Direction.VERTICAL);
		}
		if (checkDiagonalDown(coordinates)) {
			directions.add(Direction.DIAGONAL_DOWN);
		}
		return directions;
	}

	private Boolean checkHorizontal(Coordinates coordinates) {
		return (keyword.getWord().substring(1, 2).equals(grid[coordinates.getRow()][coordinates.getCol() + 1]))
				&& keyword.getLength() <= grid.length - coordinates.getCol();
	}

	private Boolean checkVertical(Coordinates coordinates) {
		return (keyword.getWord().substring(1, 2).equals(grid[coordinates.getRow() + 1][coordinates.getCol()]))
				&& keyword.getLength() <= grid.length - coordinates.getRow();
	}

	private Boolean checkDiagonalDown(Coordinates coordinates) {
		return (keyword.getWord().substring(1, 2).equals(grid[coordinates.getRow() + 1][coordinates.getCol() + 1]))
				&& keyword.getLength() <= grid.length - coordinates.getRow();
	}

	private Boolean checkIfWordIsLongerThanTwoLetters() {
		return (keyword.getLength() > 2);
	}

	public void testDirection(Direction direction, Coordinates coordinates) {
		String keywordSubstring;
		String gridSubstring = "";
		List<Coordinates> foundCoordinates;
		if (direction == Direction.HORIZONTAL) {
			keywordSubstring = keyword.getWord().substring(2, keyword.getLength());
			foundCoordinates = new ArrayList<>();
			foundCoordinates.add(coordinates);
			foundCoordinates.add(new Coordinates(coordinates.getRow(), coordinates.getCol()+1));
			for (int i = 0; i < keywordSubstring.length(); i++) {
				gridSubstring += grid[coordinates.getRow()][coordinates.getCol() + 2 + i];
				foundCoordinates.add(new Coordinates(coordinates.getRow(), coordinates.getCol() + 2 + i));
			}
			if (keywordSubstring.equals(gridSubstring)) {
				keyword.setIsFound(true);
				keyword.setCoordinates(foundCoordinates);
			}
		}
	}
}
