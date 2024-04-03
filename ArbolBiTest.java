/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - sección 40
 * Roberto Barreda - 23354
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class ArbolBiTest {
    @Test
    public void testAddAndRemove() {
        ArbolBi<Integer> heap = new ArbolBi<>();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());

        heap.add(5);
        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
        assertEquals(Integer.valueOf(5), heap.remove());

        heap.add(3);
        heap.add(7);
        heap.add(1);
        heap.add(9);

        assertEquals(Integer.valueOf(1), heap.remove());
        assertEquals(Integer.valueOf(3), heap.remove());
        assertEquals(Integer.valueOf(7), heap.remove());
        assertEquals(Integer.valueOf(9), heap.remove());

        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void testSize() {
        ArbolBi<String> heap = new ArbolBi<>();
        assertEquals(0, heap.size());

        heap.add("a");
        assertEquals(1, heap.size());

        heap.add("b");
        heap.add("c");
        assertEquals(3, heap.size());

        heap.remove();
        assertEquals(2, heap.size());

        heap.add("d");
        heap.remove();
        heap.remove();
        assertEquals(0, heap.size());
    }

    @Test
    public void testIsEmpty() {
        ArbolBi<Double> heap = new ArbolBi<>();
        assertTrue(heap.isEmpty());

        heap.add(1.0);
        assertFalse(heap.isEmpty());

        heap.remove();
        assertTrue(heap.isEmpty());
    }
}

