
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import Interfaces.SearchAlgorithm;
import Searching.BinarySearch;
import Searching.ExponentialSearch;
import Searching.InterpolationSearch;
import Searching.LinearSearch;
import Searching.RecursiveBinarySearch;

class SearchTests {

	SearchTestCase[] testCases = new SearchTestCase[] {
			new SearchTestCase(new int[] {1,2,3,4,5}, 3, 2),
			new SearchTestCase(new int[] {1,2,4,5,6}, 3, -1),
			new SearchTestCase(new int[] {200,300,310,311,4930}, 4930, 4),
			new SearchTestCase(new int[] {1,2}, 1, 0),
			new SearchTestCase(new int[] {20, 30, 40, 50}, 11, -1),
			getTimeTestSet(10000),
	};
	
	SearchAlgorithm[] algorithms = new SearchAlgorithm[] {
			new LinearSearch(),
			new LinearSearch(),
			new BinarySearch(),
			new RecursiveBinarySearch(),
			new ExponentialSearch(),
			new InterpolationSearch(),
	};
			
			
	@Test
	void test() {
		for(SearchAlgorithm algorithm : algorithms) 
		{
			long start = System.nanoTime();
			for(SearchTestCase testCase : testCases) 
			{
				assertEquals(testCase.index, algorithm.search(testCase.array, testCase.k));
			}
			System.out.println(algorithm.getClass().getSimpleName() + ": " + (System.nanoTime() - start)/1000000.0 + " ms  for " + testCases.length + " test-cases");
		}
	}
	
	class SearchTestCase
	{
		int[] array;
		int k;
		int index;
		
		public SearchTestCase(int[] a, int _k, int i) 
		{
			array = a;
			k = _k;
			index = i;
		}
		
	}
	
	public SearchTestCase getTimeTestSet(int length)
	{
		Random random = new Random();
		int[] array = new int[length];
		
		int index = random.nextInt(0, length);
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(-10000, 10000);
		}
		
		int[] sorted = array.clone();
		Arrays.sort(sorted);
		
		return new SearchTestCase(sorted, sorted[index], index);
	}

}
