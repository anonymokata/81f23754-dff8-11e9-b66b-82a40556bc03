package com.grandcircus.wordsearch.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grandcircus.wordsearch.app.Finder;
import com.grandcircus.wordsearch.app.WordSearchReader;
import com.grandcircus.wordsearch.compass.Compass;
import com.grandcircus.wordsearch.keyword.Coordinates;
import com.grandcircus.wordsearch.keyword.Direction;

public class DirectionalTests {

	WordSearchReader reader;
	Finder findTara;
	Finder findDawn;
	Finder findBuffy;
	Finder findYdoa;
	Finder findBuow;
	Finder findRaru;
	Finder findBaora;
	Finder findAaody;
	Finder findCwou;
	Finder findAll;
	Compass compassTara;

	@BeforeEach
	public void setup() {

		reader = new WordSearchReader("directional_tests.txt");
		reader.makeGrid();
		findAll = new Finder(reader.getAllKeywords());
		findTara = new Finder(findAll.getAllKeywords().get(0));
		findDawn = new Finder(findAll.getAllKeywords().get(1));
		findBuffy = new Finder(findAll.getAllKeywords().get(2));
		findYdoa = new Finder(findAll.getAllKeywords().get(3));
		findBuow = new Finder(findAll.getAllKeywords().get(4));
		findRaru = new Finder(findAll.getAllKeywords().get(5));
		findBaora = new Finder(findAll.getAllKeywords().get(6));
		findAaody = new Finder(findAll.getAllKeywords().get(7));
		findCwou = new Finder(findAll.getAllKeywords().get(8));
		compassTara = new Compass(findAll.getAllKeywords().get(0), new Coordinates(0, 4));
	}

