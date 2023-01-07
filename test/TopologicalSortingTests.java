import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GraphExploration.TopologicalSorting;
import Interfaces.TopologicalSortingAlgorithm;
import Utils.Utils;

class TopologicalSortingTests {

	TopologicalSortingTestCase[] testCases = new TopologicalSortingTestCase[] 
			{
					//Graph 1 - directed
					new TopologicalSortingTestCase(new int[][] {
						new int[] {1, 3},
						new int[] {2, 6},
						new int[] {3},
						new int[] {4, 5},
						new int[] {6},
						new int[] {},
						new int[] {},
					}, new int[] {6, 4, 5, 3, 2, 1, 0}),
					//Graph 2 - directed from lecture notes ad21-10 page 5/9 (A=0, B=1, ...)
					new TopologicalSortingTestCase(new int[][] {
						new int[] {1, 2, 5},
						new int[] {4},
						new int[] {3},
						new int[] {7},
						new int[] {5, 6, 7},
						new int[] {6},
						new int[] {},
						new int[] {6},
					}, new int[] {6, 5, 7, 4, 1, 3, 2, 0}),
			};
	
	TopologicalSortingAlgorithm[] algorithms = new TopologicalSortingAlgorithm[] 
	{
		new TopologicalSorting(),
	};
	
	@Test
	void test() {
		for(TopologicalSortingAlgorithm algorithm : algorithms) 
		{
			long start = System.nanoTime();
			for(TopologicalSortingTestCase testCase : testCases) 
			{
				assertTrue(Utils.equalArrays(testCase.correctSorting, algorithm.execute(testCase.G)));
			}
			System.out.println(algorithm.getClass().getSimpleName() + ": " + (System.nanoTime() - start)/1000000.0 + " ms  (for " + testCases.length + " test-cases)");
		}
	}
	
	class TopologicalSortingTestCase{
		
		int[][] G;
		int[] correctSorting;
		
		public TopologicalSortingTestCase(int[][] G, int[] correctTS) 
		{
			this.G = G;
			this.correctSorting = correctTS;
		}
	}

}
