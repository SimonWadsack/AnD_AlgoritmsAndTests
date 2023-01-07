import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GraphExploration.BFS;
import GraphExploration.DFS;
import GraphExploration.RecursiveDFS;
import Interfaces.GraphExplorationAlgorithm;

class GraphExplorationTests {

	GraphExplorationTestCase[] testCases = new GraphExplorationTestCase[] 
	{
			//Graph 1 - directed
			new GraphExplorationTestCase(new int[][] {
				new int[] {1, 3},
				new int[] {2, 6},
				new int[] {3},
				new int[] {4, 5},
				new int[] {2, 6},
				new int[] {0},
				new int[] {},
			}),
			//Graph 1 - undirected
			new GraphExplorationTestCase(new int[][] {
				new int[] {1, 3, 5},
				new int[] {2, 6, 0},
				new int[] {3, 1, 4},
				new int[] {4, 5, 0, 2},
				new int[] {2, 6, 3},
				new int[] {0, 3},
				new int[] {1, 4},
			}),
			//Graph 2 - directed from lecture notes ad21-10 page 5/9 (A=0, B=1, ...)
			new GraphExplorationTestCase(new int[][] {
				new int[] {1, 2, 5},
				new int[] {4},
				new int[] {3},
				new int[] {7},
				new int[] {5, 6, 7},
				new int[] {6},
				new int[] {},
				new int[] {6},
			}),
	};
	
	GraphExplorationAlgorithm[] algorithms = new GraphExplorationAlgorithm[] 
	{
			new BFS(),
			new BFS(),
			new DFS(),
			new RecursiveDFS(),
	};
	
	@Test
	void test() {
		for(GraphExplorationAlgorithm algorithm : algorithms) 
		{
			long start = System.nanoTime();
			for(GraphExplorationTestCase testCase : testCases) 
			{
				int[] visited = new int[testCase.G.length];
				algorithm.execute(testCase.G, visited);
				assertTrue(everythingVisitedOnce(visited));
			}
			System.out.println(algorithm.getClass().getSimpleName() + ": " + (System.nanoTime() - start)/1000000.0 + " ms  (for " + testCases.length + " test-cases)");
		}
	}
	
	boolean everythingVisitedOnce(int[] visited) 
	{
		for (int i = 0; i < visited.length; i++) {
			if(visited[i] != 1) return false;
		}
		
		return true;
	}
	
	class GraphExplorationTestCase
	{
		int[][] G;
		
		public GraphExplorationTestCase(int[][] G) 
		{
			this.G = G;
		}
		
	}
}
