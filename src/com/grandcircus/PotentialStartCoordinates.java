package com.grandcircus;

import java.util.List;

public class PotentialStartCoordinates {

	private Coordinates startCoordinates;
	private List<Direction> directions;

	public PotentialStartCoordinates() {
		super();
	}

	public PotentialStartCoordinates(Coordinates startCoordinates) {
		super();
		this.startCoordinates = startCoordinates;
	}

	public PotentialStartCoordinates(Coordinates startCoordinates, List<Direction> directions) {
		super();
		this.startCoordinates = startCoordinates;
		this.directions = directions;
	}

	public Coordinates getStartCoordinates() {
		return startCoordinates;
	}

	public void setStartCoordinates(Coordinates startCoordinates) {
		this.startCoordinates = startCoordinates;
	}

	public List<Direction> getDirections() {
		return directions;
	}

	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}

	@Override
	public String toString() {
		return "PotentialStartCoordinates [startCoordinates=" + startCoordinates + ", directions=" + directions + "]";
	}

}
