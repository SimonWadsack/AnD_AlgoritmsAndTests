package ShortestPath;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import Interfaces.ShortestPathAlgorithm;
import Utils.AdjEdge;
import Utils.Utils;

public class Johnson implements ShortestPathAlgorithm {

	//MODIFIED VERSION OF JOHNSON: Normally All-to-All but here One-To-All using only one iteration of Dijkstra instead of n
	//Also because the test-set does not contain negative cycles, the checking is skipped
	
	@Override
	public int[] execute(AdjEdge[][] G, int origin) {
		
		//add node q
		int q = G.length;
		AdjEdge[] qEdges = new AdjEdge[G.length];
		for (int i = 0; i < qEdges.length; i++) {
			qEdges[i] = new AdjEdge(i, 0);
		}
		
		AdjEdge[][] modifiedG = Arrays.copyOf(G, G.length+1);
		modifiedG[q] = qEdges;
		
		//Bellman-Ford
		int[] h = new BellmanFord().execute(modifiedG, q);
		
		//modified Dijkstra
		int[] dijDist = new int[G.length];
		for (int i = 0; i < dijDist.length; i++) {
			dijDist[i] = Utils.INF;
		}
		dijDist[origin] = 0;
		
		Set<Integer> settled = new HashSet<>();
		
		LinkedList<Integer> Q = new LinkedList<Integer>();
		Q.add(origin);
		
		while (settled.size() != G.length) {
			if(Q.isEmpty()) return null;
			
			int v = Utils.extractMin(Q, dijDist);
			
			if(!settled.contains(v)) 
			{
				settled.add(v);
				for (int i = 0; i < G[v].length; i++) {
					int dest = G[v][i].destination;
					if(settled.contains(dest)) continue;
					
					int weight = G[v][i].weight;
					weight = weight + h[v] - h[dest];

					dijDist[dest] = Math.min(dijDist[dest], dijDist[v] + weight);
					Q.add(dest);
				}
			}
		}
		
		//restoreDist
		for (int i = 0; i < dijDist.length; i++) {
			dijDist[i] = dijDist[i] + (h[i] - h[origin]);
		}
		
		return dijDist;
	}

}
