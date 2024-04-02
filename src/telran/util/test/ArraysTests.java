package telran.util.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.util.Arrays;

class ArraysTests {
	
	Integer[] numbers = {100, -3, 23, 4, 8, 41, 56, -7};
	String[] strings = {"abc", "lmn", "123", null, "a"};
	String[] stringsMin = {"abc", "lmn", "123", "y"};
	
	@Test
	void indexOfTest() {
		assertEquals(1, Arrays.indexOf(strings, "lmn"));
		assertEquals(3, Arrays.indexOf(strings, null));
		assertEquals(-1, Arrays.indexOf(numbers, 150));
		assertEquals(4, Arrays.indexOf(numbers, 8));
	}
	
	@Test
	void minTest() {
		assertEquals("y", Arrays.min(stringsMin, new StringLengthComparator()));
		assertEquals("123", Arrays.min(stringsMin, new StringsComparator()));
	}
	
	@Test
	void bubbleSortTest() {
		Integer[] expected = {4, 8, 56, 100, 41, 23, -3, -7};
		Integer[] numbersCopy = java.util.Arrays.copyOf(numbers, numbers.length);
		Arrays.bubbleSort(numbersCopy, new EvenOddComparator());
		assertArrayEquals(expected, numbersCopy);
	}
	
	@Test
	void binarySearchTest() {
		Integer[] sortedNumbers = {10, 20, 30, 40, 50};
		Comparator<Integer> comp = Integer::compare;
		assertEquals(0, Arrays.binarySearch(sortedNumbers, 10, comp));
		assertEquals(4, Arrays.binarySearch(sortedNumbers, 50, comp));
		assertEquals(2, Arrays.binarySearch(sortedNumbers, 30, comp));
		assertEquals(-1, Arrays.binarySearch(sortedNumbers, 5, comp));
		assertEquals(-4, Arrays.binarySearch(sortedNumbers, 35, comp));
		assertEquals(-6, Arrays.binarySearch(sortedNumbers, 55, comp));
	}
	
	 @Test
	 void removeIfTest() {
		 Integer[] expectedEven = {100, 4, 8,  56};
			assertArrayEquals(expectedEven, Arrays.removeIf(numbers,
					a -> a % 2 != 0));
			Integer[] expectedNegative = {-3,-7};
			assertArrayEquals(expectedNegative, Arrays.removeIf(numbers,
					a -> a > 0));
	 }

}
