import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MowItNow {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage: java MowItNow input_file");
            System.exit(1);
        }

        String inputFilePath = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String[] lawnDimensions = reader.readLine().split(" ");
            int lawnWidth = Integer.parseInt(lawnDimensions[0]);
            int lawnHeight = Integer.parseInt(lawnDimensions[1]);
            Gazon lawn = new Gazon(lawnWidth, lawnHeight);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] mowerInit = line.split(" ");
                int mowerX = Integer.parseInt(mowerInit[0]);
                int mowerY = Integer.parseInt(mowerInit[1]);
                char mowerOrientation = mowerInit[2].charAt(0);
                Tondeuse mower = new Tondeuse(mowerX, mowerY, mowerOrientation);

                String instructions = reader.readLine();
                for (int i = 0; i < instructions.length(); i++) {
                    char instruction = instructions.charAt(i);
                    if (instruction == 'G') {
                        mower.turnLeft();
                    } else if (instruction == 'D') {
                        mower.turnRight();
                    } else if (instruction == 'A') {
                        if (lawn.isInside(mower.getX(), mower.getY(), mower.getOrientation())) {
                            mower.moveForward();
                        }
                    }
                }

                System.out.println(mower.getX() + " " + mower.getY() + " " + mower.getOrientation());
            }
        }
    }

    static class Gazon {
        private final int width;
        private final int height;

        public Gazon(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public boolean isInside(int x, int y, char orientation) {
            switch (orientation) {
                case 'N':
                    return y + 1 <= height;
                case 'E':
                    return x + 1 <= width;
                case 'S':
                    return y - 1 >= 0;
                case 'W':
                    return x - 1 >= 0;
                default:
                    return false;
            }
        }
    }

    static class Tondeuse {
        private int x;
        private int y;
        private char orientation;

        public Tondeuse(int x, int y, char orientation) {
            this.x = x;
            this.y = y;
            this.orientation = orientation;
        }

        public void turnLeft() {
            switch (orientation) {
                case 'N':
                    orientation = 'W';
                    break;
                case 'E':
                    orientation = 'N';
                    break;
                case 'S':
                    orientation = 'E';
                    break;
                case 'W':
                    orientation = 'S';
                    break;
            }
        }

        public void turnRight() {
            switch (orientation) {
                case 'N':
                    orientation = 'E';
                    break;
                case 'E':
                    orientation = 'S';
                    break;
                case 'S':
                    orientation = 'W';
                    break;
                case 'W':
                    orientation = 'N';
                    break;
            }
        }

        public void moveForward() {
            switch (orientation) {
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
            }
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public char getOrientation() {
            return orientation;
        }

    }
    }
