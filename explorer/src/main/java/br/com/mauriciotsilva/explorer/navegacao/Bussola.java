package br.com.mauriciotsilva.explorer.navegacao;

import static java.util.Objects.requireNonNull;

public class Bussola implements Cloneable {

	private Direcao direcao;
	private final Coordenada coordenada;

	private Bussola(Direcao direcao, Coordenada coordenada) {
		this.direcao = requireNonNull(direcao, "Direcao nao deve ser nulo");
		this.coordenada = requireNonNull(coordenada, "Coordenada nao deve ser nulo");
	}

	public static Bussola com(String parametros) {
		String[] valores = extrairValores(parametros);
		return new Bussola(Direcao.valueOf(valores[2]),
				new Coordenada(Integer.valueOf(valores[0]), Integer.valueOf(valores[1])));
	}

	private static String[] extrairValores(String parametros) {
		String[] valores = requireNonNull(parametros, "Parametros nao deve ser nulo").split("\\s");
		if (valores.length != 3) {
			throw new IllegalArgumentException();
		}

		return valores;
	}

	public static Bussola com(Direcao apontado, Coordenada coordenada) {
		return new Bussola(apontado, coordenada);
	}

	public Bussola movimentar(int valor) {

		int x = coordenada.getX();
		int y = coordenada.getY();

		if (direcao == Direcao.N) {
			y++;
		} else if (direcao == Direcao.S) {
			y--;
		} else if (direcao == Direcao.E) {
			x++;
		} else {
			x--;
		}

		return new Bussola(direcao, new Coordenada(x, y));
	}

	public void girar(Lado lado) {
		direcao = direcao.proximo(lado);
	}

	public Direcao getApontado() {
		return direcao;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	@Override
	public String toString() {
		return "Bussola [apontado=" + direcao + ", coordenada=" + coordenada + "]";
	}

	@Override
	public Bussola clone() {
		try {
			return (Bussola) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Nao foi possil clonar Bussola", e);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direcao == null) ? 0 : direcao.hashCode());
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
		Bussola other = (Bussola) obj;
		if (direcao != other.direcao)
			return false;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		return true;
	}

}
