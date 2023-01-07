package Sorting;
import java.util.ArrayList;
import java.util.List;

import Interfaces.SortAlgorithm;
import Utils.Utils;

public class QuickSort implements SortAlgorithm {

	@Override
	public int[] sort(int[] A) {
		
		if(A.length <= 1) return A;
		
		int p = A[0];
		List<Integer> SMinus = new ArrayList<>(); 
		List<Integer> SPlus = new ArrayList<>(); 
		for(int i = 1; i < A.length; i++)
		{
			if(A[i] <= p) 
			{
				SMinus.add(A[i]);
			}
			else 
			{
				SPlus.add(A[i]);
			}
		}
		
		SPlus = Utils.toIntList(sort(Utils.tointArray(SPlus)));
		SMinus = Utils.toIntList(sort(Utils.tointArray(SMinus)));
		
		return Utils.concat(SMinus, p, SPlus);
	}

}
