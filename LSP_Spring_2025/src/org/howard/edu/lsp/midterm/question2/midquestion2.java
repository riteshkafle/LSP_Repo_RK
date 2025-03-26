package org.howard.edu.lsp.midterm.question2;

public class Book {


    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;
    
    /**
     * constructs a book object with the specified title, author, ISBN, and year published.
     *
     * @param title the title of the book.
     * @param author  the author of the book.
     * @param ISBN the ISBN number of the book.
     * @param yearPublished the year the book was published.
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }
    
    /**
     * Returns  title of the book.
     *
     * @return  title.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the title of the book.
     *
     * @param title the title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Returns the author of the book.
     *
     * @return The author.
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Sets the author of the book.
     *
     * @param author The author to set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * Returns the ISBN number of the book.
     *
     * @return The ISBN.
     */
    public String getISBN() {
        return ISBN;
    }
    
    /**
     * Sets the ISBN number of the book.
     *
     * @param ISBN The ISBN to set.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    /**
     * Returns the year the book was published.
     *
     * @return The year published.
     */
    public int getYearPublished() {
        return yearPublished;
    }
    
    /**
     * Sets the year the book was published.
     *
     * @param yearPublished The year published to set.
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    
    /**
     * Two books are considered equal if they have the same ISBN and author.
     *
     * @param obj The object to compare with this book.
     * @return true if the books are equal; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        // object is compared with itself
        if (this == obj)
            return true;
        // object is null or not of the same class
        if (obj == null || getClass() != obj.getClass())
            return false;
        midquestion2 other = (midquestion2) obj;
        //  ISBN and author for equality
        if (ISBN == null) {
            if (other.ISBN != null)
                return false;
        } else if (!ISBN.equals(other.ISBN))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        return true;
    }
    
    /**
     * Returns a string representation of the Book object.
     * "Title: [title], Author: [author], ISBN: [ISBN], Year Published: [yearPublished]"
     *
     * @return A string representing the Book.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}


