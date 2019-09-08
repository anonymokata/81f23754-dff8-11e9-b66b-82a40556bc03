package com.grandcircus;

import java.util.ArrayList;
import java.util.List;

public class Compass {
	
	private Keyword keyword;
	private Coordinates coordinates;
	private String[][] grid = Finder.grid;
	
	public Compass(Keyword keyword, Coordinates coordinates) {
		super();
		this.keyword = keyword;
		this.coordinates = coordinates;
	}

	protected List<Direction> getDirections() {
		List<Direction> directions = new ArrayList<>();
		if (checkHorizontal()) {
			directions.add(Direction.HORIZONTAL);
		}
		if (checkVertical(coordinates)) {
			directions.add(Direction.VERTICAL);
		}
		if (checkDiagonalDown(coordinates)) {
			directions.add(Direction.DIAGONAL_DOWN);
		}
		if (checkDiagonalUp(coordinates)) {
			directions.add(Direction.DIAGONAL_UP);
		}
		if (checkBwHorizontal(coordinates)) {
			directions.add(Direction.BW_HORIZONTAL);
		}
		if (checkBwVertical(coordinates)) {
			directions.add(Direction.BW_VERTICAL);
		}
		if (checkBwDiagonalDown(coordinates)) {
			directions.add(Direction.BW_DIAGONAL_DOWN);
		}
		if (checkBwDiagonalUp(coordinates)) {
			directions.add(Direction.BW_DIAGONAL_UP);
		}
		return directions;
	}

	protected Boolean checkHorizontal() {
		if (thereIsRoomAhead(coordinates)) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow()][coordinates.getCol() + 1]));	
		} else {
			return false;
		}
	}

	protected Boolean checkVertical(Coordinates coordinates) {
		if (thereIsRoomBelow(coordinates)) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() + 1][coordinates.getCol()]));
		} else {
			return false;
		}
	}

	protected Boolean checkDiagonalDown(Coordinates coordinates) {
		if (thereIsRoomAhead(coordinates)
				&& thereIsRoomBelow(coordinates)) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() + 1][coordinates.getCol() + 1]));
		} else {
			return false;
		}
	}

	protected Boolean checkDiagonalUp(Coordinates coordinates) {
		if (thereIsRoomAhead(coordinates)
				&& thereIsRoomAbove(coordinates)) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() - 1][coordinates.getCol() + 1]));
		} else {
			return false;
		}
	}

	protected Boolean checkBwHorizontal(Coordinates coordinates) {
		if (thereIsRoomBehind(coordinates)) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow()][coordinates.getCol() - 1]));
		} else {
			return false;
		}
	}

	protected Boolean checkBwVertical(Coordinates coordinates) {
		if (thereIsRoomAbove(coordinates)) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() - 1][coordinates.getCol()]));
		} else {
			return false;
		}
	}

	protected Boolean checkBwDiagonalDown(Coordinates coordinates) {
		if (thereIsRoomBehind(coordinates)
			&& thereIsRoomBelow(coordinates)) {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() + 1][coordinates.getCol() - 1]));
		} else {
			return false;
		}
	}
	
	protected Boolean checkBwDiagonalUp(Coordinates coordinates) {
		if (thereIsRoomBehind(coordinates)
			&& thereIsRoomAbove(coordinates))  {
			return (keyword.getSecondLetter().equals(grid[coordinates.getRow() - 1][coordinates.getCol() - 1]));
		} else {
			return false;
		}
	}
	
	private Boolean thereIsRoomAhead(Coordinates coordinates) {
		return keyword.getLength() <= grid.length - coordinates.getCol();
	}
	
	private Boolean thereIsRoomBelow(Coordinates coordinates) {
		return keyword.getLength() <= grid.length - coordinates.getRow();
	}

	private Boolean thereIsRoomAbove(Coordinates coordinates) {
		return keyword.getLength() <= (coordinates.getRow()) + 1;
	}
	
	private Boolean thereIsRoomBehind(Coordinates coordinates) {
		return keyword.getLength() <= coordinates.getCol() + 1;
	}
	
	
}
