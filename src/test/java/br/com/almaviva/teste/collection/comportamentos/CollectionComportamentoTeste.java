package br.com.almaviva.teste.collection.comportamentos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.almaviva.teste.collection.comportamentos.models.CollectionDados;

public class CollectionComportamentoTeste {

	static Stream<Collection<Character>> utilizarColecoes() {
		return Stream.of(new ArrayList<>(), new LinkedList<>(), new HashSet<>(), new TreeSet<>());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaAdicionarElementosDuplicadosEmListaENaoEmSet(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());

		collection.add(CollectionDados.LETRA_A.getLetra());

		if (collection instanceof Set) {
			assertEquals(CollectionDados.TAMANHO_PADRAO.getTamanho(), collection.size());
		} else {
			assertEquals(CollectionDados.TAMANHO_POS_ADD.getTamanho(), collection.size());
		}
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaAdicionarTodosOsElementosNasColecoes(Collection<Character> collection) {
		collection.addAll(List.of(CollectionDados.LETRA_A.getLetra(), CollectionDados.LETRA_B.getLetra(),
				CollectionDados.LETRA_C.getLetra()));

		assertEquals(CollectionDados.TAMANHO_POS_ADD.getTamanho(), collection.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaRemoverElementosDasColecoes(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());

		collection.remove(CollectionDados.LETRA_B.getLetra());

		assertFalse(collection.contains(CollectionDados.LETRA_B.getLetra()));
		assertEquals(CollectionDados.TAMANHO_POS_REMOVE.getTamanho(), collection.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaRemoverTodosElementosDasColecoes(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());

		collection.removeAll(List.of(CollectionDados.LETRA_A.getLetra(), CollectionDados.LETRA_B.getLetra(),
				CollectionDados.LETRA_C.getLetra()));

		assertFalse(collection.contains(CollectionDados.LETRA_B.getLetra()));
		assertEquals(CollectionDados.TAMANHO_ZERO.getTamanho(), collection.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaRemoverCondicionalmenteElementosDasColecoes(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());

		collection.removeIf(c -> c.equals(CollectionDados.LETRA_B.getLetra()));

		assertFalse(collection.contains(CollectionDados.LETRA_B.getLetra()));
		assertEquals(CollectionDados.TAMANHO_POS_REMOVE.getTamanho(), collection.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaLimparTodosOsElementosDasColecoes(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());

		collection.clear();

		assertTrue(collection.isEmpty());
		assertEquals(CollectionDados.TAMANHO_ZERO.getTamanho(), collection.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaManterApenasElementosEspecificos(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());
		collection.add(CollectionDados.LETRA_C.getLetra());

		collection.retainAll(List.of(CollectionDados.LETRA_A.getLetra()));

		assertEquals(CollectionDados.TAMANHO_POS_RETAIN.getTamanho(), collection.size());
		assertTrue(collection.contains(CollectionDados.LETRA_A.getLetra()));
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaRetornarSucessoParaElementoSeEncontraNaColecao(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());

		assertTrue(collection.contains(CollectionDados.LETRA_A.getLetra()));
		assertFalse(collection.contains(CollectionDados.LETRA_B.getLetra()));
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaRetornarSucessoColecoesNaoEstaoVazias(Collection<Character> collection) {
		assertTrue(collection.isEmpty());

		collection.add(CollectionDados.LETRA_A.getLetra());
		assertFalse(collection.isEmpty());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaRetornarTamanhoDasColecoes(Collection<Character> collection) {
		assertEquals(CollectionDados.TAMANHO_ZERO.getTamanho(), collection.size());

		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());
		assertEquals(CollectionDados.TAMANHO_PADRAO.getTamanho(), collection.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaConverterParaArray(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());

		Character[] array = collection.toArray(new Character[0]);
		assertEquals(CollectionDados.TAMANHO_PADRAO.getTamanho(), array.length);
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaIterarOsElementosDaColecao(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());

		Iterator<Character> iterator = collection.iterator();
		assertTrue(iterator.hasNext());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoes")
	void deveriaRetornarColecaoIgualColecao(Collection<Character> collection) {
		collection.add(CollectionDados.LETRA_A.getLetra());
		collection.add(CollectionDados.LETRA_B.getLetra());

		assertEquals(true, collection.equals(collection));
	}

	static Stream<Collection<Character>> utilizarColecoesThreadSafe() {
		return Stream.of(new ArrayList<>(), new LinkedList<>(), new HashSet<>(), new ConcurrentSkipListSet<>());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoesThreadSafe")
	void deveriaRemoverElementosConcorretemente(Collection<Character> collection) throws InterruptedException {
		for (int i = 0; i < 30; i++) {
			collection.add((char) ('A' + i % 26));
		}

		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 30; i++) {
			char letra = (char) ('A' + i % 26);
			executor.execute(() -> {
				collection.remove(letra);
			});
		}

		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);

		assertEquals(0, collection.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarColecoesThreadSafe")
	void deveriaLerElementosConcorretemente(Collection<Character> collection) throws InterruptedException {
		for (int i = 0; i < 50; i++) {
			collection.add((char) ('A' + i % 26));
		}

		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 50; i++) {
			executor.execute(() -> {
				for (Character item : collection) {
					assertTrue(item >= 'A' && item <= 'Z');
				}
			});
		}

		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);

		if (collection instanceof Set) {
			assertTrue(collection.size() <= 26);
		} else {
			assertEquals(50, collection.size());
		}
	}

}
