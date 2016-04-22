package br.com.mauriciotsilva.explorer.navegacao;

public enum Lado {

	L, R;
	
	public static Lado valueOf(char lado){
		return valueOf(Character.toString(lado));
	}
}
