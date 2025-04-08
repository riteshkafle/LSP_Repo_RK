package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class IntegerSetTest {

    IntegerSet set1;
    IntegerSet set2;

    @BeforeEach
    public void setup() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test for clear and isEmpty")
    public void testClear() {
    	//Junit test case for clear and isEmpty
        set1.add(1);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    @DisplayName("Test for length")
    public void testLength() {
    	// JUnit test case(s) for length
        assertEquals(0, set1.length());
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
    	// JUnit test case(s) for equals
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));
        set2.remove(1);
        assertFalse(set1.equals(set2));
    }

    @Test
    @DisplayName("Test for contains")
    public void testContains() {
    	// JUnit test case(s) for contains
        set1.add(5);
        assertTrue(set1.contains(5));
        assertFalse(set1.contains(100));
    }

    @Test
    @DisplayName("Test for largest")
    public void testLargest() throws IntegerSetException {
    	// JUnit test case(s) for largest
        set1.add(10);
        set1.add(20);
        set1.add(5);
        assertEquals(20, set1.largest());
    }

    @Test
    @DisplayName("Test for largest exception")
    public void testLargestException() {
    	  // JUnit test case(s) for largest exception
        assertThrows(IntegerSetException.class, () -> set1.largest());
    }

    @Test
    @DisplayName("Test for smallest")
    public void testSmallest() throws IntegerSetException {
    	  // JUnit test case(s) for smallest
        set1.add(3);
        set1.add(1);
        set1.add(5);
        assertEquals(1, set1.smallest());
    }

    @Test
    @DisplayName("Test for smallest exception")
    public void testSmallestException() {
    	  // JUnit test case(s) for smallest exception
        assertThrows(IntegerSetException.class, () -> set1.smallest());
    }

    @Test
    @DisplayName("Test for add and toString")
    public void testAddToString() {
    	// JUnit test case(s) for add and toString
        set1.add(10);
        set1.add(20);
        set1.add(10);
        assertEquals("[10, 20]", set1.toString());
    }

    @Test
    @DisplayName("Test for remove")
    public void testRemove() {
    	  // JUnit test case(s) for remove
        set1.add(1);
        set1.add(2);
        set1.remove(1);
        assertFalse(set1.contains(1));
        assertEquals("[2]", set1.toString());
    }

    @Test
    @DisplayName("Test for union")
    public void testUnion() {
    	 // JUnit test case(s) for union
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
    }

    @Test
    @DisplayName("Test for intersect")
    public void testIntersect() {
    	// JUnit test case(s) for intersect
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertEquals("[2]", set1.toString());
    }

    @Test
    @DisplayName("Test for diff")
    public void testDiff() {
    	// JUnit test case(s) for diff
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set1.diff(set2);
        assertEquals("[1, 3]", set1.toString());
    }

    @Test
    @DisplayName("Test for  complement")
    public void testComplement() {
    	 // JUnit test case(s) for complement
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set1.complement(set2);
        assertEquals("[3, 4]", set1.toString());
    }

    @Test
    @DisplayName("Test for  isEmpty")
    public void testIsEmpty() {
    	 // JUnit test case(s) for isEmpty
        assertTrue(set1.isEmpty());
        set1.add(1);
        assertFalse(set1.isEmpty());
    }

    @Test
    @DisplayName("Test for toString format")
    public void testToStringFormat() {
    	 // JUnit test case(s) for toString
        assertEquals("[]", set1.toString());
        set1.add(9);
        assertEquals("[9]", set1.toString());
    }
}
