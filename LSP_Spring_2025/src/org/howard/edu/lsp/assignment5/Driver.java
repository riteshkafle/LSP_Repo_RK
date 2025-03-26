package org.howard.edu.lsp.assignment5;


import java.util.NoSuchElementException;

/**
 * The Driver class tests the IntegerSet class methods.
 */

public class Driver {
	
    /**
     * The main method that runs tests on the IntegerSet class.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Create first IntegerSet
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1 is: " + set1.toString());
        
        try {
            System.out.println("Smallest value in Set1 is: " + set1.smallest());
            System.out.println("Largest value in Set1 is: " + set1.largest());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
        // Create second IntegerSet
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("\nValue of Set2 is: " + set2.toString());
        
        // Test union
        System.out.println("\nUnion of Set1 and Set2:");
        System.out.println("Before union, Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union (Set1): " + set1.toString());
        
        // Reset set1 for further tests
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        // Test intersection
        System.out.println("\nIntersection of Set1 and Set2:");
        System.out.println("Before intersection, Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.intersect(set2);
        System.out.println("Result of intersection (Set1): " + set1.toString());
        
        // Reset set1 for further tests
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        // Test difference: Set1 - Set2
        System.out.println("\nDifference of Set1 and Set2 (Set1 - Set2):");
        System.out.println("Before difference, Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.diff(set2);
        System.out.println("Result of difference (Set1): " + set1.toString());
        
        // Test complement: Complement of Set1 relative to Set2 (i.e., elements in Set2 not in Set1)
        System.out.println("\nComplement of Set1 relative to Set2:");
        // For complement test, reset set1 to a new set for clarity.
        set1.clear();
        set1.add(1);
        set1.add(2);
        System.out.println("Before complement, Set1: " + set1.toString());
        System.out.println("Universal Set (Set2): " + set2.toString());
        set1.complement(set2);
        System.out.println("Result of complement (Set1): " + set1.toString());
        
        // Test equals
        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(4);
        set3.add(5);
        System.out.println("\nTesting equals:");
        System.out.println("Set2: " + set2.toString());
        System.out.println("Set3: " + set3.toString());
        System.out.println("Set2 equals Set3? " + set2.equals(set3));
        
        // Test isEmpty and clear
        System.out.println("\nTesting isEmpty and clear:");
        System.out.println("Set3 before clear: " + set3.toString());
        System.out.println("Is Set3 empty? " + set3.isEmpty());
        set3.clear();
        System.out.println("Set3 after clear: " + set3.toString());
        System.out.println("Is Set3 empty? " + set3.isEmpty());
    }
}
