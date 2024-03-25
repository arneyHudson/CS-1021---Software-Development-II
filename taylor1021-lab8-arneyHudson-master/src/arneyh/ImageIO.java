/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 9 - Final Project Part 2
 * Name: Hudson Arney
 * Created: 2/7/2022
 * Updated: 2/14/2022
 */

package arneyh;

import edu.msoe.cs1021.ImageUtil;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ImageIO Class that will read and write certain images based on their file type
 */
public class ImageIO {

    private static String extension;

    /**
     * Read method that will read an image file ending in .png or .jpg
     *
     * @param path path file to read
     * @return An image to be posted to the displayImage (View)
     * @throws IllegalArgumentException if file has illegal arguments
     * @throws IOException if file has an IOException it can get caught in the Lab8Controller
     */
    public static Image read(Path path) throws IllegalArgumentException, IOException {
        Image newImage = null;

        File image = new File(String.valueOf(path));
        int i = image.getName().lastIndexOf('.');
        extension = image.getName().substring(i + 1);

        switch (extension) {
            case "png", "jpg" -> newImage = ImageUtil.readImage(path);
            case "msoe" -> newImage = readMSOE(path);
            case "bmsoe" -> newImage = readBMSOE(path);
        }
        return newImage;
    }

    /**
     * Write method that will write for an image file ending in .png or .jpg
     *
     * @param path  path file to write
     * @param image new Image to write
     * @throws IOException if file has an IOException it can get caught in the Lab8Controller
     */
    public static void write(Image image, Path path) throws IllegalArgumentException, IOException {

        switch (extension) {
            case "jpg", "pdf" -> ImageUtil.writeImage(path, image);
            case "msoe" -> writeMSOE(image, path);
            case "bmsoe" -> writeBMSOE(image, path);
        }

    }

    /**
     * Read method that will read an image file ending in .msoe
     * @param path path .msoe file to read
     * @return Image
     * @throws IOException if file has an IOException it can get caught in the Lab8Controller
     */
    private static Image readMSOE(Path path) throws IOException {
        Scanner scan = new Scanner(path);
        scan.nextLine();
        int width = Integer.parseInt(scan.next());
        int height = Integer.parseInt(scan.next());
        WritableImage writeImage = new WritableImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = stringToColor(scan.next());
                writeImage.getPixelWriter().setColor(j, i, c);
            }
        }
        return writeImage;

    }

    /**
     * Write method that will write for an image file ending in .msoe
     * @param path path .msoe write file to run
     * @throws IOException file has an IOException it can get caught in the Lab8Controller
     */
    private static void writeMSOE(Image image, Path path) throws IOException {
        File file = new File(String.valueOf(path));
        PrintWriter out = new PrintWriter(file);
        out.println("MSOE");
        out.println((int) image.getWidth() + " " + (int) image.getHeight());

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                String hex = "" +
                        colorToString(image.getPixelReader().getColor(i, j));
                out.print("" + hex + " ");
            }
            out.println();
        }
        out.close();
    }

    /**
     * Read method that will read an image file ending in .bmsoe
     * @param path path .bmsoe file to read
     * @return Image
     * @throws IOException if file has an IOException it can get caught in the Lab8Controller
     */
    private static Image readBMSOE(Path path) throws IOException {
        final int bmsoeLength = 5;
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                (Files.newInputStream(path))));
        for (int i = 0; i < bmsoeLength; i++) {
            in.readByte();
        }
        int width = in.readInt();
        int height = in.readInt();
        WritableImage writeImage = new WritableImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                writeImage.getPixelWriter().setColor(j, i, intToColor(in.readInt()));
            }
        }
        return writeImage;
    }

    /**
     * Write method that will write for an image file ending in .bmsoe
     * @param path path .bmsoe write file to run
     * @throws IOException file has an IOException it can get caught in the Lab8Controller
     */
    private static void writeBMSOE(Image image, Path path) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(path)));
        out.writeBytes("BSMOE");
        out.writeInt((int) image.getWidth());
        out.writeInt((int) image.getHeight());
        for (int j = 0; j < image.getHeight(); j++) {
            for (int i = 0; i < image.getWidth(); i++) {
                int colorToInt = colorToInt(image.getPixelReader().getColor(i, j));
                out.writeInt(colorToInt);
            }
        }
    }


    private static Color stringToColor(String hexTriple) throws InputMismatchException {
        final int index1 = 1;
        final int index3 = 3;
        final int index5 = 5;
        final int index7 = 7;
        final int base16 = 16;
        final int correctLength = 7;

        if (hexTriple.indexOf('#') != 0 || hexTriple.length() != correctLength) {
            throw new InputMismatchException("Invalid Color Format Inputted.");
        }

        for (int i = 1; i < hexTriple.length(); i++) {
            if (Character.digit(hexTriple.charAt(i), base16) == -1) {
                throw new InputMismatchException("Invalid Hex Number Entered.");
            }
        }

        int r = Integer.valueOf(hexTriple.substring(index1, index3), base16);
        int g = Integer.valueOf(hexTriple.substring(index3, index5), base16);
        int b = Integer.valueOf(hexTriple.substring(index5, index7), base16);

        return Color.rgb(r, g, b);
    }

    /**
     * Goes from a color to a string that describes that color
     *
     * @param color the color from the pixel
     * @return a string of a color from a pixel
     */
    private static String colorToString(Color color) {
        final int eightIndex = 8;
        return "#" + color.toString().substring(2, eightIndex).toUpperCase();
    }

    private static Color intToColor(int color) {
        double red = ((color >> 16) & 0x000000FF) / 255.0;
        double green = ((color >> 8) & 0x000000FF) / 255.0;
        double blue = (color & 0x000000FF) / 255.0;
        double alpha = ((color >> 24) & 0x000000FF) / 255.0;
        return new Color(red, green, blue, alpha);
    }

    private static int colorToInt(Color color) {
        int red = ((int) (color.getRed() * 255)) & 0x000000FF;
        int green = ((int) (color.getGreen() * 255)) & 0x000000FF;
        int blue = ((int) (color.getBlue() * 255)) & 0x000000FF;
        int alpha = ((int) (color.getOpacity() * 255)) & 0x000000FF;
        return (alpha << 24) + (red << 16) + (green << 8) + blue;
    }
}

