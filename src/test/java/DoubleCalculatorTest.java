import lab5.advanced.DoubleCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DoubleCalculatorTest {

    private DoubleCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new DoubleCalculator(0.0);
    }

    @AfterEach
    public void tearDown() {
        calc = null;
    }

    @Test
    public void testAddPositive() {
        calc.add(5.5);
        Assertions.assertEquals(5.5, (Double) calc.result(), 0.0001);
    }

    @Test
    public void testAddNegatives() {
        calc.add(-3.2);
        Assertions.assertEquals(-3.2, (Double) calc.result(), 0.0001);
    }

    @Test
    public void testMultiplyPositives() {
        calc.add(2.0).multiply(3.5);
        Assertions.assertEquals(7.0, (Double) calc.result(), 0.0001);
    }

    @Test
    public void testDivideBy0() {
        calc = new DoubleCalculator(10.0);
        calc.divide(0.0);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, (Double) calc.result());
    }
}