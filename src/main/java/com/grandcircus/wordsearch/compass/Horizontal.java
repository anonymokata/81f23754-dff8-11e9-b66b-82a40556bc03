package com.grandcircus.wordsearch.compass;

import com.grandcircus.wordsearch.keyword.Coordinates;

public class Horizontal extends Compass {

	public Horizontal (Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

	@Override
	public String buildSubString(Integer aStep) {
		String gridSubstring = grid[thisRow][forward + aStep];
		return gridSubstring;
	}
	
	@Override
	public Coordinates buildRemainingCoordinates(Integer aStep) {
		return new Coordinates(thisRow, forward + aStep);
	}
}
