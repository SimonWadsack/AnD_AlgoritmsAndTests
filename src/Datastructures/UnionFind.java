package Datastructures;

import java.util.Arrays;

public class UnionFind {
	
	private int[] rep;
	
	public void make(int V) 
	{
		rep = new int[V];	
		for (int i = 0; i < V; i++) {
			rep[i] = i;
 		}
	}
	
	public boolean same(int u, int v)
	{
		return rep[u] == rep[v];
	}
	
	public void union(int u, int v) 
	{
		if(same(u, v)) return;
		
		int replace = rep[u];
		
		for (int i = 0; i < rep.length; i++) {
			if(rep[i] == replace)
			{
				rep[i] = rep[v];
			}
		}
		
	}
	
	@Override
	public String toString() {
		return Arrays.toString(rep);
	}
	
}
