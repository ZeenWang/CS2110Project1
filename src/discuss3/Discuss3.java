package discuss3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/** Discussion 03: Practice with exceptions. */
public class Discuss3 {

    /**
     * Return the minimum value in c[m..n).
     * @param c a non-null array
     * @param m the lower bound, in [0..(c.length))
     * @param n the upper bound, in [m..(c.length)]
     * @throws RuntimeException with message "min of 0 values doesn't exist" if c[m..n) is empty.
     */
    public static int min(int[] c, int m, int n) {
        /* Note: array segment c[m..n) is empty if the number of values in it is 0.
         * The number of values is n - m (or 0 if this is negative).
         *
         * For example,
         *   c[m..m+2) is the segment consisting of c[m] and c[m+1],
         *   c[m..m+1) is the segment consisting of one element, c[m]
         *   c[m..m)   is the empty segment.
         *   c[m..m-1) is also the empty segment
         */

        // TODO: throw RuntimeException according to the method spec
    	
    	
    	if (n-m <=0) {
    		throw new RuntimeException("min of 0 values doesn't exist if c[m..n) is empty.");
    	 }
    	
    	
        int min= c[m];
        for (int k= m+1; k <= n; k= k+1) {
            if (c[k] < min) min= c[k];
        }
        return min;
    }

    /**
     * calls min three times and then calls printProduct.  If any of these
     * methods throws an exception, print an error message (but still execute
     * the remaining methods).
     */
    public static void main(String[] args) {
        int[] b= {5, 3, 8, 2, 6};
     
    	try {
    		System.out.println(min(b, 1, 0));
        } catch(RuntimeException e){
        	System.out.println("Caught RuntimeException: update the upper bound "
				+ "so that it is greater than the lower bound");   
        }
    	try {
    		System.out.println(min(b, 1, 3));	
        } catch(RuntimeException e){
        	System.out.println("Caught RuntimeException: update the upper bound "
				+ "so that it is greater than the lower bound");   
        }
    	try {
    		System.out.println(min(b, 1, 1));	
        } catch(RuntimeException e){
        	System.out.println("Caught RuntimeException: update the upper bound "
				+ "so that it is greater than the lower bound");   
        }
    
    	
		// printProd();
    }

    /** Do this over and over, until the user types "DONE" instead of a first integer:
     *  Read two integers from the keyboard and print their product. If the
     *  reader types anything but an integer, use the integer 1. */
    public static void printProd() throws IOException {
       
    	BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        try {
        while (true) {
     
            System.out.println("Enter a number: ");
            String s;
            
           
            // Read a line from the keyboard, trim it, and store the result in s;
            s = reader.readLine().trim();
            int numRep = Integer.parseInt(s);
           
            if (s.equals("DONE"))
                return;

            int a;
            a = Integer.parseInt(s);


            System.out.println("Enter another number: ");

            // Read a line from the keyboard and store it in s;
            s = reader.readLine().trim();

            int b;
            b= Integer.parseInt(s);

            System.out.println("Product: " + a*b);
        }
        }catch (IOException e){
        	System.out.println("input is not an integer and was assigned to 1");
        	while (true) {
        	     
                System.out.println("Enter a number: ");
                String s;
                
               
                // Read a line from the keyboard, trim it, and store the result in s;
                s = "1";
               
                if (s.equals("DONE"))
                    return;

                int a;
                a = Integer.parseInt(s);


                System.out.println("Enter another number: ");

                // Read a line from the keyboard and store it in s;
                s = reader.readLine().trim();

                int b;
                b= Integer.parseInt(s);

                System.out.println("Product: " + a*b);
        	
        }
    }
}
    }
