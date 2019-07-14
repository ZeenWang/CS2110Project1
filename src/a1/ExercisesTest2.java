//package a1;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class ExercisesTest {
//
//	@Test
//	void test() {
//
//		// test for method hasConstDiagonal.
//		int[][] matrixA = {{3,2,3},{2,3,3},{3,2,3}}; 
//		int[][] matrixB = {{1,2,3},{2,3,3},{3,2,1}}; 
//		assertEquals(true, Exercises.hasConstDiagonal(matrixA));
//		assertEquals(false, Exercises.hasConstDiagonal(matrixB));
//		System.out.println("Method hasConstDiagonal Tested!");
//		
//		// test for method mean.
//		int[] listA= {3,4,5,6,7,8,2};
//		assertEquals(5.0d, Exercises.mean(listA));
//		int[] listB= {0,1};
//		assertEquals(0.5d, Exercises.mean(listB));
//		System.out.println("Method mean Tested!");
//		
//		// test for method numZeros.
//		assertEquals(0, Exercises.numZeros(listA));
//		assertEquals(1, Exercises.numZeros(listB));
//		System.out.println("Method numZeros Tested!");
//		
//		// test for method median.
//		assertEquals(5, Exercises.median(listA));
//		assertEquals(1, Exercises.median(listB));
//		System.out.println("Method median Tested!");
//		
//		// test for method normalize.
//		String sentenceA = "Get u prepared. && So u will feel good, if u try!!! @#$%";
//		assertEquals("GetupreparedSouwillfeelgoodifutry", Exercises.normalize(sentenceA));
//		System.out.println("Method normalize Tested!");
//		
//		// test for method isPalindrome.
//		String sentenceB = "boob";
//		assertEquals(true, Exercises.isPalindrome(sentenceB));
//		assertEquals(false, Exercises.isPalindrome(sentenceA));
//		System.out.println("Method isPalindrome Tested!");
//	}
//
//}
