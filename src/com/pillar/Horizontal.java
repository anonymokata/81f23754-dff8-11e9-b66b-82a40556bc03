package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class Horizontal extends Keyword {

	public Horizontal() {
		super();
	}

	public Horizontal(String word, List<PotentialStartCoordinates> potentialStartCoordinates) {
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
		foundCoordinates.add(new Coordinates(coordinates.getRow(), coordinates.getCol() + 1));
		for (int i = 0; i < getKeywordSubstring().length(); i++) {
			gridSubstring += grid[coordinates.getRow()][coordinates.getCol() + 2 + i];
			foundCoordinates.add(new Coordinates(coordinates.getRow(), coordinates.getCol() + 2 + i));
		}
		if (getKeywordSubstring().equals(gridSubstring)) {
			setIsFound(true);
			setCoordinates(foundCoordinates);
		}
	}

	@Override
	public String toString() {
		return "Horizontal";
	}

}
