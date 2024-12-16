package br.com.almaviva.prova;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListTeste {

    private ArrayList<String> arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new ArrayList<>(Arrays.asList("A", "B", "C"));
    }

    @Test
    void testaAddComIndice() {
        arrayList.add(1, "D");
        assertEquals("D", arrayList.get(1));
    }

    @Test
    void testaAddAll() {
        arrayList.addAll(Arrays.asList("D", "E"));
        assertEquals(5, arrayList.size());
    }

    @Test
    void testaClear() {
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    void testaContains() {
        assertTrue(arrayList.contains("B"));
    }

    @Test
    void testaGet() {
        assertEquals("B", arrayList.get(1));
    }

    @Test
    void testaIsEmpty() {
        assertFalse(arrayList.isEmpty());
    }

    @Test
    void testaIterator() {
        Iterator<String> iterator = arrayList.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    void testaLastIndexOf() {
        arrayList.add("B");
        assertEquals(3, arrayList.lastIndexOf("B"));
    }

    @Test
    void testaRemove() {
        assertEquals("B", arrayList.remove(1));
        assertEquals(Arrays.asList("A", "C"), arrayList);
    }

    @Test
    void testaRemovePorObjeto() {
        assertTrue(arrayList.remove("B"));
        assertEquals(Arrays.asList("A", "C"), arrayList);
    }

    @Test
    void testaRemoveAll() {
        assertTrue(arrayList.removeAll(Arrays.asList("B", "C")));
        assertEquals(Collections.singletonList("A"), arrayList);
    }

    @Test
    void testaRemoveIf() {
        Predicate<String> filter = n -> n.startsWith("B");
        assertTrue(arrayList.removeIf(filter));
        assertEquals(Arrays.asList("A", "C"), arrayList);
    }

    @Test
    void testaSet() {
        arrayList.set(1, "X");
        assertEquals(Arrays.asList("A", "X", "C"), arrayList);
    }

    @Test
    void testaSize() {
        assertEquals(3, arrayList.size());
    }
    
    @Test
    void testaClone() {
        ArrayList arrayList2 = (ArrayList)arrayList.clone();
        assertEquals(arrayList, arrayList2);
    }
    
    
}
