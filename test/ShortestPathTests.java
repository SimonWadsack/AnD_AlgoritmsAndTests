import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Interfaces.ShortestPathAlgorithm;
import ShortestPath.BellmanFord;
import ShortestPath.FloydWarshall;
import ShortestPath.Johnson;
import Utils.AdjEdge;
import Utils.Utils;

class ShortestPathTests {

	ShortestPathTestCase[] testCases = new ShortestPathTestCase[] 
	{
			//directed weighted graph without negative cycles from lecture notes - ad21-12 page 1/11 (A=0, B=1, ...)
		new ShortestPathTestCase(new AdjEdge[][] {
			new AdjEdge[] {
					new AdjEdge(1, 3),
					new AdjEdge(2, 4),
					new AdjEdge(3, 10),
			},
			new AdjEdge[] {
					new AdjEdge(3, 6),
					new AdjEdge(4, 2),
			},
			new AdjEdge[] {
					new AdjEdge(3, 8),
					new AdjEdge(5, 3),
			},
			new AdjEdge[] {
					new AdjEdge(4, -7),
					new AdjEdge(5, -5),
			},
			new AdjEdge[] {
			},
			new AdjEdge[] {
					new AdjEdge(4, -3),
					new AdjEdge(6, 1),
			},
			new AdjEdge[] {
					new AdjEdge(4, -5),
			},
		}, 0, new int[] {0, 3, 4, 9, 0, 4, 5})
	};
	
	ShortestPathAlgorithm[] algorithms = new ShortestPathAlgorithm[] 
	{
		new InitShortestPath(),
		new FloydWarshall(),
		new BellmanFord(),
		new Johnson(),
	};
	
	@Test
	void test() {
		for(ShortestPathAlgorithm algorithm : algorithms) 
		{
			long start = System.nanoTime();
			for(ShortestPathTestCase testCase : testCases) 
			{
				assertTrue(Utils.equalArrays(testCase.shortestPaths, algorithm.execute(testCase.G, testCase.origin)));
			}
			System.out.println(algorithm.getClass().getSimpleName() + ": " + (System.nanoTime() - start)/1000000.0 + " ms  (for " + testCases.length + " test-cases)");
		}
	}

	class ShortestPathTestCase
	{
		AdjEdge[][] G;
		int origin;
		//to all vertices from origin
		int[] shortestPaths;
		
		public ShortestPathTestCase(AdjEdge[][] G, int origin, int[] shortestPaths) 
		{
			this.G = G;
			this.origin = origin;
			this.shortestPaths = shortestPaths;
		}
		
	}
	
	class InitShortestPath implements ShortestPathAlgorithm
	{
		@Override
		public int[] execute(AdjEdge[][] G, int origin) {
			return testCases[0].shortestPaths;
		}
		
	}
	
}


