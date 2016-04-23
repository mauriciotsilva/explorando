package br.com.mauriciotsilva.explorer;

import static java.util.Objects.requireNonNull;

import br.com.mauriciotsilva.explorer.navegacao.Bussola;
import br.com.mauriciotsilva.explorer.navegacao.Coordenada;
import br.com.mauriciotsilva.explorer.navegacao.Lado;

public class Sonda {

	private static final String COMANDOS_VALIDOS = "RLM";
	private Bussola bussola;
	private Planalto planalto;

	public Sonda(Planalto planalto, Bussola posicaoInicial) {
		this.planalto = requireNonNull(planalto, "Planalto nao pode ser nulo");
		this.bussola = requireNonNull(posicaoInicial, "Posicao Inicial nao deve ser nulo").clone();
	}
	
	public Coordenada getCoordernada(){
		return getPosicaoAtual().getCoordenada();
	}

	public void mover(String comandos) {
		for (char comando : comandos.toCharArray()) {
			mover(comando);
		}
	}

	public void mover(char comando) {
		validarComando(comando);
		if ('M' == comando) {
			movimentar();
		} else {
			bussola.girar(Lado.valueOf(comando));
		}
	}

	private void movimentar() {
		Bussola proximo = bussola.movimentar(1);
		validarProximoMovimento(proximo);
		bussola = proximo;
	}

	private void validarComando(char comando) {
		int index = COMANDOS_VALIDOS.indexOf(comando);
		if (index < 0) {
			throw new IllegalArgumentException("Comando invalido");
		}
	}

	private void validarProximoMovimento(Bussola bussola) {
		planalto.explorar(bussola.getCoordenada());
	}

	public Bussola getPosicaoAtual() {
		return bussola.clone();
	}

}
