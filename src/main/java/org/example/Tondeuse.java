package org.example;

public class Tondeuse {
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
