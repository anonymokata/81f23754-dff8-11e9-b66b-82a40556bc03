package com.grandcircus;

import java.util.ArrayList;
import java.util.List;

public class BwVertical extends Compass {

	public BwVertical (Keyword keyword, Coordinates coordinates) {
		super();
		this.keyword = keyword;
		this.coordinates = coordinates;
		thisCol = coordinates.getCol();
		oneUp = coordinates.getRow() - 1;
		
	}	
	
	@Override
	public String getGridSubstring() {
		String gridSubstring = "";
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			gridSubstring += grid[oneUp - i][thisCol];
		}
		return gridSubstring;
	}
	
	@Override
	public List<Coordinates> getRemainingCoordinates() {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(coordinates);
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			foundCoordinates.add(new Coordinates(oneUp - i, thisCol));
		}
		return foundCoordinates;
	}

	@Override
	public String toString() {
		return "BwVertical";
	}

}

