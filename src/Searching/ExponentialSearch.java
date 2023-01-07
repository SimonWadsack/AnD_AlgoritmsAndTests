package Searching;
import Interfaces.SearchAlgorithm;

public class ExponentialSearch implements SearchAlgorithm {

	@Override
	public int search(int[] A, int k) {
		
		if(A.length == 0) return -1;
		
		int bound = 1;
		while(bound < A.length && A[bound] < k) 
		{
			bound *= 2;
		}
		
		return RecursiveBinarySearch.binarySearch(A, k, bound/2, Math.min(bound+1, A.length));
	}

}
