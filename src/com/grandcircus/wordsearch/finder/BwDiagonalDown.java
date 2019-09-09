package com.grandcircus.wordsearch.finder;

import java.util.ArrayList;
import java.util.List;
import com.grandcircus.wordsearch.keyword.Coordinates;

public class BwDiagonalDown extends Compass {

	public BwDiagonalDown(Compass compass) {
		super(compass.getKeyword(), compass.getCoordinates());
	}

	@Override
	public String getGridSubstring() {
		String gridSubstring = "";
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			gridSubstring += grid[oneDown + i][oneBack - i];
		}
		return gridSubstring;
	}

	@Override
	public List<Coordinates> getRemainingCoordinates() {
		List<Coordinates> foundCoordinates = new ArrayList<>();
		foundCoordinates.add(coordinates);
		for (int i = 0; i < getRemainingLetters().length(); i++) {
			foundCoordinates.add(new Coordinates(oneDown + i, oneBack - i));
		}
		return foundCoordinates;
	}

	@Override
	public String toString() {
		return "BwDiagonalDown";
	}
}
