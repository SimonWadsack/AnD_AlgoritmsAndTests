package ShortestPath;

import Interfaces.ShortestPathAlgorithm;
import Utils.AdjEdge;
import Utils.Utils;

public class FloydWarshall implements ShortestPathAlgorithm {

	@Override
	public int[] execute(AdjEdge[][] G, int origin) {
		
		//Normally all-to-all which is computed here, returns only origin-to-all
		
		int[][][] sp = new int[G.length][G.length][G.length];
		
		//Init for k = 0
		for (int i = 0; i < sp.length; i++) {
			for (int j = 0; j < sp.length; j++) {
				sp[i][j][0] = i == j ? 0 : getWeight(j, G[i]);
			}
		}
		
		for (int k = 1; k < G.length; k++) {
			for (int i = 0; i < G.length; i++) {
				for (int j = 0; j < sp.length; j++) {
					sp[i][j][k] = Math.min(sp[i][j][k-1], sp[i][k][k-1] + sp[k][j][k-1]);
				}
			}
		}
		
		int[] result = new int[G.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = sp[origin][i][G.length-1];
		}
		return result;
	}
	
	int getWeight(int j, AdjEdge[] edges)
	{
		for (int i = 0; i < edges.length; i++) {
			if(edges[i].destination == j) return edges[i].weight;
		}
		
		//Represents Infinity
		return Utils.INF;
	}

}
