package com.pillar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainReaderTests {

	WordSearchReader mainReader;
	Finder findXander;
	Finder findGiles;

	@BeforeEach
	public void setup() {
		mainReader = new WordSearchReader("word_search.txt");
		findXander = new Finder(mainReader.getAllKeywords().get(1), mainReader.makeGrid());	
		findGiles = new Finder(mainReader.getAllKeywords().get(2), mainReader.makeGrid());
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
		findGiles.setDirectionsToPotentialStartCoordinates();
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
	Boolean actual = findXander.checkBwHorizontal(new Coordinates(14,5));
	Boolean expected = true;
	assertEquals(expected, actual);
	}
	
	@Test
	public void whenCheckSecondCoordinatesIsPassedABwHorizontalItAddsBwHorizontalToDirectionsField2() {
		findXander.setDirectionsToPotentialStartCoordinates();
		Direction actual = findXander.getKeyword().getPotentialStartCoordinates().get(0).getDirections().get(0);
		Direction expected = Direction.BW_HORIZONTAL;
		assertEquals(expected, actual);
	} 
}
