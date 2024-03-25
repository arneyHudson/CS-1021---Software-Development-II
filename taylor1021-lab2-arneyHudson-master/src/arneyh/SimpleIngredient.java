/*
 * Course: CS 1021 021
 * Winter 2021-2022
 * Lab 2
 * Name: Hudson Arney
 * Created: 12/6/2021
 * Updated: 12/13/2021
 */

package arneyh;

/**
 * SimpleIngredient Class uses the methods from the Ingredient interface
 * and implements values to those references
 * This is the default class for all ingredients
 */
public class SimpleIngredient implements Ingredient {
    private final double calories;
    private final double cups;
    private final boolean isDry;
    private final String name;

    /**
     * The Simple Ingredient constructor that takes in calories, cups, isDry, and name
     * @param calories the number of calories in a given item
     * @param cups the number of cups used in a given item
     * @param isDry a boolean if an item is dry or not
     * @param name the name of given item
     */
    public SimpleIngredient(double calories, double cups, boolean isDry, String name) {
        this.calories = calories;
        this.cups = cups;
        this.isDry = isDry;
        this.name = name;
    }
    public double getCalories() {
        return calories;
    }
    public double getCups() {
        return cups;
    }
    public String getName() {
        return name;
    }
    public boolean isDry() {
        return isDry;
    }

    /**
     * The print Recipe method follows the given output for the lab
     */
    public void printRecipe() {
        System.out.println("====================================================");
        System.out.println(name);
        System.out.println("====================================================");
        if(cups == (int)cups) {
            System.out.println("Cups: " + CUP_FORMAT.format((int)cups) + " Cups");
        } else {
            System.out.println("Cups: " + CUP_FORMAT.format(cups) + " Cups");
        }
        System.out.println("Energy: " + (int)calories + " Calories\n");
    }

}
