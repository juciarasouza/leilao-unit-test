package com.leilao.domain;

public class Lance {

	private Participantes participantes;
	private double valorLance;
	
	public Lance(Participantes participantes, double valorLance) {
		this.participantes = participantes;
		this.valorLance = valorLance;
	}

	public Participantes getUsuarios() {
		return participantes;
	}

	public double getValorLance() {
		return valorLance;
	}
	
	
	
}
