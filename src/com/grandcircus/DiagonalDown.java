package com.grandcircus;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDown extends Keyword {

	public DiagonalDown() {
		super();
	}

	public DiagonalDown(String word, List<PotentialCoordinates> potentialStartCoordinates) {
		super();
		this.word = word;
		this.potentialCoordinates = potentialStartCoordinates;
	}
	
	@Override
	public String getGridSubstring(Coordinates coordinates) {
		String gridSubstring = "";
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			gridSubstring += Finder.grid[coordinates.getRow() + 1 + i][coordinates.getCol() + 1 + i];
		}
		return gridSubstring;
	}
	
	@Override
	public List<Coordinates> getRemainingCoordinates(Coordinates coordinates) {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(coordinates);
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			foundCoordinates.add(new Coordinates(coordinates.getRow() + 1 + i, coordinates.getCol() + 1 + i));
		}
		return foundCoordinates;
	}
	
	
	@Override
	public String toString() {
		return "DiagonalDown";
	}
}
