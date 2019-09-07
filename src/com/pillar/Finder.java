package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class Finder {
	public static String[][] grid;

	private Keyword keyword;
	private List<Keyword> allKeywords;

	public Finder(List<Keyword> allKeywords, String[][] grid) {
		super();
		this.allKeywords = allKeywords;
		Finder.grid = grid;
	}

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

	public List<Keyword> getAllKeywords() {
		return allKeywords;
	}

	public void setAllKeywords(List<Keyword> allKeywords) {
		this.allKeywords = allKeywords;
	}

	public String printAllKeywordCoordinates(List<String> allKeywordCoordinates) {
		String formattedPrintout = "\n\nWord Search Coordinates: \n\n";
		for (String each : allKeywordCoordinates) {
			formattedPrintout += each + "\n";
		}
		return formattedPrintout;
	}
	
	public List<String> findAllKeywordCoordinates() {
		List<String> allKeywordCoordinates = new ArrayList<>();
		for (Keyword each : allKeywords) {
			setKeyword(each);
			allKeywordCoordinates.add(findKeyword());
		}
		return allKeywordCoordinates;
	}
	
	public String findKeyword() {
		setDirectionsToPotentialStartCoordinates();
		setKeywordToDirectionType();
		return keyword.writeCoordinatesString();
	}
	
	public void setDirectionsToPotentialStartCoordinates() {
		findPotentialStartingCoordinates();
		keyword.setPotentialStartCoordinates(getDirectionsForPotentialStartCoordinates());
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

	public List<PotentialStartCoordinates> getDirectionsForPotentialStartCoordinates() {
		List<PotentialStartCoordinates> culledKeywordPotentials = new ArrayList<>();
		for (int i = 0; i < keyword.getPotentialStartCoordinates().size(); i++) {
			Coordinates coordinates = keyword.getPotentialStartCoordinates().get(i).getStartCoordinates();
			List<Direction> directions = getDirections(coordinates);
			if (!directions.isEmpty()) {
				PotentialStartCoordinates potentials = new PotentialStartCoordinates(coordinates, directions);
				culledKeywordPotentials.add(potentials);
			}
		}
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
		if (checkBwDiagonalDown(coordinates)) {
			directions.add(Direction.BW_DIAGONAL_DOWN);
		}
		if (checkBwDiagonalUp(coordinates)) {
			directions.add(Direction.BW_DIAGONAL_UP);
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
					directionType = new DiagonalDown(getKeyword().getWord(),
							getKeyword().getPotentialStartCoordinates());
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case DIAGONAL_UP:
					directionType = new DiagonalUp(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case BW_HORIZONTAL:
					directionType = new BwHorizontal(getKeyword().getWord(),
							getKeyword().getPotentialStartCoordinates());
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case BW_VERTICAL:
					directionType = new BwVertical(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case BW_DIAGONAL_DOWN:
					directionType = new BwDiagonalDown(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());
					directionType.findRemainingCoordinates(
							keyword.getPotentialStartCoordinates().get(i).getStartCoordinates());
					break;
				case BW_DIAGONAL_UP:
					directionType = new BwDiagonalUp(getKeyword().getWord(), getKeyword().getPotentialStartCoordinates());
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
			if (keyword.getIsFound())
				break;
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

	Boolean checkBwDiagonalDown(Coordinates coordinates) {
		if ((keyword.getLength() <= coordinates.getCol() + 1) 
			&& keyword.getLength() <= grid.length - coordinates.getRow()) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() + 1][coordinates.getCol() - 1]));
		} else {
			return false;
		}
	}
	
	Boolean checkBwDiagonalUp(Coordinates coordinates) {
		if ((keyword.getLength() <= coordinates.getCol() + 1) 
			&& keyword.getLength() <= coordinates.getRow() + 1)  {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() - 1][coordinates.getCol() - 1]));
		} else {
			return false;
		}

	}

}
