package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test suite for IntegerSet.
 * Covers every public method with at least one normal case and one edge case.
 */
public class IntegerSetTest {

    // ─────────────────────────────────────────────
    // clear()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("clear() – normal: removes all elements from a populated set")
    public void testClearNormal() {
        IntegerSet s = new IntegerSet();
        s.add(1);
        s.add(2);
        s.add(3);
        s.clear();
        assertEquals(0, s.length(), "Length should be 0 after clear()");
        assertTrue(s.isEmpty(), "Set should be empty after clear()");
    }

    @Test
    @DisplayName("clear() – edge: calling clear() on an already-empty set is safe")
    public void testClearAlreadyEmpty() {
        IntegerSet s = new IntegerSet();
        s.clear(); // should not throw
        assertEquals(0, s.length());
        assertTrue(s.isEmpty());
    }

    // ─────────────────────────────────────────────
    // length()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("length() – normal: returns correct count for a non-empty set")
    public void testLengthNormal() {
        IntegerSet s = new IntegerSet();
        s.add(10);
        s.add(20);
        s.add(30);
        assertEquals(3, s.length());
    }

    @Test
    @DisplayName("length() – edge: returns 0 for an empty set")
    public void testLengthEmpty() {
        IntegerSet s = new IntegerSet();
        assertEquals(0, s.length());
    }

