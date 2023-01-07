package Searching;
import Interfaces.SearchAlgorithm;

public class LinearSearch implements SearchAlgorithm {

	@Override
	public int search(int[] A, int k) {
		
		for (int i = 0; i < A.length; i++) {
			if(A[i] == k) return i;
		}
		
		return -1;
	}

}
