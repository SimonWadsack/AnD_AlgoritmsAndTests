package Sorting;
import Interfaces.SortAlgorithm;

public class BubbleSort implements SortAlgorithm {
	
	@Override
	public int[] sort(int[] A) 
	{
		boolean swapped = true;
		while(swapped) 
		{
			swapped = false;
			for(int i = 0; i < A.length-1; i++) 
			{
				if(A[i] > A[i+1]) 
				{
					int temp = A[i];
					A[i] = A[i+1];
					A[i+1] = temp;
					swapped = true;
				}
			}
		}
		
		return A;
	}
	
}
