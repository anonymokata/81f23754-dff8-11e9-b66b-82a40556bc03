package com.grandcircus.wordsearch.compass;

import com.grandcircus.wordsearch.keyword.Coordinates;

public class BwDiagonalUp extends Compass {

	public BwDiagonalUp(Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

	@Override
	public String buildSubString(Integer aStep) {
		String gridSubstring = grid[up - aStep][back - aStep];
		return gridSubstring;
	}

	@Override
	public Coordinates buildRemainingCoordinates(Integer aStep) {
		return new Coordinates(up - aStep, back - aStep);
	}
}
