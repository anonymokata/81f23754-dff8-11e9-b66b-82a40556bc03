package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class Horizontal extends Keyword implements DirectionType {

	public Horizontal() {
		super();
	}

	public Horizontal(String word, List<PotentialStartCoordinates> potentialStartCoordinates) {
		super();
		this.word = word;
		this.potentialStartCoordinates = potentialStartCoordinates;
	}

	public String getKeywordSubstring() {
		String keywordSubstring = getWord().substring(2, getLength());
		return keywordSubstring;
	}

	@Override
	public String toString() {
		return "Horizontal";
	}

}
