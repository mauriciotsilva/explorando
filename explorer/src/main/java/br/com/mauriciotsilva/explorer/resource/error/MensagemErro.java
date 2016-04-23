package br.com.mauriciotsilva.explorer.resource.error;

public class MensagemErro {

	private String chave;
	private String mensagem;

	public MensagemErro(String mensagem) {
		this(mensagem, null);
	}

	public MensagemErro(String mensagem, String chave) {
		this.chave = chave;
		this.mensagem = mensagem;
	}

	public String getChave() {
		return chave;
	}

	public String getMensagem() {
		return mensagem;
	}

}
