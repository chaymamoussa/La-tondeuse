package MowItNow;

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

    public boolean isInside(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }
}