	@Test
	public void whenFindPotentialStartCoordinatesIsPassedItReturnsPotentalStartCoordinates() {
		findTara.findFirstPotentials();
		findDawn.findFirstPotentials();
		String actual = findTara.findFirstPotentials().toString();
		String actual2 = findDawn.findFirstPotentials().toString();
		String expected = "[(0,1)]";
		String expected2 = "[(2,3), (3,1), (4,3)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedAHorizontalClueItAddsHorizontalToDirectionsField() {
		findTara.addDirectionsToPotentialCoordinates();
		Direction actual = findTara.getCompasses().get(0).getDirections().get(0);
		Direction expected = Direction.HORIZONTAL;
		assertEquals(expected, actual);
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedAVerticalItAddsVerticalToDirectionsField() {
		findBuffy.addDirectionsToPotentialCoordinates();
		Direction actual = findBuffy.getCompasses().get(0).getDirections().get(0);
		Direction expected = Direction.VERTICAL;
		assertEquals(expected, actual);
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedAVerticalAndDiagnalDownClueItAddserticalAndDiagonalDownToDirectionsField() {
		findBuffy.addDirectionsToPotentialCoordinates();
		Direction actual = findBuffy.getCompasses().get(0).getDirections().get(0);
		Direction actual2 = findBuffy.getCompasses().get(0).getDirections().get(1);
		Direction expected = Direction.VERTICAL;
		Direction expected2 = Direction.DIAGONAL_DOWN;
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
		;
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedADiagonalUpItAddsDiagonalUpToDirectionsField() {
		findYdoa.addDirectionsToPotentialCoordinates();
		Direction actual = findYdoa.getCompasses().get(0).getDirections().get(0);
		Direction expected = Direction.DIAGONAL_UP;
		assertEquals(expected, actual);
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedABwHorizontalItAddsBwHorizontalToDirectionsField() {
		findRaru.addDirectionsToPotentialCoordinates();
		Direction actual = findRaru.getCompasses().get(0).getDirections().get(1);
		Direction expected = Direction.BW_HORIZONTAL;
		assertEquals(expected, actual);
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedABwVerticalItAddsBwVerticalToDirectionsField() {
		findBaora.addDirectionsToPotentialCoordinates();
		Direction actual = findBaora.getCompasses().get(0).getDirections().get(0);
		Direction expected = Direction.BW_VERTICAL;
		assertEquals(expected, actual);
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedABwDiagonalDownItAddsBwDiagonalDownToDirectionsField() {
		findAaody.addDirectionsToPotentialCoordinates();
		Direction actual = findAaody.getCompasses().get(0).getDirections().get(0);
		Direction expected = Direction.BW_DIAGONAL_DOWN;
		assertEquals(expected, actual);
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedABwDiagonalUpItAddsBwDiagonalUpToDirectionsField() {
		findCwou.addDirectionsToPotentialCoordinates();
		Direction actual = findCwou.getCompasses().get(0).getDirections().get(0);
		Direction expected = Direction.BW_DIAGONAL_UP;
		assertEquals(expected, actual);
	}

	@Test
	public void whenSetKeywordToDirectionTypeIsPassedAHorizontalMatchItSetsIsFoundToTrue() {
		findTara.addDirectionsToPotentialCoordinates();
		Boolean actual = findTara.getKeyword().getIsFound();
		String actual2 = findTara.getKeyword().getAllCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(0,1), (0,2), (0,3), (0,4)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}

	@Test
	public void whenGetKeywordSubstringIsPassedADirectionItReturnsSubstring() {
		String actual = compassTara.getKeyword().getRemainingLetters();
		String expected = "ARA";
		assertEquals(expected, actual);
	}

	@Test
	public void whenSetKeywordToDirectionTypeIsPassedAHorizontalKeywordItCreatesAHorizontalSubtype() {
		findDawn.addDirectionsToPotentialCoordinates();
		Boolean actual = findDawn.getKeyword().getIsFound();
		String actual2 = findDawn.getKeyword().getAllCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(3,1), (3,2), (3,3), (3,4)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}

	@Test
	public void whenSetKeywordToDirectionTypeIsPassedAVerticalKeywordItCreatesAVerticallSubtypeAndReturnsCoordinates() {
		findBuffy.addDirectionsToPotentialCoordinates();
		Boolean actual = findBuffy.getKeyword().getIsFound();
		String actual2 = findBuffy.getKeyword().getAllCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(0,0), (1,0), (2,0), (3,0), (4,0)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}

	@Test
	public void whenSetKeywordToDirectionTypeIsPassedADiagonalDownlKeywordItCreatesADiagonalDownlSubtypeAndReturnsCoordinates() {
		findBuow.addDirectionsToPotentialCoordinates();
		String actual = findBuow.getKeyword().getAllCoordinates().toString();
		String expected = "[(0,0), (1,1), (2,2), (3,3)]";
		assertEquals(expected, actual);
	}

	@Test
	public void whenCheckSecondCoordinatesIsPassedADiagonalUpItKeywordItCreatesADiagonalUpSubtype() {
		findYdoa.addDirectionsToPotentialCoordinates();
		Boolean actual = findYdoa.getKeyword().getIsFound();
		String actual2 = findYdoa.getKeyword().getAllCoordinates().toString();
		Boolean expected = true;
		String expected2 = "[(4,0), (3,1), (2,2), (1,3)]";
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}

	@Test
	public void whenSetKeywordToDirectionTypeIsPassedABwHorizontallKeywordItCreatesABwHorizontalSubtype() {
		findRaru.addDirectionsToPotentialCoordinates();
		String actual = findRaru.getKeyword().getAllCoordinates().toString();
		String expected = "[(1,4), (1,3), (1,2), (1,1)]";
		assertEquals(expected, actual);
	}

	@Test
	public void whenSetKeywordToDirectionTypeIsPassedABwVerticalItCreatesABwVerticalSubtype() {
		findBaora.addDirectionsToPotentialCoordinates();
		String actual = findBaora.getKeyword().getAllCoordinates().toString();
		String expected = "[(4,2), (3,2), (2,2), (1,2), (0,2)]";
		assertEquals(expected, actual);
	}

	@Test
	public void whenSetKeywordToDirectionTypeIsPassedABwDiagonalDownItCreatesABwDiagonalDownSubtype() {
		findAaody.addDirectionsToPotentialCoordinates();
		String actual = findAaody.getKeyword().getAllCoordinates().toString();
		String expected = "[(0,4), (1,3), (2,2), (3,1), (4,0)]";
		assertEquals(expected, actual);
	}

	@Test
	public void whenSetKeywordToDirectionTypeIsPassedABwDiagonalUPItCreatesABwDiagonalUpSubtype() {
		findCwou.addDirectionsToPotentialCoordinates();
		String actual = findCwou.getKeyword().getAllCoordinates().toString();
		String expected = "[(4,4), (3,3), (2,2), (1,1)]";
		assertEquals(expected, actual);
	}

	@Test
	public void whenFindKeywordIsPassedCoordinatesAreReturned() {
		String actual = findBuffy.findKeywordCoordinates();
		String expected = "BUFFY: (0,0),(1,0),(2,0),(3,0),(4,0)";
		assertEquals(expected, actual);
	}

	@Test
	public void whenFindAllKeywordCoordinatesIsPassedItReturnsAListOfPrintedCoordinates() {
		findAll.findAllKeywordCoordinates();
		String actual = findAll.getAllKeywordCoordinates().toString();
		String expected = "[TARA: (0,1),(0,2),(0,3),(0,4), DAWN: (3,1),(3,2),(3,3),(3,4), "
				+ "BUFFY: (0,0),(1,0),(2,0),(3,0),(4,0), YDOA: (4,0),(3,1),(2,2),(1,3), "
				+ "BUOW: (0,0),(1,1),(2,2),(3,3), RARU: (1,4),(1,3),(1,2),(1,1), "
				+ "BAORA: (4,2),(3,2),(2,2),(1,2),(0,2), AAODY: (0,4),(1,3),(2,2),(3,1),(4,0), "
				+ "CWOU: (4,4),(3,3),(2,2),(1,1)]";
		assertEquals(expected, actual);
	}
}
