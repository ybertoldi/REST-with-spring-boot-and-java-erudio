package br.com.yuri;

public class Greeting {
	private final long id;
	private final String content;
	private final String teste;
	
	
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
		this.teste = "testando";
	}


	public long getId() {
		return id;
	}


	public String getContent() {
		return content;
	}
	
	public String getTeste() {
		return teste;
	}
	

}
