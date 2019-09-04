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
	
	@BeforeEach
	public void setup() {
		mainReader = new WordSearchReader("word_search.txt");
	}

	@Test
	public void whenReadFileIsPassedItReturnsAListOfStringsFromTheTextFile() {
		wordSearchReader = new WordSearchReader("small_test.txt");
		List<String> actual = wordSearchReader.readFile();
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
		wordSearchReader = new WordSearchReader("puzzle_test.txt");
		List<String> actual = wordSearchReader.readPuzzle();
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
		wordSearchReader = new WordSearchReader("puzzle_grid_test_small.txt");
		String[][] actual = wordSearchReader.makeGrid();
		String[][] expected = {{"Y","G"}, {"E","K"}};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void whenMakeGridIsPassedItReturnsThePuzzleAsA2DArrayMedium() {
		wordSearchReader = new WordSearchReader("puzzle_grid_test_medium.txt");
		String[][] actual = wordSearchReader.makeGrid();
		String[][] expected = {{"Y","G","M"}, {"E","K","G"}, {"H","O","A"}};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void whenGetAllKeywordsIsPassedItReturnsAListOfKeywordObjectsFirst() {
		String actual1 = mainReader.getAllKeywords().get(0).getWord();
		String expected1 = "BUFFY";
		String actual2 = mainReader.getAllKeywords().get(2).getWord();
		String expected2 = "GILES";
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenFindFirstLetterCoordinatesIsPassedTaraItReturnsCoordinates() {
		wordSearchReader = new WordSearchReader("horizontal_test.txt");
		String actual = wordSearchReader.findFirstLetterCoordinates(wordSearchReader.getAllKeywords().get(0));
		String expected = "TARA: (1,0)";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindFirstLetterCoordinatesIsPassedDawnItReturnsCoordinates() {
		wordSearchReader = new WordSearchReader("horizontal_test.txt");
		String actual = wordSearchReader.findFirstLetterCoordinates(wordSearchReader.getAllKeywords().get(1));
		String expected = "DAWN: (3,0)";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindFirstLetterCoordinatesIsPassedDawnItReturnsCoordinatesLong() {
		wordSearchReader = new WordSearchReader("horizontal_test_long.txt");
		String actual = wordSearchReader.findFirstLetterCoordinates(wordSearchReader.getAllKeywords().get(1));
		String expected = "DAWN: (3,1)";
		assertEquals(expected, actual);
	}

}
