package com.pillar;

import java.util.List;

public class Horizontal extends Keyword {
	
	public Horizontal() {
		super();
	}
	
	public Horizontal(String word, Coordinates startCoordinates, List<Coordinates> midCoordinates) {
		super(word, startCoordinates, midCoordinates);
	}
	
	public Horizontal(String word, Boolean isFound, Coordinates startCoordinates, Coordinates endCoordinates) {
		super(word, isFound, startCoordinates, endCoordinates);
	}


	
	
}
