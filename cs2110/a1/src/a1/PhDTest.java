package a1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PhDTest {

    @Test
    void testConstructor1() {
        PhD p= new PhD("Jason", 2025, 5);
        assertEquals("Jason", p.name());
        assertEquals("5/2025", p.date());
        assertEquals(null, p.advisor1());
        assertEquals(null, p.advisor2());
        assertEquals(0, p.advisees());
        assertThrows(AssertionError.class, () -> { new PhD("B", 1100, 1); });
        assertThrows(AssertionError.class, () -> { new PhD(null, 3564, 9); });
        assertThrows(AssertionError.class, () -> { new PhD("Adam", 1101, 0); });
        assertThrows(AssertionError.class, () -> { new PhD("Bob", 9, 13); });
    }

    @Test
    void testMutators() {
        PhD a= new PhD("John", 3245, 1);
        PhD b= new PhD("Joe", 1234, 10);
        PhD c= new PhD("Helen", 9876, 12);
        PhD add= new PhD("Jojo", 1001, 1);
        a.addAdvisor1(b);
        a.addAdvisor2(c);
        c.addAdvisor1(a);
        assertEquals(b, a.advisor1());
        assertEquals(c, a.advisor2());
        assertEquals(1, b.advisees());
        assertEquals(1, c.advisees());
        assertEquals(1, a.advisees());
        add.addAdvisor1(a);
        assertEquals(2, a.advisees());
        assertThrows(AssertionError.class, () -> { a.addAdvisor1(b); });
        assertThrows(AssertionError.class, () -> { b.addAdvisor1(null); });
        assertThrows(AssertionError.class, () -> { b.addAdvisor1(b); });
        PhD d= new PhD("Joey", 1211, 12, a, b);
        assertThrows(AssertionError.class, () -> { d.addAdvisor2(a); });
        assertThrows(AssertionError.class, () -> { a.addAdvisor2(d); });
        assertThrows(AssertionError.class, () -> { c.addAdvisor2(a); });
        assertThrows(AssertionError.class, () -> { c.addAdvisor2(null); });
        assertThrows(AssertionError.class, () -> { c.addAdvisor2(c); });
        assertThrows(AssertionError.class, () -> { b.addAdvisor2(a); });
        assertThrows(AssertionError.class, () -> { b.addAdvisor2(b); });

    }

    @Test
    void testConstructor2() {
        PhD adv1= new PhD("Sir", 3481, 12);
        PhD adv2= new PhD("Maam", 1010, 9);
        PhD d= new PhD("Lebron", 5555, 8, adv1, adv2);
        assertEquals("Lebron", d.name());
        assertEquals("8/5555", d.date());
        assertEquals(adv1, d.advisor1());
        assertEquals(adv2, d.advisor2());
        assertEquals(0, d.advisees());
        assertThrows(AssertionError.class, () -> { new PhD(null, 1, 1, adv1, adv2); });
        assertThrows(AssertionError.class, () -> { new PhD("A", 1, 1, adv1, adv2); });
        assertThrows(AssertionError.class, () -> { new PhD("Hello", 1, 0, adv1, adv2); });
        assertThrows(AssertionError.class, () -> { new PhD("Bobby", 1, 103, adv1, adv2); });
        assertThrows(AssertionError.class, () -> { new PhD("Miles", 1, 1, null, adv2); });
        assertThrows(AssertionError.class, () -> { new PhD("Teo", 1, 1, adv1, null); });
        assertThrows(AssertionError.class, () -> { new PhD("Jack", 1, 1, adv1, adv1); });
    }

    @Test
    void testFunctions() {
        PhD adv1= new PhD("Sir", 3481, 12);
        PhD adv2= new PhD("Maam", 1010, 9);
        PhD adv3= new PhD("Man", 1032, 10);
        PhD person1= new PhD("Okay", 3838, 9, adv1, adv2);
        PhD person2= new PhD("Sure", 1010, 10, adv2, adv3);
        PhD person3= new PhD("Joe", 1000, 9);
        PhD person4= new PhD("Bob", 1000, 8);
        PhD person5= new PhD("Mister", 1000, 8);
        PhD person6= new PhD("Okay", 1010, 8);
        assertEquals(true, person2.gotBefore(person1));
        assertEquals(false, person1.gotBefore(person2));
        assertEquals(true, person4.gotBefore(person3));
        assertEquals(false, person3.gotBefore(person4));
        assertEquals(false, person1.gotBefore(null));
        assertEquals(false, person4.gotBefore(person5));
        assertEquals(true, person5.gotBefore(person6));
        assertEquals(false, person6.gotBefore(person5));
        assertEquals(false, person1.gotBefore(person1));
        assertEquals(true, person1.isSiblingOf(person2));
        assertEquals(false, person1.isSiblingOf(person1));
        assertEquals(false, person3.isSiblingOf(person4));
        assertThrows(AssertionError.class, () -> { person1.isSiblingOf(null); });
    }
}

// null, same date, same year different month (2), same month different year (2)
// different month different year