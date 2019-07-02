package a1;

/** an instance of a person */
// Kurt Chua and Zeen Wang

public class Person {
	
	// class invariant: non-null and non-empty string
	private String name;
	
	// class invariant: any integer that represents a valid year
	private int birthYear; 
	
	// class invariant: in range [1..12]
	private int birthMonth;
	
	// class invariant: in range [1..31]
	private int birthDay;
	
	// class invariant: integer >=0
	private int numChildren;
	
	// class invariant: a person's mother of type Person, null if unknown
	private Person mother;
	
	// class invariant: a person's father of type Person, null if unknown 
	private Person father;
	
	/**
	 * Constructor: Initialize a person with the given name and birthdate, and unknown parents.
	 * The name must be non-null and non-empty.
	 * 
	 * @param name is non-null and non-empty 
	 * @param birthYear is a valid year
	 * @param birthMonth is in the range 1..12 
	 * @param birthDay must be in the range 1..31
	 * */
	public Person(String name, int birthYear, int birthMonth, int birthDay) {
		assert(name!=null);
		assert(birthMonth>=1 && birthMonth<=12);
		assert(birthDay>=1 && birthDay <=31);
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.mother = null;
		this.father = null;
	}
	
	/** returns this person's name */
	public String name() {
		return name;
	}
	
	/** returns this person's mother */
	public Person mother() {
		return this.mother;
	}
	
	/** returns this person's father */
	public Person father() {
		return this.father;
	}
	
	/** returns this person's birth year */
	public int birthYear() {
		return birthYear;
	}
	
	/** returns this person's birth month*/
	public int birthMonth() {
		return birthMonth;
	}
	
	/** returns this person's birth day */
	public int birthDay() {
		return this.birthDay;
	}
	
	/** returns the number of Persons with this as a parent */
	public int numChildren() {
		return numChildren;
	}
	
	/**
	 * changes this person's mother to m 
	 * if m is null, mother is unknown
	 * 
	 * calls a helper function checkMother
	 * @param m is this person's mother of type of Person
	 */
	public void setMother(Person m) {
		if (m == null) {
			this.mother.numChildren --;
			this.mother = null;
		} 
		else {
			checkMother(m);
			 this.mother = m;
			 this.mother.numChildren ++;
		}
	}
	
	/**
	 * changes this person's father to f
	 * if f is null, father is unknown 
	 * 
	 * calls a helper function checkFather
	 * @param f is this person's father of type Person
	 * */
	public void setFather(Person f) {
		if (f == null) {
			this.father.numChildren --;
			this.father = null;
		} 
		else {
			checkFather(f);
			this.father = f;
			this.father.numChildren ++;
		}
	}
	
	/**
	 * checks if previous father and current father are the same person
	 * updates numChildren of previous father if they are different fathers
	 * 
	 * @param f is a father of type Person
	 **/
	private void checkFather(Person f) {
		if (this.father!=null && this.father!=f) {
			this.father.numChildren--;
		}
	}
	
	/**
	 * checks if previous father and current father are the same person
	 * updates numChildren of previous father if they are different fathers 
	 * 
	 * @param m is a mother of type Person
	 **/	
	private void checkMother(Person m) {
		if (this.mother!=null && this.mother!=m) {
			this.mother.numChildren--;
		}
	}
	/**
	 * Change this person’s name
	 * @param name a String of new name.
	 */
	public void setName(String name) {
		assert(name != null);
		this.name=name;
	}
	/**
	 * Change this person’s birth year to y.
	 * @param y a integer of new birth year.
	 */
	public void setBirthYear(int y) {
		birthYear=y;
	}
	
	/**
	 * Change this person’s birth month to m.
	 * @param m a integer of new birth month.
	 */
	public void setBirthMonth(int m) {
		assert(birthMonth>=1 && birthMonth<=12);
		birthMonth=m;
	}
	
	/**
	 * Change this person’s birth day to d.
	 * @param d a integer of new birth day.
	 */
	public void setBirthDay(int d) {
		assert(birthDay>=1 && birthDay <=31);
		birthDay=d;
	}
	
	/**
	 * Find if one is the a half sibling of another. 
	 * Precondition: requires that other is non-null.
	 * @param other a Person object one compared with.
	 * @return true if this and other share a known parent. 
	 */
	public boolean isHalfSibling(Person other) {
		assert(other != null);
		if (other.father()==this.father() || other.father()==this.mother() || 
			other.mother()== this.mother() || other.mother()== this.father())
			return true;
		return false;
	}
	
	/**
	 * Find if one is older than another.
	 * Precondition: requires that other is non-null.
	 * @param other a Person object one compared with.
	 * @return true if this person’s birthday is before other’s. 
	 */
	public boolean isOlderThan(Person other) {
		assert(other != null);
		if (this.birthYear() != other.birthYear())
			return this.birthYear() < other.birthYear();
		if (this.birthMonth() != other.birthMonth())
			return this.birthMonth() < other.birthMonth();
		if (this.birthDay()!= other.birthDay())
			return this.birthDay() < other.birthDay();
		return false;
	}
}
