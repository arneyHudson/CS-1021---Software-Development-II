/*
 * Course: CS 1021 021
 * Winter 2021-2022
 * Lab 2
 * Name: Hudson Arney
 * Created: 12/6/2021
 * Updated: 12/13/2021
 */

package arneyh; // replace with your username.

/**
 * Driver class that illustrates making evaporated milk by baking milk.
 */
public class EvaporatedMilk {
    /** The milk to be baked */
    private static final Ingredient MILK =
            new SimpleIngredient(103.0, 1.0, false, "Milk");

    /** Ratio of volume after evaporating to before */
    public static final double DEHYDRATION_FACTOR = 0.2;

    public static void main(String[] args) {
        Ingredient milk = MILK;
        Ingredient evaporatedMilk = new BakedIngredient(milk, DEHYDRATION_FACTOR);
        evaporatedMilk.printRecipe();
    }
}
