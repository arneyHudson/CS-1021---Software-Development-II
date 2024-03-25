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
 * Driver class for all reference types
 */
public class Lab3 {
    public static void main(String[] args) {
        PrintStream out = new PrintStream(System.out);
        boolean continuation = true;
        ReferenceHolder list = new ReferenceHolder();

        do {
            Scanner in = new Scanner(System.in);
            System.out.println("""
                    Enter 0 to exit the program.
                    Enter 1 to enter a new book into the reference set.
                    Enter 2 to enter a new article into the reference set.
                    Enter 3 to update a reference.
                    Enter 4 to printout the entries in Bibtex format.
                    Enter 5 to remove a reference.""");
            String choice = in.nextLine();

            switch (choice) {
                case "0" -> {
                    System.out.println("Goodbye");
                    continuation = false;
                }
                case "1" -> {
                    Book book = new Book();
                    book.promptToInitialize(out, in);
                    list.addReference(book);
                }
                case "2" -> {
                    Article article = new Article();
                    article.promptToInitialize(out, in);
                    list.addReference(article);
                }
                case "3" -> {
                    System.out.println("Enter the ID of the reference you want to update");
                    list.updateReference(in.nextLine(), out, in);
                }
                case "4" -> System.out.println(list);
                case "5" -> {
                    System.out.println("Enter the ID of the reference you want to remove.");
                    list.removeReference(in.nextLine());
                }
                default -> System.out.println("The option entered does not follow the prompt.\n" +
                        "Please try again.");
            }
        } while(continuation);
    }
}

