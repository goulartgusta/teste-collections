package br.com.almaviva.teste.collection.comportamentos.models;

public enum SetDados {
    LETRA_A('A'), LETRA_B('B'), LETRA_C('C'),
    TAMANHO_PADRAO(2), TAMANHO_POS_REMOVE(1);

    private final Character letra;
    private final Integer tamanho;

    SetDados(char letra) {
        this.letra = letra;
        this.tamanho = null;
    }

    SetDados(int tamanho) {
        this.letra = null;
        this.tamanho = tamanho;
    }

    public Character getLetra() {
        return letra;
    }

    public Integer getTamanho() {
        return tamanho;
    }
}
