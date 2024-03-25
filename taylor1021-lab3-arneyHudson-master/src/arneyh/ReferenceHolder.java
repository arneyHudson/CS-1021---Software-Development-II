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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reference Holder Class uses an Arraylist of references and holds values
 * in certain sections of the arraylist to later be printed in Bibtex format
 */
public class ReferenceHolder {
    private final List<Reference> references;

    /**
     * Reference Holder Constructor instantiates the Arraylist
     */
    public ReferenceHolder() {
        references = new ArrayList<>();
    }

    /**
     * Adds a book to the references arraylist
     * @param book book type that will be added to the arraylist
     */
    public void addReference(Book book) {
        references.add(book);
    }

    /**
     * Adds an article to the references arraylist
     * @param article article type that will be added to the arraylist
     */
    public void addReference(Article article) {
        references.add(article);
    }

    /**
     * To String method that will print out all references in bibtex format
     * @return All the references in the arraylist
     */
    public String toString() {
        StringBuilder bibtex = new StringBuilder();
        for (Reference reference : references) {
            bibtex.append(reference);
        }
        return bibtex.toString();
    }

    /**
     * Remove reference method that will remove a given reference from the references arraylist
     * @param uniqueID the specific number
     * @return a boolean if the given item can be removed
     */
    public boolean removeReference(String uniqueID) {
        boolean removed = false;
        for(int i = references.size() - 1; i >= 0; i--) {
            if (references.get(i).getMyUniqueID().equals(uniqueID)) {
                references.remove(i);
                removed = true;
            }
        }
        return removed;
    }

    /**
     * updateReference method that although for a method to be changed
     * @param uniqueID given for all references that will be different for all
     * @param out allows you to print out
     * @param in the scanner that allows the prompt to be typed
     * @return a boolean if the reference can be updated
     */
    public boolean updateReference(String uniqueID, PrintStream out, Scanner in) {
        boolean update = false;
        for (Reference reference : references) {
            if (reference.getMyUniqueID().equals(uniqueID)) {
                reference.promptForUpdate(out, in);
                update = true;
            }
        }
        return update;
    }

}

