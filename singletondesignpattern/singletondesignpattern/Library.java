package singletondesignpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for a Library
 * @author Jackson Carroll
 */
public class Library {

    private HashMap<String, Integer> books = new HashMap<>();
    private static Library library = null;

    /**
     * Private Library constructor to prevent the creation of instances of the class
     */
    private Library() {}

    /**
     * Static method to get an instance of Library class
     * @return the library
     */
    public static Library getInstance() {
        if (library == null) {
            System.out.println("Creating our Library. Time to begin reading.");
            library = new Library();
        }
        return library;
    }

    /**
     * Checks out a book by its name
     * @param bookName A String for the book name
     * @return true or false
     */
    public boolean checkoutBook(String bookName) {
        if (books.containsKey(bookName) && books.get(bookName) > 0) {
            books.put(bookName, books.get(bookName) - 1);
            System.out.println(bookName + " was successfully checked out");
            return true;
        } 
        else {
            books.putIfAbsent(bookName, 0);
            System.out.println("Sorry " + bookName + " is not in stock");
            return false;
        }
    }

    /**
     * Checks in a book by name with its number of copies being checked in
     * @param bookName A String for the book name
     * @param numToAdd An integer for the number of copies to add
     */
    public void checkInBook(String bookName, int numToAdd) {
        if (books.containsKey(bookName)) {
            numToAdd += books.get(bookName);
            books.put(bookName, numToAdd);
            System.out.println("A new copy of " + bookName + " was added to the library");
        }
        else {
            books.put(bookName, numToAdd);
            System.out.println(bookName + " was added to the library");
        }
    }

    /**
     * Displays the inventory followed by each book in stock
     */
    public void displayBooks() {
        System.out.println("\nInventory:");

        for (Map.Entry<String, Integer> entry : books.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("  - " + key + ", copies: " + value);
        } 
    }

}
