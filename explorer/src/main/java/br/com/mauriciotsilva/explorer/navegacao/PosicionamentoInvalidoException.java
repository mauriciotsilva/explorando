package br.com.mauriciotsilva.explorer.navegacao;

import br.com.mauriciotsilva.explorer.AcaoNaoExecutadaException;

public class PosicionamentoInvalidoException extends AcaoNaoExecutadaException {

	private static final long serialVersionUID = 7080116172082004619L;

	public PosicionamentoInvalidoException(String mensagem) {
		super(mensagem, null);
	}

}
