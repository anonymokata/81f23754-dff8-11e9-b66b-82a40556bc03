package com.grandcircus.wordsearch.finder;

import java.util.ArrayList;
import java.util.List;

import com.grandcircus.wordsearch.keyword.Coordinates;
import com.grandcircus.wordsearch.keyword.Direction;
import com.grandcircus.wordsearch.keyword.Keyword;
import com.grandcircus.wordsearch.keyword.PotentialCoordinates;

public class Compass {

	protected Keyword keyword;
	protected Coordinates coordinates;
	private List<Direction> directions;
	protected String[][] grid = Finder.grid;
	protected String secondLetter;
	protected Integer thisRow;
	protected Integer thisCol;
	protected Integer oneAhead;
	protected Integer oneDown;
	protected Integer oneUp;
	protected Integer oneBack;
	
	public Compass() {
	}

	public Compass(Keyword keyword, Coordinates coordinates) {
		super();
		this.keyword = keyword;
		this.coordinates = coordinates;
		secondLetter = keyword.getSecondLetter();
		thisRow = coordinates.getRow();
		thisCol = coordinates.getCol();
		oneAhead = coordinates.getCol() + 1;
		oneDown = coordinates.getRow() + 1;
		oneUp = coordinates.getRow() - 1;
		oneBack = coordinates.getCol() - 1;
	}	
	
	
	public Keyword getKeyword() {
		return keyword;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public List<Direction> getDirections() {
		return directions;
	}

	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}

//	public void findGoodPotentials() {
//		Compass potential;
//		List<Compass> goodPotentials = new ArrayList<>();
//		for (PotentialCoordinates each : keyword.getPotentialCoordinates()) {
//			potential = new Compass(keyword, each.getStartCoordinates());
//			if (!potential.getDirections().isEmpty()) {
//				goodPotentials.add(potential);
//			}
//		}
//		setCompasses(goodPotentials);
//	}	
	
	protected void findDirections() {
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
		setDirections(directions);
	}

	protected Boolean checkHorizontal() {
		if (thereIsRoomAhead()) {
			return (secondLetter.equals(grid[thisRow][oneAhead]));
		}
		return false;
	}

	protected Boolean checkVertical() {
		if (thereIsRoomBelow()) {
			return (secondLetter.equals(grid[oneDown][thisCol]));
		}
		return false;
	}

	protected Boolean checkDiagonalDown() {
		if (thereIsRoomAhead() && thereIsRoomBelow()) {
			return (secondLetter.equals(grid[oneDown][oneAhead]));
		}
		return false;
	}

	protected Boolean checkDiagonalUp() {
		if (thereIsRoomAhead() && thereIsRoomAbove()) {
			return (secondLetter.equals(grid[oneUp][oneAhead]));
		}
		return false;
	}

	public Boolean checkBwHorizontal() {
		if (thereIsRoomBehind()) {
			return (secondLetter.equals(grid[thisRow][oneBack]));
		}
		return false;
	}

	protected Boolean checkBwVertical() {
		if (thereIsRoomAbove()) {
			return (secondLetter.equals(grid[oneUp][thisCol]));
		}
		return false;
	}

	public Boolean checkBwDiagonalDown() {
		if (thereIsRoomBehind() && thereIsRoomBelow()) {
			return (secondLetter.equals(grid[oneDown][oneBack]));
		}
		return false;
	}

	public Boolean checkBwDiagonalUp() {
		if (thereIsRoomBehind() && thereIsRoomAbove()) {
			return (secondLetter.equals(grid[oneUp][oneBack]));
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
		return keyword.getLength() <= oneDown;
	}

	private Boolean thereIsRoomBehind() {
		return keyword.getLength() <= oneAhead;
	}
	
	public String getRemainingLetters() {
		return keyword.getWord().substring(1, keyword.getWord().length());
	}
	
	public void findRemainingCoordinates() {
		setCoordinatesOfRemainingLetters(getGridSubstring(), getRemainingCoordinates());
	}
	
	public void setCoordinatesOfRemainingLetters(String gridSubstring, List<Coordinates> foundCoordinates) {
		if (keywordEqualsSubsubtring(gridSubstring)) {
			keyword.setIsFound(true);
			keyword.setAllCoordinates(foundCoordinates);
		}
	}
	
	public Boolean keywordEqualsSubsubtring(String gridSubstring) {
		return getRemainingLetters().equals(gridSubstring);
	}

	public String getGridSubstring() {
		return null;
	}

	public List<Coordinates> getRemainingCoordinates() {
		return null;
	}
}
