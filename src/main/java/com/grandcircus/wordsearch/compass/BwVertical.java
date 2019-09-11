package com.grandcircus.wordsearch.compass;

import com.grandcircus.wordsearch.keyword.Coordinates;

public class BwVertical extends Compass {

	public BwVertical(Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

	@Override
	public String buildSubString(Integer aStep) {
		String gridSubstring = grid[up - aStep][thisCol];
		return gridSubstring;
	}

	@Override
	public Coordinates buildRemainingCoordinates(Integer aStep) {
		return new Coordinates(up - aStep, thisCol);
	}
}
