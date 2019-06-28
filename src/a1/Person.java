package a1;

/** an instance of a person */
public class Person {
	
	// class invariant: string that only contains letters
	private String name;
	
	// class invariant: integer that contains a valid year
	private int birthYear; 
	
	// class invariant: in range [1..12]
	private int birthMonth;
	
	// class invariant: in range [1..31]
	private int birthDay;
	
	
	// class invariant: >=0
	public int numChildren;
	
	// class invariant: a person's mother of type Person
	private Person mother;
	
	// class invariant: a person's father of type Person
	private Person father;
	
	/**
	 * Constructor: Initialize a person with the given name and birthdate, and unknown parents.
	 * The name must be non-null and non-empty.
	 * 
	 * @param name is a string that only contains letters
	 * @param birthYear is a valid year
	 * @param birthMonth is in the range 1..12 
	 * @param birthDay must be in the range 1..31
	 * */
	public Person(String name, int birthYear, int birthMonth, int birthDay) {
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
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
	 */
	void setMother(Person m) {
		if (mother == null) this.mother = null;
		this.mother = m;
		mother.numChildren ++;
	}
	/**
	 * changes this person's father to f
	 * if f is null, father is unknown 
	 * */
	void setFather(Person father) {
		if (father == null) this.father = null;
		this.father = father;
		father.numChildren ++;
	}
}
