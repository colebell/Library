package LibraryTTS;

import java.util.ArrayList;
/**
 *
 * @author coleb
 */
public class Library {
    
    private String location;
    private ArrayList<Book> Library = new ArrayList<>(); 
    
    public Library(String location){
        this.location = location;
        //ArrayList<Book> Library = new ArrayList<>();
    }
    
    public void addBook(Book b){
       this.Library.add(b);
    }
    
    public static void printOpeningHours() {
    System.out.println("Libraries are open daily from 9am to 5pm");
    }
    
    public void printAddress() {
        System.out.println(this.location);
    }
    
    public void borrowBook(String title) {
        int len = this.Library.size();
        boolean solution = false;
        for (int i = 0; i<len;i++) {
            if (this.Library.get(i).getTitle().equals(title)) {
                if(!this.Library.get(i).isBorrowed()) {
                    System.out.println("Book Borrowed successfully");
                    this.Library.get(i).borrowed();
                    solution = true;
                    break;
                }
                if(this.Library.get(i).isBorrowed()) {
                    System.out.println("Book is being borrowed already");
                    solution = true;
                    break;
                }
            }
        }
        if(!solution)
        System.out.println("This book is unavailable at this time");
    }
    
    public void returnBook(String title){
        int len = this.Library.size();
        boolean solution = false;
        for (int i = 0; i<len;i++) {
            if (this.Library.get(i).getTitle().equals(title)) {
                if(this.Library.get(i).isBorrowed()) {
                    System.out.println("Book Returned");
                    this.Library.get(i).returned();
                    solution = true;
                    break;
                }
            }
        }
        if (!solution)
        System.out.println("Not our book");
    }
    
    public void printAvailableBooks() {
        int len = this.Library.size();
        int counter = 0;
        for(int i = 0; i<len; i++) {
            if(!this.Library.get(i).isBorrowed()) {
                System.out.println(this.Library.get(i).getTitle());
                counter++;
            }
        }
        if (counter < 1) System.out.println("No available books here");
    }
    
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        
        System.out.println(firstLibrary.Library.get(0).getTitle().toString());

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
    
}
