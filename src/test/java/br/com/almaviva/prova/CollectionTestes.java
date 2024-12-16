package br.com.almaviva.prova;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectionTestes {

    private Collection<String> collection;

    @BeforeEach
    void setUp() {
        collection = new ArrayList<>(Arrays.asList("A", "B", "C"));
    }

    @Test
    void testaAdd() {
        assertTrue(collection.add("D"));
    }

    @Test
    void testaAddAll() {
        assertTrue(collection.addAll(Arrays.asList("D", "E")));
    }

    @Test
    void testaClear() {
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    @Test
    void testaContains() {
        assertTrue(collection.contains("A"));
    }

    @Test
    void testaContainsAll() {
        assertTrue(collection.containsAll(Arrays.asList("A", "B")));
    }

    @Test
    void testaEquals() {
        Collection<String> otherCollection = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertEquals(collection, otherCollection);
    }

    @Test
    void testaHashCode() {
        Collection<String> otherCollection = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertEquals(collection.hashCode(), otherCollection.hashCode());
    }

    @Test
    void testaIsEmpty() {
        assertFalse(collection.isEmpty());
    }

    @Test
    void testaIterator() {
        Iterator<String> iterator = collection.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    void testaRemove() {
        assertTrue(collection.remove("B"));
    }

    @Test
    void testaRemoveAll() {
        assertTrue(collection.removeAll(Arrays.asList("B", "C")));
    }

    @Test
    void testaToArray() {
        Object[] array = collection.toArray();
        assertEquals(3, array.length);
    }

    @Test
    void testaArrayToArray() {
        String[] array = collection.toArray(new String[0]);
        assertEquals(3, array.length);
    }

    @Test
    void testaSize() {
        assertEquals(3, collection.size());
    }

    @Test
    void testaSpliterator() {
        Spliterator<String> spliterator = collection.spliterator();
        assertEquals(3, spliterator.getExactSizeIfKnown());
    }

    @Test
    void testaRemoveIf() {
        Predicate<String> filter = s -> s.startsWith("B");
        assertTrue(collection.removeIf(filter));
        assertEquals(Arrays.asList("A", "C"), new ArrayList<>(collection));
    }
}
