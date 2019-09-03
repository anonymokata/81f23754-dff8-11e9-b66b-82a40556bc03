import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WordSearchTest {

	@Test
	public void whenReadFileIsPassedItReturnsAListOfStringsFromTheTextFile() {
		WordSearchReader wordSearchReader = new WordSearchReader("small_test.txt");
		List<String> actual = wordSearchReader.readFile();
		List<String> expected = Arrays.asList("BUFFY", "XANDER", "GILES");
	    assertEquals(expected, actual);
	}

}
