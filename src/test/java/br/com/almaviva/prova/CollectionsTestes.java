package br.com.almaviva.prova;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class CollectionsTestes {

	@Test
	void testeAddAllTamanhoSucesso() {
		List<String> lista = new ArrayList<>();
		Collections.addAll(lista, "Oi", "tudo", "bem?");
		
		assertEquals(3, lista.size());
	}

	@Test

	void testeSortSucesso() {
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(3);
		lista.add(1);
		lista.add(2);
		Collections.sort(lista);

		assertEquals(1, lista.get(0));

	}


}
