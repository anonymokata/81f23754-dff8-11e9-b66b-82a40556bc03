import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WordSearchTest {

	
	@Test
	public void whenReadFileIsPassedItReturnsAListOfStringsFromTheTextFile() {
		WordSearchReader wordSearchReader = new WordSearchReader("small_test.txt");
		List<String> actual = wordSearchReader.readFile();
		List<String> expected = Arrays.asList("BUFFY","XANDER","GILES");
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenReadKeywordsIsPassedItReturnsAStringOfKeywords() {
		WordSearchReader wordSearchReader = new WordSearchReader("keyword_test.txt");
		String actual = wordSearchReader.readKeywords();
		String expected = "BUFFY,XANDER,GILES";
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenReadPuzzleIsPassedItReturnsTheListOfPuzzleStrings() {
		WordSearchReader wordSearchReader = new WordSearchReader("puzzle_test.txt");
		List<String> actual = wordSearchReader.readPuzzle();
		List<String> expected = Arrays.asList("Y,G,M,E,F,B,N,D,H,D,G,Y,Y,B,I", "E,K,G,H,Q,Z,T,J,A,A,F,F,F,M,K");
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenSplitKeywordsIsPassedItReturnsAnArrayOfKeywords() {
		WordSearchReader wordSearchReader = new WordSearchReader("keyword_test.txt");
		String[] actual = wordSearchReader.splitKeywords();
		String[] expected = {"BUFFY","XANDER","GILES"};
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	public void whenMakeGridIsPassedItReturnsThePuzzleAsA2DArraySmall() {
		WordSearchReader wordSearchReader = new WordSearchReader("puzzle_grid_test_small.txt");
		String[][] actual = wordSearchReader.makeGrid();
		String[][] expected = {{"Y","G"}, {"E","K"}};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void whenMakeGridIsPassedItReturnsThePuzzleAsA2DArrayMedium() {
		WordSearchReader wordSearchReader = new WordSearchReader("puzzle_grid_test_medium.txt");
		String[][] actual = wordSearchReader.makeGrid();
		String[][] expected = {{"Y","G","M"}, {"E","K","G"}, {"H","O","A"}};
		assertArrayEquals(expected, actual);
	}
	

}
