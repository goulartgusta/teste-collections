package br.com.almaviva.teste.collection.segunda_prova.impl;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.almaviva.teste.collection.segunda_prova.model.ListDados;

public class ListTeste {

    private List<Character> lista;

    @BeforeEach
    void setUp() {
        lista = new ArrayList<>();
        lista.add(ListDados.LETRA_A.getLetra());
        lista.add(ListDados.LETRA_B.getLetra());
        lista.add(ListDados.LETRA_C.getLetra());
    }

    @Test
    void testaAdd() {
        lista.add(ListDados.LETRA_A.getLetra());
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho() + 1, lista.size());
    }

    @Test
    void testaAddPorIndice() {
        lista.add(1, ListDados.LETRA_A.getLetra());
        assertEquals(ListDados.LETRA_A.getLetra(), lista.get(1));
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho() + 1, lista.size());
    }

    @Test
    void testaSet() {
        lista.set(1, ListDados.LETRA_A.getLetra());
        assertEquals(ListDados.LETRA_A.getLetra(), lista.get(1));
    }

    @Test
    void testaSize() {
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho(), lista.size());
    }

    @Test
    void testaClear() {
        lista.clear();
        assertTrue(lista.isEmpty());
    }

    @Test
    void testaContains() {
        assertTrue(lista.contains(ListDados.LETRA_B.getLetra()));
    }

    @Test
    void testaContainsAll() {
        assertTrue(lista.containsAll(List.of(ListDados.LETRA_A.getLetra(), ListDados.LETRA_B.getLetra())));
    }

    @Test
    void testaRemovePorIndice() {
        lista.remove(1);
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho() - 1, lista.size());
    }

    @Test
    void testaRemovePorObjeto() {
        lista.remove(Character.valueOf(ListDados.LETRA_B.getLetra()));
        assertFalse(lista.contains(ListDados.LETRA_B.getLetra()));
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho() - 1, lista.size());
    }

    @Test
    void testaRemoveAll() {
        lista.removeAll(List.of(ListDados.LETRA_A.getLetra(), ListDados.LETRA_B.getLetra()));
        assertEquals(1, lista.size());
    }

    @Test
    void testaRetainAll() {
        lista.retainAll(List.of(ListDados.LETRA_B.getLetra()));
        assertEquals(1, lista.size());
        assertEquals(ListDados.LETRA_B.getLetra(), lista.get(0));
    }

    @Test
    void testaIndexOf() {
        assertEquals(1, lista.indexOf(ListDados.LETRA_B.getLetra()));
    }

    @Test
    void testaLastIndexOf() {
        lista.add(ListDados.LETRA_B.getLetra());
        assertEquals(3, lista.lastIndexOf(ListDados.LETRA_B.getLetra()));
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
        assertEquals(ListDados.LETRA_A.getLetra(), iterator.next());
    }

    @Test
    void testaListIterator() {
        ListIterator<Character> listIterator = lista.listIterator();
        assertTrue(listIterator.hasNext());
        assertEquals(ListDados.LETRA_A.getLetra(), listIterator.next());
    }

    @Test
    void testaListIteratorComIndice() {
        ListIterator<Character> listIterator = lista.listIterator(1);
        assertEquals(ListDados.LETRA_B.getLetra(), listIterator.next());
    }

    @Test
    void testaReplaceAll() {
        lista.replaceAll(c -> (char) (c + 1));
        assertEquals((char) (ListDados.LETRA_A.getLetra() + 1), lista.get(0));
    }

    @Test
    void testaSort() {
        lista.sort(Comparator.reverseOrder());
        assertEquals(ListDados.LETRA_C.getLetra(), lista.get(0));
    }

    @Test
    void testaSubList() {
        List<Character> subLista = lista.subList(0, 2);
        assertEquals(2, subLista.size());
        assertEquals(ListDados.LETRA_A.getLetra(), subLista.get(0));
    }

    @Test
    void testaSpliterator() {
        Spliterator<Character> spliterator = lista.spliterator();
        assertNotNull(spliterator);
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho(), spliterator.getExactSizeIfKnown());
    }

    @Test
    void testaToArray() {
        Object[] array = lista.toArray();
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho(), array.length);
    }

    @Test
    void testaToArrayComTipo() {
        Character[] array = lista.toArray(new Character[0]);
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho(), array.length);
    }

    @Test
    void testaEquals() {
        List<Character> outraLista = List.of(ListDados.LETRA_A.getLetra(), ListDados.LETRA_B.getLetra(), ListDados.LETRA_C.getLetra());
        assertEquals(lista, outraLista);
    }

    @Test
    void testaHashCode() {
        List<Character> outraLista = List.of(ListDados.LETRA_A.getLetra(), ListDados.LETRA_B.getLetra(), ListDados.LETRA_C.getLetra());
        assertEquals(lista.hashCode(), outraLista.hashCode());
    }

    @Test
    void testaForEach() {
        lista.forEach(c -> assertNotNull(c));
    }

    @Test
    void testaAddAll() {
        assertTrue(lista.addAll(List.of(ListDados.LETRA_A.getLetra(), ListDados.LETRA_E.getLetra())));
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho() + 2, lista.size());
    }

    @Test
    void testaAddAllPorIndice() {
        assertTrue(lista.addAll(1, List.of(ListDados.LETRA_A.getLetra(), ListDados.LETRA_E.getLetra())));
        assertEquals(ListDados.LETRA_A.getLetra(), lista.get(1));
        assertEquals(ListDados.TAMANHO_PADRAO.getTamanho() + 2, lista.size());
    }
}
