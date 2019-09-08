package com.grandcircus;

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

	public List<Keyword> getAllKeywords() {
		return allKeywords;
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
		setDirectionsToPotentialCoordinates();
		setKeywordToDirectionType();
		return keyword.writeCoordinatesString();
	}
	
	public void setDirectionsToPotentialCoordinates() {
		keyword.setPotentialCoordinates(findFirstPotentials());
		keyword.setPotentialCoordinates(findGoodPotentials());
	}

	public List<PotentialCoordinates> findFirstPotentials() {
		List<PotentialCoordinates> potentials = new ArrayList<>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				if (keyword.getWord().startsWith(grid[row][col])) {
					potentials.add(new PotentialCoordinates(new Coordinates(row, col)));
				}
			}
		}
		return potentials;
	}

	public List<PotentialCoordinates> findGoodPotentials() {
		Compass compass;
		PotentialCoordinates potentials;
		List<PotentialCoordinates> goodPotentials = new ArrayList<>();
		for (PotentialCoordinates each : keyword.getPotentialCoordinates()) {
			 compass = new Compass(keyword, each.getStartCoordinates());
			if (!compass.getDirections().isEmpty()) {
				potentials = new PotentialCoordinates(each.getStartCoordinates(), compass.getDirections());
				goodPotentials.add(potentials);
			}
		}
		return goodPotentials;
	}	

	public void setKeywordToDirectionType() {
		Keyword directionType;
		for (PotentialCoordinates potential : keyword.getPotentialCoordinates()) {
			for (Direction each : potential.getDirections()) {
				switch (each) {
				case HORIZONTAL:
					directionType = new Horizontal(keyword.getWord(), potential.getStartCoordinates());
					directionType.findRemainingCoordinates();
					break;
				case VERTICAL:
					directionType = new Vertical(keyword.getWord(), potential.getStartCoordinates());
					directionType.findRemainingCoordinates();
					break;
				case DIAGONAL_DOWN:
					directionType = new DiagonalDown(keyword.getWord(), potential.getStartCoordinates());
					directionType.findRemainingCoordinates();
					break;
				case DIAGONAL_UP:
					directionType = new DiagonalUp(keyword.getWord(), potential.getStartCoordinates());
					directionType.findRemainingCoordinates();
					break;
				case BW_HORIZONTAL:
					directionType = new BwHorizontal(keyword.getWord(), potential.getStartCoordinates());
					directionType.findRemainingCoordinates();
					break;
				case BW_VERTICAL:
					directionType = new BwVertical(keyword.getWord(), potential.getStartCoordinates());
					directionType.findRemainingCoordinates();
					break;
				case BW_DIAGONAL_DOWN:
					directionType = new BwDiagonalDown(keyword.getWord(), potential.getStartCoordinates());
					directionType.findRemainingCoordinates();
					break;
				case BW_DIAGONAL_UP:
					directionType = new BwDiagonalUp(keyword.getWord(), potential.getStartCoordinates());
					directionType.findRemainingCoordinates();
					break;
				default:
					directionType = null;
					break;
				}

				keyword.setIsFound(directionType.getIsFound());
				keyword.setCoordinates(directionType.getCoordinates());
				if (keyword.getIsFound())
					return;
			}
			if (keyword.getIsFound())
				return;
		}
	}
}
