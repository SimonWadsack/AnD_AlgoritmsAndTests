package Utils;

public class AdjEdge
{
	public int destination;
	public int weight;
	
	public AdjEdge(int d, int w) {
		destination = d;
		weight = w;
	}
	
	@Override
	public String toString() {
		return "(" + destination + ", w:" + weight + ")";
	}
}