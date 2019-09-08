package com.grandcircus.wordsearch.finder;

import java.util.ArrayList;
import java.util.List;

import com.grandcircus.wordsearch.keyword.Coordinates;
import com.grandcircus.wordsearch.keyword.Keyword;

public class Vertical extends Compass  {

	public Vertical (Keyword keyword, Coordinates coordinates) {
		super();
		this.keyword = keyword;
		this.coordinates = coordinates;
//		secondLetter = keyword.getSecondLetter();
//		thisRow = coordinates.getRow();
		thisCol = coordinates.getCol();
//		oneAhead = coordinates.getCol() + 1;
		oneDown = coordinates.getRow() + 1;
//		oneAbove = coordinates.getRow() - 1;
//		oneBehind = coordinates.getCol() - 1;
	}

		@Override
		public String getGridSubstring() {
			String gridSubstring = "";
			for (int i = 0; i < getRemainingLetters().length(); i++) {
				gridSubstring += grid[oneDown + i][thisCol];
			}
			return gridSubstring;
		}
		
		@Override
		public List<Coordinates> getRemainingCoordinates() {
			List<Coordinates> foundCoordinates = new ArrayList<>();
			foundCoordinates.add(coordinates);
			for (int i = 0; i < getRemainingLetters().length(); i++) {
				foundCoordinates.add(new Coordinates(oneDown + i, thisCol));
			}
			return foundCoordinates;
		}
		
		@Override
		public String toString() {
			return "Vertical";
		}
}
