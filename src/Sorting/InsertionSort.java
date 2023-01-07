package Sorting;
import Interfaces.SortAlgorithm;

public class InsertionSort implements SortAlgorithm {

	@Override
	public int[] sort(int[] A) {
		
		for (int i = 0; i < A.length; i++) {
			int v = A[i];
			int j = i-1;
			while(j >= 0 && A[j] > v) 
			{
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = v;
		}
		
		return A;
	}
	
}
