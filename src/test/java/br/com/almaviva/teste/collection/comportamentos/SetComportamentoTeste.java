package br.com.almaviva.teste.collection.comportamentos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.almaviva.teste.collection.comportamentos.models.SetDados;

public class SetComportamentoTeste {

    static Stream<Set<Character>> utilizarSets() {
        return Stream.of(new HashSet<>(), new TreeSet<>());
    }

    @ParameterizedTest
    @MethodSource("utilizarSets")
    void deveriaAdicionarElementosNoSet(Set<Character> set) {
        set.add(SetDados.LETRA_A.getLetra());
        set.add(SetDados.LETRA_B.getLetra());

        assertEquals(SetDados.TAMANHO_PADRAO.getTamanho(), set.size());
    }
    
    @ParameterizedTest
    @MethodSource("utilizarSets")
    void deveriaImpedirDuplicatasNoSet(Set<Character> set) {
        set.add(SetDados.LETRA_A.getLetra());
        set.add(SetDados.LETRA_B.getLetra());
        set.add(SetDados.LETRA_A.getLetra()); 

        assertEquals(SetDados.TAMANHO_PADRAO.getTamanho(), set.size());
        assertTrue(set.contains(SetDados.LETRA_A.getLetra()));
    }
    
    void deveriaManterElementosOrdenadosNoTreeSet(Set<Character> set) {
        set.add(SetDados.LETRA_B.getLetra());
        set.add(SetDados.LETRA_A.getLetra());
        set.add(SetDados.LETRA_C.getLetra());

        if (set instanceof TreeSet) {
            assertEquals("[A, B, C]", set.toString());
        } else {
            assertTrue(set.contains(SetDados.LETRA_A.getLetra()));
            assertTrue(set.contains(SetDados.LETRA_B.getLetra()));
            assertTrue(set.contains(SetDados.LETRA_C.getLetra()));
        }
    }

    @ParameterizedTest
    @MethodSource("utilizarSets")
    void deveriaRemoverElementoDoSet(Set<Character> set) {
        set.add(SetDados.LETRA_A.getLetra());
        set.add(SetDados.LETRA_B.getLetra());

        set.remove(SetDados.LETRA_A.getLetra());

        assertEquals(SetDados.TAMANHO_POS_REMOVE.getTamanho(), set.size());
        assertTrue(set.contains(SetDados.LETRA_B.getLetra()));
    }

    @ParameterizedTest
    @MethodSource("utilizarSets")
    void deveriaVerificarElementoEspecificoNoSet(Set<Character> set) {
        set.add(SetDados.LETRA_A.getLetra());
        set.add(SetDados.LETRA_B.getLetra());

        assertTrue(set.contains(SetDados.LETRA_A.getLetra()));
        assertTrue(set.contains(SetDados.LETRA_B.getLetra()));
        assertTrue(!set.contains(SetDados.LETRA_C.getLetra()));
    }
    
    static Stream<Set<Character>> utilizarSetsThreadSafe() {
        return Stream.of(new HashSet<>(), new ConcurrentSkipListSet<>());
    }


    @ParameterizedTest
    @MethodSource("utilizarSetsThreadSafe")
    void deveriaAdicionarElementosConcorretementeNoSet(Set<Character> set) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 50; i++) {
            final char letra = (char) ('A' + (i % 26));
            executor.execute(() -> {
                set.add(letra);
            });
        }

		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);

        assertEquals(26, set.size()); 
    }

    @ParameterizedTest
    @MethodSource("utilizarSetsThreadSafe")
    void deveriaRemoverElementosConcorretementeNoSet(Set<Character> set) throws InterruptedException {
        for (int i = 0; i < 26; i++) {
            set.add((char) ('A' + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 26; i++) {
            final char letra = (char) ('A' + i);
            executor.execute(() -> {
                set.remove(letra);
            });
        }

        executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);

        assertEquals(0, set.size());
    }

    @ParameterizedTest
    @MethodSource("utilizarSetsThreadSafe")
    void deveriaVerificarElementosConcorretementeNoSet(Set<Character> set) throws InterruptedException {
        for (int i = 0; i < 26; i++) {
            set.add((char) ('A' + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 26; i++) {
            final char letra = (char) ('A' + i);
            executor.execute(() -> {
                assertTrue(set.contains(letra));
            });
        }

        executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);

        assertEquals(26, set.size());
    }
}
