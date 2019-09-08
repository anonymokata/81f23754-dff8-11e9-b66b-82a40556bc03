package com.grandcircus.wordsearch.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grandcircus.wordsearch.app.WordSearchReader;
import com.grandcircus.wordsearch.finder.Compass;
import com.grandcircus.wordsearch.finder.Finder;
import com.grandcircus.wordsearch.keyword.Coordinates;
import com.grandcircus.wordsearch.keyword.Direction;

public class MainReaderTests {

	WordSearchReader mainReader;
	Finder findXander;
	Finder findGiles;
	Finder findAll;
	Compass compassXander;

	@BeforeEach
	public void setup() {
		mainReader = new WordSearchReader("word_search.txt");
		findXander = new Finder(mainReader.getAllKeywords().get(1), mainReader.makeGrid());	
		findGiles = new Finder(mainReader.getAllKeywords().get(2), mainReader.makeGrid());
		findAll = new Finder(mainReader.getAllKeywords(), mainReader.makeGrid());
		compassXander = new Compass(mainReader.getAllKeywords().get(1), new Coordinates(14, 5));
	}
	
	@Test
	public void whenReadKeywordsIsPassedItReturnsAStringOfKeywords() {
		String actual = mainReader.readKeywords();
		String expected = "BUFFY,XANDER,GILES,ANGEL,WILLOW,DAWN,SPIKE,HELLMOUTH,SLAYER,OZ,TARA";
	    assertEquals(expected, actual);
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
	public void whenSetKeywordToDirectionTypeIsPassedAHorizontalKeywordItCreatesAHorizontalSubtypeAndReturnsHorizontalCoordinates() {
		findGiles.setDirectionsToPotentialCoordinates();
		findGiles.setKeywordToDirectionType();
		Boolean actual = findGiles.getKeyword().getIsFound();
		String actual2 = findGiles.getKeyword().getCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(13,0), (13,1), (13,2), (13,3), (13,4)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenCheckBwHorizontalIsPassedMatchingCoordinatesItReturnsTrue() {
	findXander.setDirectionsToPotentialCoordinates();
	Boolean actual = compassXander.checkBwHorizontal();
	Boolean expected = true;
	assertEquals(expected, actual);
	}
	
	@Test
	public void whenCheckSecondCoordinatesIsPassedABwHorizontalItAddsBwHorizontalToDirectionsField2() {
		findXander.setDirectionsToPotentialCoordinates();
		Direction actual = findXander.getKeyword().getPotentialCoordinates().get(0).getDirections().get(0);
		Direction expected = Direction.BW_HORIZONTAL;
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenSetKeywordToDirectionTypeIsPassedABwHorizontallKeywordItCreatesABwHorizontalSubtype() {
		findXander.setDirectionsToPotentialCoordinates();
		findXander.setKeywordToDirectionType();
		String actual = findXander.getKeyword().getCoordinates().toString();
		String expected = "[(14,5), (14,4), (14,3), (14,2), (14,1), (14,0)]";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenFindAllKeywordCoordinatesIsPassedItReturnsAListOfPrintedCoordinates() {
		String actual = findAll.findAllKeywordCoordinates().toString();
		String expected = "[BUFFY: (4,7),(3,8),(2,9),(1,10),(0,11), "
				+ "XANDER: (14,5),(14,4),(14,3),(14,2),(14,1),(14,0), "
				+ "GILES: (13,0),(13,1),(13,2),(13,3),(13,4), "
				+ "ANGEL: (10,2),(11,3),(12,4),(13,5),(14,6), "
				+ "WILLOW: (9,6),(8,5),(7,4),(6,3),(5,2),(4,1), "
				+ "DAWN: (0,9),(1,8),(2,7),(3,6), SPIKE: (7,9),(8,9),(9,9),(10,9),(11,9), "
				+ "HELLMOUTH: (2,8),(3,7),(4,6),(5,5),(6,4),(7,3),(8,2),(9,1),(10,0), "
				+ "SLAYER: (11,11),(10,11),(9,11),(8,11),(7,11),(6,11), OZ: (8,8),(7,8), "
				+ "TARA: (13,10),(13,9),(13,8),(13,7)]";
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
