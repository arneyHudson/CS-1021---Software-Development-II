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
 * Article class is a specific type of reference that also holds its own characteristics
 * from other references
 */
public class Article extends Reference {
    private int endingPage;
    private int startingPage;
    private String journal;

    /**
     * Prints out a prompt for when a new article is created.
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
        out.print("Enter the title of the journal\n");
        journal = in.nextLine();

        out.print("Enter the first page number of the article\n");
        while(!setStartingPage(Integer.parseInt(in.nextLine()))) {
            System.out.println("Enter a valid starting page.");
        }

        out.print("Enter the last page number of the article\n");
        while(!setEndingPage(Integer.parseInt(in.nextLine()))) {
            System.out.println("Enter a valid starting page.");
        }

    }

    /**
     * Prints out a prompt that asks certain characteristics when updating an article
     * @param out prints out the output for an updated prompt
     * @param in Scanner object that allows the user to input
     */
    public void promptForUpdate(PrintStream out, Scanner in) {
        out.print("Enter the ID of the reference you want to update\n");
        in.nextLine();
        out.print("Enter the updated author of the reference\n");
        author = in.nextLine();
        out.print("Enter the updated title of the reference\n");
        title = in.nextLine();
        out.print("Enter the updated copyright year for the reference.\n");
        publicationYear = Integer.parseInt(in.nextLine());
        out.print("Enter the updated title of the journal\n");
        journal = in.nextLine();

        out.print("Enter the updated first page number of the article\n");
        while(!setStartingPage(Integer.parseInt(in.nextLine()))) {
            System.out.println("Enter a valid starting page.");
        }

        out.print("Enter the updated last page number of the article\n");
        while(!setEndingPage(Integer.parseInt(in.nextLine()))) {
            System.out.println("Enter a valid starting page.");
        }
    }

    public int getEndingPage() {
        return endingPage;
    }

    public int getStartingPage() {
        return startingPage;
    }

    public String getJournal() {
        return journal;
    }

    @Override
    public String toString() {
        return "@ARTICLE { " + super.getMyUniqueID() + ",\n" +
                "author = \"" + getAuthor() + "\",\n" +
                "title = \"" + getTitle() + "\",\n" +
                "journal = \"" + getJournal() + "\",\n" +
                "pages = \"" + getStartingPage() + "-" + getEndingPage() + "\",\n" +
                "year = \"" + getPublicationYear() + "\"\n" +
                "}\n";
    }

    private boolean setStartingPage(int startingPage) {
        this.startingPage = startingPage;
        return true;
    }

    private boolean setEndingPage(int endingPage) {
        this.endingPage = endingPage;
        return true;
    }
}

