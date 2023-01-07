package Sorting;
import java.util.ArrayList;
import java.util.List;

import Interfaces.SortAlgorithm;
import Utils.Utils;

public class MergeSort implements SortAlgorithm {

	@Override
	public int[] sort(int[] A) {
		
		if(A.length <= 1) return A;
		int n = A.length;
		int n1 = n/2;
		int n2 = n - n1;
		List<Integer> SMinus = new ArrayList<>(); 
		List<Integer> SPlus = new ArrayList<>(); 
		for (int i = 0; i < A.length; i++) {
			if(i < n1)
				SMinus.add(A[i]);
			else
				SPlus.add(A[i]);
		}
		
		SPlus = Utils.toIntList(sort(Utils.tointArray(SPlus)));
		SMinus = Utils.toIntList(sort(Utils.tointArray(SMinus)));
		
		List<Integer> R = new ArrayList<>();
		int i = 0, j = 0;
		while(i < n1 && j < n2) 
		{
			if(SMinus.get(i) <= SPlus.get(j)) 
			{
				R.add(SMinus.get(i));
				i++;
			}
			else 
			{
				R.add(SPlus.get(j));
				j++;
			}
		}
		
		for(int index = i; index < SMinus.size(); index++) 
		{
			R.add(SMinus.get(index));
		}
		
		for(int index = j; index < SPlus.size(); index++) 
		{
			R.add(SPlus.get(index));
		}
		
		return Utils.tointArray(R);
	}

}
