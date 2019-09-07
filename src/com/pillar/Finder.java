package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class Finder {
	public static String[][] grid;

	private Keyword keyword;

	public Finder(Keyword keyword, String[][] grid) {
		super();
		this.keyword = keyword;
		Finder.grid = grid;
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

	public void setDirectionsToPotentialStartCoordinates() {
		findPotentialStartingCoordinates();
		keyword.setPotentialStartCoordinates(getDirectionsForPotentialStartCoordinates());
		System.out.println(keyword.getPotentialStartCoordinates());
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
		System.out.println(keyword.getPotentialStartCoordinates());
	}

	public List<PotentialStartCoordinates> getDirectionsForPotentialStartCoordinates() {
		List<PotentialStartCoordinates> culledKeywordPotentials = new ArrayList<>();
		for (int i = 0; i < keyword.getPotentialStartCoordinates().size(); i++) {
			Coordinates coordinates = keyword.getPotentialStartCoordinates().get(i).getStartCoordinates();
			List<Direction> directions = getDirections(coordinates);
			if (!directions.isEmpty()) {
			PotentialStartCoordinates potentials = new PotentialStartCoordinates(coordinates,
					directions);
			culledKeywordPotentials.add(potentials);
			}
		}
		System.out.println("Culls: " + culledKeywordPotentials);
		return culledKeywordPotentials;
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
		if (checkDiagonalUp(coordinates)) {
			directions.add(Direction.DIAGONAL_UP);
		}
		if (checkBwHorizontal(coordinates)) {
			directions.add(Direction.BW_HORIZONTAL);
		}
		if (checkBwVertical(coordinates)) {
			directions.add(Direction.BW_VERTICAL);
		}
		return directions;
	}
	
	
	public void setKeywordToDirectionType() {
		Keyword directionType;
		for (int i = 0; i < keyword.getPotentialStartCoordinates().size(); i++) {
			for (Direction each : keyword.getPotentialStartCoordinates().get(i).getDirections()) {
				switch (each) {
				case HORIZONTAL:
					directionType = new Horizontal(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case VERTICAL:
					directionType = new Vertical(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case DIAGONAL_DOWN:
					directionType = new DiagonalDown(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case DIAGONAL_UP:
					directionType = new DiagonalUp(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());					
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case BW_HORIZONTAL:
					directionType = new BwHorizontal(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());					
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case BW_VERTICAL:
					directionType = new BwVertical(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());					
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				default:
					directionType = null;
					break;
				}
	
				keyword.setIsFound(directionType.getIsFound());
				keyword.setCoordinates(directionType.getCoordinates());
				if (keyword.getIsFound())
					break;
			}

		}
	}
	


	private Boolean checkHorizontal(Coordinates coordinates) {
		if (keyword.getLength() <= grid.length - coordinates.getCol()) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow()][coordinates.getCol() + 1]));
		} else {
			return false;
		}
	}

	private Boolean checkVertical(Coordinates coordinates) {
		if (keyword.getLength() <= grid.length - coordinates.getRow()) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() + 1][coordinates.getCol()]));
		} else {
			return false;
		}
	}

	private Boolean checkDiagonalDown(Coordinates coordinates) {
		if ((keyword.getLength() <= grid.length - coordinates.getCol())
				&& (keyword.getLength() <= grid.length - coordinates.getRow())) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() + 1][coordinates.getCol() + 1]));
		} else {
			return false;
		}
	}

	private Boolean checkDiagonalUp(Coordinates coordinates) {
		if (keyword.getLength() <= grid.length - coordinates.getCol()
				&& keyword.getLength() <= (coordinates.getRow()) + 1) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() - 1][coordinates.getCol() + 1]));
		} else {
			return false;
		}
	}
	
	Boolean checkBwHorizontal(Coordinates coordinates) {
		if ((keyword.getLength() <= coordinates.getCol() + 1)) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow()][coordinates.getCol() - 1]));
		} else {
			return false;
		}
	}
	
	Boolean checkBwVertical(Coordinates coordinates) {
		if ((keyword.getLength() <= coordinates.getRow() + 1)) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() - 1][coordinates.getCol()]));
		} else {
			return false;
		}
	}

	

//	private Boolean checkIfWordIsLongerThanTwoLetters() {
//		return (keyword.getLength() > 2);
//	}

}
