package br.com.almaviva.teste.collection.comportamentos.models;

public enum CollectionDados {

    LETRA_A((char) 65), 
    LETRA_B((char) 66), 
    LETRA_C((char) 67), 
    LETRA_D((char) 68), 
    LETRA_E((char) 69),

    TAMANHO_ZERO(0), 
    TAMANHO_PADRAO(2), 
    TAMANHO_POS_ADD(3), 
    TAMANHO_POS_REMOVE(1), 
    TAMANHO_POS_RETAIN(1);

    private final Character letra;
    private final Integer tamanho;

    CollectionDados(char letra) {
        this.letra = letra;
        this.tamanho = null;
    }

    CollectionDados(int tamanho) {
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
