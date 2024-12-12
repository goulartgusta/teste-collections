package br.com.almaviva.prova;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertTrue(collection.add("D"));
	}

	@Test
	void testaAddAllSucesso() {
		Collection<String> collection = new ArrayList<>();
		assertTrue(collection.addAll(Arrays.asList("B", "C", "D")));
	}

	@Test
	void testaClearSucesso() {
		Collection<String> collection = new ArrayList<>();
		collection.add("B");
		collection.add("C");
		collection.clear();
		assertTrue(collection.isEmpty());
	}

	@Test
	void testaIsEmptySucesso() {
		Collection<String> collection = new ArrayList<>();
		assertTrue(collection.isEmpty());
	}

	@Test
	void testaContainsAllSucesso() {
		Collection<String> collection = List.of("B", "C", "D");
		assertTrue(collection.containsAll(Arrays.asList("B", "C", "D")));
	}

	@Test
	void testaContainsSucesso() {
		Collection<String> collection = List.of("B", "C", "D");
		assertTrue(collection.contains("B"));
	}

	@Test
	void testaRemoveSucesso() {
		Collection<String> collection = new ArrayList<>();
		collection.add("B");
		collection.add("C");
		assertTrue(collection.remove("B"));
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
		assertFalse(collection1.hashCode() == collection2.hashCode());
	}

	@Test
	void testaIratorTemProximo() {
		Collection<String> collection = List.of("B", "C", "D");
		Iterator<String> it = collection.iterator();
		assertTrue(it.hasNext());
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
	    assertEquals(4, arrayDividido1.getExactSizeIfKnown());
	}

	@Test
	void testaRemoveIfSucesso() {
	    Collection<Integer> collection = new ArrayList<>(List.of(1, 2, 3, 4));
	    Predicate<Integer> filtro = num -> num > 2;
	    boolean resultado = collection.removeIf(filtro);
	    assertTrue(resultado);
	}
	
	
	//testar melhor
	@Test
	void testaRetainAll() {
		Collection<String> collection1 = List.of("A", "B", "D", "E");
		Collection<String> collection2 = List.of("F", "G");
		collection2.retainAll(collection1);
		
		assertEquals(List.of("F", "G"), collection1);
	}
	
// stream, parallelStream
}
