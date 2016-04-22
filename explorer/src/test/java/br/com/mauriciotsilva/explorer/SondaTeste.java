package br.com.mauriciotsilva.explorer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

import br.com.mauriciotsilva.explorer.navegacao.Bussola;

public class SondaTeste {

	private Sonda sonda;
	private Planalto planalto;
	private Bussola posicaoInicial;

	@Before
	public void iniciar() {
		planalto = Planalto.com("5 5");
		posicaoInicial = Bussola.com("0 0 N");
		sonda = new Sonda(planalto, posicaoInicial);
	}

	@Test(expected = NullPointerException.class)
	public void naoDeveCriarSemPosicaoInicial() {
		new Sonda(planalto, (Bussola) null);
	}

	@Test(expected = NullPointerException.class)
	public void naoDeveCriarSemPlanalto() {
		new Sonda((Planalto) null, Bussola.com("0 0 N"));
	}

	@Test
	public void naoDeveAlterarAposicaoAtualDeFormaExterna() {
		Bussola bussola = Bussola.com("0 0 N");

		Sonda sonda = new Sonda(planalto, bussola);
		assertNotSame("Nao pode ser o mesmo", bussola, sonda.getPosicaoAtual());
	}

	@Test
	public void deveGirarNoventaGrausParaDireita() {

		sonda.mover('R');
		assertEquals(Bussola.com("0 0 E"), sonda.getPosicaoAtual());

		sonda.mover('R');
		assertEquals(Bussola.com("0 0 S"), sonda.getPosicaoAtual());

		sonda.mover('R');
		assertEquals(Bussola.com("0 0 W"), sonda.getPosicaoAtual());

		sonda.mover('R');
		assertEquals(Bussola.com("0 0 N"), sonda.getPosicaoAtual());
	}

	@Test
	public void deveGirarNoventaGrausParaEsquerda() {

		sonda.mover('L');
		assertEquals(Bussola.com("0 0 W"), sonda.getPosicaoAtual());

		sonda.mover('L');
		assertEquals(Bussola.com("0 0 S"), sonda.getPosicaoAtual());

		sonda.mover('L');
		assertEquals(Bussola.com("0 0 E"), sonda.getPosicaoAtual());

		sonda.mover('L');
		assertEquals(Bussola.com("0 0 N"), sonda.getPosicaoAtual());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarComandoInvalidoParaMover() {
		sonda.mover('a');
	}

	@Test
	public void deveMoverUmNoEixoY() {

		sonda.mover("M");
		assertEquals(Bussola.com("0 1 N"), sonda.getPosicaoAtual());
	
		sonda.mover("RRM");
		assertEquals(Bussola.com("0 0 S"), sonda.getPosicaoAtual());
	}
	
	@Test
	public void deveMoverUmNoEixoX() {

		sonda.mover("RM");
		assertEquals(Bussola.com("1 0 E"), sonda.getPosicaoAtual());
	
		sonda.mover("RRM");
		assertEquals(Bussola.com("0 0 W"), sonda.getPosicaoAtual());
	}

	@Test
	public void deveGirarParaDireitaEMover() {
		Sonda sonda = new Sonda(planalto, Bussola.com("3 3 E"));
		sonda.mover("MMRMMRMRRM");

		assertEquals(Bussola.com("5 1 E"), sonda.getPosicaoAtual());
	}

	@Test
	public void deveGirarParaEsquerdaEMover() {
		Sonda sonda = new Sonda(planalto, Bussola.com("1 2 N"));
		sonda.mover("LMLMLMLMM");

		assertEquals(Bussola.com("1 3 N"), sonda.getPosicaoAtual());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSairDoPlanalto() {
		sonda.mover("MMMMMM");
	}

}
