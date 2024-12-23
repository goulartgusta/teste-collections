package br.com.almaviva.teste.collection.comportamentos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.almaviva.teste.collection.comportamentos.models.ListDados;

public class ListComportamentoTeste {

	static Stream<List<Character>> utilizarListas() {
		return Stream.of(new ArrayList<>(), new LinkedList<>(), new CopyOnWriteArrayList<>());
	}

	@ParameterizedTest
	@MethodSource("utilizarListas")
	void deveriaAdicionarElementosNaLista(List<Character> list) {
		list.add(ListDados.LETRA_A.getLetra());
		list.add(ListDados.LETRA_B.getLetra());
		list.add(ListDados.LETRA_C.getLetra());

		assertEquals(3, list.size());
		assertEquals(ListDados.LETRA_A.getLetra(), list.get(0));
		assertEquals(ListDados.LETRA_B.getLetra(), list.get(1));
		assertEquals(ListDados.LETRA_C.getLetra(), list.get(2));
	}

	@ParameterizedTest
	@MethodSource("utilizarListas")
	void deveriaRemoverElementoPeloIndice(List<Character> list) {
		list.add(ListDados.LETRA_A.getLetra());
		list.add(ListDados.LETRA_B.getLetra());
		list.add(ListDados.LETRA_C.getLetra());

		list.remove(1); 

		assertEquals(2, list.size());
		assertFalse(list.contains(ListDados.LETRA_B.getLetra()));
		assertEquals(ListDados.LETRA_C.getLetra(), list.get(1));
	}

	@ParameterizedTest
	@MethodSource("utilizarListas")
	void deveriaInserirElementoEmPosicaoEspecifica(List<Character> list) {
		list.add(ListDados.LETRA_A.getLetra());
		list.add(ListDados.LETRA_C.getLetra());

		list.add(1, ListDados.LETRA_B.getLetra());

		assertEquals(3, list.size());
		assertEquals(ListDados.LETRA_B.getLetra(), list.get(1));
		assertEquals(ListDados.LETRA_C.getLetra(), list.get(2));
	}

	@ParameterizedTest
	@MethodSource("utilizarListas")
	void deveriaSubstituirElementoEmPosicaoEspecifica(List<Character> list) {
		list.add(ListDados.LETRA_A.getLetra());
		list.add(ListDados.LETRA_B.getLetra());

		list.set(1, ListDados.LETRA_C.getLetra()); 

		assertEquals(2, list.size());
		assertEquals(ListDados.LETRA_C.getLetra(), list.get(1));
		assertFalse(list.contains(ListDados.LETRA_B.getLetra()));
	}

	@ParameterizedTest
	@MethodSource("utilizarListas")
	void deveriaAdicionarElementosConcorretemente(List<Character> list) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) {
			final char letra = (char) ('A' + i % 26); 
			executor.execute(() -> list.add(letra));
		}

		executor.shutdown();
		executor.awaitTermination(50, TimeUnit.SECONDS);

		assertEquals(100, list.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarListas")
	void deveriaRemoverElementosConcorretemente(List<Character> list) throws InterruptedException {
	    for (int i = 0; i < 100; i++) {
	        list.add((char) ('A' + i % 26));
	    }

	    if (list instanceof CopyOnWriteArrayList) {
	        ExecutorService executor = Executors.newFixedThreadPool(10);

	        for (int i = 0; i < 100; i++) {
	            final char letra = (char) ('A' + i % 26);
	            executor.execute(() -> list.remove(Character.valueOf(letra)));
	        }

	        executor.shutdown();
	        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
	            throw new IllegalStateException("Threads não concluídas a tempo.");
	        }

	        assertEquals(0, list.size());
	    }
	}

	@ParameterizedTest
	@MethodSource("utilizarListas")
	void deveriaLerElementosConcorretemente(List<Character> list) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			list.add((char) ('A' + i % 26));
		}

		ExecutorService executor = Executors.newFixedThreadPool(10);

		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);

		assertEquals(100, list.size());
	}
}
