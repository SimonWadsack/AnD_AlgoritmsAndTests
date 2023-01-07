package Sorting;

import java.util.ArrayList;
import java.util.List;

import Interfaces.SortAlgorithm;
import Utils.Utils;

public class BucketSort implements SortAlgorithm {
	
	@Override
	public int[] sort(int[] A) {
		return bucketSort(A, 5, new QuickSort());
	}
	
	public static int[] bucketSort(int[] A, int k, SortAlgorithm sortAlgorithm) 
	{
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[k];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		//normalize array because this BucketSort can only work with arrays with elements >= 0
		int min = Utils.getMinimum(A);
		A = Utils.normalize(A, min);
		
		int m = 1 + Utils.getMaximum(A);

		for (int i = 0; i < A.length; i++) {
			buckets[(int)Math.floor(k * A[i] / m)].add(A[i]);
		}
		
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = Utils.toIntList(sortAlgorithm.sort(Utils.tointArray(buckets[i])));
		}
		
		//return the restored array from the normalization above
		return Utils.restore(Utils.concat(buckets, A.length), min);
	}

}
