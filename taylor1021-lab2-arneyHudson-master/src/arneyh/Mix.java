/*
 * Course: CS 1021 021
 * Winter 2021-2022
 * Lab 2
 * Name: Hudson Arney
 * Created: 12/6/2021
 * Updated: 12/13/2021
 */

package arneyh;

import java.util.ArrayList;
import java.util.List;

/**
 * Mix Class that uses methods from the Ingredient interface
 * Includes an ArrayList of ingredients
 */
public class Mix implements Ingredient {
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final String name;

    /**
     * Mix constructor that takes in the name of the item
     * @param name name of the given item
     */
    public Mix(String name) {
        this.name = name;
    }

    /**
     * add Ingredient method will add to the ArrayList ingredients a certain item at a time
     * @param ingredient of type Ingredient that makes up the given item
     */
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * Goes through the ingredients ArrayList searching one Item at a time.
     * @return a boolean based on if the given ingredient is dry or not.
     */
    public boolean hasDryIngredient() {
        boolean dry = false;
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isDry()) {
                dry = true;
            }
        }
        return dry;
    }

    /**
     * Uses the hasDryIngredient method and tests if the ingredient is not
     * dry, it must be wet.
     * @return a boolean based on if the given ingredient is wet or not.
     */
    public boolean hasWetIngredient() {
        boolean dry = false;
        for (Ingredient ingredient : ingredients) {
            if (!ingredient.isDry()) {
                dry = true;
            }
        }
        return dry;
    }

    @Override
    public double getCalories() {
        double cal = 0;
        for (Ingredient ingredient : ingredients) {
            cal += ingredient.getCalories();
        }
        return cal;
    }

    @Override
    public double getCups() {
        double cups = 0;
        for (Ingredient ingredient : ingredients) {
            cups += ingredient.getCups();
        }
        return cups;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDry() {
        for (Ingredient ingredient : ingredients) {
            if (!ingredient.isDry()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printRecipe() {
        System.out.println("====================================================");
        System.out.println(name);
        System.out.println("====================================================");
        System.out.println("Dry Ingredients:");
        for (Ingredient value : ingredients) {
            if (hasDryIngredient() && value.isDry()) {
                System.out.println("  " + value.getName());
            }
        }

        System.out.println("\nWet Ingredients:");
        for (Ingredient ingredient : ingredients) {
            if (hasWetIngredient() && !ingredient.isDry()) {
                System.out.println("  " + ingredient.getName());
            }
        }

        if(getCups() == (int)getCups()) {
            System.out.println("\nCups: " + CUP_FORMAT.format((int)getCups()) + " Cups");
        } else {
            System.out.println("\nCups: " + CUP_FORMAT.format(getCups()) + " Cups");
        }
        System.out.println("Energy: " + Math.round(getCalories()) + " Calories\n");

        for (Ingredient ingredient : ingredients) {
            ingredient.printRecipe();
        }
    }
}

