package com.grandcircus.wordsearch.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grandcircus.wordsearch.app.Finder;
import com.grandcircus.wordsearch.app.Grid;
import com.grandcircus.wordsearch.app.WordSearchReader;

public class BigTest {

	WordSearchReader mainReader;
	Grid grid;
	Finder findXander;
	Finder findGiles;
	Finder findAll;

	@BeforeEach
	public void setup() {
		mainReader = new WordSearchReader("mega_puzzle.txt");
		grid = new Grid(mainReader.makeGrid());
		findXander = new Finder(mainReader.getAllKeywords().get(1));
		findGiles = new Finder(mainReader.getAllKeywords().get(3));
		findAll = new Finder(mainReader.getAllKeywords());
	}
	
	@Test
	public void whenReadKeywordsIsPassedItReturnsAStringOfKeywords() {
		String actual = mainReader.readKeywords();
		String expected = "BUFFY,XANDER,WILLOW,GILES,CORDELIA,ANGEL,OZ,SPIKE,RILEY,ANYA,DAWN,TARA,JOYCE,FAITH,DRUSILLA,GLORY,CALEB,WARREN,JONATHAN,ANDREW";
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindKeywordIsPassedCoordinatesAreReturned() {
		String actual = findXander.findKeywordCoordinates();
		String expected = "XANDER: (27,37),(26,37),(25,37),(24,37),(23,37),(22,37)";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindKeywordIsPassedGilesIsReturned() {
		String actual = findGiles.findKeywordCoordinates();
		String expected = "GILES: (9,18),(10,17),(11,16),(12,15),(13,14)";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenPrintAllKeywordsIsPassedItPrintsAPrettyList() {
		findAll.findAllKeywordCoordinates();
		String actual = findAll.printAllKeywordCoordinates();
		String expected = 
				"\n\nBuffy the Vampire Slayer\n\nWord Search Coordinates: \n\n" +  
				"BUFFY: (5,21),(6,21),(7,21),(8,21),(9,21)\n" + 
				"XANDER: (27,37),(26,37),(25,37),(24,37),(23,37),(22,37)\n" + 
				"WILLOW: (18,1),(17,2),(16,3),(15,4),(14,5),(13,6)\n" + 
				"GILES: (9,18),(10,17),(11,16),(12,15),(13,14)\n" + 
				"CORDELIA: (14,7),(15,6),(16,5),(17,4),(18,3),(19,2),(20,1),(21,0)\n" + 
				"ANGEL: (13,11),(13,10),(13,9),(13,8),(13,7)\n" + 
				"OZ: (10,28),(11,27)\n" + 
				"SPIKE: (27,33),(26,32),(25,31),(24,30),(23,29)\n" + 
				"RILEY: (20,20),(19,20),(18,20),(17,20),(16,20)\n" + 
				"ANYA: (30,35),(31,34),(32,33),(33,32)\n" + 
				"DAWN: (32,12),(32,11),(32,10),(32,9)\n" + 
				"TARA: (12,25),(11,24),(10,23),(9,22)\n" + 
				"JOYCE: (21,2),(20,3),(19,4),(18,5),(17,6)\n" + 
				"FAITH: (23,17),(23,18),(23,19),(23,20),(23,21)\n" + 
				"DRUSILLA: (32,32),(32,31),(32,30),(32,29),(32,28),(32,27),(32,26),(32,25)\n" + 
				"GLORY: (3,20),(4,21),(5,22),(6,23),(7,24)\n" + 
				"CALEB: (19,33),(20,33),(21,33),(22,33),(23,33)\n" + 
				"WARREN: (24,7),(24,8),(24,9),(24,10),(24,11),(24,12)\n" + 
				"JONATHAN: (19,7),(18,6),(17,5),(16,4),(15,3),(14,2),(13,1),(12,0)\n" + 
				"ANDREW: (0,25),(1,26),(2,27),(3,28),(4,29),(5,30)\n";
		assertEquals(expected, actual);
	}
}
