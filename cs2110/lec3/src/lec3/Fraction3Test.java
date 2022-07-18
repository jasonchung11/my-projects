package lec3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Fraction3Test {

    @Test
    void testTwoParConstructor() {
        Fraction3 f= new Fraction3(5, 2);
        assertEquals(2.5, f.toDouble());
    }

    @Test
    void testOneParConstructor() {
        Fraction3 g= new Fraction3(2);
        assertEquals(2, g.toDouble());
    }
    // Run --> Run, make sure green bar appears on left
}
