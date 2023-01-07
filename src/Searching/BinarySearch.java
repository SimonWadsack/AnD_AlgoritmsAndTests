package Searching;
import Interfaces.SearchAlgorithm;

public class BinarySearch implements SearchAlgorithm {
	
	@Override
	public int search(int[] A, int k) 
	{
		int left = 0;
		int right = A.length-1;
		
		while(right >= left) 
		{
			int middle = (int)Math.floor((left + right)/2);
			if(A[middle] == k) return middle;
			else if(A[middle] > k) right = middle-1;
			else left = middle+1;
		}
		
		return -1;
	}

}
