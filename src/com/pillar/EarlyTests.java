package com.pillar;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EarlyTests {

	WordSearchReader smallTest;

	@BeforeEach
	public void setup() {	
		smallTest = new WordSearchReader("puzzle_grid_test_medium.txt");
	}

	@Test
	public void whenReadFileIsPassedItReturnsAListOfStringsFromTheTextFile() {
		List<String> actual = smallTest.readFile();
		List<String> expected = Arrays.asList("BUFFY,XANDER,GILES", "Y,G,M", "E,K,G", "H,O,A");
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenReadPuzzleIsPassedItReturnsTheListOfPuzzleStrings() {
		List<String> actual = smallTest.readPuzzle();
		List<String> expected = Arrays.asList("Y,G,M", "E,K,G", "H,O,A");
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenMakeGridIsPassedItReturnsThePuzzleAsA2DArraySmall() {
		String[][] actual = smallTest.makeGrid();
		String[][] expected = {{"Y","G","M"}, {"E","K","G"}, {"H","O","A"}};
		assertArrayEquals(expected, actual);
	}
	
}
