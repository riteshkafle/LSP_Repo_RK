package org.howard.edu.lsp.midterm.question2;

public class midquestion2Driver {

    public static void main(String[] args) {
        // Create Book objects
    	midquestion2 book1 = new midquestion2("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
    	midquestion2 book2 = new midquestion2("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        midquestion2 book3 = new midquestion2("A Promised Land", "Barack Obama", "9780593239681", 2020);
        
        // Test equality between book1 and book2 
        System.out.println(book1.equals(book2)); 
        
        // Test equality between book1 and book3 (
        System.out.println(book1.equals(book3)); 
        
        // Print the string representation of book1
        System.out.println(book1);
        
    }
}
