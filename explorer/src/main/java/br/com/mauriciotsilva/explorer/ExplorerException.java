package br.com.mauriciotsilva.explorer;

public class ExplorerException extends RuntimeException {

	private static final long serialVersionUID = 3371603805749226339L;

	private final int codigo;

	public ExplorerException(int codigo, String mensagem, Throwable causa) {
		super(mensagem, causa);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

}
