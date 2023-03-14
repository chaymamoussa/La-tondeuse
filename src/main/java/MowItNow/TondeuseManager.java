package MowItNow;

import java.util.ArrayList;
import java.util.List;

public class TondeuseManager {
    private final Gazon gazon;
    private final List<Tondeuse> tondeuses = new ArrayList<>();

    public TondeuseManager(Gazon gazon) {
        this.gazon = gazon;
    }

    public void addTondeuse(int x, int y, Orientation orientation) {
        if (gazon.isInside(x, y)) {
            Tondeuse tondeuse = new Tondeuse(x, y, orientation, gazon);
            tondeuses.add(tondeuse);
        }
    }

    public void moveAllTondeuses(String instructions) {
        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);
            for (Tondeuse tondeuse : tondeuses) {
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
                    default:
                        throw new IllegalArgumentException("Invalid instruction: " + instruction);
                }
            }
        }
    }

    public List<Tondeuse> getTondeuses() {
        return tondeuses;
    }
}
