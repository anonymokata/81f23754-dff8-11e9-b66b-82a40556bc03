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
	WordSearchReader verticalTest;
	
	Finder finder;
	Finder findTaraShort;
	Finder findDawnShort;
	Finder findDawnLong;
	Finder findXander;
	Finder findTaraVertical;

	@BeforeEach
	public void setup() {
		mainReader = new WordSearchReader("word_search.txt");
		smallTest = new WordSearchReader("small_test.txt");
		puzzleTest = new WordSearchReader("puzzle_test.txt");
		puzzleTestGridSmall = new WordSearchReader("puzzle_grid_test_small.txt");
		puzzleTestGridMed = new WordSearchReader("puzzle_grid_test_medium.txt");
		horizontalReader = new WordSearchReader("horizontal_test.txt");
		horizontalReaderLong = new WordSearchReader("horizontal_test_long.txt");
		verticalTest = new WordSearchReader("vertical_test.txt");
		
		findTaraShort = new Finder(horizontalReader.getAllKeywords().get(0), horizontalReader.makeGrid());
		findDawnShort = new Finder(horizontalReader.getAllKeywords().get(1), horizontalReader.makeGrid());
		findDawnLong = new Finder(horizontalReaderLong.getAllKeywords().get(1), horizontalReaderLong.makeGrid());
		findXander = new Finder(mainReader.getAllKeywords().get(1), mainReader.makeGrid());
		findTaraVertical = new Finder(verticalTest.getAllKeywords().get(1), verticalTest.makeGrid());
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
	public void whenFindPotentialStartCoordinatesIsPassedItSetsTheKeywordPotentalStartCoordinates() {
		findTaraShort.findPotentialStartingCoordinates();
		findDawnShort.findPotentialStartingCoordinates();
		String actual = findTaraShort.getKeyword().getPotentialStartCoordinates().toString();
		String actual2 = findDawnShort.getKeyword().getPotentialStartCoordinates().toString();
		String expected = "[(1,0)]";
		String expected2 = "[(2,3), (3,0)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenFindPotentialStartCoordinatesIsPassedItSetsTheKeywordPotentalStartCoordinatesLong() {
		findDawnLong.findPotentialStartingCoordinates();
		findXander.findPotentialStartingCoordinates();
		String actual = findDawnLong.getKeyword().getPotentialStartCoordinates().toString();
		String actual2 = findXander.getKeyword().getPotentialStartCoordinates().toString();
		String expected = "[(2,3), (3,1)]";
		String expected2 = "[(4,11), (7,0), (7,12), (8,3), (9,0), (11,0), (11,7), (14,5)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenCheckSecondCoordinatesIsPassedAHorizontalClueItAddsHorizontalToDirectionsField() {
		findTaraShort.checkSecondCoordinates(new Coordinates (1,0));
		Direction actual = findTaraShort.getDirections().get(0); 
		Direction expected = Direction.HORIZONTAL;
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenCheckSecondCoordinatesIsPassedAVerticalClueItAddsVerticalToDirectionsField() {
		findTaraVertical.checkSecondCoordinates(new Coordinates (0,1));
		Direction actual = findTaraVertical.getDirections().get(0); 
		Direction expected = Direction.VERTICAL;
		assertEquals(expected, actual);
	}
	
//	@Test
//	public void whenCheckNextCoordinatesIsPassedItReturnsNullKeywordIfNextCoordinateDoesNotMatchKeyword() {
//		String actual = findDawnShort.checkSecondCoordinates(new Coordinates (2,0)).getWord();
//		String expected = null;
//		assertEquals(expected, actual);
//	}
	
	
	
//	@Test
//	public void whenGetSurroundingLettersIsPassedACoordinatesItReturnsAListOfMatchingGridStrings() {
//		List<String> actual = findDawnShort.getSurroundingLetters(new Coordinates (3,0));
//		List<String> expected = "A";
//		assertEquals(expected, actual);
//	}
	


}
