package br.com.mauriciotsilva.explorer.navegacao;

import static br.com.mauriciotsilva.explorer.navegacao.Direcao.E;
import static br.com.mauriciotsilva.explorer.navegacao.Direcao.N;
import static br.com.mauriciotsilva.explorer.navegacao.Direcao.S;
import static br.com.mauriciotsilva.explorer.navegacao.Direcao.W;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirecaoTeste {

	@Test
	public void deveDarProximoADireita() {

		Direcao direcao = N;

		assertEquals(E, direcao = direcao.proximo(Lado.R));
		assertEquals(S, direcao = direcao.proximo(Lado.R));
		assertEquals(W, direcao = direcao.proximo(Lado.R));
		assertEquals(N, direcao.proximo(Lado.R));
	}

	@Test
	public void deveDarProximoAEsquerda() {

		Direcao direcao = N;

		assertEquals(W, direcao = direcao.proximo(Lado.L));
		assertEquals(S, direcao = direcao.proximo(Lado.L));
		assertEquals(E, direcao = direcao.proximo(Lado.L));
		assertEquals(N, direcao.proximo(Lado.L));
	}

}
