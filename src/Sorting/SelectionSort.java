package Sorting;
import Interfaces.SortAlgorithm;

public class SelectionSort implements SortAlgorithm {

	@Override
	public int[] sort(int[] A) {
		
		for (int i = 0; i < A.length-1; i++) {
			int m = i;
			int v = A[i];
			for (int j = i+1; j < A.length; j++) {
				if(A[j] < v)
				{
					m = j;
					v = A[j];
				}
			}
			if(m != i) 
			{
				int temp = A[i];
				A[i] = A[m];
				A[m] = temp;
			}
		}
		
		return A;
	}

}
