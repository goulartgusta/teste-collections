package br.com.almaviva.teste.collection.segunda_prova.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.teste.collection.segunda_prova.model.CollectionDados;

public class CollectionTeste {

	private Collection<Character> collection;

	@BeforeEach
	void setUp() {
		collection = new ArrayList<>();
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());
		collection.add(CollectionDados.LETRA_C.getLetra());
	}

	@Test
	void testaAdd() {
		assertTrue(collection.add(CollectionDados.LETRA_D.getLetra()));
	}

	@Test
	void testaRemove() {
		assertTrue(collection.remove(CollectionDados.LETRA_B.getLetra()));
		assertFalse(collection.contains(CollectionDados.LETRA_B.getLetra()));
	}

	@Test
	void testaRemoveAll() {
		collection.removeAll(List.of(CollectionDados.LETRA_A.getLetra(), CollectionDados.LETRA_B.getLetra()));
		assertEquals(CollectionDados.TAMANHO_POS_REMOVEALL.getTamanho(), collection.size());
	}

	@Test
	void testaRemoveIf() {
		collection.removeIf(c -> c.equals(CollectionDados.LETRA_B.getLetra()));
		assertFalse(collection.contains(CollectionDados.LETRA_B.getLetra()));
		assertEquals(CollectionDados.TAMANHO_POS_REMOVE.getTamanho(), collection.size());
	}

	@Test
	void testaAddAll() {
		assertTrue(collection.addAll(List.of(CollectionDados.LETRA_D.getLetra(), CollectionDados.LETRA_E.getLetra())));
	}

	@Test
	void testaClear() {
		collection.clear();
		assertEquals(CollectionDados.TAMANHO_ZERO.getTamanho(), collection.size());
	}

	@Test
	void testaContains() {
		assertTrue(collection.contains(CollectionDados.LETRA_A.getLetra()));
	}

	@Test
	void testaContainsAll() {
		assertTrue(collection
				.containsAll(List.of(CollectionDados.LETRA_A.getLetra(), CollectionDados.LETRA_B.getLetra())));
	}

	@Test
	void testaEquals() {
		Collection<Character> copiaCollection = List.of(CollectionDados.LETRA_A.getLetra(),
				CollectionDados.LETRA_B.getLetra(), CollectionDados.LETRA_C.getLetra());
		assertEquals(collection, copiaCollection);
	}

	@Test
	void testaSize() {
		assertEquals(CollectionDados.TAMANHO_PADRAO.getTamanho(), collection.size());
	}

	@Test
	void testaHashCode() {
		Collection<Character> copiaCollection = List.of(CollectionDados.LETRA_A.getLetra(),
				CollectionDados.LETRA_B.getLetra(), CollectionDados.LETRA_C.getLetra());
		assertEquals(collection.hashCode(), copiaCollection.hashCode());
	}

	@Test
	void testaIsEmpty() {
		collection.clear();
		assertTrue(collection.isEmpty());
		assertNotNull(collection);
	}

	@Test
	void testaRetainAll() {
		collection.retainAll(List.of(CollectionDados.LETRA_A.getLetra()));
		assertEquals(CollectionDados.TAMANHO_POS_RETAIN.getTamanho(), collection.size());
		assertNotNull(collection);
	}

	@Test
	void testaToArray() {
		Object[] array = collection.toArray();
		assertEquals(CollectionDados.TAMANHO_PADRAO.getTamanho(), array.length);
		assertArrayEquals(new Character[] { CollectionDados.LETRA_A.getLetra(), CollectionDados.LETRA_B.getLetra(),
				CollectionDados.LETRA_C.getLetra() }, array);
	}

	@Test
	void testaToArrayComTipo() {
		Character[] array = collection.toArray(new Character[0]);
		assertEquals(CollectionDados.TAMANHO_PADRAO.getTamanho(), array.length);
		assertArrayEquals(new Character[] { CollectionDados.LETRA_A.getLetra(), CollectionDados.LETRA_B.getLetra(),
				CollectionDados.LETRA_C.getLetra() }, array);
	}

	@Test
	void testaSpliterator() {
		Spliterator<Character> spliterator = collection.spliterator();
		assertNotNull(spliterator);
		assertEquals(CollectionDados.TAMANHO_PADRAO.getTamanho(), spliterator.getExactSizeIfKnown());
	}

	@Test
	void testaStream() {
		Stream<Character> stream = collection.stream();
		assertNotNull(stream);
		long count = stream.count();
		assertEquals(CollectionDados.TAMANHO_PADRAO.getTamanho(), count);
	}

	@Test
	void testaParallelStream() {
		Stream<Character> parallelStream = collection.parallelStream();
		assertNotNull(parallelStream);
		long count = parallelStream.count();
		assertEquals(CollectionDados.TAMANHO_PADRAO.getTamanho(), count);
	}
}
