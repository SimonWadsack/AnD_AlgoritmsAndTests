package MinimalSpanningTree;

import java.util.ArrayList;
import java.util.List;

import Datastructures.UnionFind;
import Interfaces.MinimalSpanningTreeAlgorithm;
import Utils.Edge;

public class Boruvka implements MinimalSpanningTreeAlgorithm {

	@Override
	public Edge[] execute(int V, Edge[] E) {
		
		List<Integer> edges = new ArrayList<Integer>();
		
		UnionFind uf = new UnionFind();
		uf.make(V);
		
		for (int t = 1; t < V && edges.size() < V; t=t+t) {
			
			int[] minimumEdge = new int[V];
			for (int i = 0; i < V; i++) {
				minimumEdge[i] = -1;
			}
			
			for (int i = 0; i < E.length; i++) {
				Edge e = E[i];
				if(uf.same(e.source, e.destination)) continue;
				
				if(minimumEdge[e.source] == -1) minimumEdge[e.source] = i;
				if(minimumEdge[e.destination] == -1) minimumEdge[e.destination] = i;
				
				int uWeight = E[minimumEdge[e.source]].weight;
				int vWeight = E[minimumEdge[e.destination]].weight;
				if(e.weight < uWeight) minimumEdge[e.source] = i;
				if(e.weight < vWeight) minimumEdge[e.destination] = i;
			}
			
			for (int i = 0; i < V; i++) {
				int eI = minimumEdge[i];
				if(eI == -1) continue;
				
				Edge e = E[eI];
				if(uf.same(e.source, e.destination)) continue;
				
				edges.add(eI);
				uf.union(e.source, e.destination);
			}
		}
		
		Edge[] tree = new Edge[edges.size()];
		
		//Build Edges Array
		for (int i = 0; i < edges.size(); i++) {
			tree[i] = E[edges.get(i)];
		}
		
		return tree;
	}

}
