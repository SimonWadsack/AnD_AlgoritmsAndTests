package Searching;
import Interfaces.SearchAlgorithm;

public class RecursiveBinarySearch implements SearchAlgorithm {

	@Override
	public int search(int[] A, int k) {
		return binarySearch(A, k, 0, A.length-1);
	}
	
	public static int binarySearch(int[] A, int k, int left, int right) 
	{
		if(left > right) return -1;
		int middle = (int)Math.floor((left+right)/2.0);
		
		if(A[middle] == k) return middle;
		else if(A[middle] > k) return binarySearch(A, k, left, middle-1);
		else return binarySearch(A, k, middle+1, right);
	}

}
