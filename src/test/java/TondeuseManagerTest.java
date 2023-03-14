import MowItNow.Gazon;
import MowItNow.Orientation;
import MowItNow.Tondeuse;
import MowItNow.TondeuseManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TondeuseManagerTest {

    private TondeuseManager manager;

    @BeforeEach
    public void setup() {
        Gazon gazon = new Gazon(5, 5);
        manager = new TondeuseManager(gazon);
    }

    @Test
    public void testAddTondeuse() {
        manager.addTondeuse(1, 2, Orientation.N);
        Assertions.assertEquals(1, manager.getTondeuses().size());

        Tondeuse tondeuse = manager.getTondeuses().get(0);
        Assertions.assertEquals(1, tondeuse.getX());
        Assertions.assertEquals(2, tondeuse.getY());
        Assertions.assertEquals(Orientation.N, tondeuse.getOrientation());
    }

    @Test
    public void testAddTondeuseOutsideGazon() {
        manager.addTondeuse(6, 6, Orientation.N);
        Assertions.assertEquals(0, manager.getTondeuses().size());
    }


    @Test
    public void testInvalidInstruction() {
        manager.addTondeuse(1, 2, Orientation.N);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            manager.moveAllTondeuses("GDAF");
        });
    }
}