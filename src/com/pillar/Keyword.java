package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class Keyword {
	
	private String word;
	private Integer length;
	private Boolean isFound = false;
	private List<PotentialStartCoordinates> potentialStartCoordinates;
	private Coordinates startCoordinates;
	private List<Coordinates> midCoordinates;
	private Coordinates endCoordinates;

	public Keyword() {
		super();
	}

	public Keyword(String word) {
		super();
		this.word = word;
	}
	
	public Keyword(String word, Coordinates startCoordinates, List<Coordinates> midCoordinates) {
		super();
		this.word = word;
		this.startCoordinates = startCoordinates;
		this.midCoordinates = midCoordinates;
	}

	public Keyword(String word, Boolean isFound, Coordinates startCoordinates, Coordinates endCoordinates) {
		super();
		this.word = word;
		this.isFound = isFound;
		this.startCoordinates = startCoordinates;
		this.endCoordinates = endCoordinates;
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
