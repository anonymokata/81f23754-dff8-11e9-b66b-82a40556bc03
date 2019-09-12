package com.grandcircus.wordsearch.compass;

import com.grandcircus.wordsearch.keyword.Coordinates;

public class Vertical extends Compass {

	public Vertical(Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

	@Override
	public String buildSubString(Integer aStep) {
		String gridSubstring = grid[down + aStep][thisCol];
		return gridSubstring;
	}

	@Override
	public Coordinates buildRemainingCoordinates(Integer aStep) {
		return new Coordinates(down + aStep, thisCol);
	}
}
