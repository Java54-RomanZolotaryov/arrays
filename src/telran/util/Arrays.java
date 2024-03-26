package telran.util;

import java.util.Comparator;

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
		//TODO
		
	}

	private static <T> boolean equals(T element1, T element2) {
		return element1 == null ? 
				element1 == element2 :
					element1.equals(element2);
	}
}
