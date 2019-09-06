package com.pillar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DirectionalTests {

	WordSearchReader directionalReader;
	Finder findTara;
	Finder findDawn;
	Finder findBuffyVertical;
	Finder findYdoa;
	Finder findBuow;
	Finder findRaru;

	@BeforeEach
	public void setup() {

		directionalReader = new WordSearchReader("directional_tests.txt");
		findTara = new Finder(directionalReader.getAllKeywords().get(0), directionalReader.makeGrid());
		findDawn = new Finder(directionalReader.getAllKeywords().get(1), directionalReader.makeGrid());
		findBuffyVertical = new Finder(directionalReader.getAllKeywords().get(2), directionalReader.makeGrid());
		findYdoa = new Finder(directionalReader.getAllKeywords().get(3), directionalReader.makeGrid());
		findBuow = new Finder(directionalReader.getAllKeywords().get(4), directionalReader.makeGrid());
		findRaru = new Finder(directionalReader.getAllKeywords().get(5), directionalReader.makeGrid());
	}

	@Test
	public void whenFindPotentialStartCoordinatesIsPassedItSetsTheKeywordPotentalStartCoordinates() {
		findTara.findPotentialStartingCoordinates();
		findDawn.findPotentialStartingCoordinates();
		String actual = findTara.getKeyword().getPotentialStartCoordinates().get(0).getStartCoordinates().toString();
		String actual2 = findDawn.getKeyword().getPotentialStartCoordinates().get(0).getStartCoordinates().toString();
		String expected = "(0,1)";
		String expected2 = "(2,3)";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	
	@Test
	public void whenCheckSecondCoordinatesIsPassedAHorizontalClueItAddsHorizontalToDirectionsField() {
		findTara.setDirectionsToPotentialStartCoordinates();
		Direction actual = findTara.getKeyword().getPotentialStartCoordinates().get(0).getDirections().get(0); 
		Direction expected = Direction.HORIZONTAL;
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenCheckSecondCoordinatesIsPassedAVerticalItAddsVerticalToDirectionsField() {
		findBuffyVertical.setDirectionsToPotentialStartCoordinates();
		Direction actual = findBuffyVertical.getKeyword().getPotentialStartCoordinates().get(0).getDirections().get(0); 
		Direction expected = Direction.VERTICAL;
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void whenCheckSecondCoordinatesIsPassedAVerticalAndDiagnalDownClueItAddserticalAndDiagonalDownToDirectionsField() {
		findBuffyVertical.setDirectionsToPotentialStartCoordinates();
		Direction actual = findBuffyVertical.getKeyword().getPotentialStartCoordinates().get(0).getDirections().get(0);
		Direction actual2 = findBuffyVertical.getKeyword().getPotentialStartCoordinates().get(0).getDirections().get(1);
		Direction expected = Direction.VERTICAL;
		Direction expected2 = Direction.DIAGONAL_DOWN;
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);;
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedADiagonalUpItAddsDiagonalUpToDirectionsField() {
		findYdoa.setDirectionsToPotentialStartCoordinates();
		Direction actual = findYdoa.getKeyword().getPotentialStartCoordinates().get(0).getDirections().get(0);
		Direction expected = Direction.DIAGONAL_UP;
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenCheckSecondCoordinatesIsPassedABwHorizontalItAddsBwHorizontalToDirectionsField2() {
		findRaru.setDirectionsToPotentialStartCoordinates();
		Direction actual = findRaru.getKeyword().getPotentialStartCoordinates().get(1).getDirections().get(0);
		Direction expected = Direction.BW_HORIZONTAL;
		assertEquals(expected, actual);
	} 
	
	@Test
	public void whenSetKeywordToDirectionTypeIsPassedAHorizontalMatchItSetsIsFoundToTrue() {
		findTara.setDirectionsToPotentialStartCoordinates();
		findTara.setKeywordToDirectionType();
		Boolean actual = findTara.getKeyword().getIsFound(); 
		String actual2 = findTara.getKeyword().getCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(0,1), (0,2), (0,3), (0,4)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenGetKeywordSubstringIsPassedADirectionItReturnsSubstring() {
		String actual = findTara.getKeyword().getRemainingLetters();
		String expected = "RA";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenSetKeywordToDirectionTypeIsPassedAHorizontalKeywordItCreatesAHorizontalSubtypeAndReturnsHorizontalCoordinates() {
		findDawn.setDirectionsToPotentialStartCoordinates();
		findDawn.setKeywordToDirectionType();
		Boolean actual = findDawn.getKeyword().getIsFound();
		String actual2 = findDawn.getKeyword().getCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(3,1), (3,2), (3,3), (3,4)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenSetKeywordToDirectionTypeIsPassedAVerticalKeywordItCreatesAVerticallSubtypeAndReturnsCoordinates() {
		findBuffyVertical.setDirectionsToPotentialStartCoordinates();
		findBuffyVertical.setKeywordToDirectionType();
		Boolean actual = findBuffyVertical.getKeyword().getIsFound();
		String actual2 = findBuffyVertical.getKeyword().getCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(0,0), (1,0), (2,0), (3,0), (4,0)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenSetKeywordToDirectionTypeIsPassedADiagonalDownlKeywordItCreatesADiagonalDownlSubtypeAndReturnsCoordinates() {
		findBuow.setDirectionsToPotentialStartCoordinates();
		findBuow.setKeywordToDirectionType();
		String actual = findBuow.getKeyword().getCoordinates().toString();
		String expected = "[(0,0), (1,1), (2,2), (3,3)]";
		assertEquals(expected, actual);
	}



	@Test
	public void whenCheckSecondCoordinatesIsPassedADiagonalUpItKeywordItCreatesADiagonalUpSubtype() {
		findYdoa.setDirectionsToPotentialStartCoordinates();
		findYdoa.setKeywordToDirectionType();
		Boolean actual = findYdoa.getKeyword().getIsFound();
		String actual2 = findYdoa.getKeyword().getCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(4,0), (3,1), (2,2), (1,3)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	
}
