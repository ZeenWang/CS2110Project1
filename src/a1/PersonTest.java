package a1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void personAndNameTest() {
		// test for a person's constructor
		// test for name(),birthYear(),birthMonth() and birthDay()

		// test for a new person Kurt
		Person kurt = new Person("Kurt",1999,4,12);
		assertEquals("Kurt", kurt.name());
		assertEquals(1999, kurt.birthYear());
		assertEquals(4, kurt.birthMonth());
		assertEquals(12, kurt.birthDay());
		assertEquals(null, kurt.mother());
		assertEquals(null,kurt.father());
		
		// test for a new person Ezra
		Person ezra = new Person("Ezra",1807,1,11);
		assertEquals("Ezra", ezra.name());
		assertEquals(1807, ezra.birthYear());
		assertEquals(1, ezra.birthMonth());
		assertEquals(11, ezra.birthDay());
		assertEquals(null,ezra.mother());
		assertEquals(null,ezra.father());
		
		System.out.println("Contructor tests passed!");
	}
	
	@Test
	void motherTests() {
		
		// test for methods mother() and setMother()
		Person kurt = new Person("Kurt",1999,4,12);
		Person daisy = new Person("Daisy",1975,9,8);
		kurt.setMother(daisy);
		assertEquals(daisy, kurt.mother());
		
		// change mother
		Person martha = new Person("Martha",1989,1,4);
		kurt.setMother(martha);
		assertEquals(martha,kurt.mother());
		
		Person kate = new Person("Kate",1978,2,3);
		kurt.setMother(kate);
		assertEquals(kate,kurt.mother());
		
		// unknown mother
		Person unknown = null;
		kurt.setMother(unknown);
		assertEquals(unknown, kurt.mother());
		
		
		System.out.println("mother() and setMother() test cases passed!");
	}
	
	@Test
	void fatherTests() {
		
		// test for methods father() and setFather()
		Person kurt = new Person("Kurt",1999,4,12);
		assertEquals(null, kurt.father());
		Person alan = new Person("Alan",1969,10,11);
		kurt.setFather(alan);
		assertEquals(alan, kurt.father());
		
		// change father
		Person bob = new Person("Bob",1976,12,3);
		kurt.setFather(bob);
		assertEquals(bob, kurt.father());
		
		Person dave = new Person ("Dave",1982,2,4);
		kurt.setFather(dave);
		assertEquals(dave,kurt.father());
		
		// unknown father
		Person unknown = null;
		kurt.setFather(unknown);
		assertEquals(unknown,kurt.father());
		
		System.out.println("father() and setFather() test cases passed!");
	}

	
	@Test
	void numChildrenTest() {
		
		// test for numChildren()
		
		// 1 child for two parents 
		Person kurt = new Person("Kurt",1999,4,12);
		Person daisy = new Person("Daisy",1975,9,8);
		Person alan = new Person("Alan",1969,10,11);
		kurt.setFather(alan);
		kurt.setMother(daisy);
		assertEquals(1, alan.numChildren());
		assertEquals(1, daisy.numChildren());
		
		// change father
		Person bob = new Person("Bob",1976,12,3);
		kurt.setFather(bob);
		assertEquals(1, bob.numChildren());
		assertEquals(1, daisy.numChildren());
		assertEquals(0,alan.numChildren());
		
		// change mother
		Person martha = new Person("Martha",1989,1,4);
		kurt.setMother(martha);
		assertEquals(1,martha.numChildren());
		assertEquals(1, bob.numChildren());
		assertEquals(0,daisy.numChildren());
		assertEquals(0,alan.numChildren());
		
		// unknown parents 
		kurt.setFather(null);
		kurt.setMother(null);
		assertEquals(0,martha.numChildren());
		assertEquals(0, bob.numChildren());
		assertEquals(0,daisy.numChildren());
		assertEquals(0,alan.numChildren());
		
		System.out.println("numChildren() test cases passed!");
	}
	
	@Test
	void settersTest() {
		// create a new person Kurt
		Person kurt = new Person("Kurt",1999,4,12);
		
		// set new birthday and name
		kurt.setBirthDay(4);
		kurt.setBirthMonth(11);
		kurt.setBirthYear(2001);
		kurt.setName("zeen");
		
		// test
		assertEquals("zeen", kurt.name());
		assertEquals(2001, kurt.birthYear());
		assertEquals(11, kurt.birthMonth());
		assertEquals(4, kurt.birthDay());
		
		System.out.println("Setters tests passed!");
	}
	
	@Test
	void comparisonsTest() {
		// create new persons Kurt and Bob.
		Person kurt = new Person("Kurt",1999,4,12);
		Person bob = new Person("Bob",1976,12,3);

		// test for isOlderThan method.
		assertEquals(true, bob.isOlderThan(kurt));
		bob.setBirthYear(2000);
		assertEquals(false, bob.isOlderThan(kurt));
		bob.setBirthYear(1999);
		assertEquals(false, bob.isOlderThan(kurt));
		bob.setBirthMonth(2);
		assertEquals(true, bob.isOlderThan(kurt));
		bob.setBirthMonth(4);
		assertEquals(true, bob.isOlderThan(kurt));
		bob.setBirthDay(22);;
		assertEquals(false, bob.isOlderThan(kurt));
		bob.setBirthDay(12);;
		assertEquals(false, bob.isOlderThan(kurt));
		
		// create parents.
		Person daisy = new Person("Daisy",1975,9,8);
		Person alan = new Person("Alan",1969,10,11);
		Person martha = new Person("Martha",1989,1,4);
		
		// set parents. 
		kurt.setFather(daisy);
		kurt.setMother(alan);
		bob.setFather(daisy);
		bob.setMother(martha);
		
		daisy.setFather(alan);
		daisy.setMother(martha);
		martha.setMother(alan);
		
		// test for isHalfSibling method.
	   	assertEquals(true, bob.isHalfSibling(bob));
		assertEquals(true, daisy.isHalfSibling(kurt));
		assertEquals(true, bob.isHalfSibling(kurt));
		assertEquals(true, martha.isHalfSibling(kurt));
		daisy.setFather(alan);
		daisy.setMother(kurt);
		bob.setFather(martha);
		bob.setMother(daisy);
		assertEquals(true, bob.isHalfSibling(kurt));
		assertEquals(true, daisy.isHalfSibling(kurt));
		assertEquals(false, daisy.isHalfSibling(alan));
		// same person
		assertEquals(true, bob.isHalfSibling(bob));
		
		
		System.out.println("Comparisons tests passed!");
	}
}
