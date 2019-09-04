package com.pillar;

import java.util.List;

public class Keyword {
	
	private String word;
	private Integer length;
	private Boolean isFound;
	private List<Coordinates> potentialStartCoordinates;
	private Coordinates startCoordinates;
	private List<Coordinates> midCoordinates;
	private Coordinates endCoordinates;

	public Keyword(String word, Boolean isFound) {
		super();
		this.word = word;
		this.isFound = isFound;
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

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
	}

	public List<Coordinates> getPotentialStartCoordinates() {
		return potentialStartCoordinates;
	}

	public void setPotentialStartCoordinates(List<Coordinates> potentialStartCoordinates) {
		this.potentialStartCoordinates = potentialStartCoordinates;
	}

	public Coordinates getStartCoordinates() {
		return startCoordinates;
	}

	public void setStartCoordinates(Coordinates startCoordinates) {
		this.startCoordinates = startCoordinates;
	}

	public List<Coordinates> getMidCoordinates() {
		return midCoordinates;
	}

	public void setMidCoordinates(List<Coordinates> midCoordinates) {
		this.midCoordinates = midCoordinates;
	}

	public Coordinates getEndCoordinates() {
		return endCoordinates;
	}

	public void setEndCoordinates(Coordinates endCoordinates) {
		this.endCoordinates = endCoordinates;
	}
	
	public String writeCoordinatesString() {
		String coordinates = word + ": " + startCoordinates.toString() + ",";
		for (Coordinates each : midCoordinates) {
			coordinates += each.toString() + ",";
		}
		return coordinates += endCoordinates.toString();
	}

	@Override
	public String toString() {
		return word;
	}

}
