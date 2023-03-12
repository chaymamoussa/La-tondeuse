package org.example;

public class Gazon {
    private final int width;
    private final int height;

    public Gazon(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
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
