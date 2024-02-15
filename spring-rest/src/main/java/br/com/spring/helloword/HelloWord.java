package br.com.spring.helloword;

public class HelloWord {
	private long id;
	private String content;

	public HelloWord() {
	}
	
	public HelloWord(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
