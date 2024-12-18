package br.com.almaviva.teste.collection.segunda_prova.model;

public enum SetDados {

	LETRA_A(65), LETRA_B(66), LETRA_C(67), LETRA_D(68), LETRA_E(69),

	TAMANHO_PADRAO(3), TAMANHO_ZERO(0), TAMANHO_POS_REMOVE(2), TAMANHO_POS_REMOVEALL(1), TAMANHO_POS_RETAIN(1);

	private int letraAscii;

	SetDados(int letraAscii) {
		this.letraAscii = letraAscii;
	}

	public int getLetraAscii() {
		return letraAscii;
	}

}
