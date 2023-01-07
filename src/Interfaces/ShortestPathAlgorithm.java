package Interfaces;

import Utils.AdjEdge;

public interface ShortestPathAlgorithm {
	public int[] execute(AdjEdge[][] G, int origin);
}
