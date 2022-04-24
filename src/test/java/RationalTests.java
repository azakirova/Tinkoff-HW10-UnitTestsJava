import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RationalTests {
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test
    public void testAlternativeConstructor() {
        Rational rational = new Rational(1, 2);
        assertEquals("Nominator is not 1", rational.getNumerator(), 1);
        assertEquals("Denominator is not 2", rational.getDenominator(), 2);
    }

    @Test
    public void testAlternativeConstructorException() {
        try {
            Rational rational = new Rational(1, 0);
            fail("Exception wasn't raise");
        } catch (ArithmeticException exception) {
            assertEquals(exception.getMessage(), "division by zero !");
        }
    }

    @Test
    public void testAlternativeConstructorReduce() {
        Rational rational = new Rational(2, 4);
        assertEquals("", rational.getNumerator(), 1);
        assertEquals("", rational.getDenominator(), 2);
    }

    @Test
    public void testSetNumerator() {
        Rational rational = new Rational(1, 3);
        rational.setNumerator(2);
        assertEquals("", rational.getNumerator(), 2);
    }


    @Test
    public void testSetDenominator() {
        Rational rational = new Rational(1, 3);
        rational.setDenominator(2);
        assertEquals("", rational.getDenominator(), 2);
    }

    @Test
    public void testSetNumeratorReduce() {
        Rational rational = new Rational(1, 4);
        rational.setNumerator(2);
        assertEquals("", rational.getNumerator(), 1);
        assertEquals("", rational.getDenominator(), 2);

    }

    @Test
    public void testSetDenominatorReduce() {
        Rational rational = new Rational(2, 1);
        rational.setDenominator(2);
        assertEquals("", rational.getNumerator(), 1);
        assertEquals("", rational.getDenominator(), 1);
    }
}