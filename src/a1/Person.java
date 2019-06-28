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
		throw new NotImplementedError();
	}
	
	/** returns this person's name */
	public String name() {
		throw new NotImplementedError();
	}
	
	/** returns this person's mother */
	public Person mother() {
		throw new NotImplementedError();
	}
	
	/** returns this person's father */
	public Person father() {
		throw new NotImplementedError();
	}
	
	/** returns this person's birth year */
	public int birthYear() {
		throw new NotImplementedError();
	}
	
	/** returns this person's birth month*/
	public int birthMonth() {
		throw new NotImplementedError();
	}
	
	/** returns this person's birth day */
	public int birthDay() {
		throw new NotImplementedError();
	}
	
	/** returns the number of Persons with this as a parent */
	public int numChildren() {
		throw new NotImplementedError();
	}
	
}
