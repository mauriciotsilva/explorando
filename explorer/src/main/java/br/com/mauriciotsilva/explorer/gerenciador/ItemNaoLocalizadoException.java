package br.com.mauriciotsilva.explorer.gerenciador;

import br.com.mauriciotsilva.explorer.ExplorerException;

public class ItemNaoLocalizadoException extends ExplorerException {

	private static final long serialVersionUID = -2653638739142180031L;

	public ItemNaoLocalizadoException(String mensagem) {
		super(404, mensagem, null);
	}

}
