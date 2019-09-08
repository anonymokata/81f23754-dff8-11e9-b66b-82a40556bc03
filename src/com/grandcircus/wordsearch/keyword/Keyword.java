package com.grandcircus.wordsearch.keyword;

import java.util.List;

public class Keyword {

	protected String word;
	private Boolean isFound = false;
	protected Coordinates tempCoordinates;
	protected List<PotentialCoordinates> potentialCoordinates;
	private List<Coordinates> coordinates;

	public Keyword() {
		super();
	}

	public Keyword(String word) {
		super();
		this.word = word;
	}
	
	public Keyword(String word, Coordinates tempCoordinates) {
		super();
		this.word = word;
		this.tempCoordinates = tempCoordinates;
	}

	public Keyword(String word, List<PotentialCoordinates> potentialCoordinates) {
		super();
		this.word = word;
		this.potentialCoordinates = potentialCoordinates;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
	}
	
	public Coordinates getTempCoordinates() {
		return tempCoordinates;
	}

	public void setTempCoordinates(Coordinates tempCoordinates) {
		this.tempCoordinates = tempCoordinates;
	}

	public List<PotentialCoordinates> getPotentialCoordinates() {
		return potentialCoordinates;
	}

	public void setPotentialCoordinates(List<PotentialCoordinates> potentialCoordinates) {
		this.potentialCoordinates = potentialCoordinates;
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

	public String getSecondLetter() {
		return word.substring(1, 2);
	}
	
//	public String getRemainingLetters() {
//		return word.substring(1, word.length());
//	}

//	public void findRemainingCoordinates() {
//		setCoordinatesOfRemainingLetters(getGridSubstring(), getRemainingCoordinates());
//	}
//	
//	public void setCoordinatesOfRemainingLetters(String gridSubstring, List<Coordinates> foundCoordinates) {
//		if (keywordEqualsSubsubtring(gridSubstring)) {
//			setIsFound(true);
//			setCoordinates(foundCoordinates);
//		}
//	}
//	
//	public Boolean keywordEqualsSubsubtring(String gridSubstring) {
//		return getRemainingLetters().equals(gridSubstring);
//	}
//
//	public String getGridSubstring() {
//		return null;
//	}
//
//	public List<Coordinates> getRemainingCoordinates() {
//		return null;
//	}
	
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
