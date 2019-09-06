package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class Vertical extends Keyword  {

		public Vertical() {
			super();
		}

		public Vertical(String word, List<PotentialStartCoordinates> potentialStartCoordinates) {
			super();
			this.word = word;
			this.potentialStartCoordinates = potentialStartCoordinates;
		}


		@Override
		public void findRemainingCoordinates(String[][] grid, Coordinates coordinates) {
		String gridSubstring = "";
		List<Coordinates> foundCoordinates;
			foundCoordinates = new ArrayList<>();
			foundCoordinates.add(coordinates);
			foundCoordinates.add(new Coordinates(coordinates.getRow() + 1, coordinates.getCol()));
			for (int i = 0; i < getKeywordSubstring().length(); i++) {
				gridSubstring += grid[coordinates.getRow() + 2 + i][coordinates.getCol()];
				foundCoordinates.add(new Coordinates(coordinates.getRow() + 2 + i, coordinates.getCol()));
			}
			if (getKeywordSubstring().equals(gridSubstring)) {
				setIsFound(true);
				setCoordinates(foundCoordinates);
			}
		}
		
		
		@Override
		public String toString() {
			return "Vertical";
		}
	
}
