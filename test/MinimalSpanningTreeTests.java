import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Interfaces.MinimalSpanningTreeAlgorithm;
import MinimalSpanningTree.Boruvka;
import MinimalSpanningTree.Kruskal;
import MinimalSpanningTree.Prim;
import Utils.Edge;
import Utils.Utils;

class MinimalSpanningTreeTests {

	MinimalSpanningTreeTestCase[] testCases = new MinimalSpanningTreeTestCase[] 
	{
			//undirected weighted graph from the lecture notes ad21-13 (numbered left to right and top to bottom)
		new MinimalSpanningTreeTestCase(7, new Edge[] {
				new Edge(0, 1, 5),
				new Edge(0, 2, 2),
				new Edge(1, 3, 3),
				new Edge(2, 3, 7),
				new Edge(3, 4, 9),
				new Edge(3, 5, 11),
				new Edge(4, 6, 1),
				new Edge(5, 6, 6),
		}, new Edge[] {
				new Edge(0, 2, 2),
				new Edge(0, 1, 5),
				new Edge(1, 3, 3),
				new Edge(3, 4, 9),
				new Edge(4, 6, 1),
				new Edge(5, 6, 6),
		}),
	};
	
	MinimalSpanningTreeAlgorithm[] algorithms = new MinimalSpanningTreeAlgorithm[] 
	{
		new InitMST(),
		new Boruvka(),
		new Prim(),
		new Kruskal(),
	};
	
	@Test
	void test() {
		for(MinimalSpanningTreeAlgorithm algorithm : algorithms) 
		{
			long start = System.nanoTime();
			for(MinimalSpanningTreeTestCase testCase : testCases) 
			{
				assertTrue(Utils.equalMSTs(testCase.tree, algorithm.execute(testCase.V, testCase.E)));
			}
			System.out.println(algorithm.getClass().getSimpleName() + ": " + (System.nanoTime() - start)/1000000.0 + " ms  (for " + testCases.length + " test-cases)");
		}
	}
	
	class MinimalSpanningTreeTestCase
	{
		int V;
		Edge[] E;
		Edge[] tree;
		
		public MinimalSpanningTreeTestCase(int V, Edge[] E, Edge[] tree) 
		{
			this.V = V;
			this.E = E;
			this.tree = tree;
		}
		
	}
	
	class InitMST implements MinimalSpanningTreeAlgorithm
	{
		@Override
		public Edge[] execute(int V, Edge[] G) {
			return testCases[0].tree;
		}
	}
	
}
