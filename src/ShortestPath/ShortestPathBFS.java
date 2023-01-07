package ShortestPath;

import java.util.LinkedList;

import Interfaces.UnweightedShortestPathAlgorithm;

public class ShortestPathBFS implements UnweightedShortestPathAlgorithm{

	public int[] execute(int[][] G,  int origin) {
		
		int[] shortestPaths = new int[G.length];
		for (int i = 0; i < shortestPaths.length; i++) {
			//Cannot reach any vertex
			shortestPaths[i] = -1;
		}
		
		LinkedList<Integer> Q = new LinkedList<Integer>();
		Q.push(origin);
		boolean[] D = new boolean[G.length];
		D[origin] = true;
		shortestPaths[origin] = 0;
		
		while(!Q.isEmpty()) 
		{
			int vertex = Q.pollLast();
			for (int i = 0; i < G[vertex].length; i++) {
				int w = G[vertex][i];
				if(!D[w]) 
				{
					Q.push(w);
					D[w] = true;
					shortestPaths[w] = shortestPaths[vertex] + 1;
				}
			}
		}
		
		return shortestPaths;
	}

}
