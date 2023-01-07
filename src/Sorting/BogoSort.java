package Sorting;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Interfaces.SortAlgorithm;
import Utils.Utils;

public class BogoSort implements SortAlgorithm {

	@Override
	public int[] sort(int[] A) {
		
		while(true)
		{
			List<Integer> array = Arrays.asList(Utils.toIntArray(A));
			
			Collections.shuffle(array);
			
			if(Utils.isSorted(Utils.tointArray(array))) 
			{
				return Utils.tointArray(array);
			}
		}
		
	}

}
