/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 7 - Shaped Revisited
 * Name: Hudson Arney
 * Created: 1/23/2022
 * Updated: 1/30/2022
 */

package arneyh;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * LabeledTriangle class is a specific type of Triangle that has
 * additional characteristics (a name)
 */
public class LabeledTriangle extends Triangle {
    private final String name;

    /**
     * Labeled Triangle constructor that takes in the Triangle
     * characteristics but adds a name
     * @param x default point on the x-axis
     * @param y default point on the y-axis
     * @param base the labeled triangles bottom line
     * @param height the labeled triangle's length from the top to bottom
     * @param color gives the labeled triangle a color characteristic
     * @param name gives a name characteristic to the labeled rectangle
     */
    public LabeledTriangle(double x, double y, double base,
                           double height, Color color, String name) {
        super(x, y, base, height, color);
        this.name = name;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        super.draw(plotter);
        plotter.printAt(x, y, name);
    }
}
