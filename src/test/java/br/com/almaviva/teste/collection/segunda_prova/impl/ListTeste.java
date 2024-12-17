package br.com.almaviva.teste.collection.segunda_prova.impl;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.teste.collection.segunda_prova.model.ListDados;

public class ListTeste implements ListDados {

    private List<Character> lista;

    @BeforeEach
    void setUp() {
        lista = new ArrayList<>();
        lista.add(LETRA_A);
        lista.add(LETRA_B);
        lista.add(LETRA_C);
    }

    @Test
    void testaAdd() {
        lista.add(LETRA_D);
        assertEquals(TAMANHO_PADRAO + 1, lista.size());
    }

    @Test
    void testaAddPorIndice() {
        lista.add(1, LETRA_D);
        assertEquals(LETRA_D, lista.get(1));
        assertEquals(TAMANHO_PADRAO + 1, lista.size());
    }

    @Test
    void testaSet() {
        lista.set(1, LETRA_D);
        assertEquals(LETRA_D, lista.get(1));
    }

    @Test
    void testaSize() {
        assertEquals(TAMANHO_PADRAO, lista.size());
    }

    @Test
    void testaClear() {
        lista.clear();
        assertTrue(lista.isEmpty());
    }

    @Test
    void testaContains() {
        assertTrue(lista.contains(LETRA_B));
    }

    @Test
    void testaContainsAll() {
        assertTrue(lista.containsAll(List.of(LETRA_A, LETRA_B)));
    }

    @Test
    void testaRemovePorIndice() {
        lista.remove(1);
        assertEquals(TAMANHO_PADRAO - 1, lista.size());
    }

    @Test
    void testaRemovePorObjeto() {
        lista.remove(Character.valueOf(LETRA_B));
        assertFalse(lista.contains(LETRA_B));
        assertEquals(TAMANHO_PADRAO - 1, lista.size());
    }

    @Test
    void testaRemoveAll() {
        lista.removeAll(List.of(LETRA_A, LETRA_B));
        assertEquals(1, lista.size());
    }

    @Test
    void testaRetainAll() {
        lista.retainAll(List.of(LETRA_B));
        assertEquals(1, lista.size());
        assertEquals(LETRA_B, lista.get(0));
    }

    @Test
    void testaIndexOf() {
        assertEquals(1, lista.indexOf(LETRA_B));
    }

    @Test
    void testaLastIndexOf() {
        lista.add(LETRA_B);
        assertEquals(3, lista.lastIndexOf(LETRA_B));
    }

    @Test
    void testaIsEmpty() {
        lista.clear();
        assertTrue(lista.isEmpty());
    }

    @Test
    void testaIterator() {
        Iterator<Character> iterator = lista.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(LETRA_A, iterator.next());
    }

    @Test
    void testaListIterator() {
        ListIterator<Character> listIterator = lista.listIterator();
        assertTrue(listIterator.hasNext());
        assertEquals(LETRA_A, listIterator.next());
    }

    @Test
    void testaListIteratorComIndice() {
        ListIterator<Character> listIterator = lista.listIterator(1);
        assertEquals(LETRA_B, listIterator.next());
    }

    @Test
    void testaReplaceAll() {
        lista.replaceAll(c -> (char) (c + 1));
        assertEquals((char) (LETRA_A + 1), lista.get(0));
    }

    @Test
    void testaSort() {
        lista.sort(Comparator.reverseOrder());
        assertEquals(LETRA_C, lista.get(0));
    }

    @Test
    void testaSubList() {
        List<Character> subLista = lista.subList(0, 2);
        assertEquals(2, subLista.size());
        assertEquals(LETRA_A, subLista.get(0));
    }

    @Test
    void testaSpliterator() {
        Spliterator<Character> spliterator = lista.spliterator();
        assertNotNull(spliterator);
        assertEquals(TAMANHO_PADRAO, spliterator.getExactSizeIfKnown());
    }

    @Test
    void testaToArray() {
        Object[] array = lista.toArray();
        assertEquals(TAMANHO_PADRAO, array.length);
    }

    @Test
    void testaToArrayComTipo() {
        Character[] array = lista.toArray(new Character[0]);
        assertEquals(TAMANHO_PADRAO, array.length);
    }

    @Test
    void testaEquals() {
        List<Character> outraLista = List.of(LETRA_A, LETRA_B, LETRA_C);
        assertEquals(lista, outraLista);
    }

    @Test
    void testaHashCode() {
        List<Character> outraLista = List.of(LETRA_A, LETRA_B, LETRA_C);
        assertEquals(lista.hashCode(), outraLista.hashCode());
    }

    @Test
    void testaForEach() {
        lista.forEach(c -> assertNotNull(c));
    }

    @Test
    void testaAddAll() {
        assertTrue(lista.addAll(List.of(LETRA_D, LETRA_E)));
        assertEquals(TAMANHO_PADRAO + 2, lista.size());
    }

    @Test
    void testaAddAllPorIndice() {
        assertTrue(lista.addAll(1, List.of(LETRA_D, LETRA_E)));
        assertEquals(LETRA_D, lista.get(1));
        assertEquals(TAMANHO_PADRAO + 2, lista.size());
    }
}
