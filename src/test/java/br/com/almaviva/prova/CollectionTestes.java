package br.com.almaviva.prova;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class CollectionTestes {

	@Test
	void testaAddSucesso() {
		Collection<String> collection = new ArrayList<>();
		assertEquals(true, collection.add("D"));
	}

	@Test
	void testaAddAllSucesso() {
		Collection<String> collection = new ArrayList<>();
		assertEquals(true, collection.addAll(Arrays.asList("B", "C", "D")));
	}

	@Test
	void testaClearSucesso() {
		Collection<String> collection = new ArrayList<>();
		collection.add("B");
		collection.add("C");
		collection.clear();
		assertEquals(true, collection.isEmpty());
	}

	@Test
	void testaIsEmptySucesso() {
		Collection<String> collection = new ArrayList<>();
		assertEquals(true, collection.isEmpty());
	}

	@Test
	void testaContainsAllSucesso() {
		Collection<String> collection = List.of("B", "C", "D");
		assertEquals(true, collection.containsAll(Arrays.asList("B", "C", "D")));
	}

	@Test
	void testaContainsSucesso() {
		Collection<String> collection = List.of("B", "C", "D");
		assertEquals(true, collection.contains("B"));
	}

	@Test
	void testaRemoveSucesso() {
		Collection<String> collection = new ArrayList<>();
		collection.add("B");
		collection.add("C");
		assertEquals(true, collection.remove("B"));
	}

	@Test
	void testaSizeSucesso() {
		Collection<String> collection = List.of("B", "C", "D");
		assertEquals(3, collection.size());
	}

	@Test
	void testaHashCodeFalso() {
		Collection<String> collection1 = new ArrayList<>();
		collection1.add("C");
		Collection<String> collection2 = new ArrayList<>();
		collection2.add("B");

		assertEquals(false, collection1.hashCode() == collection2.hashCode());
	}

	@Test
	void testaIratorTemProximo() {
		Collection<String> collection = List.of("B", "C", "D");
		Iterator<String> it = collection.iterator();
		assertEquals(true, it.hasNext());
	}

	@Test
	void testaToArraySucesso() {
		Collection<String> collection = List.of("B", "C", "D");
		String[] array = new String[3];
		collection.toArray(array);
		assertEquals(3, array.length);
	}

	@Test
	void testaArrayToArraySucesso() {
		Collection<String> collection = List.of("B", "C", "D");
		String[] array = collection.toArray(new String[3]);
		assertEquals(3, array.length);
	}

	@Test
	void testaSpliratorSucesso() {
		Collection<String> collection = List.of("B", "C", "D", "E");
		Spliterator<String> arrayDividido1 = collection.spliterator();
		assertEquals(2, arrayDividido1);

	}

	@Test
	void testaRemoveIfSucesso() {
		Collection<Integer> collection = List.of(1, 2, 3, 4);
		Predicate<Integer> filtro;
		int num = 1;
		collection.removeIf(num);
		assertEquals(true, 3 );
	}

}
