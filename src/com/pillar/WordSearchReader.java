package com.pillar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordSearchReader {
	private Path filePath;

	public WordSearchReader(Path filePath) {
		this.filePath = filePath;
	}

	public WordSearchReader(String filePath) {
		this(Paths.get(filePath));
	}

	public List<Keyword> getAllKeywords() {
		String[] splitKeywords = splitKeywords();
		List<Keyword> keywords = new ArrayList<>();
		for (String each : splitKeywords) {
			keywords.add(new Keyword(each, false));
		}
		return keywords;
	}

	public String[] splitKeywords() {
		String keywords = readKeywords();
		return keywords.split(",");
	}

	public String readKeywords() {
		List<String> lines = readFile();
		return lines.get(0);
	}

	public String[][] makeGrid() {
		List<String> puzzle = readPuzzle();
		String[][] grid = new String[puzzle.size()][puzzle.size()];
		for (int i = 0; i < puzzle.size(); i++) {
			grid[i] = puzzle.get(i).split(",");
		}
		return grid;
	}

	public List<String> readPuzzle() {
		List<String> lines = readFile();
		List<String> puzzle = new ArrayList<>();
		for (int i = 1; i < lines.size(); i++) {
			puzzle.add(lines.get(i));
		}
		return puzzle;
	}

	public List<String> readFile() {

		try {
			return Files.readAllLines(filePath);
		} catch (FileNotFoundException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
	
//	public String findFirstLetterCoordinates(Keyword keyword) {
//		String[][] grid = makeGrid();
//		String coordinates = keyword.getWord() + ": ";
//		for (int row = 0; row < grid.length; row++) {
//			for (int col = 0; col < grid.length; col++) {
//			if (keyword.getWord().startsWith(grid[row][col]) 
//					&& (keyword.getLength() <= (grid[0].length - col)))  {
//					coordinates += "(" + row + "," + col + ")";
//				}
//			}
//		}
//		return coordinates;
//	}

//	public String findKeywordCoordinatesHorizontal(Keyword keyword) {
//		String[][] grid = makeGrid();
//		String coordinates = keyword.getWord() + ": ";
//		for (int row = 0; row < grid[0].length; row++) {
//			for (int col = 0; col < grid.length; col++) {
//				if (keyword.getLength() < (grid[0].length - col) 
//						&& (keyword.getWord().startsWith(grid[row][col]))) {
//					coordinates += "(" + row + "," + col + "),";
//					for (int i = 1; i < keyword.getLength() - 1; i++) {
//
//						if (keyword.getWord().substring(i, i + 1).equals(grid[row][col + i])) {
//							coordinates += "(" + row + "," + (col + i) + "),";
//
//						} 
//						
//					}
//				}
//			}
//		}
//		return coordinates;
//	}
}
