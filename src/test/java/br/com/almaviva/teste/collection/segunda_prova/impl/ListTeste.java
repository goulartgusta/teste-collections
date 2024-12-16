package br.com.almaviva.teste.collection.segunda_prova.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.teste.collection.segunda_prova.model.ListDados;

public class ListTeste {

	private List<Character> list;

	@BeforeEach
	void setUp() {
		list = new ArrayList<>();
		list.add(ListDados.LETRA_A);
		list.add(ListDados.LETRA_B);
		list.add(ListDados.LETRA_C);
	}

	@Test
	void testaAdd() {
		list.add(ListDados.LETRA_D);
		assertEquals(4, list.size());
	}
	
    @Test
    void testaSet() {
        list.set(1, ListDados.LETRA_D);
        assertEquals(ListDados.LETRA_D, list.get(1));
    }

    @Test
    void testaSize() {
        assertEquals(3, list.size());
    }

	@Test
	void testaAddPorIndice() {
		list.add(1, ListDados.LETRA_D);
		assertEquals(ListDados.LETRA_D, list.get(1));
		assertEquals(4, list.size());
	}

	@Test
	void testaAddAll() {
		assertTrue(list.addAll(List.of(ListDados.LETRA_D, ListDados.LETRA_E)));
		assertEquals(5, list.size());
	}

	@Test
	void testaAddAllPorIndice() {
		assertTrue(list.addAll(1, List.of(ListDados.LETRA_D, ListDados.LETRA_E)));
		assertEquals(ListDados.LETRA_D, list.get(1));
		assertEquals(5, list.size());
	}

	@Test
	void testaClear() {
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	void testaContains() {
		assertTrue(list.contains(ListDados.LETRA_B));
	}

	@Test
	void testaContainsAll() {
		assertTrue(list.containsAll(List.of(ListDados.LETRA_A, ListDados.LETRA_B)));
	}

	@Test
	void testaEquals() {
		List<Character> outraList = List.of(ListDados.LETRA_A, ListDados.LETRA_B, ListDados.LETRA_C);
		assertEquals(list, outraList);
	}

	@Test
	void testaHashCode() {
		List<Character> outraList = List.of(ListDados.LETRA_A, ListDados.LETRA_B, ListDados.LETRA_C);
		assertEquals(list.hashCode(), outraList.hashCode());
	}

	@Test
	void testaGetPorIndice() {
		assertEquals(ListDados.LETRA_A, list.get(0));
	}

	@Test
	void testaRemovePorIndice() {
		Character removed = list.remove(1);
		assertEquals(ListDados.LETRA_B, removed);
		assertEquals(2, list.size());
	}

	@Test
	void testaRemovePorObjeto() {
		assertTrue(list.remove(Character.valueOf(ListDados.LETRA_B)));
		assertEquals(2, list.size());
	}

	@Test
	void testaRemoveAll() {
		list.removeAll(List.of(ListDados.LETRA_A, ListDados.LETRA_B));
		assertEquals(1, list.size());
	}

	@Test
	void testaIndexOf() {
		assertEquals(1, list.indexOf(ListDados.LETRA_B));
	}

	@Test
	void testaLastIndexOf() {
		list.add(ListDados.LETRA_B);
		assertEquals(3, list.lastIndexOf(ListDados.LETRA_B));
	}

	@Test
	void testaIsEmpty() {
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	void testaIterator() {
		assertTrue(list.iterator().hasNext());
	}

	@Test
	void testaListIterator() {
		ListIterator<Character> iterator = list.listIterator();
		assertTrue(iterator.hasNext());
		assertEquals(ListDados.LETRA_A, iterator.next());
	}

	@Test
	void testaListIteratorComIndice() {
		ListIterator<Character> iterator = list.listIterator(1);
		assertEquals(ListDados.LETRA_B, iterator.next());
	}

	@Test
	void testaRetainAll() {
		list.retainAll(List.of(ListDados.LETRA_B));
		assertEquals(1, list.size());
	}

	@Test
	void testaReplaceAll() {
		list.replaceAll(c -> (char) (c + 1));
		assertEquals((char) (ListDados.LETRA_A + 1), list.get(0));
	}

	@Test
	void testaSort() {
		list.sort(Comparator.reverseOrder());
		assertEquals(ListDados.LETRA_C, list.get(0));
	}

	@Test
	void testaSpliterator() {
		Spliterator<Character> spliterator = list.spliterator();
		assertNotNull(spliterator);
		assertEquals(3, spliterator.getExactSizeIfKnown());
	}

	@Test
	void testaSubList() {
		List<Character> subList = list.subList(0, 2);
		assertEquals(2, subList.size());
		assertEquals(ListDados.LETRA_A, subList.get(0));
	}

	@Test
	void testaToArray() {
		Object[] array = list.toArray();
		assertEquals(3, array.length);
	}

	@Test
	void testaToArrayComTipo() {
		Character[] array = list.toArray(new Character[0]);
		assertEquals(3, array.length);
	}
}
