package br.com.almaviva.teste.collection.segunda_prova.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapTeste {

	Map<String, Integer> mapaFrutas;

	@BeforeEach
	void setUp() {
		mapaFrutas = new HashMap<>();
		mapaFrutas.put("Maçã", 3);
		mapaFrutas.put("Banana", 5);
		mapaFrutas.put("Laranja", 2);
	}

	@Test
	void testaCompute() {
		mapaFrutas.forEach((chave, valor) -> mapaFrutas.compute(chave, (k, v) -> v + 1));
	}

	@Test
	void testaComputeIfAbsent() {

	}

	@Test
	void testaComputeIfPresent() {

	}

	@Test
	void testaContainsKey() {

	}

	@Test
	void testaContainsValue() {

	}

	@Test
	void testaEntrySet() {

	}

	@Test
	void testaEquals() {

	}

	@Test
	void testaForEach() {

	}

	@Test
	void testaGet() {

	}

	@Test
	void testaGetOrDefault() {

	}

	@Test
	void testaHashCode() {

	}

	@Test
	void testaIsEmpty() {

	}

	@Test
	void testaKeySet() {

	}

	@Test
	void testaMerge() {

	}

	@Test
	void testaPut() {

	}

	@Test
	void PutAll() {

	}

	@Test
	void testaPutIfAbsent() {

	}

	@Test
	void testaRemove() {

	}

	@Test
	void testaRemoveComChave() {

	}

	@Test
	void testaReplace() {

	}

	@Test
	void testaReplaceValorAntigoNovo() {

	}

	@Test
	void testaReplaceAll() {

	}

	@Test
	void testaSize() {

	}

	@Test
	void testaValues() {

	}

}
