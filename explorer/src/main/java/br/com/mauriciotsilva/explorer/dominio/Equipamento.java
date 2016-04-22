package br.com.mauriciotsilva.explorer.dominio;

import java.util.ArrayList;
import java.util.List;

import br.com.mauriciotsilva.explorer.Sonda;
import br.com.mauriciotsilva.explorer.navegacao.Bussola;

public class Equipamento {

	private Long id;
	private Mapa mapa;
	private String posicaoAtual;
	private List<ComandoEquipamento> comandos;

	protected Equipamento() {
		comandos = new ArrayList<>();
	}

	public Equipamento(Mapa mapa, String posicaoAtual) {
		this();
		this.mapa = mapa;
		this.posicaoAtual = posicaoAtual;
	}

	public ComandoEquipamento comandar(String comando) {
		atualizarPosicao(comando);
		ComandoEquipamento comandoEquipamento = new ComandoEquipamento(comando);

		comandos.add(comandoEquipamento);

		return comandoEquipamento;
	}

	private void atualizarPosicao(String comando) {
		Sonda sonda = getSonda();
		sonda.mover(comando);

		posicaoAtual = sonda.getPosicaoAtual().toString();
	}

	public Sonda getSonda() {
		return new Sonda(mapa.getPlanalto(), Bussola.com(posicaoAtual));
	}

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected String getPosicaoAtual() {
		return posicaoAtual;
	}

	protected void setPosicaoAtual(String posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}

	protected List<ComandoEquipamento> getComandos() {
		return comandos;
	}

	protected void setComandos(List<ComandoEquipamento> comandos) {
		this.comandos = comandos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipamento other = (Equipamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
