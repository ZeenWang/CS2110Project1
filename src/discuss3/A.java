package discuss3;

public class A {
	public static double p(int x) {
		int y =x;
		try {
			System.out.println("six");
			y = 5/x;
			System.out.println("five");
			return 5/(x+2);
		} catch (RuntimeException e) {
			System.out.println("four");
			y = 5/(x+1);
			System.out.println("three");
		}
		
		System.out.println("two");
		y = 4/x;
		System.out.println("one");
		return 1/x;
	
	}
	
	public static void main(String[] args) {
		p(-2); // passes
	//	p(0); // throws new ArithmeticException
		
	}

}
