package com.grandcircus.wordsearch.compass;

import java.util.ArrayList;
import java.util.List;
import com.grandcircus.wordsearch.keyword.Coordinates;


public class BwHorizontal extends Compass {

	public BwHorizontal (Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}
	
	@Override
	public void makeGridSubstring() {
		String gridSubstring = "";
		int aStep = 0;
		for (; !outOfLetters(aStep); aStep++) {
			gridSubstring += grid[thisRow][back - aStep];
		}
		setGridSubstring(gridSubstring);
	}
	
	@Override
	public void findRemainingCoordinates() {
		List<Coordinates> remainingCoordinates = new ArrayList<>();
		remainingCoordinates.add(coordinates);
		int aStep = 0;
		for (; !outOfLetters(aStep); aStep++) {
			remainingCoordinates.add(new Coordinates(thisRow, back - aStep));
		}
		setRemainingCoordinates(remainingCoordinates);
	}

	@Override
	public String toString() {
		return "BwHorizontal";
	}

}

