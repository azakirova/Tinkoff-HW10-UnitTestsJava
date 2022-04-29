import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RationalTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test
    public void testAlternativeConstructor() {
        Rational rational = new Rational(1, 2);
        assertEquals("Alternative constructor returns wrong numerator", 1, rational.getNumerator());
        assertEquals("Alternative constructor returns wrong denominator", 2, rational.getDenominator());
    }

    @Test
    public void testAlthernativeConstructorThrowsArithmeticException() {
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("division by zero !");
        Rational rational = new Rational(1, 0);
    }

    @Test
    public void testAlternativeConstructorReduceAndSimplifyMinuses() {
        Rational rational1 = new Rational(2, 4);
        Rational rational2 = new Rational(-1, -4);
        Rational rational3 = new Rational(1, -4);

        assertEquals("Alternative constructor Reduce returns wrong numerator", 1, rational1.getNumerator());
        assertEquals("Alternative constructor Reduce returns wrong denominator", 2, rational1.getDenominator());

        assertEquals("Alternative constructor Simplify Minuses returns wrong numerator", 1, rational2.getNumerator());
        assertEquals("Alternative constructor Simplify Minuses returns wrong denominator", 4, rational2.getDenominator());

        assertEquals("Alternative constructor Simplify Minuses returns wrong numerator", -1, rational3.getNumerator());
        assertEquals("Alternative constructor Simplify Minuses returns wrong denominator", 4, rational3.getDenominator());
    }

    @Test
    public void testSetNumerator() {
        Rational rational = new Rational(1, 3);
        rational.setNumerator(2);
        assertEquals("Set Numerator returns wrong numerator", 2, rational.getNumerator());
    }

    @Test
    public void testSetDenominator() {
        Rational rational = new Rational(1, 3);
        rational.setDenominator(2);
        assertEquals("Set Denominator returns wrong numerator", 2, rational.getDenominator());
    }

    @Test
    public void testSetNumeratorReduce() {
        Rational rational = new Rational(1, 4);
        rational.setNumerator(2);
        assertEquals("Set Numerator Reduce returns wrong numerator", 1, rational.getNumerator());
        assertEquals("Set Numerator Reduce returns wrong denominator", 2, rational.getDenominator());
    }

    @Test
    public void testSetDenominatorReduce() {
        Rational rational = new Rational(2, 1);
        rational.setDenominator(2);
        assertEquals("Set Denominator Reduce returns wrong numerator", 1, rational.getNumerator());
        assertEquals("Set Denominator Reduce returns wrong denominator", 1, rational.getDenominator());
    }

    @Test
    public void testToString() {
        Rational rational = new Rational(1, 3);
        assertEquals("1/3", rational.toString());
    }

    @Test
    public void testEqualsNull() {
        Rational rational = new Rational(1, 2);
        assertFalse(rational.equals(null));
    }

    @Test
    public void testEqualsObjGetClass() {
        Rational rational = new Rational(1, 2);
        assertFalse(rational.equals(""));
    }

    @Test
    public void testEqualsEqualityObjects() {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(1, 2);

        assertTrue(rational1.equals(rational2));
    }

    @Test
    public void testLessDenominatorsEqual() {
        Rational rational1 = new Rational(1, 3);
        Rational rational2 = new Rational(2, 3);
        Rational rational3 = new Rational(-1, 3);
        Rational rational4 = new Rational(-2, 3);

        assertTrue(rational1.less(rational2));
        assertTrue(rational3.less(rational2));
        assertTrue(rational4.less(rational3));
    }

    @Test
    public void testLessNumeratorEqual() {
        Rational rational1 = new Rational(2, 5);
        Rational rational2 = new Rational(2, 3);
        Rational rational3 = new Rational(-2, 5);
        Rational rational4 = new Rational(-2, 3);

        assertTrue(rational1.less(rational2));
        assertFalse(rational3.less(rational2));
        assertTrue(rational4.less(rational3)); // test down, error in code
    }

    @Test
    public void testLessDenominatorNumeratorNotEqual() {
        Rational rational1 = new Rational(1, 10);
        Rational rational2 = new Rational(997, 1003);

        assertTrue("", rational1.less(rational2)); // test down, error in code
    }

    @Test
    public void testLessDenominatorNumeratorNotEqualNegative() {
        Rational rational1 = new Rational(-1, 3);
        Rational rational2 = new Rational(2, 5);
        Rational rational3 = new Rational(-2, 5);

        assertTrue(rational1.less(rational2));
        assertTrue(rational3.less(rational1)); // test down, error in code
    }

    @Test
    public void testLessDenominatorNumeratorEqual() {
        Rational rational1 = new Rational(1, 3);
        Rational rational2 = new Rational(1, 3);
        Rational rational3 = new Rational(-1, 3);
        Rational rational4 = new Rational(-1, 3);

        assertFalse(rational1.less(rational2));
        assertFalse(rational3.less(rational4));
    }

    @Test
    public void testLessOrEqual() {
        Rational rational1 = new Rational(1, 3);
        Rational rational2 = new Rational(1, 2);
        Rational rational3 = new Rational(1, 3);

        assertTrue(rational1.lessOrEqual(rational2));
        assertTrue(rational1.lessOrEqual(rational3));
    }

    @Test
    public void testLessOrEqualNegative() {
        Rational rational1 = new Rational(1, 3);
        Rational rational2 = new Rational(-1, 3);
        Rational rational3 = new Rational(-1, 3);

        assertTrue(rational2.lessOrEqual(rational1));
        assertTrue(rational2.lessOrEqual(rational3));
    }

    @Test
    public void testPlusDifferentDenominators() {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(1, 3);
        Rational expectedResult1 = new Rational(5, 6);

        assertEquals("Plus Different Denominators returns wrong expectedResult1", expectedResult1, rational1.plus(rational2));

        Rational rational3 = new Rational(1, 3);
        Rational rational4 = new Rational(-1, 2);
        Rational expectedResult2 = new Rational(-1, 6);

        assertEquals("Plus Different Denominators returns wrong expectedResult2", expectedResult2, rational3.plus(rational4));

        Rational rational5 = new Rational(-1, 2);
        Rational rational6 = new Rational(-1, 3);
        Rational expectedResult3 = new Rational(-5, 6);

        assertEquals("Plus Different Denominators returns wrong expectedResult3", expectedResult3, rational5.plus(rational6));
    }

    @Test
    public void testPlusSameDenominators() {
        Rational rational1 = new Rational(1, 5);
        Rational rational2 = new Rational(2, 5);
        Rational expectedResult1 = new Rational(3, 5);

        assertEquals("Plus Same Denominators returns wrong expectedResult1", expectedResult1, rational1.plus(rational2));

        Rational rational3 = new Rational(1, 5);
        Rational rational4 = new Rational(-2, 5);
        Rational expectedResult2 = new Rational(-1, 5);

        assertEquals("Plus Same Denominators returns wrong expectedResult2", expectedResult2, rational3.plus(rational4));

        Rational rational5 = new Rational(-1, 5);
        Rational rational6 = new Rational(-2, 5);
        Rational expectedResult3 = new Rational(-3, 5);

        assertEquals("Plus Same Denominators returns wrong expectedResult3", expectedResult3, rational5.plus(rational6));
    }

    @Test
    public void testMultiply() {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(3, 5);
        Rational expectedResult1 = new Rational(3, 10);

        assertEquals("Multiply returns wrong expectedResult1", expectedResult1, rational1.multiply(rational2));

        Rational rational3 = new Rational(1, 2);
        Rational rational4 = new Rational(-3, 5);
        Rational expectedResult2 = new Rational(-3, 10);

        assertEquals("Multiply returns wrong expectedResult2", expectedResult2, rational3.multiply(rational4));

        Rational rational5 = new Rational(-1, 2);
        Rational rational6 = new Rational(-3, 5);
        Rational expectedResult3 = new Rational(3, 10);

        assertEquals("Multiply returns wrong expectedResult3", expectedResult3, rational5.multiply(rational6));
    }

    @Test
    public void testMultiplyByZero() {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(0, 5);
        Rational expectedResult = new Rational(0, 10);

        assertEquals("Multiply By Zero returns wrong expectedResult", expectedResult, rational1.multiply(rational2));
    }

    @Test
    public void testMinus() {
        Rational rational1 = new Rational(2, 3);
        Rational rational2 = new Rational(1, 5);
        Rational expectedResult1 = new Rational(7, 15);

        assertEquals("Minus returns wrong expectedResult1", expectedResult1, rational1.minus(rational2));

        Rational rational3 = new Rational(2, 3);
        Rational rational4 = new Rational(-1, 5);
        Rational expectedResult2 = new Rational(13, 15);

        assertEquals("Minus returns wrong expectedResult2", expectedResult2, rational3.minus(rational4));

        Rational rational5 = new Rational(-2, 3);
        Rational rational6 = new Rational(-1, 5);
        Rational expectedResult3 = new Rational(-7, 15);

        assertEquals("Minus returns wrong expectedResult3", expectedResult3, rational5.minus(rational6));
    }

    @Test
    public void testMinusSameDenominators() {
        Rational rational1 = new Rational(1, 5);
        Rational rational2 = new Rational(2, 5);
        Rational expectedResult1 = new Rational(-1, 5);

        assertEquals("Minus Same Denominators returns wrong expectedResult1", expectedResult1, rational1.minus(rational2));

        Rational rational3 = new Rational(1, 5);
        Rational rational4 = new Rational(-2, 5);
        Rational expectedResult2 = new Rational(3, 5);

        assertEquals("Minus Same Denominators returns wrong expectedResult2", expectedResult2, rational3.minus(rational4));

        Rational rational5 = new Rational(-1, 5);
        Rational rational6 = new Rational(-2, 5);
        Rational expectedResult3 = new Rational(1, 5);

        assertEquals("Minus Same Denominators returns wrong expectedResult3", expectedResult3, rational5.minus(rational6));
    }

    @Test
    public void testDivideArithmeticException() {

        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("division by zero !");
        Rational rational1 = new Rational(2, 1);
        Rational rational2 = new Rational(0, 1);

        rational1.divide(rational2);
    }

    @Test
    public void testDivide() {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(3, 5);
        Rational expectedResult1 = new Rational(5, 6);

        assertEquals("Divide returns wrong expectedResult1", expectedResult1, rational1.divide(rational2));

        Rational rational3 = new Rational(1, 2);
        Rational rational4 = new Rational(-3, 5);
        Rational expectedResult2 = new Rational(-5, 6);

        assertEquals("Divide returns wrong expectedResult2", expectedResult2, rational3.divide(rational4));

        Rational rational5 = new Rational(-1, 2);
        Rational rational6 = new Rational(-3, 5);
        Rational expectedResult3 = new Rational(5, 6);

        assertEquals("Divide returns wrong expectedResult3", expectedResult3, rational5.divide(rational6));
    }
}