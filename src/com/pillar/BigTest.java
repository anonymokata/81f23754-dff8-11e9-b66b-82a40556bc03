package com.pillar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigTest {

	WordSearchReader mainReader;
	Finder findXander;
	Finder findGiles;
	Finder findAll;
	

	@BeforeEach
	public void setup() {
		mainReader = new WordSearchReader("big_puzzle.txt");
		findXander = new Finder(mainReader.getAllKeywords().get(1), mainReader.makeGrid());
		findGiles = new Finder(mainReader.getAllKeywords().get(2), mainReader.makeGrid());
		findAll = new Finder(mainReader.getAllKeywords(), mainReader.makeGrid());
	}
	
	@Test
	public void whenReadKeywordsIsPassedItReturnsAStringOfKeywords() {
		String actual = mainReader.readKeywords();
		String expected = "BUFFY, XANDER, GILES, ANGEL, WILLOW, DAWN, SPIKE, HELLMOUTH, SLAYER, TARA";
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindKeywordIsPassedCoordinatesAreReturned() {
		String actual = findXander.findKeyword();
		String expected = "BUFFY: (0,0),(1,0),(2,0),(3,0),(4,0)";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindKeywordIsPassedGilesIsReturned() {
		String actual = findGiles.findKeyword();
		String expected = "BUFFY: (0,0),(1,0),(2,0),(3,0),(4,0)";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenPrintAllKeywordsIsPassedItPrintsAPrettyList() {
		String actual = findAll.printAllKeywordCoordinates(findAll.findAllKeywordCoordinates());
		String expected = 
				"\n\nWord Search Coordinates: \n\n" + 		  
				"BUFFY: (4,7),(3,8),(2,9),(1,10),(0,11)\n" + 
				"XANDER: (14,5),(14,4),(14,3),(14,2),(14,1),(14,0)\n" + 
				"GILES: (13,0),(13,1),(13,2),(13,3),(13,4)\n" + 
				"ANGEL: (10,2),(11,3),(12,4),(13,5),(14,6)\n" + 
				"WILLOW: (9,6),(8,5),(7,4),(6,3),(5,2),(4,1)\n" + 
				"DAWN: (0,9),(1,8),(2,7),(3,6)\n" + 
				"SPIKE: (7,9),(8,9),(9,9),(10,9),(11,9)\n" + 
				"HELLMOUTH: (2,8),(3,7),(4,6),(5,5),(6,4),(7,3),(8,2),(9,1),(10,0)\n" + 
				"SLAYER: (11,11),(10,11),(9,11),(8,11),(7,11),(6,11)\n" + 
				"OZ: (8,8),(7,8)\n" + 
				"TARA: (13,10),(13,9),(13,8),(13,7)\n";
		assertEquals(expected, actual);
	}
}
