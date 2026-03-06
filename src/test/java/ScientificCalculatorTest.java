import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ScientificCalculatorTest {

    @Test
    public void testSquareRoot() {
        assertEquals(4.0, ScientificCalculator.squareRoot(16.0), 0.001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, ScientificCalculator.factorial(5));
    }

    @Test
    public void testPower() {
        assertEquals(8.0, ScientificCalculator.power(2.0, 3.0), 0.001);
    }
}