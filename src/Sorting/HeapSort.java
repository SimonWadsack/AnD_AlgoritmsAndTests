package Sorting;
import java.util.PriorityQueue;

import Interfaces.SortAlgorithm;

public class HeapSort implements SortAlgorithm {

	@Override
	public int[] sort(int[] A) {
		
		PriorityQueue<Integer> H = new PriorityQueue<>();
		
		for (int i = 0; i < A.length; i++) {
			H.add(A[i]);
		}
		
		int[] R = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			R[i] = H.poll();
		}
		
		return R;
	}

}
