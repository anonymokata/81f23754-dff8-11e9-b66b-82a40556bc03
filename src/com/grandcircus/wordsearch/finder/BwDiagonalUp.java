package com.grandcircus.wordsearch.finder;

import java.util.ArrayList;
import java.util.List;
import com.grandcircus.wordsearch.keyword.Coordinates;

public class BwDiagonalUp extends Compass {

	protected String gridSubstring;
	protected List<Coordinates> remainingCoordinates;
	protected Integer aStep;

	public BwDiagonalUp(Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

	@Override
	public void buildGridSubstring() {
		String gridSubstring = "";
		for (aStep = 0; !outOfLetters(aStep); aStep++) {
			gridSubstring += grid[up - aStep][back - aStep];
		}
		setGridSubstring(gridSubstring);
	}

	@Override
	public void buildRemainingCoordinates() {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(coordinates);
		for (aStep = 0; !outOfLetters(aStep); aStep++) {
			foundCoordinates.add(new Coordinates(up - aStep, back - aStep));
		}
		setRemainingCoordinates(foundCoordinates);
	}

	@Override
	public String toString() {
		return "BwDiagonalUp";
	}
}
