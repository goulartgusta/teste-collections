package br.com.almaviva.teste.collection.segunda_prova.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.teste.collection.segunda_prova.model.SetDados;

public class SetTeste {

    private Set<Character> set;

    @BeforeEach
    void setUp() {	
        set = new HashSet<>();
        set.add(SetDados.LETRA_A);
        set.add(SetDados.LETRA_B);
        set.add(SetDados.LETRA_C);
    }

    @Test
    void testaAdd() {
        boolean resultado = set.add(SetDados.LETRA_D);
        assertTrue(resultado);
    }

    @Test
    void testaAddAll() {
        Set<Character> addSet = Set.of(SetDados.LETRA_D, SetDados.LETRA_E);
        boolean resultado = set.addAll(addSet);
        assertTrue(resultado);
    }

    @Test
    void testaClear() {
        set.clear();
        int resultado = set.size();
        assertEquals(SetDados.TAMANHO_ZERO, resultado);
    }

    @Test
    void testaContains() {
        boolean resultado = set.contains(SetDados.LETRA_A);
        assertTrue(resultado);
    }

    @Test
    void testaContainsAll() {
        boolean resultado = set.containsAll(Set.of(SetDados.LETRA_A, SetDados.LETRA_B));
        assertTrue(resultado);
    }

    @Test
    void testaEquals() {
        Set<Character> copiaSet = Set.of(SetDados.LETRA_A, SetDados.LETRA_B, SetDados.LETRA_C);
        assertEquals(set, copiaSet);
    }

    @Test
    void testaHashCode() {
        Set<Character> copiaSet = Set.of(SetDados.LETRA_A, SetDados.LETRA_B, SetDados.LETRA_C);
        assertEquals(set.hashCode(), copiaSet.hashCode());
    }

    @Test
    void testaIsEmpty() {
        set.clear();
        boolean resultado = set.isEmpty();
        assertTrue(resultado);
    }

    @Test
    void testaIterator() {
        Iterator<Character> iterator = set.iterator();
        boolean resultado = iterator.hasNext();
        assertTrue(resultado);
    }

    @Test
    void testaRemove() {
        boolean resultado = set.remove(SetDados.LETRA_B);
        assertTrue(resultado);
    }

    @Test
    void testaRemoveAll() {
        boolean resultado = set.removeAll(Set.of(SetDados.LETRA_A, SetDados.LETRA_B));
        assertTrue(resultado);
    }

    @Test
    void testaRetainAll() {
        boolean resultado = set.retainAll(Set.of(SetDados.LETRA_A));
        assertTrue(resultado);
        assertEquals(SetDados.TAMANHO_POS_RETAIN, set.size());
    }

    @Test
    void testaSize() {
        int resultado = set.size();
        assertEquals(SetDados.TAMANHO_PADRAO, resultado);
    }

    @Test
    void testaToArray() {
        Object[] array = set.toArray();
        assertEquals(SetDados.TAMANHO_PADRAO, array.length);
    }

    @Test
    void testaToArrayComTipo() {
        Character[] array = set.toArray(new Character[0]);
        assertEquals(SetDados.TAMANHO_PADRAO, array.length);
    }

    @Test
    void testaSpliterator() {
        Spliterator<Character> spliterator = set.spliterator();
        assertNotNull(spliterator);
        assertEquals(SetDados.TAMANHO_PADRAO, spliterator.getExactSizeIfKnown());
    }
}
