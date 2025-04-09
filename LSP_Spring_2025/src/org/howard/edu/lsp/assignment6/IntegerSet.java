package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The IntegerSet class represents a set of integers.
 * It supports standard set operations such as union, intersection, difference, and complement.
 * Duplicate integers are not allowed.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<>();

    /**
     * Default constructor that initializes an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Constructor that initializes the IntegerSet with a pre-existing ArrayList.
     * Ensures that no duplicate elements are added.
     *
     * @param set The ArrayList of integers.
     */
    public IntegerSet(ArrayList<Integer> set) {
        for (Integer item : set) {
            if (!this.set.contains(item)) {
                this.set.add(item);
            }
        }
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length (number of elements) of the set.
     *
     * @return The size of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Determines if two IntegerSets are equal.
     * Two sets are equal if they contain all of the same values (order does not matter).
     *
     * @param o The object to compare with.
     * @return True if the sets are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet other = (IntegerSet) o;
        if (this.length() != other.length()) return false;
        for (Integer item : set) {
            if (!other.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the set contains the specified value.
     *
     * @param value The value to check.
     * @return True if the value exists in the set, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     *
     * @return The largest integer in the set.
     * @throws IntegerSetException if the set is empty.
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty. No largest element.");
        }
        int max = set.get(0);
        for (int item : set) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    /**
     * Returns the smallest item in the set.
     *
     * @return The smallest integer in the set.
     * @throws IntegerSetException if the set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty. No smallest element.");
        }
        int min = set.get(0);
        for (int item : set) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }

    /**
     * Adds an item to the set or does nothing if it is already present.
     *
     * @param item The integer to add.
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if it is not present.
     *
     * @param item The integer to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Set union. Modifies the current set to be the union of itself and another set.
     *
     * @param intSetb The other IntegerSet to union with.
     */
    public void union(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            if (!this.contains(item)) {
                this.set.add(item);
            }
        }
    }

    /**
     * Set intersection. Modifies the current set to retain only the elements that are in both sets.
     *
     * @param intSetb The other IntegerSet to intersect with.
     */
    public void intersect(IntegerSet intSetb) {
        List<Integer> intersection = new ArrayList<>();
        for (Integer item : set) {
            if (intSetb.contains(item)) {
                intersection.add(item);
            }
        }
        this.set = intersection;
    }

    /**
     * Set difference. Modifies the current set to remove all elements that are present in another set.
     * (i.e., s1 - s2)
     *
     * @param intSetb The other IntegerSet whose elements will be removed from the current set.
     */
    public void diff(IntegerSet intSetb) {
        List<Integer> difference = new ArrayList<>();
        for (Integer item : set) {
            if (!intSetb.contains(item)) {
                difference.add(item);
            }
        }
        this.set = difference;
    }

    /**
     * Set complement. Modifies the current set to be the complement relative to the provided universal set.
     * That is, the current set becomes all the elements in intSetb that are not in the original set.
     *
     * @param intSetb The universal set to compare with.
     */
    public void complement(IntegerSet universalSet) {
    	List<Integer> complementSet = new ArrayList<>();
        for (Integer item : universalSet.set) {
            if (!this.set.contains(item)) {
                complementSet.add(item);
            }
        }
        this.set.clear();
        this.set.addAll(complementSet);
        
 
    }

    /**
     * Returns true if the set is empty, false otherwise.
     *
     * @return True if the set contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a String representation of the set.
     *
     * @return The string representation of the set.
     */
    @Override
    public String toString() {
        return set.toString();
    }
}