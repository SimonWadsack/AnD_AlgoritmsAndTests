package MinimalSpanningTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import Interfaces.MinimalSpanningTreeAlgorithm;
import Utils.Edge;
import Utils.Utils;

public class Prim implements MinimalSpanningTreeAlgorithm {

	@Override
	public Edge[] execute(int V, Edge[] E) {
		
		LinkedList<Integer> H = new LinkedList<Integer>();
		H.add(0);
		
		//modified Dijkstra
		int[] dijDist = new int[V];
		for (int i = 0; i < dijDist.length; i++) {
			dijDist[i] = Utils.INF;
		}
		dijDist[0] = 0;
		
		Set<Integer> settled = new HashSet<>();
		
		int[] parent = new int[V];
		Arrays.fill(parent, -1);
		
		while (!H.isEmpty()) {
			int v = Utils.extractMin(H, dijDist);
			settled.add(v);
			for (int i = 0; i < E.length; i++) {
				Edge e = E[i];
				if(e.source == v && !settled.contains(e.destination)) 
				{
					dijDist[e.destination] = Math.min(dijDist[e.destination], e.weight);
					if(!H.contains(e.destination)) H.add(e.destination);
					parent[e.destination] = v;
				}
				
				if(e.destination == v && !settled.contains(e.source)) 
				{
					dijDist[e.source] = Math.min(dijDist[e.source], e.weight);
					if(!H.contains(e.source)) H.add(e.source);
					parent[e.source] = v;
				}
			}
		}
		
		//Recreate MST with parents
		Edge[] tree = new Edge[V-1];
		
		int index = 0;
		
		for (int i = 0; i < parent.length; i++) {
			if(parent[i] == -1) continue;
			//assume only one edge between two nodes exists for simplicity
			for (int j = 0; j < E.length; j++) {
				Edge e = E[j];
				if((e.destination == i && e.source == parent[i]) || (e.source == i && e.destination == parent[i])) 
				{
					tree[index] = e;
					index++;
				}
			}
		}
		
		return tree;
	}

}
