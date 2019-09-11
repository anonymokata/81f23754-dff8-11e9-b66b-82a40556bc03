package com.grandcircus.wordsearch.compass;

import com.grandcircus.wordsearch.keyword.Coordinates;

public class DiagonalUp extends Compass {

	public DiagonalUp(Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

	@Override
	public String buildSubString(Integer aStep) {
		String gridSubstring = grid[up - aStep][forward + aStep];
		return gridSubstring;
	}

	@Override
	public Coordinates buildRemainingCoordinates(Integer aStep) {
		return new Coordinates(up - aStep, forward + aStep);
	}
}
