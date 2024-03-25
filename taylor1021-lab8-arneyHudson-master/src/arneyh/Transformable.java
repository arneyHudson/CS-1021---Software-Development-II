/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 9 - Final Project Part 2
 * Name: Hudson Arney
 * Created: 2/7/2022
 * Updated: 2/14/2022
 */

package arneyh;

import javafx.scene.paint.Color;

@FunctionalInterface
interface Transformable {
    Color apply(int y, Color color);
}