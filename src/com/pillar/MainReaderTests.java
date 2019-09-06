package com.pillar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainReaderTests {

	WordSearchReader mainReader;
	Finder findXander;

	@BeforeEach
	public void setup() {
		mainReader = new WordSearchReader("word_search.txt");
		findXander = new Finder(mainReader.getAllKeywords().get(1), mainReader.makeGrid());		
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
}
