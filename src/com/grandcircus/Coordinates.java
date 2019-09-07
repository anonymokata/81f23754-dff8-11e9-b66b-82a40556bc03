package com.grandcircus;

public class Coordinates {

	private Integer row;
	private Integer col;
	
	public Coordinates() {
		super();
	}

	public Coordinates(Integer row, Integer col) {
		super();
		this.row = row;
		this.col = col;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "(" + row + "," + col + ")";
	}
	
	
	
}
