package ShortestPath;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import Interfaces.UnweightedShortestPathAlgorithm;
import Utils.Utils;

public class UnweightedDijkstra implements UnweightedShortestPathAlgorithm {

	//UNWEIGHTED: Yes, Dijkstra is normally for weighted graphs with non-negative weights, you can find such an 
    //			  implementation in Johnson's Algorithm, because the tests for the normal shortest paths contain negative weights
	//			  so this is the implementation for an unweighted graph (= all weights equal to 0).
	
	@Override
	public int[] execute(int[][] G, int origin) {
		
		int[] distance = new int[G.length];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Utils.INF;
		}
		distance[origin] = 0;
		
		Set<Integer> settled = new HashSet<>();
		
		LinkedList<Integer> Q = new LinkedList<Integer>();
		Q.add(origin);
		
		while(settled.size() != G.length) 
		{
			if(Q.isEmpty()) return null;
			
			int v = Utils.extractMin(Q, distance);
			
			if(!settled.contains(v)) 
			{
				settled.add(v);
				for (int i = 0; i < G[v].length; i++) {
					int w = G[v][i];
					if(settled.contains(w)) continue;
					
					distance[w] = Math.min(distance[w], distance[v] + 1);
					Q.add(w);
				}
			}
			
		}
		
		return distance;
	}

}
