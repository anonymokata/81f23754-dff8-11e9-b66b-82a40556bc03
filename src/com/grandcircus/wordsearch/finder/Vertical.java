package com.grandcircus.wordsearch.finder;

import java.util.ArrayList;
import java.util.List;
import com.grandcircus.wordsearch.keyword.Coordinates;


public class Vertical extends Compass  {

	public Vertical (Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

	@Override
	public void makeGridSubstring() {
		String gridSubstring = "";
		int aStep = 0;
		for (; !outOfLetters(aStep); aStep++) {
				gridSubstring += grid[down + aStep][thisCol];
			}
			setGridSubstring(gridSubstring);
		}
		
	@Override
	public void findRemainingCoordinates() {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(coordinates);
		int aStep = 0;
		for (; !outOfLetters(aStep); aStep++) {
				foundCoordinates.add(new Coordinates(down + aStep, thisCol));
			}
		setRemainingCoordinates(foundCoordinates);
		}
		
		@Override
		public String toString() {
			return "Vertical";
		}
}
