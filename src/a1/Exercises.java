package a1;

import static org.junit.Assert.fail;

import com.sun.jdi.Value;
import com.sun.source.doctree.ReturnTree;

public class Exercises {
	
	/**
	 * Tell whether s is the same backwards and forwards.
	 * @param s a String.
	 * @return true if s is the same backwards and forwards.
	 */
	public static boolean isPalindrome(String s) {
		assert(s != null);
		for(int i=0;i< s.length()/2;i++)
			if(s.charAt(i) != s.charAt(s.length() -i -1)) 
				return false;
		return true;
	}
	
	/**
	 * Remove all whitespace and punctuation in a String.
	 * @param s a String.
	 * @return a copy of s with all whitespace and punctuation removed.
	 */
	public static String normalize(String s) {
		assert(s != null);
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		return s;
	}
	
	/**
	 * Calculate the median of the values.
	 * @param values an integer array, representing the sample. 
	 * @return the median of the values.
	 */
	public static int median(int[ ] values) {
		assert(values != null);
		// sort the array.
		int buffer=values[0];
		for (int i=0;i<(values.length/2+1);i++) {
			buffer=values[i];
			for(int j=i;j<values.length;j++) {
				if(values[j]<buffer) {
					buffer=values[j];
					values[j]=values[i];
					values[i]=buffer;
				}
			}
		}
		// calculate the median.
		if(values.length % 2 ==0)
			return values[(values.length+1)/2];
		else 
			return values[values.length/2];
	}
	
	/**
	 * Count the number of the 0 in a series of numbers.
	 * @param values an integer array, representing the sample. 
	 * @return the number of 0’s in values.
	 */
	public static int numZeros(int[ ] values) {
		assert(values != null);
		int count=0;
		for (int i: values) {
			if (i==0)
				count++;
		}
		return count;
	}
	
	/**
	 * Calculate the mean.
	 * @param values an integer array, representing the sample. 
	 * @return the mean of the values.
	 */
	public static double mean(int[ ] values) {
		assert(values != null);
		int sum=0;
		for(int i : values)
			sum=sum+i;
		return (double)sum/values.length;
	}
	
	/** 
	 * Tell whether the numbers on the diagonal of a square matrix share a same value.
	 * Prerequisite: requires values to be a square matrix (that is, for all i, values[i].length== values.length).
	 * @param values a 2-dimensional integer array, representing a matrix. 
	 * @return true if all of the values on the diagonal are the same.
	 */
	public static boolean hasConstDiagonal(int[][] values) {
		assert(values.length == values[0].length);
		for (int i = 0; i < values.length; i++) {
			if(values[i][i]!= values[i][values.length-i-1] || values[i][values.length-i-1] != values[0][0] || values[i][i] != values[0][0])
				return false;
		}
		return true;
	}
}
