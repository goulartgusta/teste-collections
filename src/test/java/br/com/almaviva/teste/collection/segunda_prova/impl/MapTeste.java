package br.com.almaviva.teste.collection.segunda_prova.impl;

import br.com.almaviva.teste.collection.segunda_prova.model.MapDados;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

	private Map<String, Integer> mapaFrutas;

	@BeforeEach
	void setUp() {
		mapaFrutas = new HashMap<>();
		mapaFrutas.put(MapDados.FRUTA_MACA.getFruta(), MapDados.QTD_MACA.getQuantidadeFrutas());
		mapaFrutas.put(MapDados.FRUTA_BANANA.getFruta(), MapDados.QTD_BANANA.getQuantidadeFrutas());
		mapaFrutas.put(MapDados.FRUTA_LARANJA.getFruta(), MapDados.QTD_LARANJA.getQuantidadeFrutas());
	}

	@Test
	void testaCompute() {
		mapaFrutas.compute(MapDados.FRUTA_MACA.getFruta(), (k, v) -> v + 10);
		assertEquals(13, mapaFrutas.get(MapDados.FRUTA_MACA.getFruta()));
	}

	@Test
	void testaComputeIfAbsent() {
		mapaFrutas.computeIfAbsent(MapDados.FRUTA_MAMAO.getFruta(), k -> MapDados.QTD_MAMAO.getQuantidadeFrutas());
		assertEquals(MapDados.QTD_MAMAO.getFruta(), mapaFrutas.get(MapDados.FRUTA_MAMAO.getFruta()));
	}

	@Test
	void testaComputeIfPresent() {
		mapaFrutas.computeIfPresent(MapDados.FRUTA_BANANA.getFruta(), (k, v) -> v - 2);
		assertEquals(3, mapaFrutas.get(MapDados.FRUTA_BANANA.getFruta()));
	}

	@Test
	void testaContainsKey() {
		assertTrue(mapaFrutas.containsKey(MapDados.FRUTA_MACA.getFruta()));
		assertFalse(mapaFrutas.containsKey(MapDados.FRUTA_UVA.getFruta()));
	}

	@Test
	void testaContainsValue() {
		assertTrue(mapaFrutas.containsValue(MapDados.QTD_LARANJA.getQuantidadeFrutas()));
		assertFalse(mapaFrutas.containsValue(100));
	}

	@Test
	void testaEntrySet() {
		Set<Map.Entry<String, Integer>> entrySet = mapaFrutas.entrySet();
		assertEquals(MapDados.TAMANHO_PADRAO.getQuantidadeFrutas(), entrySet.size());
	}

	@Test
	void testaEquals() {
		Map<String, Integer> outroMapa = new HashMap<>(mapaFrutas);
		assertEquals(mapaFrutas, outroMapa);
	}

	@Test
	void testaForEach() {
		mapaFrutas.forEach((k, v) -> assertNotNull(k));
	}

	@Test
	void testaGet() {
		assertEquals(MapDados.QTD_MACA.getQuantidadeFrutas(), mapaFrutas.get(MapDados.FRUTA_MACA.getFruta()));
	}

	@Test
	void testaGetOrDefault() {
		assertEquals(MapDados.QTD_BANANA.getQuantidadeFrutas(), mapaFrutas.getOrDefault(MapDados.FRUTA_BANANA.getFruta(), MapDados.QTD_ZERO.getQuantidadeFrutas() ));
		assertEquals(MapDados.QTD_ZERO.getQuantidadeFrutas(), mapaFrutas.getOrDefault(MapDados.FRUTA_UVA.getFruta(), MapDados.QTD_ZERO.getQuantidadeFrutas() ));
	}

	@Test
	void testaHashCode() {
		Map<String, Integer> outroMapa = new HashMap<>(mapaFrutas);
		assertEquals(mapaFrutas.hashCode(), outroMapa.hashCode());
	}

	@Test
	void testaIsEmpty() {
		assertFalse(mapaFrutas.isEmpty());
		mapaFrutas.clear();
		assertTrue(mapaFrutas.isEmpty());
	}

	@Test
	void testaKeySet() {
		Set<String> chaves = mapaFrutas.keySet();
		assertTrue(chaves.contains(MapDados.FRUTA_MACA.getFruta()));
	}

	@Test
	void testaMerge() {
		mapaFrutas.merge(MapDados.FRUTA_LARANJA.getFruta(), 3, Integer::sum);
		assertEquals(5, mapaFrutas.get(MapDados.FRUTA_LARANJA.getFruta()));
	}

	@Test
	void testaPut() {
		mapaFrutas.put(MapDados.FRUTA_MAMAO.getFruta(), MapDados.QTD_MAMAO.getQuantidadeFrutas());
		assertEquals(MapDados.QTD_MAMAO.getQuantidadeFrutas(), mapaFrutas.get(MapDados.FRUTA_MAMAO.getFruta()));
	}

	@Test
	void testaPutAll() {
		Map<String, Integer> novoMapa = new HashMap<>();
		novoMapa.put(MapDados.FRUTA_UVA.getFruta(), MapDados.QTD_ZERO.getQuantidadeFrutas() );
		mapaFrutas.putAll(novoMapa);
		assertTrue(mapaFrutas.containsKey(MapDados.FRUTA_UVA.getFruta()));
	}

	@Test
	void testaPutIfAbsent() {
		mapaFrutas.putIfAbsent(MapDados.FRUTA_MAMAO.getFruta(), MapDados.QTD_MAMAO.getQuantidadeFrutas());
		assertEquals(MapDados.QTD_MAMAO.getQuantidadeFrutas(), mapaFrutas.get(MapDados.FRUTA_MAMAO.getFruta()));
	}

	@Test
	void testaRemove() {
		mapaFrutas.remove(MapDados.FRUTA_MACA.getFruta());
		assertFalse(mapaFrutas.containsKey(MapDados.FRUTA_MACA.getFruta()));
	}

	@Test
	void testaRemoveComValor() {
		mapaFrutas.remove(MapDados.FRUTA_BANANA.getFruta(), MapDados.QTD_BANANA.getQuantidadeFrutas());
		assertFalse(mapaFrutas.containsKey(MapDados.FRUTA_BANANA.getFruta()));
	}

	@Test
	void testaReplace() {
		mapaFrutas.replace(MapDados.FRUTA_LARANJA.getFruta(), 10);
		assertEquals(10, mapaFrutas.get(MapDados.FRUTA_LARANJA.getFruta()));
	}

	@Test
	void testaReplaceComValorAntigo() {
		mapaFrutas.replace(MapDados.FRUTA_MACA.getFruta(), MapDados.QTD_MACA.getQuantidadeFrutas(), 100);
		assertEquals(100, mapaFrutas.get(MapDados.FRUTA_MACA.getFruta()));
	}

	@Test
	void testaReplaceAll() {
		mapaFrutas.replaceAll((k, v) -> v + 1);
		assertEquals(4, mapaFrutas.get(MapDados.FRUTA_MACA.getFruta()));
	}

	@Test
	void testaSize() {
		assertEquals(MapDados.TAMANHO_PADRAO.getQuantidadeFrutas(), mapaFrutas.size());
	}

	@Test
	void testaValues() {
		assertTrue(mapaFrutas.values().contains(MapDados.QTD_MACA.getQuantidadeFrutas()));
	}
}
