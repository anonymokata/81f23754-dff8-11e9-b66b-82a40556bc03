package com.grandcircus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;
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
	Finder findBaora;
	Finder findAaody;
	Finder findCwou;
	Finder findAll;
	Compass compassAaody;
	Compass compassCwou;

	@BeforeEach
	public void setup() {

		directionalReader = new WordSearchReader("directional_tests.txt");
		findTara = new Finder(directionalReader.getAllKeywords().get(0), directionalReader.makeGrid());
		findDawn = new Finder(directionalReader.getAllKeywords().get(1), directionalReader.makeGrid());
		findBuffyVertical = new Finder(directionalReader.getAllKeywords().get(2), directionalReader.makeGrid());
		findYdoa = new Finder(directionalReader.getAllKeywords().get(3), directionalReader.makeGrid());
		findBuow = new Finder(directionalReader.getAllKeywords().get(4), directionalReader.makeGrid());
		findRaru = new Finder(directionalReader.getAllKeywords().get(5), directionalReader.makeGrid());
		findBaora = new Finder(directionalReader.getAllKeywords().get(6), directionalReader.makeGrid());
		findAaody = new Finder(directionalReader.getAllKeywords().get(7), directionalReader.makeGrid());
		findCwou = new Finder(directionalReader.getAllKeywords().get(8), directionalReader.makeGrid());
		findAll = new Finder(directionalReader.getAllKeywords(), directionalReader.makeGrid());
		compassAaody = new Compass(directionalReader.getAllKeywords().get(7), new Coordinates(0, 4));
		compassCwou = new Compass(directionalReader.getAllKeywords().get(8), new Coordinates(4, 4));
	}

//	@Test
//	public void whenFindPotentialStartCoordinatesIsPassedItReturnsPotentalStartCoordinates() {
//		findTara.findFirstPotentials();
//		findDawn.findFirstPotentials();
//		String actual = findTara.findFirstPotentials().toString(); 
//		String actual2 = findDawn.findFirstPotentials().toString();
//		String expected = "[PotentialStartCoordinates [startCoordinates=(0,1), directions=null]]";
//		String expected2 = "[PotentialStartCoordinates [startCoordinates=(2,3), directions=null], "
//				+ "PotentialStartCoordinates [startCoordinates=(3,1), directions=null], "
//				+ "PotentialStartCoordinates [startCoordinates=(4,3), directions=null]]";
//		assertEquals(expected, actual);
//		assertEquals(expected2, actual2);
//	}
//	
	
	@Test
	public void whenCheckSecondCoordinatesIsPassedAHorizontalClueItAddsHorizontalToDirectionsField() {
		findTara.setDirectionsToPotentialCoordinates();
		Direction actual = findTara.getKeyword().getPotentialCoordinates().get(0).getDirections().get(0); 
		Direction expected = Direction.HORIZONTAL;
		assertEquals(expected, actual);
	}
	
