package a1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExercisesTest {

	@Test
	void testIsPalindrome() {
		assertEquals(true, Exercises.isPalindrome(""));
		assertEquals(true, Exercises.isPalindrome("abccba"));
		assertEquals(true, Exercises.isPalindrome("abcba"));
		assertEquals(false, Exercises.isPalindrome("abc"));
		assertEquals(true, Exercises.isPalindrome("a"));
	}
	
	@Test
	void testNormalize() {
		assertEquals("abc", Exercises.normalize("a.b?c"));
		assertEquals("abc", Exercises.normalize("abc"));
		assertEquals("", Exercises.normalize(""));
	}

	@Test
	void testMedian() {
		assertEquals(3, Exercises.median(new int[] {1,2,3,4,5}));
		assertEquals(3, Exercises.median(new int[] {3}));
		int result = Exercises.median(new int[] {1,2,3,4});
		assertEquals(true, result == 2 || result == 3);
	}
	
	@Test
	void testNumZeros() {
		assertEquals(1, Exercises.numZeros(new int[] {1,2,0,1}));
		assertEquals(1, Exercises.numZeros(new int[] {0}));
		assertEquals(0, Exercises.numZeros(new int[] {1,2,3,4}));
		assertEquals(0, Exercises.numZeros(new int[] {}));
		assertEquals(4, Exercises.numZeros(new int[] {0,0,0,0}));
	}

	@Test
	void testMean() {
		assertEquals(1.0, Exercises.mean(new int[] {1}));
		assertEquals((1 + 2 + 3)/3.0, Exercises.mean(new int[] {1, 2, 3}));
	}

	@Test
	void testHasConstDiagonal() {
		int[][] matrix1 = new int[][] {
			{0, 1, 0},
			{1, 0, 1},
			{0, 1, 0},
		};
		assertEquals(true, Exercises.hasConstDiagonal(matrix1));
		
		int[][] matrix2 = new int[][] {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 1},
		};
		assertEquals(false, Exercises.hasConstDiagonal(matrix2));
		
		int[][] matrix3 = new int[][] {};
		assertEquals(true, Exercises.hasConstDiagonal(matrix3));
	}
}
