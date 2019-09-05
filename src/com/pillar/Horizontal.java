package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class Horizontal extends Keyword  {

	public Horizontal() {
		super();
	}

	public Horizontal(String word, List<PotentialStartCoordinates> potentialStartCoordinates) {
		super();
		this.word = word;
		this.potentialStartCoordinates = potentialStartCoordinates;
	}

	@Override
	public String toString() {
		return "Horizontal";
	}

}
