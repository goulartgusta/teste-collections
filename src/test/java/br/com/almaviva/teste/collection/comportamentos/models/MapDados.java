package br.com.almaviva.teste.collection.comportamentos.models;

public enum MapDados {
    FRUTA_MACA("Maçã"), 
    FRUTA_BANANA("Banana"), 
    FRUTA_LARANJA("Laranja"),

    QTD_MACA(10), 
    QTD_BANANA(20), 
    QTD_LARANJA(30),

    TAMANHO_ZERO(0), 
    TAMANHO_PADRAO(2), 
    TAMANHO_POS_REPLACE(1);

    private final String fruta;
    private final Integer quantidade;

    MapDados(String fruta) {
        this.fruta = fruta;
        this.quantidade = null;
    }

    MapDados(int quantidade) {
        this.fruta = null;
        this.quantidade = quantidade;
    }

    public String getFruta() {
        return fruta;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
