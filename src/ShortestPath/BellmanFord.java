package ShortestPath;

import Interfaces.ShortestPathAlgorithm;
import Utils.AdjEdge;
import Utils.Utils;

public class BellmanFord implements ShortestPathAlgorithm {

	@Override
	public int[] execute(AdjEdge[][] G, int origin) {
		
		int distance[] = new int[G.length];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Utils.INF;
		}
		distance[origin] = 0;
		
		//RELAX EDGES |V|-1 times
		for(int i = 1; i < G.length; i++) 
		{
			
			//Go through all edges
			for (int src = 0; src < G.length; src++) {
				if(G[src].length == 0) continue;
				for (int e = 0; e < G[src].length; e++) {
					int dest = G[src][e].destination;
					int weight = G[src][e].weight;
					
					if(distance[src] != Utils.INF && distance[src] + weight < distance[dest]) 
					{
						distance[dest] = distance[src] + weight;
					}
				}
			}
			
			
		}
		
		return distance;
	}

}
