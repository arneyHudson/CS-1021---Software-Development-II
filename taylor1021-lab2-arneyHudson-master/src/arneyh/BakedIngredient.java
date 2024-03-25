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
 * Baked Ingredient class that uses methods from the Ingredient interface
 * Takes a base ingredient that will be "baked" and runs the given methods
 * on this ingredient.
 */
public class BakedIngredient implements Ingredient {
    private final Ingredient baseIngredient;
    private final double expansionFactor;

    /**
     * Baked Ingredient Constructor that takes in a baseIngredient and a user-provided
     * expansion factor.
     * @param ingredient of type Ingredient. Is the single item focused on in the bake
     * @param expansionFactor a number that will expand the volume of the given item while baking
     */
    public BakedIngredient(Ingredient ingredient, double expansionFactor) {
        this.baseIngredient = ingredient;
        this.expansionFactor = expansionFactor;
    }

    @Override
    public double getCalories() {
        return baseIngredient.getCalories();
    }

    @Override
    public double getCups() {
        return baseIngredient.getCups() * expansionFactor;
    }

    @Override
    public String getName() {
        return "Baked " + baseIngredient.getName();
    }

    @Override
    public boolean isDry() {
        return true;
    }

    @Override
    public void printRecipe() {
        System.out.println("====================================================");
        System.out.println("Baked " + baseIngredient.getName());
        System.out.println("====================================================");
        System.out.println("Ingredient to be baked: " + baseIngredient.getName());
        System.out.println("Cups: " + CUP_FORMAT.format(baseIngredient.getCups() * expansionFactor)
                + " Cups");
        System.out.println("Energy: " + (int) baseIngredient.getCalories() + " Calories\n");

        baseIngredient.printRecipe();
    }
}