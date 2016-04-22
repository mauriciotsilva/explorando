package br.com.mauriciotsilva.explorer;

import static java.util.Objects.requireNonNull;

import br.com.mauriciotsilva.explorer.navegacao.Coordenada;

public class Planalto {

	private final int[][] campo;
	private final Coordenada coordenada;

	private Planalto(int x, int y) {
		this.campo = new int[x + 1][y + 1];
		this.coordenada = new Coordenada(x, y);
	}

	public static Planalto com(String tamanho) {
		String[] valores = extrairTamanho(tamanho);
		return com(Integer.valueOf(valores[0]), Integer.valueOf(valores[1]));
	}

	public static Planalto com(int x, int y) {
		return new Planalto(x, y);
	}

	private static String[] extrairTamanho(String tamanho) {
		String[] valores = requireNonNull(tamanho, "Tamanho nao pode ser nulo").split("\\s");
		if (valores.length != 2) {
			throw new IllegalArgumentException();
		}
		return valores;
	}

	public int explorar(Coordenada coordenada) {
		try {
			return campo[coordenada.getX()][coordenada.getY()];
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Coordenada invalida para o " + this);
		}
	}

	public int getX() {
		return coordenada.getX();
	}

	public int getY() {
		return coordenada.getY();
	}

	@Override
	public String toString() {
		return "Planalto [x=" + coordenada.getX() + ", y=" + coordenada.getY() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordenada == null) ? 0 : coordenada.hashCode());
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
		Planalto other = (Planalto) obj;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		return true;
	}

}
