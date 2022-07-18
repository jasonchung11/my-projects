
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.Test;

public class DTest {

	@Test
	public void testSumDigs() {
		assertEquals(15, D.sumDigs(50271));
		assertEquals(0, D.sumDigs(0));
		assertEquals(9, D.sumDigs(9));
	}

	@Test
	public void testLen() {
		assertEquals(0, D.len(""));
		assertEquals(1, D.len("b"));
		assertEquals(9, D.len("123456789"));
	}

	@Test
	public void testDup() {
		assertEquals("", D.dup(""));
		assertEquals("bb", D.dup("b"));
		assertEquals("aaaabbccddaa", D.dup("aabcda"));
	}

	@Test
	public void testCountEm() {
		assertEquals(0, D.countEm(""));
		assertEquals(0, D.countEm("b"));
		assertEquals(1, D.countEm("e"));
		assertEquals(6, D.countEm(" e ee eee"));
	}

	@Test
	public void isPal() {
		assertEquals(true, D.isPal(""));
		assertEquals(true, D.isPal("b"));
		assertEquals(true, D.isPal("bb"));
		assertEquals(false, D.isPal("ba"));
		assertEquals(true, D.isPal("bab"));
		assertEquals(false, D.isPal("aab"));
		assertEquals(true, D.isPal("noon"));
		assertEquals(true, D.isPal("ablewasIereIsawelba"));
		assertEquals(false, D.isPal("ablewasIereisawelba"));
	}

	@Test
	public void removeDups() {
		assertEquals("", D.removeAdjDups(""));
		assertEquals("b", D.removeAdjDups("b"));
		assertEquals("abcdea", D.removeAdjDups("abbcccdeaaa"));
	}

	public void testNumDigits() {
		assertEquals(1, D.numDigits(0));
		assertEquals(1, D.numDigits(9));
		assertEquals(2, D.numDigits(19));
		assertEquals(6, D.numDigits(803453));
	}

	@Test
	public void testCommafy() {
		assertEquals("95", D.commafy(95));
		assertEquals("1,095", D.commafy(1095));
		assertEquals("10,956,000", D.commafy(10956000));

	}

	@Test
	public void testExp() {
		// Note: assertEquals should not be used to test doubles for
		// equality because doubles are only approximations
		// But we know all doubles in this tests below are ints
		assertEquals(1, (int) D.exp(2, 0));
		assertEquals(2, (int) D.exp(2, 1));
		assertEquals(32, (int) D.exp(2, 5));
		assertEquals(27, (int) D.exp(3, 3));
	}

	public void testRev() {
		assertEquals("", D.rev(""));
		assertEquals("b", D.rev("b"));
		assertEquals("abcdef", D.rev("fedcba"));
		assertEquals("abcdefg", D.rev("gfedcba"));
	}

	@Test
	public void testPerms() {
		HashSet<String> s= new HashSet<>();
		s.add("");
		assertEquals(s, D.perms(""));

		s= new HashSet<>();
		s.add("b");
		assertEquals(s, D.perms("b"));

		s= new HashSet<>();
		s.add("ab");
		s.add("ba");
		assertEquals(s, D.perms("ab"));

		s= new HashSet<>();
		s.add("abc");
		s.add("bac");
		s.add("bca");
		s.add("acb");
		s.add("cab");
		s.add("cba");
		assertEquals(s, D.perms("abc"));
	}

}
