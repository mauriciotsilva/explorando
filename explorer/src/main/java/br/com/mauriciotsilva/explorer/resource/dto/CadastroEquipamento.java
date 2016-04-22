package br.com.mauriciotsilva.explorer.resource.dto;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(FIELD)
public class CadastroEquipamento {

	private Long mapa;
	private String posicao;

	public Long getMapa() {
		return mapa;
	}

	protected void setMapa(Long mapa) {
		this.mapa = mapa;
	}

	public String getPosicao() {
		return posicao;
	}

	protected void setPosicao(String posicao) {
		this.posicao = posicao;
	}

}
