package com.pillar;

import java.util.List;

public class Keyword {
	
	
	protected String word;
	private Boolean isFound = false;
	protected List<PotentialStartCoordinates> potentialStartCoordinates;
	private List<Coordinates> coordinates;

	public Keyword() {
		super();
	}

	public Keyword(String word) {
		super();
		this.word = word;
	}

	public Keyword(String word, List<PotentialStartCoordinates> potentialStartCoordinates) {
		super();
		this.word = word;
		this.potentialStartCoordinates = potentialStartCoordinates;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getLength() {
		return getWord().length();
	}
	
	public String getSecondLetter() {
		return word.substring(1, 2);
	}

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
	}

	public String getRemainingLetters() {
		return word.substring(2, word.length());
	}

	public List<PotentialStartCoordinates> getPotentialStartCoordinates() {
		return potentialStartCoordinates;
	}

	public void setPotentialStartCoordinates(List<PotentialStartCoordinates> potentialStartCoordinates) {
		this.potentialStartCoordinates = potentialStartCoordinates;
	}

	public List<Coordinates> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}

	// fix ending ","
	public String writeCoordinatesString() {
		String coordinatesString = word + ": ";
		for (int i = 0; i < coordinates.size() - 1; i++) {
			coordinatesString += coordinates.get(i).toString() + ",";
		}
		coordinatesString += coordinates.get(coordinates.size() - 1);
		return coordinatesString;
	}

	@Override
	public String toString() {
		return word;
	}

	public void findRemainingCoordinates(Coordinates coordinates) {
		ifKeywordEqualsSubstringSetCoordinates(getGridSubstring(coordinates),
				getRemainingCoordinates(coordinates));
	}

	public void ifKeywordEqualsSubstringSetCoordinates(String gridSubstring, List<Coordinates> foundCoordinates) {
		if (getRemainingLetters().equals(gridSubstring)) {
			setIsFound(true);
			setCoordinates(foundCoordinates);
		}
	}

	public String getGridSubstring(Coordinates coordinates) {
		return null;
	}

	public List<Coordinates> getRemainingCoordinates(Coordinates coordinates) {
		return null;
	}

}
