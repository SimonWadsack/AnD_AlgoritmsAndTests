import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Interfaces.UnweightedShortestPathAlgorithm;
import ShortestPath.UnweightedDijkstra;
import ShortestPath.ShortestPathBFS;
import Utils.Utils;

class UnweightedShortestPathTests {

	UnweightedShortestPathTestCase[] testCases = new UnweightedShortestPathTestCase[]
	{
			//Graph 1 - directed
		new UnweightedShortestPathTestCase(new int[][] {
			new int[] {1, 3},
			new int[] {2, 6},
			new int[] {3},
			new int[] {4, 5},
			new int[] {6},
			new int[] {},
			new int[] {},
		}, 0, new int[] {0, 1, 2, 1, 2, 2, 2}),
		new UnweightedShortestPathTestCase(new int[][] {
			new int[] {1, 2, 5},
			new int[] {4},
			new int[] {3},
			new int[] {7},
			new int[] {5, 6, 7},
			new int[] {6},
			new int[] {},
			new int[] {6},
		}, 0, new int[] {0, 1, 1, 2, 2, 1, 2, 3})
	};
	
	UnweightedShortestPathAlgorithm[] algorithms = new UnweightedShortestPathAlgorithm[] 
	{
		new ShortestPathBFS(),
		new ShortestPathBFS(),
		new UnweightedDijkstra()
	};
	
	@Test
	void test() {
		for(UnweightedShortestPathAlgorithm algorithm : algorithms) 
		{
			long start = System.nanoTime();
			for(UnweightedShortestPathTestCase testCase : testCases) 
			{
				assertTrue(Utils.equalArrays(testCase.shortestPaths, algorithm.execute(testCase.G, testCase.origin)));
			}
			System.out.println(algorithm.getClass().getSimpleName() + ": " + (System.nanoTime() - start)/1000000.0 + " ms  (for " + testCases.length + " test-cases)");
		}
	}

	class UnweightedShortestPathTestCase
	{
		int[][] G;
		int origin;
		//to all vertices from origin
		int[] shortestPaths;
		
		public UnweightedShortestPathTestCase(int[][] G, int origin, int[] shortestPaths) 
		{
			this.G = G;
			this.origin = origin;
			this.shortestPaths = shortestPaths;
		}
	}
	
}
