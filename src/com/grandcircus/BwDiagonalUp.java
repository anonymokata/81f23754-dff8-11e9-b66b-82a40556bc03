package com.grandcircus;

import java.util.ArrayList;
import java.util.List;

public class BwDiagonalUp extends Keyword {

	public BwDiagonalUp() {
		super();
	}

	public BwDiagonalUp (String word, Coordinates tempCoordinates) {
		super();
		this.word = word;
		this.tempCoordinates = tempCoordinates;
	}
	
	@Override
	public String getGridSubstring() {
		String gridSubstring = "";
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			gridSubstring += Finder.grid[tempCoordinates.getRow() - 1 - i][tempCoordinates.getCol() - 1 - i];
		}
		return gridSubstring;
	}
	
	@Override
	public List<Coordinates> getRemainingCoordinates() {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(tempCoordinates);
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			foundCoordinates.add(new Coordinates(tempCoordinates.getRow()  - 1 - i, tempCoordinates.getCol() - 1 - i));
		}
		return foundCoordinates;
	}

	@Override
	public String toString() {
		return "BwDiagonalUp";
	}

}

