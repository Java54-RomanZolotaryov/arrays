package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
	    boolean o1IsEven = o1 % 2 == 0;
	    boolean o2IsEven = o2 % 2 == 0;
	    int result = 0;
	    if (o1IsEven == o2IsEven) {
	    	result = o1IsEven ? o1.compareTo(o2) : o2.compareTo(o1);
	    } else {
	    	result = o1IsEven ? -1 : 1;
	    }
	    return result;
	}

}
