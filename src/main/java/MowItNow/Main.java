package MowItNow;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        // Read input file
        Scanner scanner = null;
        try {
            //put the pathname of your input file
            scanner = new Scanner(new File("C:\\Users\\shaym\\OneDrive\\Bureau\\input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Read lawn dimensions
        int lawnWidth = scanner.nextInt();
        int lawnHeight = scanner.nextInt();
        Gazon gazon = new Gazon(lawnWidth, lawnHeight);

        // Read mowers
        ArrayList<Tondeuse> tondeuses = new ArrayList<>();
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Orientation orientation = Orientation.valueOf(scanner.next());
            Tondeuse tondeuse = new Tondeuse(x, y, orientation, gazon);
            tondeuses.add(tondeuse);
            String instructions = scanner.next();
            for (int i = 0; i < instructions.length(); i++) {
                char instruction = instructions.charAt(i);
                switch (instruction) {
                    case 'G':
                        tondeuse.turnLeft();
                        break;
                    case 'D':
                        tondeuse.turnRight();
                        break;
                    case 'A':
                        tondeuse.moveForward();
                        break;
                }
            }
        }

        // Print mowers final positions
        for (Tondeuse tondeuse : tondeuses) {
            System.out.println(tondeuse.getX() + " " + tondeuse.getY() + " " + tondeuse.getOrientation());
        }

        scanner.close();
    }

}
