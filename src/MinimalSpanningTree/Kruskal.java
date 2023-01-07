package MinimalSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Datastructures.UnionFind;
import Interfaces.MinimalSpanningTreeAlgorithm;
import Utils.Edge;

public class Kruskal implements MinimalSpanningTreeAlgorithm {

	@Override
	public Edge[] execute(int V, Edge[] E) {
		
		List<Integer> edges = new ArrayList<Integer>();
		
		Arrays.sort(E);
		
		UnionFind uf = new UnionFind();
		uf.make(V);
		
		for (int i = 0; i < E.length; i++) {
			Edge e = E[i];
			if(uf.same(e.source, e.destination)) continue;
			
			edges.add(i);
			uf.union(e.source, e.destination);
		}
		
		Edge[] tree = new Edge[edges.size()];
		
		//Build Edges Array
		for (int i = 0; i < edges.size(); i++) {
			tree[i] = E[edges.get(i)];
		}
		
		return tree;
	}

}
