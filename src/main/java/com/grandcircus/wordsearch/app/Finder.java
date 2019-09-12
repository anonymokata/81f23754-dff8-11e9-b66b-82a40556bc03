package com.grandcircus.wordsearch.app;

import java.util.ArrayList;
import java.util.List;

import com.grandcircus.wordsearch.compass.BwDiagonalDown;
import com.grandcircus.wordsearch.compass.BwDiagonalUp;
import com.grandcircus.wordsearch.compass.BwHorizontal;
import com.grandcircus.wordsearch.compass.BwVertical;
import com.grandcircus.wordsearch.compass.Compass;
import com.grandcircus.wordsearch.compass.DiagonalDown;
import com.grandcircus.wordsearch.compass.DiagonalUp;
import com.grandcircus.wordsearch.compass.Horizontal;
import com.grandcircus.wordsearch.compass.Vertical;
import com.grandcircus.wordsearch.keyword.Coordinates;
import com.grandcircus.wordsearch.keyword.Direction;
import com.grandcircus.wordsearch.keyword.Keyword;

public class Finder {
	public static String[][] grid;

	private Keyword keyword;
	private List<Keyword> allKeywords;
	private List<Compass> compasses;
	private List<String> allKeywordCoordinates;

	public Finder(Keyword keyword, String[][] grid) {
		super();
		this.keyword = keyword;
		Finder.grid = grid;
	}

	public Finder(List<Keyword> allKeywords, String[][] grid) {
		super();
		this.allKeywords = allKeywords;
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

	public List<Compass> getCompasses() {
		return compasses;
	}

	public void setCompasses(List<Compass> compasses) {
		this.compasses = compasses;
	}

	public List<String> getAllKeywordCoordinates() {
		return allKeywordCoordinates;
	}

	public void setAllKeywordCoordinates(List<String> allKeywordCoordinates) {
		this.allKeywordCoordinates = allKeywordCoordinates;
	}

	public void findAllKeywordCoordinates() {
		List<String> allKeywordCoordinates = new ArrayList<>();
		for (Keyword each : allKeywords) {
			setKeyword(each);
			allKeywordCoordinates.add(findKeywordCoordinates());
		}
		setAllKeywordCoordinates(allKeywordCoordinates);
	}

	public String findKeywordCoordinates() {
		addDirectionsToPotentialCoordinates();
		return keyword.writeCoordinatesString();
	}

	public void addDirectionsToPotentialCoordinates() {
		keyword.setPotentialCoordinates(findFirstPotentials());
		findGoodPotentials();
		setKeywordToDirectionType();
	}

	public List<Coordinates> findFirstPotentials() {
		List<Coordinates> potentials = new ArrayList<>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				if (keyword.getWord().startsWith(grid[row][col])) {
					potentials.add(new Coordinates(row, col));
				}
			}
		}
		return potentials;
	}

	public void findGoodPotentials() {
		List<Compass> goodPotentials = new ArrayList<>();
		for (Compass compassPotential : makeCompasses()) {
			compassPotential.findDirections();
			if (!compassPotential.getDirections().isEmpty()) {
				goodPotentials.add(compassPotential);
			}
		}
		setCompasses(goodPotentials);
	}

	private List<Compass> makeCompasses() {
		List<Compass> compassPotentials = new ArrayList<>();
		for (Coordinates coordinates : keyword.getPotentialCoordinates()) {
			compassPotentials.add(new Compass(keyword, coordinates));
		}
		return compassPotentials;
	}

	public void setKeywordToDirectionType() {
		Compass directionType;
		for (Compass potential : getCompasses()) {
			for (Direction each : potential.getDirections()) {
				switch (each) {
				case HORIZONTAL:
					directionType = new Horizontal(potential);
					directionType.findFullMatch();
					break;
				case VERTICAL:
					directionType = new Vertical(potential);
					directionType.findFullMatch();
					break;
				case DIAGONAL_DOWN:
					directionType = new DiagonalDown(potential);
					directionType.findFullMatch();
					break;
				case DIAGONAL_UP:
					directionType = new DiagonalUp(potential);
					directionType.findFullMatch();
					break;
				case BW_HORIZONTAL:
					directionType = new BwHorizontal(potential);
					directionType.findFullMatch();
					break;
				case BW_VERTICAL:
					directionType = new BwVertical(potential);
					directionType.findFullMatch();
					break;
				case BW_DIAGONAL_DOWN:
					directionType = new BwDiagonalDown(potential);
					directionType.findFullMatch();
					break;
				case BW_DIAGONAL_UP:
					directionType = new BwDiagonalUp(potential);
					directionType.findFullMatch();
					break;
				default:
					directionType = null;
					break;
				}
				if (keywordIsFound(directionType)) {
					return;
				}
			}
		}
	}

	private Boolean keywordIsFound(Compass directionType) {
		if (directionType.getKeyword().getIsFound()) {
			keyword.setIsFound(true);
			keyword.setAllCoordinates(directionType.getKeyword().getAllCoordinates());
			return true;
		}
		return false;
	}

	public String printAllKeywordCoordinates() {
		String formattedPrintout = "\n\nBuffy the Vampire Slayer\n\nWord Search Coordinates: \n\n";
		for (String each : getAllKeywordCoordinates()) {
			formattedPrintout += each + "\n";
		}
		return formattedPrintout;
	}
}
