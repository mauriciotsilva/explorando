package br.com.mauriciotsilva.explorer.dominio;

import java.time.Instant;

public class ComandoEquipamento {

	private Instant data;
	private String comando;

	protected ComandoEquipamento() {
		data = Instant.now();
	}

	public ComandoEquipamento(String comando) {
		this();
		this.comando = comando;
	}

	public String getComando() {
		return comando;
	}

	public Instant getData() {
		return data;
	}
}
