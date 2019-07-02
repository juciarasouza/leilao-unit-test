package com.leilao.builder;

import com.leilao.domain.Leilao;
import com.leilao.domain.Lance;
import com.leilao.domain.Participantes;

public class CriaNovoLeilao {

	private Leilao leilao;

	public CriaNovoLeilao novoLeilao(String descricao) {
		this.leilao = new Leilao (descricao);
		return this;
	}

	public CriaNovoLeilao lance(Participantes participantes, double valorLance) {
		leilao.lance(new Lance(participantes, valorLance));
		return this;
	}
	
	public Leilao build() {
		return leilao;
	}


}
