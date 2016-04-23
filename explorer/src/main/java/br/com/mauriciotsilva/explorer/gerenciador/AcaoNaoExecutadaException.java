package br.com.mauriciotsilva.explorer.gerenciador;

import br.com.mauriciotsilva.explorer.ExplorerException;

public class AcaoNaoExecutadaException extends ExplorerException {

	private static final long serialVersionUID = 2116878079061220202L;

	public AcaoNaoExecutadaException(Throwable causa) {
		this(causa.getMessage(), causa);
	}

	public AcaoNaoExecutadaException(String mensagem, Throwable causa) {
		super(400, mensagem, causa);
	}

}
