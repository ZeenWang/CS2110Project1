package a1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void personTest() {
		
		// test for a new person Kurt 
		Person kurt = new Person("Kurt",1999,4,12);
		assertEquals("Kurt", kurt.name());
		assertEquals(1999, kurt.birthYear());
		assertEquals(4, kurt.birthMonth());
		assertEquals(12, kurt.birthDay());
		
		// test for a new person Ezra
		Person ezra = new Person("Ezra",1807,1,11);
		assertEquals("Ezra", ezra.name());
		assertEquals(1807, ezra.birthYear());
		assertEquals(1, ezra.birthMonth());
		assertEquals(11, ezra.birthDay());
		
	    
	}
	
	@Test
	void nameTest() {
		
		
	}

	@Test
	void motherTest() {
		
	}
	
	@Test
	void fatherTest() {
		
	}
	
	@Test
	void birthYearTest() {
		
	}
	
	@Test
	void birthMonthTest() {
		
	}
	
	@Test
	void birthDayTest() {
		
	}
	
	@Test
	void numChildrenTest() {
		
	}
}
