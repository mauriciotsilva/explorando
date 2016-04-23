package br.com.mauriciotsilva.explorer;

public class AcaoNaoExecutadaException extends ExplorerException {

	private static final long serialVersionUID = 2116878079061220202L;

	public AcaoNaoExecutadaException(Throwable causa) {
		this(causa.getMessage(), causa);
	}

	public AcaoNaoExecutadaException(String mensage, Throwable causa) {
		this(0, mensage, causa);
	}

	protected AcaoNaoExecutadaException(int subCodigo, String mensagem, Throwable causa) {
		super(400 + subCodigo, mensagem, causa);
	}

}
