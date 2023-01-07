package GraphExploration;

import java.util.LinkedList;

import Interfaces.GraphExplorationAlgorithm;

public class BFS implements GraphExplorationAlgorithm {

	@Override
	public void execute(int[][] G, int[] visited) {
		
		LinkedList<Integer> Q = new LinkedList<Integer>();
		//root is always 0
		Q.push(0);
		boolean[] D = new boolean[G.length];
		D[0] = true;
		
		while(!Q.isEmpty()) 
		{
			int vertex = Q.pollLast();
			/* do something with vertex - here increase count for testing */
			visited[vertex]++;
			/* do something with vertex */
			for (int i = 0; i < G[vertex].length; i++) {
				int w = G[vertex][i];
				if(!D[w]) 
				{
					Q.push(w);
					D[w] = true;
				}
			}
		}
		
	}
}
