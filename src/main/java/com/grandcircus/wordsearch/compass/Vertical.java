package com.grandcircus.wordsearch.compass;

import java.util.ArrayList;
import java.util.List;
import com.grandcircus.wordsearch.keyword.Coordinates;


public class Vertical extends Compass  {

	public Vertical (Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

//	@Override
//	public void makeGridSubstring() {
//		String gridSubstring = "";
//		int aStep = 0;
//		for (; !outOfLetters(aStep); aStep++) {
//				gridSubstring += grid[down + aStep][thisCol];
//			}
//			setGridSubstring(gridSubstring);
//		}
//		
//	@Override
//	public void findRemainingCoordinates() {
//		List<Coordinates> remainingCoordinates = new ArrayList<>();
//		remainingCoordinates.add(coordinates);
//		int aStep = 0;
//		for (; !outOfLetters(aStep); aStep++) {
//				remainingCoordinates.add(new Coordinates(down + aStep, thisCol));
//			}
//		setRemainingCoordinates(remainingCoordinates);
//		}
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
