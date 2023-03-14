package MowItNow;


public class Tondeuse {


    private int x;
    private int y;
    private Orientation orientation;
    private Gazon gazon;

    public Tondeuse(int x, int y, Orientation orientation, Gazon gazon) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.gazon = gazon;
    }
    public void turnLeft() {
        switch (orientation) {
            case N:
                orientation = Orientation.W;
                break;
            case E:
                orientation = Orientation.N;
                break;
            case S:
                orientation = Orientation.E;
                break;
            case W:
                orientation = Orientation.S;
                break;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case N:
                orientation = Orientation.E;
                break;
            case E:
                orientation = Orientation.S;
                break;
            case S:
                orientation = Orientation.W;
                break;
            case W:
                orientation = Orientation.N;
                break;
        }
    }

    public void moveForward() {
        switch (orientation) {
            case N:
                if (gazon.isInside(x, y + 1)) {
                    y++;
                }
                break;
            case E:
                if (gazon.isInside(x + 1, y)) {
                    x++;
                }
                break;
            case S:
                if (gazon.isInside(x, y - 1)) {
                    y--;
                }
                break;
            case W:
                if (gazon.isInside(x - 1, y)) {
                    x--;
                }
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
