package br.com.mauriciotsilva.explorer.navegacao;

import static br.com.mauriciotsilva.explorer.navegacao.Direcao.N;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BussolaTeste {

	@Test(expected = NullPointerException.class)
	public void naoDeveCriarComCoordenadaNula() {
		Bussola.com(N, (Coordenada) null);
	}

	@Test(expected = NullPointerException.class)
	public void naoDeveCriarComApontamentoNulo() {
		Bussola.com((Direcao) null, new Coordenada());
	}

	@Test(expected = NullPointerException.class)
	public void naoDeveCriarComStringNula() {
		Bussola.com((String) null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarSemCoordenada() {
		Bussola.com("N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarSemApontamento() {
		Bussola.com("0 0");
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarComStringVazia() {
		Bussola.com("");
	}

	@Test
	public void deveCriarComCoordenadaEmString() {
		Bussola bussola = Bussola.com("1 2 N");

		assertEquals("Nao esta apontado para o Norte", N, bussola.getApontado());
		assertEquals("coordena nao confere", new Coordenada(1, 2), bussola.getCoordenada());
	}

	@Test
	public void deveSerIgualABussolaComMesmaCoordenada() {
		Bussola bussola = Bussola.com("1 2 N");
		Bussola outra = Bussola.com(Direcao.N, new Coordenada(1, 2));

		assertEquals("Nao sao iguais", outra, bussola);
	}

	@Test
	public void deveGirarParaEsquerda() {
		Bussola bussola = Bussola.com("0 0 N");

		bussola.girar(Lado.L);
		assertEquals(Bussola.com("0 0 W"), bussola);

		bussola.girar(Lado.L);
		assertEquals(Bussola.com("0 0 S"), bussola);

		bussola.girar(Lado.L);
		assertEquals(Bussola.com("0 0 E"), bussola);

		bussola.girar(Lado.L);
		assertEquals(Bussola.com("0 0 N"), bussola);
	}

	@Test
	public void deveGirarParaDereita() {
		Bussola bussola = Bussola.com("0 0 N");

		bussola.girar(Lado.R);
		assertEquals(Bussola.com("0 0 E"), bussola);

		bussola.girar(Lado.R);
		assertEquals(Bussola.com("0 0 S"), bussola);

		bussola.girar(Lado.R);
		assertEquals(Bussola.com("0 0 W"), bussola);

		bussola.girar(Lado.R);
		assertEquals(Bussola.com("0 0 N"), bussola);
	}

}
