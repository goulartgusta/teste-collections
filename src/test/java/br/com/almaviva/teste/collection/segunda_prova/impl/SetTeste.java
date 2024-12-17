package br.com.almaviva.teste.collection.segunda_prova.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.teste.collection.segunda_prova.model.SetDados;

public class SetTeste implements SetDados {

    private Set<Character> set;

    @BeforeEach
    void setUp() {
        set = new HashSet<>();
        set.add(LETRA_A);
        set.add(LETRA_B);
        set.add(LETRA_C);
    }

    @Test
    void testaAdd() {
        assertTrue(set.add(LETRA_D));
    }

    @Test
    void testaAddAll() {
        assertTrue(set.addAll(Set.of(LETRA_D, LETRA_E)));
    }

    @Test
    void testaClear() {
        set.clear();
        assertEquals(TAMANHO_ZERO, set.size());
    }

    @Test
    void testaContains() {
        assertTrue(set.contains(LETRA_A));
    }

    @Test
    void testaContainsAll() {
        assertTrue(set.containsAll(Set.of(LETRA_A, LETRA_B)));
    }

    @Test
    void testaEquals() {
        Set<Character> copiaSet = Set.of(LETRA_A, LETRA_B, LETRA_C);
        assertEquals(set, copiaSet);
    }

    @Test
    void testaHashCode() {
        Set<Character> copiaSet = Set.of(LETRA_A, LETRA_B, LETRA_C);
        assertEquals(set.hashCode(), copiaSet.hashCode());
    }

    @Test
    void testaIsEmpty() {
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    void testaIterator() {
        Iterator<Character> iterator = set.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    void testaRemove() {
        assertTrue(set.remove(LETRA_B));
    }

    @Test
    void testaRemoveAll() {
        assertTrue(set.removeAll(Set.of(LETRA_A, LETRA_B)));
    }

    @Test
    void testaRetainAll() {
        set.retainAll(Set.of(LETRA_A));
        assertEquals(TAMANHO_POS_RETAIN, set.size());
    }

    @Test
    void testaSize() {
        assertEquals(TAMANHO_PADRAO, set.size());
    }

    @Test
    void testaToArray() {
        Object[] array = set.toArray();
        assertEquals(TAMANHO_PADRAO, array.length);
    }

    @Test
    void testaToArrayComTipo() {
        Character[] array = set.toArray(new Character[0]);
        assertEquals(TAMANHO_PADRAO, array.length);
    }

    @Test
    void testaSpliterator() {
        Spliterator<Character> spliterator = set.spliterator();
        assertNotNull(spliterator);
        assertEquals(TAMANHO_PADRAO, spliterator.getExactSizeIfKnown());
    }
}
