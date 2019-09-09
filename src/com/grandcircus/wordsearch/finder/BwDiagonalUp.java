package com.grandcircus.wordsearch.finder;

import java.util.ArrayList;
import java.util.List;
import com.grandcircus.wordsearch.keyword.Coordinates;

public class BwDiagonalUp extends Compass {

	protected String gridSubstring;
	protected List<Coordinates> remainingCoordinates;
	protected Integer aStep;
	
	public BwDiagonalUp (Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}
	
	@Override
	public String getGridSubstring() {
		String gridSubstring = "";		
		for (aStep = 0; !outOfLetters(aStep); aStep++) {
			gridSubstring += grid[up - aStep][back - aStep];
		}
		return gridSubstring;
	}
	
	@Override
	public List<Coordinates> getRemainingCoordinates() {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(coordinates);
		for (aStep = 0; !outOfLetters(aStep); aStep++) {
			foundCoordinates.add(new Coordinates(up - aStep, back - aStep));
		}
		return foundCoordinates;
	}
	
	@Override
	public String toString() {
		return "BwDiagonalUp";
	}
}

