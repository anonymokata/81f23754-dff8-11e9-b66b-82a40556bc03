
public class Keyword {

	private String word;
	private Integer length;
	private Boolean isFound;

	public Keyword(String word, Boolean isFound) {
		super();
		this.word = word;
		this.isFound = isFound;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getLength() {
		return getWord().length();
	}

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
	}

	@Override
	public String toString() {
		return word;
	}

}
