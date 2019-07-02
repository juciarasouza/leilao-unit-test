package com.leilao.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void lance(Lance lance) {
		if(lances.isEmpty() || permitidoEnviarLance(lance.getUsuarios()))
		lances.add(lance);
	}

	private boolean permitidoEnviarLance(Participantes participantes) {
		return !ultimoLance().getUsuarios().equals(participantes) && contaLancesPorUsuario(participantes)<4;
	}

	private int contaLancesPorUsuario(Participantes participantes) {
		int total = 0;
		
		for(Lance listaLances : lances){
			if(listaLances.getUsuarios().equals(participantes)) total++;
		}
		return total;
	}

	private Lance ultimoLance() {
		return lances.get(lances.size()-1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	
	
}
