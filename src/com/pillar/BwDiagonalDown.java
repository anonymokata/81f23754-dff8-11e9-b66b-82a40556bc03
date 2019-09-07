package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class BwDiagonalDown extends Keyword {

	public BwDiagonalDown() {
		super();
	}

	public BwDiagonalDown(String word, List<PotentialStartCoordinates> potentialStartCoordinates) {
		super();
		this.word = word;
		this.potentialStartCoordinates = potentialStartCoordinates;
	}
	
	@Override
	public String getGridSubstring(Coordinates coordinates) {
		String gridSubstring = "";
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			gridSubstring += Finder.grid[coordinates.getRow() + 1 + i][coordinates.getCol() - 1 - i];
		}
		return gridSubstring;
	}
	
	@Override
	public List<Coordinates> getRemainingCoordinates(Coordinates coordinates) {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(coordinates);
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			foundCoordinates.add(new Coordinates(coordinates.getRow()  + 1 + i, coordinates.getCol() - 1 - i));
		}
		return foundCoordinates;
	}

	@Override
	public String toString() {
		return "BwDiagonalDown";
	}

}

