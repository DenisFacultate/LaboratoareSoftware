import lab5.advanced.NewIntCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NewIntCalculatorTest {

    private NewIntCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new NewIntCalculator(0);
    }

    @AfterEach
    public void tearDown() {
        calc = null;
    }

    @Test
    public void testAddPositive() {
        calc.add(5);
        Assertions.assertEquals(5, calc.result(), "0 + 5 ar trebui sa fie 5");
    }

    @Test
    public void testAddNegatives() {
        calc.add(-3);
        Assertions.assertEquals(-3, calc.result());
    }

    @Test
    public void testSubtractPositives() {
        calc.add(10).substract(4);
        Assertions.assertEquals(6, calc.result());
    }

    @Test
    public void testSubtractNegatives() {
        calc.add(5).substract(-2);
        Assertions.assertEquals(7, calc.result());
    }

    @Test
    public void testMultiplyPositives() {
        calc.add(5).multiply(3);
        Assertions.assertEquals(15, calc.result());
    }

    @Test
    public void testMultiplyNegatives() {
        calc.add(5).multiply(-2);
        Assertions.assertEquals(-10, calc.result());
    }

    @Test
    public void testMultiplyBy0() {
        calc.add(100).multiply(0);
        Assertions.assertEquals(0, calc.result());
    }

    @Test
    public void testDivideBy0() {
        calc = new NewIntCalculator(10);
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            calc.divide(0);
        });

        Assertions.assertNotNull(exception);
    }
}