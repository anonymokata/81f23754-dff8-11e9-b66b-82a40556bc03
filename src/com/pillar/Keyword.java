package com.pillar;

import java.util.ArrayList;
import java.util.List;

public class Keyword {
	
	private String word;
	private Integer length;
	private Boolean isFound = false;
	private List<PotentialStartCoordinates> potentialStartCoordinates;
	private Coordinates startCoordinates;
	private List<Coordinates> remainingCoordinates;


	public Keyword() {
		super();
	}

	public Keyword(String word) {
		super();
		this.word = word;
	}
	
	public Keyword(String word, Coordinates startCoordinates, List<Coordinates> remainingCoordinates) {
		super();
		this.word = word;
		this.startCoordinates = startCoordinates;
		this.remainingCoordinates = remainingCoordinates;
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


	public List<Coordinates> getRemainingCoordinates() {
		return remainingCoordinates;
	}

	public void setRemainingCoordinates(List<Coordinates> remainingCoordinates) {
		this.remainingCoordinates = remainingCoordinates;
	}

	//fix ending ","
	public String writeCoordinatesString() {
		String coordinates = word + ": " + startCoordinates.toString() + ",";
		for (Coordinates each : remainingCoordinates) {
			coordinates += each.toString() + ",";
		}
		return coordinates;
	}
	

	@Override
	public String toString() {
		return word;
	}

}
