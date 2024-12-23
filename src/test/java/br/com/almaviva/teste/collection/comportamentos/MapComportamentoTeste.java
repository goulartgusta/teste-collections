package br.com.almaviva.teste.collection.comportamentos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.almaviva.teste.collection.comportamentos.models.MapDados;

public class MapComportamentoTeste {

	static Stream<Map<String, Integer>> utilizarMaps() {
		return Stream.of(new HashMap<>(), new TreeMap<>(), new ConcurrentHashMap<>());
	}

	@ParameterizedTest
	@MethodSource("utilizarMaps")
	void deveriaAdicionarParesChaveValor(Map<String, Integer> map) {
		map.put(MapDados.FRUTA_MACA.getFruta(), MapDados.QTD_MACA.getQuantidade());
		map.put(MapDados.FRUTA_BANANA.getFruta(), MapDados.QTD_BANANA.getQuantidade());

		assertEquals(MapDados.TAMANHO_PADRAO.getQuantidade(), map.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarMaps")
	void deveriaSobrescreverChaveExistente(Map<String, Integer> map) {
		map.put(MapDados.FRUTA_MACA.getFruta(), MapDados.QTD_MACA.getQuantidade());
		map.put(MapDados.FRUTA_MACA.getFruta(), MapDados.QTD_BANANA.getQuantidade());

		assertEquals(MapDados.TAMANHO_POS_REPLACE.getQuantidade(), map.size());
		assertEquals(MapDados.QTD_BANANA.getQuantidade(), map.get(MapDados.FRUTA_MACA.getFruta()));
	}

	@ParameterizedTest
	@MethodSource("utilizarMaps")
	void deveriaRemoverParesPorChave(Map<String, Integer> map) {
		map.put(MapDados.FRUTA_MACA.getFruta(), MapDados.QTD_MACA.getQuantidade());
		map.put(MapDados.FRUTA_BANANA.getFruta(), MapDados.QTD_BANANA.getQuantidade());

		map.remove(MapDados.FRUTA_MACA.getFruta());

		assertEquals(MapDados.TAMANHO_POS_REPLACE.getQuantidade(), map.size());
	}

	@ParameterizedTest
	@MethodSource("utilizarMaps")
	void deveriaLimparTodosOsElementosDoMap(Map<String, Integer> map) {
		map.put(MapDados.FRUTA_MACA.getFruta(), MapDados.QTD_MACA.getQuantidade());
		map.put(MapDados.FRUTA_BANANA.getFruta(), MapDados.QTD_BANANA.getQuantidade());

		map.clear();

		assertEquals(MapDados.TAMANHO_ZERO.getQuantidade(), map.size());
	}
	

	static Stream<Map<String, Integer>> utilizarMapsThreadSafe() {
		return Stream.of(new HashMap<>(), new ConcurrentHashMap<>());
	}

	@ParameterizedTest
	@MethodSource("utilizarMapsThreadSafe")
	void deveriaAdicionarParesConcorretemente(Map<Integer, String> map) throws InterruptedException {
	    ExecutorService executor = Executors.newFixedThreadPool(10);

	    for (int i = 0; i < 20; i++) {
	        final int key = i;
	        executor.execute(() -> {
	            map.put(key, "Valor-" + key);
	        });
	    }

	    executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);

	    assertEquals(20, map.size(), "Tamanho do Map está incorreto para: " + map.getClass().getName());
	}


	@ParameterizedTest
	@MethodSource("utilizarMapsThreadSafe")
	void deveriaLerChavesConcorretemente(Map<Integer, String> map) throws InterruptedException {
		for (int i = 0; i < 20; i++) {
			map.put(i, "Valor-" + i);
		}

		ExecutorService executor = Executors.newFixedThreadPool(20);

		for (int i = 0; i < 20; i++) {
			final int key = i;
			executor.execute(() -> {
				assertTrue(map.containsKey(key), "Chave não encontrada no Map: " + key);
			});
		}

		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);

		assertEquals(20, map.size(), map.getClass().getName());
	}

}
