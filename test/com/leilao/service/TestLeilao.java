package com.leilao.service;

import org.junit.Test;

import com.leilao.domain.Leilao;
import com.leilao.domain.Lance;
import com.leilao.domain.Participantes;

import static org.junit.Assert.assertEquals;

public class TestLeilao {
	
	@Test	
	public void deveReceberLance(){
		Leilao leilao = new Leilao("Celular");		
		assertEquals(0,leilao.getLances().size());
		
		leilao.lance(new Lance(new Participantes("Mauricio"),200));
		assertEquals(1,leilao.getLances().size());
		assertEquals(200, leilao.getLances().get(0).getValorLance(),0.001);
		assertEquals("Celular", leilao.getDescricao());
	}
	
	@Test	
	public void deveReceberMaisdeUmLance(){
		
		Leilao leilao = new Leilao("Notebook");		
			
		leilao.lance(new Lance(new Participantes("Marcos"),200));
		leilao.lance(new Lance(new Participantes("Suzi"),300));
		assertEquals(2,leilao.getLances().size());
		assertEquals(200, leilao.getLances().get(0).getValorLance(),0.001);
		assertEquals(300, leilao.getLances().get(1).getValorLance(),0.001);
		assertEquals("Notebook", leilao.getDescricao());
	}
	
	
	@Test
	public void naoDevePermitirMaisQueQuatroLancesPorParticipante() {
		Leilao leilao = new Leilao ("Televisão");
		Participantes maria = new Participantes("Maria");
		Participantes marcos = new Participantes("Marcos");
		
		leilao.lance(new Lance(maria, 100));
		leilao.lance(new Lance (marcos, 110));
		
		leilao.lance(new Lance (maria, 130));
		leilao.lance(new Lance (marcos, 140));
		
		leilao.lance(new Lance (maria, 150));
		leilao.lance(new Lance (marcos, 160));
		
		leilao.lance(new Lance (maria, 170));
		leilao.lance(new Lance (marcos, 180));
		
		leilao.lance(new Lance (maria, 210));
		
		assertEquals(8, leilao.getLances().size());
		assertEquals(180, leilao.getLances().get(7).getValorLance(), 0.001);
		
	}

}
