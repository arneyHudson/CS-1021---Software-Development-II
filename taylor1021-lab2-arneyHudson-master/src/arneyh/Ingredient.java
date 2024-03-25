/*
 * Course: CS 1021 021
 * Winter 2021-2022
 * Lab 2
 * Name: Hudson Arney
 * Created: 12/6/2021
 * Updated: 12/13/2021
 */

package arneyh;

import java.text.DecimalFormat;

public interface Ingredient {

    public static final DecimalFormat CUP_FORMAT = new DecimalFormat("#.##");

    public double getCalories();
    public double getCups();
    public String getName();
    public boolean isDry();
    public void printRecipe();

}