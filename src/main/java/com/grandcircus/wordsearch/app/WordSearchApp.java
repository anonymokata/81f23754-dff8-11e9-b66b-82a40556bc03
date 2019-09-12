package com.grandcircus.wordsearch.app;

public class WordSearchApp {

	public static void main(String[] args) {

		WordSearchReader reader = new WordSearchReader("mega_puzzle.txt");
		Grid grid = new Grid(reader.makeGrid());
		Finder findAll = new Finder(reader.getAllKeywords());

		findAll.findAllKeywordCoordinates();
		System.out.println(findAll.printAllKeywordCoordinates());
	}
}
