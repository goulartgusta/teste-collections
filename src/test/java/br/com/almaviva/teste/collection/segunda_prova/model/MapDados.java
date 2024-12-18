package br.com.almaviva.teste.collection.segunda_prova.model;

public enum MapDados {

    FRUTA_MACA("Maçã"),
    FRUTA_BANANA("Banana"),
    FRUTA_LARANJA("Laranja"),
    FRUTA_MAMAO("Mamão"),
    FRUTA_UVA("Uva"),

    QTD_MACA(3),
    QTD_BANANA(5),
    QTD_LARANJA(2),
    QTD_MAMAO(4),
    QTD_ZERO(0),

    TAMANHO_PADRAO(3),
    TAMANHO_FINAL(4);

	private String fruta;
	private int quantidadeFrutas;
	
	MapDados(String fruta) {
		this.fruta = fruta;
	}
	
	MapDados(int quantidadeFrutas){
		this.quantidadeFrutas= quantidadeFrutas;
	}

	public String getFruta() {
		return fruta;
	}

	public int getQuantidadeFrutas() {
		return quantidadeFrutas;
	}

    
}
