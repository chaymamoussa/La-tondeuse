package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage: java MowItNow input_file");
            System.exit(1);
        }

        String inputFilePath = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String[] gazonDimensions = reader.readLine().split(" ");
            int gazonWidth = Integer.parseInt(gazonDimensions[0]);
            int gazonHeight = Integer.parseInt(gazonDimensions[1]);
            Gazon gazon = new Gazon(gazonWidth, gazonHeight);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tondeuseInit = line.split(" ");
                int tondeuseX = Integer.parseInt(tondeuseInit[0]);
                int tondeuseY = Integer.parseInt(tondeuseInit[1]);
                char tondeuseOrientation = tondeuseInit[2].charAt(0);
                Tondeuse tondeuse = new Tondeuse(tondeuseX, tondeuseY, tondeuseOrientation);

                String instructions = reader.readLine();
                for (int i = 0; i < instructions.length(); i++) {
                    char instruction = instructions.charAt(i);
                    if (instruction == 'G') {
                        tondeuse.turnLeft();
                    } else if (instruction == 'D') {
                        tondeuse.turnRight();
                    } else if (instruction == 'A') {
                        if (gazon.isInside(tondeuse.getX(), tondeuse.getY(), tondeuse.getOrientation())) {
                            tondeuse.moveForward();
                        }
                    }
                }

                System.out.println(tondeuse.getX() + " " + tondeuse.getY() + " " + tondeuse.getOrientation());
            }
        }
    }
}