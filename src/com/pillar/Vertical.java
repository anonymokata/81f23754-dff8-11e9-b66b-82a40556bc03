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
		public String getGridSubstring(Coordinates coordinates) {
			String gridSubstring = "";
			for (int i = 0; i < getRemainingLetters().length(); i++) {
				gridSubstring += Finder.grid[coordinates.getRow() + 1 + i][coordinates.getCol()];
			}
			return gridSubstring;
		}
		
		@Override
		public List<Coordinates> getRemainingCoordinates(Coordinates coordinates) {
			List<Coordinates> foundCoordinates = new ArrayList<>();
			foundCoordinates.add(coordinates);
			for (int i = 0; i < getRemainingLetters().length(); i++) {
				foundCoordinates.add(new Coordinates(coordinates.getRow() + 1 + i, coordinates.getCol()));
			}
			return foundCoordinates;
		}
		
		
		@Override
		public String toString() {
			return "Vertical";
		}
	
}
