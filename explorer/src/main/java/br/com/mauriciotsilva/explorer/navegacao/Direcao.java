package br.com.mauriciotsilva.explorer.navegacao;

import static br.com.mauriciotsilva.explorer.navegacao.TipoEixo.HORIZONTAL;
import static br.com.mauriciotsilva.explorer.navegacao.TipoEixo.VERTICAL;

import java.util.stream.Stream;

public enum Direcao {

	N(0, VERTICAL, 1), E(90, HORIZONTAL, 1), S(180, VERTICAL, -1), W(270, HORIZONTAL, -1);

	private final int polo;
	private final int graus;
	private final TipoEixo tipoEixo;

	private Direcao(int graus, TipoEixo tipoEixo, int polo) {
		this.polo = polo;
		this.graus = graus;
		this.tipoEixo = tipoEixo;
	}

	public TipoEixo getTipoEixo() {
		return tipoEixo;
	}

	public int getPolo() {
		return polo;
	}

	public Direcao proximo(Lado lado) {
		int resultado = Lado.R == lado ? graus + 90 : graus - 90;
		if (resultado > 270) {
			resultado = 0;
		} else if (resultado < 0) {
			resultado = 270;
		}

		return valueOf(resultado);
	}

	public static Direcao valueOf(int graus) {
		return Stream.of(values()).filter(apontado -> apontado.graus == graus).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
