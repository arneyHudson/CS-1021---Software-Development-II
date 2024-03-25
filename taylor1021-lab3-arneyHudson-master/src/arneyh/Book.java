/*
 * Course: CS 1021 021
 * Winter 2021-2022
 * Lab 3
 * Name: Hudson Arney
 * Created: 12/14/2021
 * Updated:
 */

package arneyh;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Book class that is a reference. A book class has its own separate functions from other
 * reference types
 */
public class Book extends Reference {
    private String publisher;

    /**
     * Prints out a prompt for when a new book is created.
     * @param out prints out the output for a new prompt
     * @param in Scanner object that allows the user to input
     */
    public void promptToInitialize(PrintStream out, Scanner in) {
        out.print("Enter the author of the reference\n");
        author = in.nextLine();
        out.print("Enter the title of the reference\n");
        title = in.nextLine();
        out.print("Enter the copyright year of the reference\n");
        publicationYear = Integer.parseInt(in.nextLine());
        out.print("Enter the publisher of the book\n");
        publisher = in.nextLine();

    }

    /**
     * Prints out a prompt that asks certain characteristics when updating an article
     * @param out prints out the output for an updated prompt
     * @param in Scanner object that allows the user to input
     */
    public void promptForUpdate(PrintStream out, Scanner in) {
        out.print("Enter the updated author of the reference\n");
        author = in.nextLine();
        out.print("Enter the updated title of the reference\n");
        title = in.nextLine();
        out.print("Enter the updated copyright year for the reference.\n");
        publicationYear = Integer.parseInt(in.nextLine());
        out.print("Enter the updated publisher for the book\n");
        publisher = in.nextLine();
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "@BOOK { " + super.getMyUniqueID() +",\n" +
                "author = \"" + getAuthor() + "\",\n" +
                "title = \"" + getTitle() + "\",\n" +
                "publisher = \"" + getPublisher() + "\",\n" +
                "year = \"" + getPublicationYear() + "\"\n}\n";
    }
}

