package br.com.almaviva.teste.collection.primeira_prova;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListTestes {

	private List<String> list;

	@BeforeEach
	void setUp() {
		list = new ArrayList<>(Arrays.asList("A", "B", "C"));
	}

	@Test
	void testaAddComIndice() {
		list.add(1, "X");
		assertTrue(list.add("D"));
		assertEquals("X", list.get(1));
	}

	@Test
	void testaAddAll() {
		list.addAll(Arrays.asList("D", "E"));
		assertEquals(5, list.size());
	}

	@Test
	void testaAddAllComLista() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));

		list.addAll(1, Arrays.asList("X", "Y"));
		assertEquals(Arrays.asList("A", "X", "Y", "B", "C"), list);
	}

	@Test
	void testaClear() {
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	void testaRemove() {
		assertEquals("B", list.remove(1));
		assertEquals(Arrays.asList("A", "C"), list);
	}

	@Test
	void testaRemovePorObjeto() {
		assertTrue(list.remove("B"));
		assertEquals(Arrays.asList("A", "C"), list);
	}

	@Test
	void testaRemoveAll() {
		assertTrue(list.removeAll(Arrays.asList("B", "C")));
	}

	@Test
	void testaReplaceAll() {
		UnaryOperator<String> toLowerCase = String::toLowerCase;
		list.replaceAll(toLowerCase);
		assertEquals(Arrays.asList("a", "b", "c"), list);
	}

	@Test
	void testaContains() {
		assertTrue(list.contains("B"));
	}

	@Test
	void testaContainsAll() {
		assertTrue(list.containsAll(Arrays.asList("A", "B")));
	}

	@Test
	void testaGet() {
		assertEquals("B", list.get(1));
	}

	@Test
	void testaHashCode() {
		List<String> otherList = Arrays.asList("A", "B", "C");
		assertEquals(list.hashCode(), otherList.hashCode());
	}

	@Test
	void testaIndexOf() {
		assertEquals(1, list.indexOf("B"));
	}

	@Test
	void testaIsEmpty() {
		assertFalse(list.isEmpty());
	}

	@Test
	void testaIterator() {
		Iterator<String> iterator = list.iterator();
		assertTrue(iterator.hasNext());
	}

	@Test
	void testaListIterator() {
		ListIterator<String> listIterator = list.listIterator();
		assertTrue(listIterator.hasNext());
	}

	@Test
	void testaSet() {
		list.set(1, "X");
		assertEquals(Arrays.asList("A", "X", "C"), list);
	}

	@Test
	void testaSize() {
		assertEquals(3, list.size());
	}

	@Test
	void testaSort() {
		list.add("Z");
		list.sort(Comparator.naturalOrder());
		assertEquals(Arrays.asList("A", "B", "C", "Z"), list);
	}

	@Test
	void testaSpliterator() {
		Spliterator<String> spliterator = list.spliterator();
		assertEquals(3, spliterator.getExactSizeIfKnown());
	}

	@Test
	void testaSubList() {
		List<String> subList = list.subList(1, 3);
		assertEquals(Arrays.asList("B", "C"), subList);
	}

	@Test
	void testaToArray() {
		Object[] array = list.toArray();
		assertEquals(3, array.length);
	}

	@Test
	void testaLastIndexOf() {
		list.add("B");
		assertEquals(3, list.lastIndexOf("B"));
	}

	@Test
	void testaArrayToArray() {
		String[] array = list.toArray(new String[0]);
		assertEquals(3, array.length);
	}
}
