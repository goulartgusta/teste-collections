package br.com.almaviva.teste.collection.segunda_prova.model;

public enum ListDados {
	LETRA_A('A'), LETRA_B('B'), LETRA_C('C'), LETRA_D('D'), LETRA_E('E'),

	TAMANHO_PADRAO(3), TAMANHO_ZERO(0), TAMANHO_POS_REMOVE(2), TAMANHO_POS_REMOVEALL(1), TAMANHO_POS_RETAIN(1);

	private char letra;
	private int tamanho;

	ListDados(char letra) {
		this.letra = letra;
	}

	ListDados(int tamanho) {
		this.tamanho = tamanho;
	}

	public char getLetra() {
		return letra;
	}

	public int getTamanho() {
		return tamanho;
	}
	
}
