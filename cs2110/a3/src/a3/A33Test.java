package a3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class A33Test {

    @Test
    void testMidsAreEqual() {
        assertEquals(true, A33.midsAreEqual(""));
        assertEquals(true, A33.midsAreEqual("$"));
        assertEquals(false, A33.midsAreEqual("23"));
        assertEquals(true, A33.midsAreEqual("44"));
        assertEquals(false, A33.midsAreEqual("22AB"));
        assertEquals(true, A33.midsAreEqual("2AAB"));
        assertEquals(true, A33.midsAreEqual("A22"));
        assertEquals(true, A33.midsAreEqual("AAA"));
        assertEquals(false, A33.midsAreEqual("AABC"));
        assertEquals(true, A33.midsAreEqual("abcdefaabcdefg"));
        assertEquals(false, A33.midsAreEqual("abcdef$abcdefg"));
        assertEquals(true, A33.midsAreEqual("aaaaaaaaaaaaaaaa"));
        assertEquals(false, A33.midsAreEqual("aaaaaaa$aaaaaaaa"));
        assertEquals(true, A33.midsAreEqual("aaaaaaa$aaaaaaaaa"));
        assertEquals(true, A33.midsAreEqual("abcdefgAAAabcdefg"));
    }

    @Test
    void testSurroundLittles() {
        assertEquals("", A33.surroundLittles(""));
        assertEquals("BbB", A33.surroundLittles("b"));
        assertEquals("B", A33.surroundLittles("B"));
        assertEquals("å", A33.surroundLittles("å"));
        assertEquals("$", A33.surroundLittles("$"));
        assertEquals("1ABCDEFXxX", A33.surroundLittles("1ABCDEFx"));
        assertEquals("1ZzZZ$BBbBYyY", A33.surroundLittles("1zZ$Bby"));
        assertEquals("AaABbBCcCDdDEeEFfFGgGHhHIiIJjJKkK",
            A33.surroundLittles("abcdefghijk"));
        assertEquals("LlLMmMNnNOoOPpPQqQRrRSsSTtT",
            A33.surroundLittles("lmnopqrst"));
        assertEquals("UuUVvVWwWXxXYyYZzZ",
            A33.surroundLittles("uvwxyz"));
    }

    @Test
    void testPutCapsFirst() {
        assertEquals("", A33.putCapsFirst(""));

        assertEquals("$", A33.putCapsFirst("$"));
        assertEquals("Ac", A33.putCapsFirst("cA"));
        assertEquals("cÅc", A33.putCapsFirst("cÅc"));
        assertEquals("ABCDXZabcdxy$z", A33.putCapsFirst("aAbBcCdDxXy$zZ"));
        assertEquals("mnopqrst", A33.putCapsFirst("mnopqrst"));
        assertEquals("1z$aàēĤƀ", A33.putCapsFirst("1z$aàēĤƀ"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ.$%!",
            A33.putCapsFirst("ABCDE.FGHIJKLMNO$PQ%RSTUV!WXYZ"));
    }

    @Test
    void testMoreThan1() {
        assertEquals(false, A33.moreThan1("", ""));
        assertEquals(true, A33.moreThan1("a", ""));
        assertEquals(false, A33.moreThan1("", "a"));
        assertEquals(false, A33.moreThan1("abcb", "c"));
        assertEquals(true, A33.moreThan1("acbcb", "c"));
        assertEquals(false, A33.moreThan1("abbb", "c"));
        assertEquals(true, A33.moreThan1("aaa", "aa"));
        assertEquals(false, A33.moreThan1("abbc", "ab"));
        assertEquals(true, A33.moreThan1("aaa", "a"));
        assertEquals(true, A33.moreThan1("abbbabc", "ab"));
        assertEquals(true, A33.moreThan1("what if what if what", "what"));
        assertEquals(true, A33.moreThan1("what if what if what", "what if"));
        assertEquals(true, A33.moreThan1("what if what if what", "what if what"));
        assertEquals(false, A33.moreThan1("what if what if what", "what if what if"));
    }

    @Test
    void testDuplicate() {
        assertEquals("", A33.duplicate(" b0 "));
        assertEquals("c", A33.duplicate("        c1"));
        assertEquals("$$$$$$$$", A33.duplicate("$8        "));
        assertEquals("33333", A33.duplicate("35"));
    }

    @Test
    void testAreAnagrams() {
        // assertEquals(true, A33.areAnagrams("", ""));
        assertEquals(true, A33.areAnagrams("noon", "noon"));
        assertEquals(true, A33.areAnagrams("mary", "army"));
        assertEquals(true, A33.areAnagrams("tom marvolo riddle", "i am lordvoldemort"));
        assertEquals(false, A33.areAnagrams("tommarvoloriddle", "i am lordvoldemort"));
        assertEquals(false, A33.areAnagrams("world", "hello"));
        assertEquals(false, A33.areAnagrams("a", "A"));
    }

}
