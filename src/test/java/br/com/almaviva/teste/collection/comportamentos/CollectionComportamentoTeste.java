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
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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

		assertTrue(collection.equals(collection));
	}
}
