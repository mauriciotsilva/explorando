package br.com.mauriciotsilva.explorer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.mauriciotsilva.explorer.navegacao.Coordenada;

public class PlanatoTeste {

	@Test
	public void deveCriarComCoordenadaEmString() {

		Planalto planalto = Planalto.com("10 5");

		assertEquals(10, planalto.getX());
		assertEquals(5, planalto.getY());
	}

	@Test
	public void deveSerIgualAoPlanaltoComMesmoTamanho() {
		Planalto planalto = Planalto.com("5 6");
		Planalto outro = Planalto.com(5, 6);

		assertEquals(planalto, outro);

	}

	@Test(expected = NullPointerException.class)
	public void naoDeveCriarComStringNula() {
		Planalto.com((String) null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarComCoordenaVazia() {
		Planalto.com("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarComCoordenadaIncompleta() {
		Planalto.com("10");
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveExplorarAreaInvalida() {
		Planalto planalto = Planalto.com("10 4");
		planalto.explorar(new Coordenada(11, 2));
	}

	@Test
	public void deveExplorarCoordenada() {
		Planalto planalto = Planalto.com("10 5");
		planalto.explorar(new Coordenada(10, 5));
	}

}
