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
 * Reference class that holds values that all reference types need to have
 */
public abstract class Reference {
    private static int instanceCount = 0;
    protected String author;
    protected final String myUniqueID;
    protected int publicationYear;
    protected String title;

    /**
     * Reference constructor that give the uniqueID of a reference the
     * string "REF" + a number
     * This number will be added based on how many references there are
     */
    public Reference() {
        myUniqueID = "REF" + instanceCount;
        instanceCount++;
    }

    /**
     * promptToInitialize method is abstract
     * @param out the output of all the information
     * @param in Scanner that will add text to the output
     */
    public abstract void promptToInitialize(PrintStream out, Scanner in);

    /**
     * prompt for update method which is the default for all classes
     * @param out the output of all the information
     * @param in Scanner that will add text to the output
     */
    public void promptForUpdate(PrintStream out, Scanner in) {
        out.print("Enter the title of the work.");
        title = in.nextLine();
        out.print("Enter the name of the author.");
        author = in.nextLine();
        out.print("Enter the year of publication.");
        publicationYear = Integer.parseInt(in.nextLine());
    }

    public String getAuthor() {
        return author;
    }

    public String getMyUniqueID() {
        return myUniqueID;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }
}
