
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import Interfaces.SortAlgorithm;
//import Sorting.BogoSort;
import Sorting.BubbleSort;
import Sorting.BucketSort;
import Sorting.HeapSort;
import Sorting.InsertionSort;
import Sorting.MergeSort;
import Sorting.QuickSort;
import Sorting.SelectionSort;
import Utils.Utils;

class SortTests {

	SortTestCase[] testCases = new SortTestCase[] 
	{
			new SortTestCase(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5}),
			new SortTestCase(new int[] {2, 3, 1, 4, 5}, new int[] {1, 2, 3, 4, 5}),
			new SortTestCase(new int[] {5, 4, 3, 2, 1}, new int[] {1, 2, 3, 4, 5}),
			new SortTestCase(new int[] {1, 2, 3, 3, 4, 5}, new int[] {1, 2, 3, 3, 4, 5}),
			new SortTestCase(new int[] {-10, 20, -123, 322, 22, -121}, new int[] {-123, -121, -10, 20, 22, 322}),
			new SortTestCase(new int[] {-1, 1, 0}, new int[] {-1, 0, 1}),
			getTimeTestSet(100000),
	};
	
	SortAlgorithm[] algorithms = new SortAlgorithm[] {
			//PLEASE DONT USE BOGOSORT (WITH AN ARRAY WITH 100000 ELEMENTS) AT ALL
			//new BogoSort(),
			new BubbleSort(),
			new InsertionSort(),
			new SelectionSort(),
			new QuickSort(),
			new MergeSort(),
			new HeapSort(),
			new BucketSort(),
	};
	
	@Test
	void test() {
		for(SortAlgorithm algorithm : algorithms) 
		{
			long start = System.nanoTime();
			for(SortTestCase testCase : testCases) 
			{
				assertTrue(Utils.equalArrays(testCase.sortedArray, algorithm.sort(testCase.array.clone())));
			}
			System.out.println(algorithm.getClass().getSimpleName() + ": " + (System.nanoTime() - start)/1000000.0 + " ms  (for " + testCases.length + " test-cases)");
		}
		
	}
	
	class SortTestCase
	{
		int[] array;
		int[] sortedArray;
		
		public SortTestCase(int[] a, int[] s) 
		{
			array = a;
			sortedArray = s;
		}
		
	}
	
	
	public SortTestCase getTimeTestSet(int length)
	{
		Random random = new Random();
		int[] array = new int[length];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(-10000, 10000);
		}
		
		int[] sorted = array.clone();
		Arrays.sort(sorted);
		
		return new SortTestCase(array, sorted);
	}

}
