package GraphExploration;

import Interfaces.GraphExplorationAlgorithm;

public class RecursiveDFS implements GraphExplorationAlgorithm {

	@Override
	public void execute(int[][] G, int[] visited) {
		boolean[] D = new boolean[G.length];
		D[0] = true;
		recursiveDFS(0, D, G, visited);
	}
	
	public void recursiveDFS(int v, boolean[] D, int[][] G, int[] visited) 
	{
		/* do something with vertex - here increase count for testing */
		visited[v]++;
		/* do something with vertex */
		for (int i = 0; i < G[v].length; i++) {
			int w = G[v][i];
			if(!D[w]) 
			{
				D[w] = true;
				recursiveDFS(w, D, G, visited);
			}
		}
	}

}
