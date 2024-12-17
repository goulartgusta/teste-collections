package br.com.almaviva.teste.collection.segunda_prova.impl;

import br.com.almaviva.teste.collection.segunda_prova.model.MapDados;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapTest implements MapDados {

    private Map<String, Integer> mapaFrutas;

    @BeforeEach
    void setUp() {
        mapaFrutas = new HashMap<>();
        mapaFrutas.put(FRUTA_MACA, QTD_MACA);
        mapaFrutas.put(FRUTA_BANANA, QTD_BANANA);
        mapaFrutas.put(FRUTA_LARANJA, QTD_LARANJA);
    }

    @Test
    void testaCompute() {
        mapaFrutas.compute(FRUTA_MACA, (k, v) -> v + 10);
        assertEquals(13, mapaFrutas.get(FRUTA_MACA));
    }

    @Test
    void testaComputeIfAbsent() {
        mapaFrutas.computeIfAbsent(FRUTA_MAMAO, k -> QTD_MAMAO);
        assertEquals(QTD_MAMAO, mapaFrutas.get(FRUTA_MAMAO));
    }

    @Test
    void testaComputeIfPresent() {
        mapaFrutas.computeIfPresent(FRUTA_BANANA, (k, v) -> v - 2);
        assertEquals(3, mapaFrutas.get(FRUTA_BANANA));
    }

    @Test
    void testaContainsKey() {
        assertTrue(mapaFrutas.containsKey(FRUTA_MACA));
        assertFalse(mapaFrutas.containsKey(FRUTA_UVA));
    }

    @Test
    void testaContainsValue() {
        assertTrue(mapaFrutas.containsValue(QTD_LARANJA));
        assertFalse(mapaFrutas.containsValue(100));
    }

    @Test
    void testaEntrySet() {
        Set<Map.Entry<String, Integer>> entrySet = mapaFrutas.entrySet();
        assertEquals(TAMANHO_PADRAO, entrySet.size());
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
        assertEquals(QTD_MACA, mapaFrutas.get(FRUTA_MACA));
    }

    @Test
    void testaGetOrDefault() {
        assertEquals(QTD_BANANA, mapaFrutas.getOrDefault(FRUTA_BANANA, QTD_ZERO));
        assertEquals(QTD_ZERO, mapaFrutas.getOrDefault(FRUTA_UVA, QTD_ZERO));
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
        assertTrue(chaves.contains(FRUTA_MACA));
    }

    @Test
    void testaMerge() {
        mapaFrutas.merge(FRUTA_LARANJA, 3, Integer::sum);
        assertEquals(5, mapaFrutas.get(FRUTA_LARANJA));
    }

    @Test
    void testaPut() {
        mapaFrutas.put(FRUTA_MAMAO, QTD_MAMAO);
        assertEquals(QTD_MAMAO, mapaFrutas.get(FRUTA_MAMAO));
    }

    @Test
    void testaPutAll() {
        Map<String, Integer> novoMapa = new HashMap<>();
        novoMapa.put(FRUTA_UVA, QTD_ZERO);
        mapaFrutas.putAll(novoMapa);
        assertTrue(mapaFrutas.containsKey(FRUTA_UVA));
    }

    @Test
    void testaPutIfAbsent() {
        mapaFrutas.putIfAbsent(FRUTA_MAMAO, QTD_MAMAO);
        assertEquals(QTD_MAMAO, mapaFrutas.get(FRUTA_MAMAO));
    }

    @Test
    void testaRemove() {
        mapaFrutas.remove(FRUTA_MACA);
        assertFalse(mapaFrutas.containsKey(FRUTA_MACA));
    }

    @Test
    void testaRemoveComValor() {
        mapaFrutas.remove(FRUTA_BANANA, QTD_BANANA);
        assertFalse(mapaFrutas.containsKey(FRUTA_BANANA));
    }

    @Test
    void testaReplace() {
        mapaFrutas.replace(FRUTA_LARANJA, 10);
        assertEquals(10, mapaFrutas.get(FRUTA_LARANJA));
    }

    @Test
    void testaReplaceComValorAntigo() {
        mapaFrutas.replace(FRUTA_MACA, QTD_MACA, 100);
        assertEquals(100, mapaFrutas.get(FRUTA_MACA));
    }

    @Test
    void testaReplaceAll() {
        mapaFrutas.replaceAll((k, v) -> v + 1);
        assertEquals(4, mapaFrutas.get(FRUTA_MACA));
    }

    @Test
    void testaSize() {
        assertEquals(TAMANHO_PADRAO, mapaFrutas.size());
    }

    @Test
    void testaValues() {
        assertTrue(mapaFrutas.values().contains(QTD_MACA));
    }
}
