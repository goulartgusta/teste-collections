package br.com.almaviva.teste.collection.comportamentos.models;

public enum ListDados {
    LETRA_A('A'), LETRA_B('B'), LETRA_C('C'),
    TAMANHO_ZERO(0), TAMANHO_PADRAO(2);

    private final Character letra;
    private final Integer tamanho;

    ListDados(char letra) {
        this.letra = letra;
        this.tamanho = null;
    }

    ListDados(int tamanho) {
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
