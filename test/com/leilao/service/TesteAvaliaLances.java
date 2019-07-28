package com.leilao.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.leilao.builder.CriaNovoLeilao;
import com.leilao.domain.Lance;
import com.leilao.domain.Leilao;
import com.leilao.domain.Participantes;

public class TesteAvaliaLances {

	private AvaliaLances avaliador;
	private Participantes Joana;
	private Participantes Ana;
	private Participantes Pedro;
	private Leilao leilao;

	@Before
	public void novoAvaliadorLances() {

		this.Joana = new Participantes("Joana");
		this.Ana = new Participantes("Ana");
		this.Pedro = new Participantes("Pedro");

		this.avaliador = new AvaliaLances();

	}
	
	@Test
	public void deveAvaliarLimiteMaiorValor() {
		
		//cria um leilao e passa os primeiros lances
		leilao = new CriaNovoLeilao().novoLeilao("Leilao de tipos de testes").lance(Ana, 200).lance(Pedro, 200).build();

		avaliador.avaliaLances(leilao);

		assertEquals(200, avaliador.getMaiorValor(), 0.001);


	}


	@Test
	public void devePermitirLancesEmOrdemAscendente() {
		
		//cria um leilao e passa os primeiros lances
		leilao = new CriaNovoLeilao().novoLeilao("Leilao de tipos de testes").lance(Ana, 200).lance(Pedro, 400).build();

		avaliador.avaliaLances(leilao);

		assertEquals(400, avaliador.getMaiorValor(), 0.001);
		assertEquals(200, avaliador.getMenorValor(), 0.001);
		assertEquals(300, avaliador.getValorMedio(), 0.001);

	}

	@Test
	public void devePermitirLanceUnico() {

		leilao = new CriaNovoLeilao().novoLeilao("Leilao de tipos de testes").lance(Ana, 50).build();

		avaliador.avaliaLances(leilao);

		assertEquals(50, avaliador.getMaiorValor(), 0.001);
		assertEquals(50, avaliador.getMenorValor(), 0.001);

	}

	@Test
	public void deveAvaliarTresMaioresLances() {

		leilao = new CriaNovoLeilao().novoLeilao("Leilao de tipos de testes").lance(Joana, 1000).lance(Ana, 300)
				.lance(Pedro, 400).lance(Ana, 3000).build();

		avaliador.avaliaLances(leilao);

		List<Lance> bigger = avaliador.getTresMaioresLances();
		
		assertEquals(3, bigger.size());
		assertEquals(3000, bigger.get(0).getValorLance(), 0.001);
		assertEquals(1000, bigger.get(1).getValorLance(), 0.001);
		assertEquals(400, bigger.get(2).getValorLance(), 0.001);

	}

	@Test
	public void deveAvaliarMaioreMenorLancesEnviadosAleatoriamente() {

				leilao = new CriaNovoLeilao().novoLeilao("Leilao de tipos de testes").lance(Joana, 200).lance(Ana, 450)
				.lance(Pedro, 120).lance(Ana, 700).lance(Ana, 630).lance(Ana, 230).build();

		avaliador.avaliaLances(leilao);

		assertEquals(700, avaliador.getMaiorValor(), 0.001);
		assertEquals(120, avaliador.getMenorValor(), 0.001);

	}

	//Teste do valor limite
	@Test
	public void deveEncontrarMaiorLanceComValorLimite() {

		leilao = new CriaNovoLeilao().novoLeilao("Leilao de tipos de testes").lance(Joana, 400.01).lance(Ana, 400)
				.lance(Pedro, 101).lance(Ana, 101.1).build();

		avaliador.avaliaLances(leilao);

		assertEquals(400.01, avaliador.getMaiorValor(), 0.001);
		

	}


	@Test(expected = RuntimeException.class)
	public void deveRetornarErroSeNenhumLanceFoiEnviado() {

		leilao = new CriaNovoLeilao().build();

		avaliador.avaliaLances(leilao);

	}

	@After
	public void finaliza() {
		System.out.println("fim de leilao");
	}

}
