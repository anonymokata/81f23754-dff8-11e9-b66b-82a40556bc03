package com.grandcircus.wordsearch.keyword;

public class Coordinates {

	private Integer row;
	private Integer col;

	public Coordinates(Integer row, Integer col) {
		super();
		this.row = row;
		this.col = col;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "(" + row + "," + col + ")";
	}
}
