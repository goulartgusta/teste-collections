package br.com.almaviva.prova;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

import org.junit.jupiter.api.Test;

public class ListTestes {

    @Test
    void testaAddSucesso() {
        List<String> list = new ArrayList<>();
        list.add(0, "A");
        assertEquals("A", list.get(0));
    }

    @Test
    void testaAddAllSucesso() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("A", "B", "C"));
        assertEquals(3, list.size());
    }

    @Test
    void testaAddAllComListaSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        list.addAll(1, Arrays.asList("A", "B"));
        assertEquals(Arrays.asList("X", "A", "B", "Y", "Z"), list);
    }

    @Test
    void testaClearSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testaContainsSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertTrue(list.contains("B"));
    }

    @Test
    void testaContainsAllSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertTrue(list.containsAll(Arrays.asList("A", "B")));
    }

    @Test
    void testaEqualsSucesso() {
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertEquals(list1, list2);
    }

    @Test
    void testaGetSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertEquals("B", list.get(1));
    }

    @Test
    void testaHashCodeSucesso() {
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertEquals(list1.hashCode(), list2.hashCode());
    }

    @Test
    void testaIndexOfSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "B"));
        assertEquals(1, list.indexOf("B"));
    }

    @Test
    void testaIsEmptySucesso() {
        List<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void testaIteratorSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
    }

    @Test
    void testaListIteratorSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ListIterator<String> listIterator = list.listIterator(1);
        assertEquals("B", listIterator.next());
    }
    
    @Test
    void testaLastIndexOfSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "B"));
        assertEquals(3, list.lastIndexOf("B"));
    }

    @Test
    void testaRemoveSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertEquals("B", list.remove(1));
        assertTrue(list.remove("A"));
    }

    @Test
    void testaRemoveAllSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertTrue(list.removeAll(Arrays.asList("B", "C")));
    }

    @Test
    void testaReplaceAllSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        UnaryOperator<String> upperCaseOperator = String::toUpperCase;
        list.replaceAll(upperCaseOperator);
        assertEquals(Arrays.asList("A", "B", "C"), list);
    }

    @Test
    void testaSetSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        list.set(1, "X");
        assertEquals(Arrays.asList("A", "X", "C"), list);
    }

    @Test
    void testaSizeSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertEquals(3, list.size());
    }

    @Test
    void testaSubListSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        List<String> subList = list.subList(1, 3);
        assertEquals(Arrays.asList("B", "C"), subList);
    }

    @Test
    void testaToArraySucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Object[] array = list.toArray();
        assertEquals(3, array.length);
    }

    @Test
    void testaArrayToArraySucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        String[] array = list.toArray(new String[0]);
        assertEquals(3, array.length);
    }
    
    @Test
    void testaSortSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("C", "A", "B"));
        list.sort(Comparator.naturalOrder());
        assertEquals(Arrays.asList("A", "B", "C"), list);
    }

    @Test
    void testaSpliteratorSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        Spliterator<String> spliterator = list.spliterator();
        assertEquals(4, spliterator.getExactSizeIfKnown());
    }
    @Test
    void testaRetainAllSucesso() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertTrue(list.retainAll(Arrays.asList("A", "C")));
    }
}
