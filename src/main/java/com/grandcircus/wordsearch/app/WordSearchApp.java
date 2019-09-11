package com.grandcircus.wordsearch.app;

public class WordSearchApp {

	public static void main(String[] args) {
		
		WordSearchReader reader = new WordSearchReader("mega_puzzle.txt");
		Finder findAll = new Finder(reader.getAllKeywords(), reader.makeGrid());
		
		findAll.findAllKeywordCoordinates();
		System.out.println(findAll.printAllKeywordCoordinates());
	}	
}
