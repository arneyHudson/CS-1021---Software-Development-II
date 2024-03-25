/*
 * Course: CS 1021 021
 * Winter 2021-2022
 * Lab 1
 * Name: Hudson Arney
 * Created: 11/29/2021
 * Updated: 12/6/2021
 */
package arneyh;

import java.util.Scanner;
import java.util.ArrayList;
import us.msoe.csse.taylor.audio.WavFile;

/**
 * WavGenerator Class
 * Allows you to type in multiple options to work with .wav files
 * Option 1 allows you to create a new file that reverses the sound of the file selected
 * Option 2 allows you to create a new file which play a certain frequency that the user selects
 * for 1 second
 */
public class WavGenerator {
    public static void main(String[] args) {
        System.out.println("Welcome to Hudson's WavGenerator!");
        String num;
        boolean tryAgain = true;

        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter a number");
            num = in.nextLine();

            if(num.equals("0")) {
                System.out.println("The program will now end!");
                tryAgain = false;
            } else if (num.equals("1")) {
                option1(in);
            } else if (num.equals("2")) {
                option2(in);
            } else {
                System.out.println("Number entered is not 0, 1, or 2");
            }
        } while(tryAgain);
    }

    private static void option1(Scanner in) {
        System.out.println("Please enter a file name");
        String fileOption = in.next();
        String originalOption = "sounds/" + fileOption + ".wav";

        WavFile sound = new WavFile(originalOption);

        ArrayList<Double> original = new ArrayList<>(sound.getSamples());
        ArrayList<Double> reverse = new ArrayList<>();

        for(int i = original.size() - 1; i >= 0; i--) {
            reverse.add(original.get(i));
        }

        String reverseOption = "sounds/" + fileOption + "Rev.wav";
        WavFile reversed = new WavFile(reverseOption, sound.getNumChannels(),
                sound.getNumFrames(), sound.getValidBits(), sound.getSampleRate());

        reversed.setSamples(reverse);
        reversed.close();
        System.out.println("Option 1 has been complete. You now have a reversed file!");
    }

    private static void option2(Scanner in) {
        System.out.println("Please enter a file name");
        String fileOption = "sounds/" + in.next() + ".wav";
        System.out.println("Now please enter a frequency");
        double frequency = in.nextDouble();
        ArrayList<Double> original = new ArrayList<>();

        final int numChannels = 1;
        final int numFrames = 8000;
        final int validBits = 8;
        final int sampleRates = 8000;

        WavFile sample = new WavFile(fileOption, numChannels, numFrames, validBits, sampleRates);
        double sampleRate = sample.getSampleRate();
        for(int i = 0; i < sampleRate - 1; i++) {
            original.add(Math.sin(2 * Math.PI * i * (frequency/sampleRate)));
        }
        System.out.println("Option 2 is now complete. You now have a specific frequency!");

        sample.setSamples(original);
        sample.close();
    }
}
