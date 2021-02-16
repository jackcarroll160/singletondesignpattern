package singletondesignpattern;

import java.util.HashMap;

/**
 * Library Class 
 * @author Jackson Carroll
 */
public class Library {
    
    private HashMap<String, Integer> books;
    private static Library library;

    /**
     * Private Library constructor to prevent the creation of instances of the class
     */
    private Library() {}

    public static Library getInstance() {
        if(Library == null) {
            System.out.println("Creating our Library. Time to begin reading.");
            library = new Library();
        }
        return library;
    }

    public boolean checkoutBook(String bookName) {
        while(books.hasNext()) {
            if(books.getKey(bookName) && books.getValue() >= 1) {
                books.remove(bookName, books.getValue() - 1);
                System.out.println(bookName + " was successfully checked out");
                return true;
            }
            else {
                System.out.println("Sorry " + bookName + " is not in stock");
                return false;
            }
        }
    }

    public void checkInBook(String bookName, int numToAdd) {
        while(books.hasNext()) {
            if(books.getKey(bookName)) {
                numToAdd += books.getValue();
            }
            else {
                books.put(bookName, numToAdd);
            }
        }
        System.out.println(bookName + " was added to the library");
    }

    public void displayBooks() {
        System.out.println("Inventory:");

        while(books.hasNext()) {
            System.out.println("\t- " + books.getKey() + ", copies: " + books.getValue());
        }
    }


}
