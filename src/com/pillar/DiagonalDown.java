package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDown extends Keyword {

	public DiagonalDown() {
		super();
	}

	public DiagonalDown(String word, List<PotentialStartCoordinates> potentialStartCoordinates) {
		super();
		this.word = word;
		this.potentialStartCoordinates = potentialStartCoordinates;
	}
	
	@Override
	public String getGridSubstring(Coordinates coordinates) {
		String gridSubstring = "";
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			gridSubstring += Finder.grid[coordinates.getRow() + 2 + i][coordinates.getCol() + 2 + i];
		}
		return gridSubstring;
	}
	
	@Override
	public List<Coordinates> getRemainingCoordinates(Coordinates coordinates) {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(coordinates);
		foundCoordinates.add(new Coordinates(coordinates.getRow() + 1, coordinates.getCol() + 1));
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			foundCoordinates.add(new Coordinates(coordinates.getRow() + 2 + i, coordinates.getCol() + 2 + i));
		}
		return foundCoordinates;
	}
	
	
	@Override
	public String toString() {
		return "DiagonalDown";
	}
}
