package br.com.mauriciotsilva.explorer.dominio;

import br.com.mauriciotsilva.explorer.AcaoNaoExecutadaException;
import br.com.mauriciotsilva.explorer.navegacao.Coordenada;

public class RiscoColisaoException extends AcaoNaoExecutadaException {

	private static final long serialVersionUID = -863217754108600662L;

	public RiscoColisaoException(Coordenada coordenada) {
		super(9, String.format("Nao e possivel ir ate esta coordenada %s no momento", coordenada), null);
	}

}
