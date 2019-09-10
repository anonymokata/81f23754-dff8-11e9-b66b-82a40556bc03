package com.grandcircus.wordsearch.keyword;

import java.util.List;

public class Keyword {

	protected String word;
	private Boolean isFound = false;
	protected List<Coordinates> potentialCoordinates;
	private List<Coordinates> allCoordinates;

	public Keyword(String word) {
		super();
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
	}

	public List<Coordinates> getPotentialCoordinates() {
		return potentialCoordinates;
	}

	public void setPotentialCoordinates(List<Coordinates> potentialCoordinates) {
		this.potentialCoordinates = potentialCoordinates;
	}

	public List<Coordinates> getAllCoordinates() {
		return allCoordinates;
	}

	public void setAllCoordinates(List<Coordinates> allCoordinates) {
		this.allCoordinates = allCoordinates;
	}

	public Integer getLength() {
		return getWord().length();
	}

	public String getSecondLetter() {
		return word.substring(1, 2);
	}
	
	public String getRemainingLetters() {
		return word.substring(1, word.length());
	}
	
	public String writeCoordinatesString() {
		String coordinatesString = word + ": ";
		if (word.length() > 2) {
			for (int i = 0; i < allCoordinates.size() - 1; i++) {
				coordinatesString += allCoordinates.get(i) + ",";
			}
			coordinatesString += allCoordinates.get(allCoordinates.size() - 1);
		} else {
			coordinatesString += allCoordinates.get(0) + "," + allCoordinates.get(1);
		}

		return coordinatesString;
	}
}
