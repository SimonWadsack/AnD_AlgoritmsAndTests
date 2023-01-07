package Utils;


//can function as undirected and directed
public class Edge implements Comparable<Edge> {
	
	public int source;
	public int destination;
	public int weight;
	
	public Edge(int src, int dest, int w) 
	{
		source = src;
		destination = dest;
		weight = w;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Edge) {
			Edge other = (Edge)obj;
			return (source == other.source && destination == other.destination && weight == other.weight);
		}
		else 
		{
			return false;
		}	
	}
	
	@Override
    public int compareTo(Edge other)
    {
      return Integer.compare(this.weight, other.weight);
    }
	
	@Override
	public String toString() {
		return "(Edge: " + source + " - " + destination + " | " + weight + ")";
	}
	
}
