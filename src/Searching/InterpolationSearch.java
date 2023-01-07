package Searching;

import Interfaces.SearchAlgorithm;

public class InterpolationSearch implements SearchAlgorithm {

	@Override
	public int search(int[] A, int k) {
		
		int low = 0;
		int high = A.length-1;
		
		while(A[low] != A[high] && k >= A[low] && k <= A[high]) 
		{
			int middle = low + ((k - A[low]) * (high - low) / (A[high] - A[low]));
			
			if(A[middle] < k)
				low = middle + 1;
			else if (A[middle] > k)
				high = middle - 1;
			else
				return middle;
		}
		
		if(A[low] == k)
			return low;
		else
			return -1;
	}

}
