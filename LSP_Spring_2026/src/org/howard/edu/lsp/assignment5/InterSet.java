package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet models a mathematical set of integers.
 * The set does not allow duplicates and supports standard set operations.
 */
public class IntegerSet {

    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return length of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this set with another set for equality.
     * Two sets are equal if they contain the same elements.
     * @param b another IntegerSet
     * @return true if sets are equal, false otherwise
     */
    public boolean equals(IntegerSet b) {
        ArrayList<Integer> aList = new ArrayList<>(this.set);
        ArrayList<Integer> bList = new ArrayList<>(b.set);

        Collections.sort(aList);
        Collections.sort(bList);

        return aList.equals(bList);
    }

    /**
     * Checks if a value exists in the set.
     * @param value integer to check
     * @return true if value exists, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     * @return largest integer
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     * @return smallest integer
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it does not already exist.
     * @param item integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     * @param item integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set that is the union of this set and another set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet containing all unique elements from both sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        result.set.addAll(this.set);

        for (int item : intSetb.set) {
            if (!result.set.contains(item)) {
                result.set.add(item);
            }
        }

        return result;
    }

    /**
     * Returns a new set that is the intersection of this set and another set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet containing common elements
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (intSetb.set.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements in this set but not in the other set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet representing the difference (this - b)
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (!intSetb.set.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements in the other set but not in this set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet representing the complement (b - this)
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : intSetb.set) {
            if (!this.set.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Checks if the set is empty.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format: [1, 2, 3]
     * @return formatted string of set elements
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
