package com.grandcircus;

import java.util.ArrayList;
import java.util.List;

public class DiagonalUp extends Compass {

	public DiagonalUp (Keyword keyword, Coordinates coordinates) {
		super();
		this.keyword = keyword;
		this.coordinates = coordinates;
		oneAhead = coordinates.getCol() + 1;
		oneUp = coordinates.getRow() - 1;
	}
	
	@Override
	public String getGridSubstring() {
		String gridSubstring = "";
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			gridSubstring += grid[oneUp - i][oneAhead + i];
		}
		return gridSubstring;
	}
	
	@Override
	public List<Coordinates> getRemainingCoordinates() {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(coordinates);
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			foundCoordinates.add(new Coordinates(oneUp - i, oneAhead + i));
		}
		return foundCoordinates;
	}
	
	
	@Override
	public String toString() {
		return "DiagonalUp";
	}
	
}
