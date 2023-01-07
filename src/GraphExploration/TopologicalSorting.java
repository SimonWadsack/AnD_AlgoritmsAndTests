package GraphExploration;

import java.util.ArrayList;
import java.util.List;

import Interfaces.TopologicalSortingAlgorithm;
import Utils.Utils;

public class TopologicalSorting implements TopologicalSortingAlgorithm {
	
	@Override
	public int[] execute(int[][] G) 
	{
		List<Integer> topoSort = new ArrayList<Integer>();
		boolean[] D = new boolean[G.length];
		D[0] = true;
		topoSortDFS(0, G, D, topoSort);
		
		for (int i = 0; i < G.length; i++) {
			if(!D[i]) topoSortDFS(i, G, D, topoSort);
		}
		
		return Utils.tointArray(topoSort);
	}
	
	void topoSortDFS(int v, int[][] G, boolean[] D, List<Integer> T) 
	{
		for (int i = 0; i < G[v].length; i++) {
			int w = G[v][i];
			if(!D[w]) 
			{
				D[w] = true;
				topoSortDFS(w, G, D, T);
			}
		}
		T.add(v);
	}
	
}
