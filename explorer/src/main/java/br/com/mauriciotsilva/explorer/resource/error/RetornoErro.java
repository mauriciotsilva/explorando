package br.com.mauriciotsilva.explorer.resource.error;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import br.com.mauriciotsilva.explorer.ExplorerException;

public class RetornoErro {

	private Collection<MensagemErro> errors;

	private RetornoErro() {
		this.errors = new ArrayList<>();
	}

	public RetornoErro(ExplorerException explorer) {
		this();

		Throwable causa = explorer.getCause();
		adicionarMensagem(explorer);
		if (causa instanceof ExplorerException) {
			adicionarMensagem(causa);
		}

	}

	private void adicionarMensagem(Throwable causa) {
		errors.add(new MensagemErro(causa.getMessage()));
	}

	public Collection<MensagemErro> getErrors() {
		return Collections.unmodifiableCollection(errors);
	}

}
