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
        assertEquals("Nominator is not 1", 1, rational.getNumerator());
        assertEquals("Denominator is not 2", 2, rational.getDenominator());
    }

//    @Test
//    public void testAlternativeConstructorException() {
//        try {
//            Rational rational = new Rational(1, 0);
//            fail("Exception wasn't raise");
//       } catch (ArithmeticException exception) {
//         assertEquals(exception.getMessage(), "division by zero !");
//       }
//    }

    @Rule
    public ExpectedException thrown =ExpectedException.none();

    @Test
    public void testArithmeticException() {
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("division by zero !");
        Rational rational = new Rational(1,0);
    }


    @Test
    public void testAlternativeConstructorReduce() {
        Rational rational = new Rational(2, 4);
        assertEquals("", 1, rational.getNumerator());
        assertEquals("", 2, rational.getDenominator());
    }

    @Test
    public void testSetNumerator() {
        Rational rational = new Rational(1, 3);
        rational.setNumerator(2);
        assertEquals("", 2, rational.getNumerator());
    }


    @Test
    public void testSetDenominator() {
        Rational rational = new Rational(1, 3);
        rational.setDenominator(2);
        assertEquals("", 2, rational.getDenominator());
    }

    @Test
    public void testSetNumeratorReduce() {
        Rational rational = new Rational(1, 4);
        rational.setNumerator(2);
        assertEquals("", 1,  rational.getNumerator());
        assertEquals("", 2, rational.getDenominator());

    }

    @Test
    public void testSetDenominatorReduce() {
        Rational rational = new Rational(2, 1);
        rational.setDenominator(2);
        assertEquals("", 1, rational.getNumerator());
        assertEquals("", 1, rational.getDenominator());
    }

    @Test
    public void testString(){
        Rational rational= new Rational(1,3);
        assertEquals("1/3", rational.toString());
    }

    @Test
    public void testEqualesNull(){
        Rational rational = new Rational(1,2);
        assertFalse(rational.equals(null));

    }

    @Test
    public void testEqualesObjGetClass(){
        Rational rational = new Rational(1,2);
        assertFalse(rational.equals(""));

    }
    @Test
    public void testEqualesEqualityObjects(){
        Rational rational1 = new Rational(1,2);
        Rational rational2 = new Rational(1,2);

        assertTrue(rational1.equals(rational2));

    }

    @Test
    public void testLessDenominatorsEqual(){
        Rational rational1 = new Rational(1,3);
        Rational rational2 = new Rational(2,3);

        assertTrue(rational1.less(rational2));
    }

    @Test
    public void testLessNumeratorEqual(){
        Rational rational1 = new Rational(2,5);
        Rational rational2 = new Rational(2,3);

        assertTrue(rational1.less(rational2));
    }

    @Test
    public void testLessDenominatorNumeratorNotEqual(){
        Rational rational1 = new Rational(1,10);
        Rational rational2 = new Rational(997,1003);

        assertTrue(rational1.less(rational2));
    }

}