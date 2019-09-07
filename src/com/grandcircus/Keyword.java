package com.grandcircus;

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

	public String getSecondLetter() {
		return word.substring(1, 2);
	}

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
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

	public Integer getLength() {
		return getWord().length();
	}
	
	public String getRemainingLetters() {
		return word.substring(1, word.length());
	}

	public void findRemainingCoordinates(Coordinates coordinates) {
		setCoordinatesOfRemainingLetters(getGridSubstring(coordinates), getRemainingCoordinates(coordinates));
	}
	
	public void setCoordinatesOfRemainingLetters(String gridSubstring, List<Coordinates> foundCoordinates) {
		if (keywordEqualsSubsubtring(gridSubstring)) {
			setIsFound(true);
			setCoordinates(foundCoordinates);
		}
	}
	
	public Boolean keywordEqualsSubsubtring(String gridSubstring) {
		return getRemainingLetters().equals(gridSubstring);
	}

	public String getGridSubstring(Coordinates coordinates) {
		return null;
	}

	public List<Coordinates> getRemainingCoordinates(Coordinates coordinates) {
		return null;
	}
	
	public String writeCoordinatesString() {
		String coordinatesString = word + ": ";
		if (word.length() > 2) {
			for (int i = 0; i < coordinates.size() - 1; i++) {
				coordinatesString += coordinates.get(i) + ",";
			}
			coordinatesString += coordinates.get(coordinates.size() - 1);
		} else {
			coordinatesString += coordinates.get(0) + "," + coordinates.get(1);
		}

		return coordinatesString;
	}
	
	@Override
	public String toString() {
		return word;
	}

}
