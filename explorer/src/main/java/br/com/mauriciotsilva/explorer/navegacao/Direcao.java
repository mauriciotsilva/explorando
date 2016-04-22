package br.com.mauriciotsilva.explorer.navegacao;

import java.util.stream.Stream;

public enum Direcao {

	N(0), E(90), S(180), W(270);

	private final int graus;

	private Direcao(int graus) {
		this.graus = graus;
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
