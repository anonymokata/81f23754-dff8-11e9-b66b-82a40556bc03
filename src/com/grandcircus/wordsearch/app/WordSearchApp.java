package com.grandcircus.wordsearch.app;

public class WordSearchApp {

	public static void main(String[] args) {
		
		WordSearchReader reader = new WordSearchReader("big_puzzle.txt");
		Finder findAll = new Finder(reader.getAllKeywords(), reader.makeGrid());
		
		String printedKeywords = (findAll.printAllKeywordCoordinates(findAll.findAllKeywordCoordinates()));
		System.out.println(printedKeywords);
	}
}
