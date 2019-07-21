package com.leilao.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leilao.domain.Leilao;
import com.leilao.domain.Lance;

public class AvaliaLances {

	private double valorMaiorQue = Double.NEGATIVE_INFINITY;
	private double valorMenorQue = Double.POSITIVE_INFINITY;
	private double 
	private double total = 0;
	private double mediaValores = 0;
	private List<Lance> maioresLances;

	public void avaliaLances(Leilao leilao) {
		
		if(leilao.getLances().size() == 0)
			throw new RuntimeException("Leilao sem lances"); 

		for (Lance lance : leilao.getLances()) {

			if (lance.getValorLance() > valorMaiorQue)
				valorMaiorQue = lance.getValorLance();
			if (lance.getValorLance() < valorMenorQue)
				valorMenorQue = lance.getValorLance();
			
			

			total += lance.getValorLance();
		}

		mediaValores = total / leilao.getLances().size();

		maioresLances = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maioresLances, new Comparator<Lance>() {

			public int compare(Lance bid1, Lance bid2) {
				if (bid1.getValorLance() < bid2.getValorLance())
					return 1;
				else return -1;
			
			}

		});
		maioresLances = maioresLances.subList(0, maioresLances.size() > 3 ? 3 : maioresLances.size());

	}

	public double getMaiorValor() {
		return valorMaiorQue;
	}

	public double getMenorValor() {
		return valorMenorQue;
	}

	public double getValorMedio() {
		return mediaValores;
	}

	public List<Lance> getTresMaioresLances() {
		return maioresLances;
	}
}
