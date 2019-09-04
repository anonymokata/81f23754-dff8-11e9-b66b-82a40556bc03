package com.pillar;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordSearchTest {

	WordSearchReader wordSearchReader;
	WordSearchReader mainReader;
	WordSearchReader horizontalReader;
	WordSearchReader horizontalReaderLong;
	WordSearchReader smallTest;
	WordSearchReader puzzleTest;
	WordSearchReader puzzleTestGridSmall;
	WordSearchReader puzzleTestGridMed;
	
	Finder finder;
	Finder findTaraShort;
	Finder findDawnShort;
	Finder findDawnLong;
	Finder findXander;

	@BeforeEach
	public void setup() {
		mainReader = new WordSearchReader("word_search.txt");
		smallTest = new WordSearchReader("small_test.txt");
		puzzleTest = new WordSearchReader("puzzle_test.txt");
		puzzleTestGridSmall = new WordSearchReader("puzzle_grid_test_small.txt");
		puzzleTestGridMed = new WordSearchReader("puzzle_grid_test_medium.txt");
		horizontalReader = new WordSearchReader("horizontal_test.txt");
		horizontalReaderLong = new WordSearchReader("horizontal_test_long.txt");
		
		findTaraShort = new Finder(horizontalReader.getAllKeywords().get(0), horizontalReader.makeGrid());
		findDawnShort = new Finder(horizontalReader.getAllKeywords().get(1), horizontalReader.makeGrid());
		findDawnLong = new Finder(horizontalReaderLong.getAllKeywords().get(1), horizontalReaderLong.makeGrid());
		findXander = new Finder(mainReader.getAllKeywords().get(1), mainReader.makeGrid());
	}

	@Test
	public void whenReadFileIsPassedItReturnsAListOfStringsFromTheTextFile() {
		List<String> actual = smallTest.readFile();
		List<String> expected = Arrays.asList("BUFFY","XANDER","GILES");
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenReadKeywordsIsPassedItReturnsAStringOfKeywords() {
		String actual = mainReader.readKeywords();
		String expected = "BUFFY,XANDER,GILES,ANGEL,WILLOW,DAWN,SPIKE,HELLMOUTH,SLAYER,OZ,TARA";
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenReadPuzzleIsPassedItReturnsTheListOfPuzzleStrings() {
		List<String> actual = puzzleTest.readPuzzle();
		List<String> expected = Arrays.asList("Y,G,M,E,F,B,N,D,H,D,G,Y,Y,B,I", "E,K,G,H,Q,Z,T,J,A,A,F,F,F,M,K");
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenSplitKeywordsIsPassedItReturnsAnArrayOfKeywords() {
		String[] actual = mainReader.splitKeywords();
		String[] expected = {"BUFFY","XANDER","GILES","ANGEL","WILLOW","DAWN","SPIKE","HELLMOUTH","SLAYER","OZ","TARA"};		
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	public void whenMakeGridIsPassedItReturnsThePuzzleAsA2DArraySmall() {
		String[][] actual = puzzleTestGridSmall.makeGrid();
		String[][] actual2 = puzzleTestGridMed.makeGrid();
		String[][] expected = {{"Y","G"}, {"E","K"}};
		String[][] expected2 = {{"Y","G","M"}, {"E","K","G"}, {"H","O","A"}};
		assertArrayEquals(expected, actual);
		assertArrayEquals(expected2, actual2);
	}
	
	@Test
	public void whenGetAllKeywordsIsPassedItReturnsAListOfKeywordObjectsFirst() {
		String actual = mainReader.getAllKeywords().get(0).getWord();
		String actual2 = mainReader.getAllKeywords().get(2).getWord();
		String expected = "BUFFY";
		String expected2 = "GILES";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenFindPotentialStartingCoordinatesIsPassedAKeywordItReturnsCoordinates() {
		String actual = findTaraShort.findPotentialStartingCoordinates().toString();
		String actual2 = findDawnShort.findPotentialStartingCoordinates().toString();
		String expected = "[(1,0)]";
		String expected2 = "[(3,0)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenFindPotentialStartingCoordinatesIsPassedDawnItReturnsCoordinatesLong() {
		String actual = findDawnLong.findPotentialStartingCoordinates().toString();
		String expected = "[(3,1)]";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindPotentialStartingCoordinatesIsPassedXanderItReturnsAListOfCoordinatesFull() {
		String actual = findXander.findPotentialStartingCoordinates().toString();
		String expected = "[(7,0), (8,3), (9,0), (11,0), (11,7), (14,5)]";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenCheckNextCoordinatesIsPassedItReturnsTrueIfNextCoordinateMatchesKeyword() {
		Boolean actual = findTaraShort.checkNextCoordinates(new Coordinates (1,0));
		Boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenCheckNextCoordinatesIsPassedItReturnsFalseIfNextCoordinateDoesNotMatchKeyword() {
		Boolean actual = findDawnShort.checkNextCoordinates(new Coordinates (2,0));
		Boolean expected = false;
		assertEquals(expected, actual);
	}

}