    // ─────────────────────────────────────────────
    // equals()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("equals() – normal: two sets with the same elements in the same order are equal")
    public void testEqualsNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(1); b.add(2); b.add(3);
        assertTrue(a.equals(b));
    }

    @Test
    @DisplayName("equals() – edge: same elements added in different order are still equal")
    public void testEqualsDifferentInsertionOrder() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(3); a.add(1); a.add(2);
        b.add(1); b.add(2); b.add(3);
        assertTrue(a.equals(b));
    }

    @Test
    @DisplayName("equals() – edge: sets with different elements are not equal")
    public void testEqualsMismatch() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(1); b.add(99);
        assertFalse(a.equals(b));
    }

    @Test
    @DisplayName("equals() – edge: two empty sets are equal")
    public void testEqualsBothEmpty() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        assertTrue(a.equals(b));
    }

    // ─────────────────────────────────────────────
    // contains()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("contains() – normal: returns true when value is present")
    public void testContainsPresent() {
        IntegerSet s = new IntegerSet();
        s.add(5);
        assertTrue(s.contains(5));
    }

    @Test
    @DisplayName("contains() – edge: returns false when value is not present")
    public void testContainsAbsent() {
        IntegerSet s = new IntegerSet();
        s.add(5);
        assertFalse(s.contains(99));
    }

    @Test
    @DisplayName("contains() – edge: returns false on an empty set")
    public void testContainsEmptySet() {
        IntegerSet s = new IntegerSet();
        assertFalse(s.contains(0));
    }

    // ─────────────────────────────────────────────
    // largest()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("largest() – normal: returns the maximum element")
    public void testLargestNormal() {
        IntegerSet s = new IntegerSet();
        s.add(3); s.add(7); s.add(1);
        assertEquals(7, s.largest());
    }

    @Test
    @DisplayName("largest() – edge: single-element set returns that element")
    public void testLargestSingleElement() {
        IntegerSet s = new IntegerSet();
        s.add(42);
        assertEquals(42, s.largest());
    }

    @Test
    @DisplayName("largest() – edge: throws RuntimeException on empty set")
    public void testLargestEmptyThrows() {
        IntegerSet s = new IntegerSet();
        assertThrows(RuntimeException.class, s::largest);
    }

    // ─────────────────────────────────────────────
    // smallest()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("smallest() – normal: returns the minimum element")
    public void testSmallestNormal() {
        IntegerSet s = new IntegerSet();
        s.add(3); s.add(7); s.add(1);
        assertEquals(1, s.smallest());
    }

    @Test
    @DisplayName("smallest() – edge: single-element set returns that element")
    public void testSmallestSingleElement() {
        IntegerSet s = new IntegerSet();
        s.add(42);
        assertEquals(42, s.smallest());
    }

    @Test
    @DisplayName("smallest() – edge: throws RuntimeException on empty set")
    public void testSmallestEmptyThrows() {
        IntegerSet s = new IntegerSet();
        assertThrows(RuntimeException.class, s::smallest);
    }

    // ─────────────────────────────────────────────
    // add()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("add() – normal: adds a new element and length increases")
    public void testAddNormal() {
        IntegerSet s = new IntegerSet();
        s.add(10);
        assertTrue(s.contains(10));
        assertEquals(1, s.length());
    }

    @Test
    @DisplayName("add() – edge: adding a duplicate does not increase length")
    public void testAddDuplicate() {
        IntegerSet s = new IntegerSet();
        s.add(10);
        s.add(10); // duplicate
        assertEquals(1, s.length(), "Duplicate should not be added");
        assertTrue(s.contains(10));
    }

    // ─────────────────────────────────────────────
    // remove()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("remove() – normal: removes an existing element")
    public void testRemoveNormal() {
        IntegerSet s = new IntegerSet();
        s.add(5); s.add(10);
        s.remove(5);
        assertFalse(s.contains(5));
        assertEquals(1, s.length());
    }

    @Test
    @DisplayName("remove() – edge: removing a value not in set is safe (no exception)")
    public void testRemoveNotPresent() {
        IntegerSet s = new IntegerSet();
        s.add(5);
        s.remove(99); // should not throw
        assertEquals(1, s.length(), "Length should remain the same");
    }

    @Test
    @DisplayName("remove() – edge: removing from an empty set is safe")
    public void testRemoveFromEmptySet() {
        IntegerSet s = new IntegerSet();
        s.remove(1); // should not throw
        assertEquals(0, s.length());
    }

    // ─────────────────────────────────────────────
    // union()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("union() – normal: result contains all elements from both sets without duplicates")
    public void testUnionNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(3); b.add(4); b.add(5);
        IntegerSet result = a.union(b);
        assertEquals(5, result.length());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
        assertTrue(result.contains(5));
    }

    @Test
    @DisplayName("union() – edge: union with an empty set returns a copy of the non-empty set")
    public void testUnionWithEmptySet() {
        IntegerSet a = new IntegerSet();
        IntegerSet empty = new IntegerSet();
        a.add(1); a.add(2);
        IntegerSet result = a.union(empty);
        assertEquals(2, result.length());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
    }

    @Test
    @DisplayName("union() – edge: union of two empty sets is empty")
    public void testUnionBothEmpty() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        IntegerSet result = a.union(b);
        assertTrue(result.isEmpty());
    }

    // ─────────────────────────────────────────────
    // intersect()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("intersect() – normal: result contains only common elements")
    public void testIntersectNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2); b.add(3); b.add(4);
        IntegerSet result = a.intersect(b);
        assertEquals(2, result.length());
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertFalse(result.contains(1));
        assertFalse(result.contains(4));
    }

    @Test
    @DisplayName("intersect() – edge: disjoint sets produce an empty intersection")
    public void testIntersectNoCommonElements() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(3); b.add(4);
        IntegerSet result = a.intersect(b);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("intersect() – edge: intersection with an empty set is empty")
    public void testIntersectWithEmptySet() {
        IntegerSet a = new IntegerSet();
        IntegerSet empty = new IntegerSet();
        a.add(1); a.add(2);
        IntegerSet result = a.intersect(empty);
        assertTrue(result.isEmpty());
    }

    // ─────────────────────────────────────────────
    // diff()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("diff() – normal: result contains elements in this set but not in the other")
    public void testDiffNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2); b.add(3);
        IntegerSet result = a.diff(b);
        assertEquals(1, result.length());
        assertTrue(result.contains(1));
        assertFalse(result.contains(2));
        assertFalse(result.contains(3));
    }

    @Test
    @DisplayName("diff() – edge: diff of identical sets is empty")
    public void testDiffIdenticalSets() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(1); b.add(2);
        IntegerSet result = a.diff(b);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("diff() – edge: diff against an empty set returns a copy of this set")
    public void testDiffAgainstEmptySet() {
        IntegerSet a = new IntegerSet();
        IntegerSet empty = new IntegerSet();
        a.add(1); a.add(2);
        IntegerSet result = a.diff(empty);
        assertEquals(2, result.length());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
    }

    // ─────────────────────────────────────────────
    // complement()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("complement() – normal: result contains elements in b but not in this")
    public void testComplementNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(3); b.add(4);
        IntegerSet result = a.complement(b);
        assertEquals(2, result.length());
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
        assertFalse(result.contains(2));
    }

    @Test
    @DisplayName("complement() – edge: disjoint sets — complement returns all of b")
    public void testComplementDisjointSets() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(3); b.add(4);
        IntegerSet result = a.complement(b);
        assertEquals(2, result.length());
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
    }

    @Test
    @DisplayName("complement() – edge: complement against empty b returns empty set")
    public void testComplementEmptyB() {
        IntegerSet a = new IntegerSet();
        IntegerSet empty = new IntegerSet();
        a.add(1); a.add(2);
        IntegerSet result = a.complement(empty);
        assertTrue(result.isEmpty());
    }

    // ─────────────────────────────────────────────
    // isEmpty()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("isEmpty() – normal: returns false when set has elements")
    public void testIsEmptyFalse() {
        IntegerSet s = new IntegerSet();
        s.add(1);
        assertFalse(s.isEmpty());
    }

    @Test
    @DisplayName("isEmpty() – edge: returns true for a freshly created set")
    public void testIsEmptyTrue() {
        IntegerSet s = new IntegerSet();
        assertTrue(s.isEmpty());
    }

    @Test
    @DisplayName("isEmpty() – edge: returns true after all elements are removed")
    public void testIsEmptyAfterRemoveAll() {
        IntegerSet s = new IntegerSet();
        s.add(1);
        s.remove(1);
        assertTrue(s.isEmpty());
    }

    // ─────────────────────────────────────────────
    // toString()
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("toString() – normal: elements are displayed in ascending sorted order")
    public void testToStringNormal() {
        IntegerSet s = new IntegerSet();
        s.add(3); s.add(1); s.add(2);
        assertEquals("[1, 2, 3]", s.toString());
    }

    @Test
    @DisplayName("toString() – edge: empty set produces '[]'")
    public void testToStringEmpty() {
        IntegerSet s = new IntegerSet();
        assertEquals("[]", s.toString());
    }

    @Test
    @DisplayName("toString() – edge: single element produces '[n]'")
    public void testToStringSingleElement() {
        IntegerSet s = new IntegerSet();
        s.add(7);
        assertEquals("[7]", s.toString());
    }
}
