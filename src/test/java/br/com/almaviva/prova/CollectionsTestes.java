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
	
	@Test
	void testeCheckedListFalha() {
		List<String> lista = new ArrayList<>();
		List<String> checkedList = Collections.checkedList(lista, String.class);
		List<String> listaSemTipo = checkedList;
		listaSemTipo.add("123");

		assertEquals("123", listaSemTipo.get(0));
	}
	
	@Test
	void testeBinarySearch() {
		List<Integer> listaInteiros = List.of(1, 5, 8, 10, 12, 16, 19, 24, 26, 46, 84);
		int item = 24;
		Collections.binarySearch(listaInteiros, item);

		assertEquals(7, Collections.binarySearch(listaInteiros, item));
	}
	
	@Test
	void teste() {
		
	}

}
