package com.grandcircus;

import java.util.ArrayList;
import java.util.List;

public class BwVertical extends Keyword {

	public BwVertical() {
		super();
	}

	public BwVertical (String word, Coordinates tempCoordinates) {
		super();
		this.word = word;
		this.tempCoordinates = tempCoordinates;
	}
	
	@Override
	public String getGridSubstring() {
		String gridSubstring = "";
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			gridSubstring += Finder.grid[tempCoordinates.getRow() - 1 - i][tempCoordinates.getCol()];
		}
		return gridSubstring;
	}
	
	@Override
	public List<Coordinates> getRemainingCoordinates() {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(tempCoordinates);
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			foundCoordinates.add(new Coordinates(tempCoordinates.getRow()  - 1 - i, tempCoordinates.getCol()));
		}
		return foundCoordinates;
	}

	@Override
	public String toString() {
		return "BwVertical";
	}

}

