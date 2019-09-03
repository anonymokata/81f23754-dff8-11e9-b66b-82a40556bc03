import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordSearchReader {
	
	private Path filePath;
	
	public WordSearchReader(Path filePath) {
		this.filePath = filePath;
	}

	public WordSearchReader(String filePath) {
		this(Paths.get(filePath));
	}

	public List<String> readFile() {
		
		try {
			return Files.readAllLines(filePath);
		} catch (FileNotFoundException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

}
