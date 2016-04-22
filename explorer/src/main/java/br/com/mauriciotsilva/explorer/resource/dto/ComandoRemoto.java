package br.com.mauriciotsilva.explorer.resource.dto;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(FIELD)
public class ComandoRemoto {
	
	private String comando;
	
	protected void setComando(String comando) {
		this.comando = comando;
	}

	public String getComando() {
		return comando;
	}

}
