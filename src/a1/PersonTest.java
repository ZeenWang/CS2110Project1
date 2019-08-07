package a1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	// Helpers /////////////////////////////////////////////////////////////////
	
	static Person testCase() {
		return new Person("Mike", 1983, 5, 8);
	}
		
	// Black box tests
	
	/*
	 * A-level
	 */
	
	@Test
	void testGroupA() {
		Person p = testCase();
		assertEquals(p.name(),"Mike");
		assertEquals(p.mother(),null);
		assertEquals(p.father(),null);
		assertEquals(p.birthYear(),1983);
		assertEquals(p.birthMonth(), 5);
		assertEquals(p.birthDay(), 8);
		assertEquals(p.numChildren(), 0);
	}
	
	@Test
	void testConstructorEmpty() {
		assertThrows(AssertionError.class, () -> {new Person("", 1983, 5, 8); });
	}
	
	@Test
	void testConstructorNull() {
		assertThrows(AssertionError.class, () -> {new Person(null, 1983, 5, 8); });
	}
	
	@Test
	void testConstructorBadMonth() {
		assertThrows(AssertionError.class, () -> {new Person("Mike", 1983, 0, 8); });
		assertThrows(AssertionError.class, () -> {new Person("Mike", 1983, 25, 8); });
	}
	
	@Test
	void testConstructorBadDay() {
		assertThrows(AssertionError.class, () -> {new Person("Mike", 1983, 5, -5); });
		assertThrows(AssertionError.class, () -> {new Person("Mike", 1983, 5, 40); });
	}
	
	/*
	 * B-level
	 */
	
	@Test
	void testSetName() {
		Person p = testCase();
		p.setName("Michael");
		assertEquals("Michael", p.name());
	}
	
	@Test
	void testSetNameNull() {
		Person p = testCase();
		assertThrows(AssertionError.class, () -> {p.setName(null);});
	}
	
	@Test
	void testSetNameNonNull() {
		Person p = testCase();
		assertThrows(AssertionError.class, () -> {p.setName("");});
	}
	
	@Test
	void testSetBirthYear() {
		Person p = testCase();
		p.setBirthYear(2019);
		assertEquals(2019, p.birthYear());
		p.setBirthYear(1983);
		assertEquals(1983, p.birthYear());
	}
	
	@Test
	void testSetBirthMonth() {
		Person p = testCase();
		p.setBirthMonth(9);
		assertEquals(p.birthMonth(), 9);
	}
	
	@Test
	void testSetBirthMonthBad() {
		Person p = testCase();
		assertThrows(AssertionError.class, () -> { p.setBirthMonth( 0); });
		assertThrows(AssertionError.class, () -> { p.setBirthMonth(-1); });
		assertThrows(AssertionError.class, () -> { p.setBirthMonth(30); });
		assertEquals(p.birthMonth(),5);
	}
	
	@Test
	void testSetBirthDay() {
		Person p = testCase();
		p.setBirthDay(13);
		assertEquals(13, p.birthDay());
	}
	
	@Test
	void testSetBirthDayBad() {
		Person p = testCase();
		assertThrows(AssertionError.class, () -> { p.setBirthDay( 0); });
		assertThrows(AssertionError.class, () -> { p.setBirthDay(-1); });
		assertThrows(AssertionError.class, () -> { p.setBirthDay(32); });
		assertEquals(p.birthDay(),8);
	}

	@Test
	void testSetFather() {
		Person p = testCase();
		Person f = new Person("Bob", 1, 2, 3);
		
		p.setFather(f);
		assertSame(f, p.father());
		assertEquals(f.numChildren(), 1);
		assertEquals(p.numChildren(), 0);
	}
	
	@Test
	void testSetFatherNull() {
		Person p = testCase();
		Person f = new Person("Bob", 1, 2, 3);
		
		p.setFather(null);
		assertSame(null, p.father());
		assertEquals(f.numChildren(), 0);
		assertEquals(p.numChildren(), 0);
	}
	
	@Test
	void testSetFatherSelf() {
		Person p = testCase();
		
		p.setFather(p);
		assertSame(p, p.father());
		assertEquals(p.numChildren(), 1);
	}

	@Test
	void testSetMother() {
		Person p = testCase();
		Person m = new Person("Alice", 1, 2, 3);
		
		p.setMother(m);
		assertSame(m, p.mother());
		assertEquals(m.numChildren(), 1);
		assertEquals(p.numChildren(), 0);
	}
	
	@Test
	void testSetMotherNull() {
		Person p = testCase();
		Person m = new Person("Alice", 1, 2, 3);
		
		p.setMother(null);
		assertSame(null, p.mother());
		assertEquals(m.numChildren(), 0);
		assertEquals(p.numChildren(), 0);
	}
	
	@Test
	void testSetMotherSelf() {
		Person p = testCase();
		
		p.setMother(p);
		assertSame(p, p.mother());
		assertEquals(p.numChildren(), 1);
	}
	
	/*
	 * C-level
	 */
		
	/** Set up and test isHalfSibling test.  The first four arguments indicate
	 * the parents of a and b; the options are 0: unknown, 1 and 2: different people
	 *
	 * @param expected the expected answer
	 */
	static void testHalfSiblingScenario(int am, int af, int bm, int bf, boolean result) {
		Person[] ps = {null, new Person("Parent 1", 1,2,3), new Person("Parent 2", 2,3,4)};
		
		Person a = new Person("Alice", 4,5,6);
		Person b = new Person("Bob", 7,8,9);
		
		a.setMother(ps[am]);
		a.setFather(ps[af]);
		b.setMother(ps[bm]);
		b.setFather(ps[bf]);
		
		assertEquals(a.isHalfSibling(b), result);
		assertEquals(b.isHalfSibling(a), result);
	}
			
	@Test
	void testIsHalfSibling() {
		testHalfSiblingScenario(0, 0, 0, 0, false);
		testHalfSiblingScenario(0, 1, 0, 1, true);
		testHalfSiblingScenario(1, 0, 1, 0, true);
		testHalfSiblingScenario(0, 1, 0, 2, false);
		testHalfSiblingScenario(1, 0, 2, 0, false);
		testHalfSiblingScenario(1, 2, 1, 2, true);
		testHalfSiblingScenario(1, 1, 0, 0, false);
		testHalfSiblingScenario(1, 2, 2, 0, true);
		testHalfSiblingScenario(1, 2, 0, 1, true);
	}
	
	/**
	 * set up and test a.isOlderThan(b).
	 * @param yDiff a.year  - b.year,  in range [-1..1]
	 * @param mDiff a.month - b.month, in range [-1..1]
	 * @param dDiff a.day   - b.day,   in range [-1..1]
	 */
	void testOlderThanScenario(int yDiff, int mDiff, int dDiff) {
		Person b = new Person("B", 10, 10, 10);
		Person a = new Person("A", 10+yDiff, 10+mDiff, 10+dDiff);
		
		// a is older than b if a's date is birthdate is smaller,
		// i.e. if a.date < b.date
		// i.e. if a.date - b.date < 0
		boolean result =
			   yDiff < 0
			|| yDiff == 0 && mDiff < 0
			|| yDiff == 0 && mDiff == 0 && dDiff < 0;
		
		assertEquals(result, a.isOlderThan(b));
	}
	
	@Test
	void testIsOlderThan() {
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				for (int k = -1; k <= 1; k++)
					testOlderThanScenario(i,j,k);
	}
}
