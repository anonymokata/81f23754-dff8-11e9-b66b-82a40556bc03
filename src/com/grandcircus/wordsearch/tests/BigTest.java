package com.grandcircus.wordsearch.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grandcircus.wordsearch.app.WordSearchReader;
import com.grandcircus.wordsearch.finder.Finder;

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
		String expected = "BUFFY,XANDER,GILES,ANGEL,WILLOW,DAWN,SPIKE,HELLMOUTH,SLAYER,OZ,TARA";
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindKeywordIsPassedCoordinatesAreReturned() {
		String actual = findXander.findKeyword();
		String expected = "XANDER: (13,15),(14,16),(15,17),(16,18),(17,19),(18,20)";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindKeywordIsPassedGilesIsReturned() {
		String actual = findGiles.findKeyword();
		String expected = "GILES: (1,23),(2,24),(3,25),(4,26),(5,27)";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenPrintAllKeywordsIsPassedItPrintsAPrettyList() {
		String actual = findAll.printAllKeywordCoordinates(findAll.findAllKeywordCoordinates());
		String expected = 
				"\n\nWord Search Coordinates: \n\n" +  
				"BUFFY: (13,5),(13,6),(13,7),(13,8),(13,9)\n" + 
				"XANDER: (13,15),(14,16),(15,17),(16,18),(17,19),(18,20)\n" + 
				"GILES: (1,23),(2,24),(3,25),(4,26),(5,27)\n" + 
				"ANGEL: (18,9),(19,9),(20,9),(21,9),(22,9)\n" + 
				"WILLOW: (24,23),(23,23),(22,23),(21,23),(20,23),(19,23)\n" + 
				"DAWN: (17,13),(17,12),(17,11),(17,10)\n" + 
				"SPIKE: (22,26),(23,25),(24,24),(25,23),(26,22)\n" + 
				"HELLMOUTH: (11,8),(11,7),(11,6),(11,5),(11,4),(11,3),(11,2),(11,1),(11,0)\n" + 
				"SLAYER: (20,0),(19,1),(18,2),(17,3),(16,4),(15,5)\n" + 
				"OZ: (9,27),(10,28)\n" + 
				"TARA: (22,3),(21,2),(20,1),(19,0)\n";
		assertEquals(expected, actual);
	}
}
