package com.grandcircus.wordsearch.compass;

import com.grandcircus.wordsearch.keyword.Coordinates;

public class DiagonalDown extends Compass {

	public DiagonalDown(Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

	@Override
	public String buildSubString(Integer aStep) {
		String gridSubstring = grid[down + aStep][forward + aStep];
		return gridSubstring;
	}

	@Override
	public Coordinates buildRemainingCoordinates(Integer aStep) {
		return new Coordinates(down + aStep, forward + aStep);
	}
}
