package test;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Person {
		 public String name;
		 public Person(String name) { this.name = name; }
		 public String toString() { return this.name; }
		}
	
	class Cornellian extends Person {
		public String netid;
		public Cornellian(String name, String netid) {
		super(name);
		 this.netid = netid;
		}
		public String toString() {
		 return this.name + " (" + this.netid + ")"; }
		}
	
	class Cell<E> {
		E value;
		
		E get() {
			return this.value; 
		}
		
		void put(E val) {
			this.value = val; 
		}
	}
	
	
}


