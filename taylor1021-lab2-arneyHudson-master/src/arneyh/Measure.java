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
 * Measure class that uses methods from the Ingredient interface
 *
 */
public class Measure implements Ingredient {
    private final Ingredient baseIngredient;
    private final int numerator;
    private final int denominator;

    /**
     * Measure constructor if not given a denominator.
     * The denominator defaults to one and calls the default constructor
     * @param numerator an int that determines the cups of ingredient
     * @param ingredient keeps track of a certain ingredient
     */
    public Measure(int numerator, Ingredient ingredient) {
        this(numerator, 1, ingredient);
    }

    /**
     * Default constructor
     * Takes a numerator, denominator, and ingredient which allows
     * the program to have fractions of certain ingredients
     * @param numerator numerator of fraction amount in a certain ingredient
     * @param denominator denominator of fraction in a certain ingredient
     * @param ingredient keeps track of a certain ingredient
     */
    public Measure(int numerator, int denominator, Ingredient ingredient) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.baseIngredient = ingredient;
    }

    @Override
    public double getCalories() {
        return ((double)numerator/denominator) *
                (baseIngredient.getCalories() / baseIngredient.getCups());
    }

    @Override
    public double getCups() {
        if(denominator == 1) {
            return numerator;
        } else {
            return ((double) numerator / denominator);
        }
    }

    @Override
    public String getName() {
        if((double)numerator/denominator == 1) {
            return numerator + " Cup " + baseIngredient.getName();
        } else if(numerator > 1 && denominator == 1) {
            return numerator + " Cups " + baseIngredient.getName();
        } else if(numerator == 1 && denominator > 1) {
            return numerator + "/" + denominator + " Cup " + baseIngredient.getName();
        } else {
            return numerator + "/" + denominator + " Cups " + baseIngredient.getName();
        }
    }

    @Override
    public boolean isDry() {
        return baseIngredient.isDry();
    }

    @Override
    public void printRecipe() {
        System.out.println("====================================================");
        System.out.println(getName());
        System.out.println("====================================================");
        System.out.println("Measured ingredient: " + baseIngredient.getName());
        System.out.println(formatQuantity());
        System.out.println("Energy: " + Math.round(getCalories()) + " Calories\n");
        baseIngredient.printRecipe();
    }

    /**
     * Changes the output of the final output depending on the amount of
     * certain ingredients measured
     * @return The final string needed for the Measure output
     */
    private String formatQuantity() {
        double fractionOfIngredients = (double)numerator / denominator;
        String cupsOfMeasuredIngredient = "";
        if(fractionOfIngredients == 1) {
            cupsOfMeasuredIngredient += "Quantity: "+ (int)fractionOfIngredients
                    + " Cup (" + (int)fractionOfIngredients + " Cup)";
        } else if(numerator > 1 && denominator == 1) {
            cupsOfMeasuredIngredient += "Quantity: " + numerator
                    + " Cups (" + numerator + " Cups)";
        } else if(numerator == 1 && denominator > 1) {
            cupsOfMeasuredIngredient += "Quantity: " + numerator + "/" + denominator + " Cup (" +
                    CUP_FORMAT.format(fractionOfIngredients) + " Cups)";
        } else {
            cupsOfMeasuredIngredient += "Quantity: " + numerator + "/" + denominator + " Cups (" +
                    CUP_FORMAT.format(fractionOfIngredients) + " Cups)";
        }
        return cupsOfMeasuredIngredient;
    }
}

