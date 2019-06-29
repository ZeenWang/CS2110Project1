package a1;

/** an instance of a person */
public class Person {
	
	// class invariant: non-null and non-empty string
	private String name;
	
	// class invariant: integer that contains a valid year
	private int birthYear; 
	
	// class invariant: in range [1..12]
	private int birthMonth;
	
	// class invariant: in range [1..31]
	private int birthDay;
	
	// class invariant: integer >=0
	private int numChildren;
	
	// class invariant: a person's mother of type Person
	private Person mother;
	
	// class invariant: a person's father of type Person
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
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		// unknown parents
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
	 * calls a helper function setFather 
	 * @param m is this person's mother of type of Person
	 */
	public void setMother(Person m) {
		if (m == null) {
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
	 * calls a helper function setMother
	 * @param f is this person's father of type Person
	 * */
	public void setFather(Person f) {
		if (f == null) {
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
	 * @param f is a father of type Person
	 **/
	public void checkFather(Person f) {
		if (this.father!=null && this.father!=f) {
			this.father.numChildren--;
		}
	}
	
	/**
	 * checks if previous father and current father are the same person
	 * @param m is a mother of type Person
	 **/	
	public void checkMother(Person m) {
		if (this.mother!=null && this.mother!=m) {
			this.mother.numChildren--;
		}
	}
	
}