//	@Test
//	public void whenCheckSecondCoordinatesIsPassedAVerticalItAddsVerticalToDirectionsField() {
//		findBuffyVertical.setDirectionsToPotentialCoordinates();
//		Direction actual = findBuffyVertical.getKeyword().getPotentialCoordinates().get(0).getDirections().get(0); 
//		Direction expected = Direction.VERTICAL;
//		assertEquals(expected, actual);
//	}
//	
//	
//	@Test
//	public void whenCheckSecondCoordinatesIsPassedAVerticalAndDiagnalDownClueItAddserticalAndDiagonalDownToDirectionsField() {
//		findBuffyVertical.setDirectionsToPotentialCoordinates();
//		Direction actual = findBuffyVertical.getKeyword().getPotentialCoordinates().get(0).getDirections().get(0);
//		Direction actual2 = findBuffyVertical.getKeyword().getPotentialCoordinates().get(0).getDirections().get(1);
//		Direction expected = Direction.VERTICAL;
//		Direction expected2 = Direction.DIAGONAL_DOWN;
//		assertEquals(expected, actual);
//		assertEquals(expected2, actual2);;
//	}
//
//	@Test
//	public void whenCheckSecondCoordinatesIsPassedADiagonalUpItAddsDiagonalUpToDirectionsField() {
//		findYdoa.setDirectionsToPotentialCoordinates();
//		Direction actual = findYdoa.getKeyword().getPotentialCoordinates().get(0).getDirections().get(0);
//		Direction expected = Direction.DIAGONAL_UP;
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void whenCheckSecondCoordinatesIsPassedABwHorizontalItAddsBwHorizontalToDirectionsField() {
//		findRaru.setDirectionsToPotentialCoordinates();
//		Direction actual = findRaru.getKeyword().getPotentialCoordinates().get(1).getDirections().get(0);
//		Direction expected = Direction.BW_HORIZONTAL;
//		assertEquals(expected, actual);
//	} 
//	
//	@Test
//	public void whenCheckSecondCoordinatesIsPassedABwVerticalItAddsBwVerticalToDirectionsField() {
//		findBaora.setDirectionsToPotentialCoordinates();	
//		Direction actual = findBaora.getKeyword().getPotentialCoordinates().get(0).getDirections().get(0);
//		Direction expected = Direction.BW_VERTICAL;
//		assertEquals(expected, actual);
//	} 
//	
//	@Test
//	public void whenCheckSecondCoordinatesIsPassedABwDiagonalDownItAddsBwDiagonalDownToDirectionsField() {
//		findAaody.setDirectionsToPotentialCoordinates();	
//		Boolean actual = compassAaody.checkBwDiagonalDown();
//		Direction actual2 = findAaody.getKeyword().getPotentialCoordinates().get(0).getDirections().get(0);
//		Boolean expected = true;
//		Direction expected2 = Direction.BW_DIAGONAL_DOWN;
//		assertEquals(expected, actual);
//		assertEquals(expected2, actual2);
//	} 
//	
//	@Test
//	public void whenCheckSecondCoordinatesIsPassedABwDiagonalUpItAddsBwDiagonalUpToDirectionsField() {
//		findCwou.setDirectionsToPotentialCoordinates();	
//		Boolean actual = compassCwou.checkBwDiagonalUp();
//		Direction actual2 = findCwou.getKeyword().getPotentialCoordinates().get(0).getDirections().get(0);
//		Boolean expected = true;
//		Direction expected2 = Direction.BW_DIAGONAL_UP;
//		assertEquals(expected, actual);
//		assertEquals(expected2, actual2);
//	} 
//	
//	@Test
//	public void whenSetKeywordToDirectionTypeIsPassedAHorizontalMatchItSetsIsFoundToTrue() {
//		findTara.setDirectionsToPotentialCoordinates();
//		findTara.setKeywordToDirectionType();
//		Boolean actual = findTara.getKeyword().getIsFound(); 
//		String actual2 = findTara.getKeyword().getCoordinates().toString();
//		Boolean expected = true;
//		String expected2 = "[(0,1), (0,2), (0,3), (0,4)]";
//		assertEquals(expected, actual);
//		assertEquals(expected2, actual2);
//	}
//	
//	@Ignore
//	@Test
//	public void whenGetKeywordSubstringIsPassedADirectionItReturnsSubstring() {
//		String actual = findTara.getKeyword().getRemainingLetters();
//		String expected = "ARA";
//		assertEquals(expected, actual);
//	}
	
	@Test
	public void whenSetKeywordToDirectionTypeIsPassedAHorizontalKeywordItCreatesAHorizontalSubtype() {
		findDawn.setDirectionsToPotentialCoordinates();
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
		findBuffyVertical.setDirectionsToPotentialCoordinates();
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
		findBuow.setDirectionsToPotentialCoordinates();
		findBuow.setKeywordToDirectionType();
		String actual = findBuow.getKeyword().getCoordinates().toString();
		String expected = "[(0,0), (1,1), (2,2), (3,3)]";
		assertEquals(expected, actual);
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedADiagonalUpItKeywordItCreatesADiagonalUpSubtype() {
		findYdoa.setDirectionsToPotentialCoordinates();
		findYdoa.setKeywordToDirectionType();
		Boolean actual = findYdoa.getKeyword().getIsFound();
		String actual2 = findYdoa.getKeyword().getCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(4,0), (3,1), (2,2), (1,3)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}
	
	@Test
	public void whenSetKeywordToDirectionTypeIsPassedABwHorizontallKeywordItCreatesABwHorizontalSubtype() {
		findRaru.setDirectionsToPotentialCoordinates();
		findRaru.setKeywordToDirectionType();
		String actual = findRaru.getKeyword().getCoordinates().toString();
		String expected = "[(1,4), (1,3), (1,2), (1,1)]";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenSetKeywordToDirectionTypeIsPassedABwVerticalItCreatesABwVerticalSubtype() {
		findBaora.setDirectionsToPotentialCoordinates();
		findBaora.setKeywordToDirectionType();
		String actual = findBaora.getKeyword().getCoordinates().toString();
		String expected = "[(4,2), (3,2), (2,2), (1,2), (0,2)]";
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenSetKeywordToDirectionTypeIsPassedABwDiagonalDownItCreatesABwDiagonalDownSubtype() {
		findAaody.setDirectionsToPotentialCoordinates();
		findAaody.setKeywordToDirectionType();
		String actual = findAaody.getKeyword().getCoordinates().toString();
		String expected = "[(0,4), (1,3), (2,2), (3,1), (4,0)]";
		assertEquals(expected, actual);
	}
//	
//	@Test
//	public void whenSetKeywordToDirectionTypeIsPassedABwDiagonalUPItCreatesABwDiagonalUpSubtype() {
//		findCwou.setDirectionsToPotentialCoordinates();
//		findCwou.setKeywordToDirectionType();
//		String actual = findCwou.getKeyword().getCoordinates().toString();
//		String expected = "[(4,4), (3,3), (2,2), (1,1)]";
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void whenFindKeywordIsPassedCoordinatesAreReturned() {
//		String actual = findBuffyVertical.findKeyword();
//		String expected = "BUFFY: (0,0),(1,0),(2,0),(3,0),(4,0)";
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void whenFindAllKeywordCoordinatesIsPassedItReturnsAListOfPrintedCoordinates() {
//		String actual = findAll.findAllKeywordCoordinates().toString();
//		String expected = "[TARA: (0,1),(0,2),(0,3),(0,4), DAWN: (3,1),(3,2),(3,3),(3,4), "
//				+ "BUFFY: (0,0),(1,0),(2,0),(3,0),(4,0), YDOA: (4,0),(3,1),(2,2),(1,3), "
//				+ "BUOW: (0,0),(1,1),(2,2),(3,3), RARU: (1,4),(1,3),(1,2),(1,1), "
//				+ "BAORA: (4,2),(3,2),(2,2),(1,2),(0,2), AAODY: (0,4),(1,3),(2,2),(3,1),(4,0), "
//				+ "CWOU: (4,4),(3,3),(2,2),(1,1)]";
//		assertEquals(expected, actual);
//	}
	

	
	
	
	
}
