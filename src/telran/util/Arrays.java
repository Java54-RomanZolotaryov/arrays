package telran.util;

import java.util.Comparator;
import java.util.function.Predicate;

public class Arrays {
	
	public static <T> int indexOf(T[] array, T element) {
		int index = 0;
		while (index < array.length && !equals(array[index], element)) {
			index++;
		}
		return index == array.length ? -1 : index;
	}
	
	public static <T> T min(T[] array, Comparator<T> comparator) {
		T result = null;
		if (array != null && array.length > 0) {
			result = array[0];
			for (int i = 1; i < array.length; i++) {
				if (comparator.compare(result, array[i]) > 0) {
					result = array[i];
				}
			}
		}
		return result;
	}
	
	public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {		
	    boolean swapped = true;
	    int walkOverCount = 0;
	    while (swapped) {
	        swapped = false;
	        for (int i = 0; i < array.length - 1 - walkOverCount; i++) {
	            if (comparator.compare(array[i], array[i + 1]) > 0) {
	                swap(array, i, i + 1);
	                swapped = true;
	            }
	        }
	        walkOverCount++;
	    }
	}
	
	public static <T> int binarySearch(T[] arr, T key, Comparator<? super T> comparator) {
		int left = 0;
		int right = arr.length - 1;
		int middle = (left + right) / 2;
		int res = -1;
		while (left <= right && (res = comparator.compare(key, arr[middle])) != 0) {
			if (res > 0) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
			middle = (left + right) / 2;
		}
		return left > right ? -(left + 1) : middle;
	}
	
	public static <T> T[] search(T[] array, Predicate<T> predicate) {
		T[] result = java.util.Arrays.copyOf(array, array.length);
		int insertIndex = 0;
		for (int i = 0; i < array.length; i++) {
			if (predicate.test(array[i])) {
				result[insertIndex++] = array[i];
			}
		}
		return java.util.Arrays.copyOf(result, insertIndex);
	}
	
	public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
		return search(array, predicate.negate());
	}

	private static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static <T> boolean equals(T element1, T element2) {
		return element1 == null ? 
				element1 == element2 :
					element1.equals(element2);
	}
}
