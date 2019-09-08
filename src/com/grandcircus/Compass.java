package com.grandcircus;

import java.util.ArrayList;
import java.util.List;

public class Compass {

	private Keyword keyword;
	private Coordinates coordinates;
	private String[][] grid = Finder.grid;
	private String secondLetter;
	private Integer thisRow;
	private Integer thisCol;
	private Integer oneAhead;
	private Integer oneBelow;
	private Integer oneAbove;
	private Integer oneBehind;

	public Compass(Keyword keyword, Coordinates coordinates) {
		super();
		this.keyword = keyword;
		this.coordinates = coordinates;
		secondLetter = keyword.getSecondLetter();
		thisRow = coordinates.getRow();
		thisCol = coordinates.getCol();
		oneAhead = coordinates.getCol() + 1;
		oneBelow = coordinates.getRow() + 1;
		oneAbove = coordinates.getRow() - 1;
		oneBehind = coordinates.getCol() - 1;
	}	
		
	protected List<Direction> getDirections() {
		List<Direction> directions = new ArrayList<>();
		if (checkHorizontal()) {
			directions.add(Direction.HORIZONTAL);
		}
		if (checkVertical()) {
			directions.add(Direction.VERTICAL);
		}
		if (checkDiagonalDown()) {
			directions.add(Direction.DIAGONAL_DOWN);
		}
		if (checkDiagonalUp()) {
			directions.add(Direction.DIAGONAL_UP);
		}
		if (checkBwHorizontal()) {
			directions.add(Direction.BW_HORIZONTAL);
		}
		if (checkBwVertical()) {
			directions.add(Direction.BW_VERTICAL);
		}
		if (checkBwDiagonalDown()) {
			directions.add(Direction.BW_DIAGONAL_DOWN);
		}
		if (checkBwDiagonalUp()) {
			directions.add(Direction.BW_DIAGONAL_UP);
		}
		return directions;
	}

	protected Boolean checkHorizontal() {
		if (thereIsRoomAhead()) {
			return (secondLetter.equals(grid[thisRow][oneAhead]));
		}
		return false;
	}

	protected Boolean checkVertical() {
		if (thereIsRoomBelow()) {
			return (secondLetter.equals(grid[oneBelow][thisCol]));
		}
		return false;
	}

	protected Boolean checkDiagonalDown() {
		if (thereIsRoomAhead() && thereIsRoomBelow()) {
			return (secondLetter.equals(grid[oneBelow][oneAhead]));
		}
		return false;
	}

	protected Boolean checkDiagonalUp() {
		if (thereIsRoomAhead() && thereIsRoomAbove()) {
			return (secondLetter.equals(grid[oneAbove][oneAhead]));
		}
		return false;
	}

	protected Boolean checkBwHorizontal() {
		if (thereIsRoomBehind()) {
			return (secondLetter.equals(grid[thisRow][oneBehind]));
		}
		return false;
	}

	protected Boolean checkBwVertical() {
		if (thereIsRoomAbove()) {
			return (secondLetter.equals(grid[oneAbove][thisCol]));
		}
		return false;
	}

	protected Boolean checkBwDiagonalDown() {
		if (thereIsRoomBehind() && thereIsRoomBelow()) {
			return (secondLetter.equals(grid[oneBelow][oneBehind]));
		}
		return false;
	}

	protected Boolean checkBwDiagonalUp() {
		if (thereIsRoomBehind() && thereIsRoomAbove()) {
			return (secondLetter.equals(grid[oneAbove][oneBehind]));
		}
		return false;
	}

	private Boolean thereIsRoomAhead() {
		return keyword.getLength() <= grid.length - thisCol;
	}

	private Boolean thereIsRoomBelow() {
		return keyword.getLength() <= grid.length - thisRow;
	}

	private Boolean thereIsRoomAbove() {
		return keyword.getLength() <= oneBelow;
	}

	private Boolean thereIsRoomBehind() {
		return keyword.getLength() <= oneAhead;
	}
}
