package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class Keyword {
	
	private String word;
	private Integer length;
	private Boolean isFound = false;
	private List<PotentialStartCoordinates> potentialStartCoordinates;
	private List<Coordinates> coordinates;


	public Keyword() {
		super();
	}

	public Keyword(String word) {
		super();
		this.word = word;
	}

	public Keyword(String word, List<Coordinates> coordinates) {
		super();
		this.word = word;
		this.coordinates = coordinates;
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

	//fix ending ","
	public String writeCoordinatesString() {
		String coordinatesString = word + ": ";
		for (Coordinates each : coordinates) {
			coordinatesString += each.toString() + ",";
		}
		return coordinatesString;
	}
	

	@Override
	public String toString() {
		return word;
	}

}
