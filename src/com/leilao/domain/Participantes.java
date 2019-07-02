package com.leilao.domain;

public class Participantes {

	private int id;
	private String name;
	
	public Participantes(String name) {
		this(0, name);
	}

	public Participantes(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	
}
