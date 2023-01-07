package Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

	//Represents infinite weight for our graphs
	public static final int INF = 123456;
	
	public static void printArray(int[] A) 
	{
		System.out.println(java.util.Arrays.toString(A));
	}
	
	public static void printArray(int[][] A) 
	{
		System.out.println(java.util.Arrays.deepToString(A));
	}
	
	public static void printArray(AdjEdge[][] A) 
	{
		System.out.println(java.util.Arrays.deepToString(A));
	}
	
	public static boolean equalArrays(int[] expected, int[] actual) 
	{
		if(expected.length != actual.length) return false;
		
		for(int i = 0; i < expected.length; i++) 
		{
			if(expected[i] != actual[i]) return false;
		}
		
		return true;
	}
	
	public static boolean equalMSTs(Edge[] expected, Edge[] actual) 
	{
		if(expected.length != actual.length) return false;
		
		Set<Integer> indices = new HashSet<Integer>();
		
		for (int i = 0; i < expected.length; i++) {
			boolean found = false;
			for (int j = 0; j < actual.length; j++) {
				if(indices.contains(j)) continue;
				
				if(expected[i].equals(actual[j])) 
				{
					found = true;
					indices.add(j);
				}
			}
			
			if(!found) return false;
		}
		
		return true;
		
	}
	
	public static boolean isSorted(int[] A) 
	{
		for(int i = 1; i < A.length; i++) 
		{
			if(A[i-1] > A[i]) return false;
		}
		
		return true;
	}
	
	public static int getMaximum(int[] A) 
	{
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if(max < A[i]) max = A[i];
		}
		return max;
	}
	
	public static int getMinimum(int[] A) 
	{
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if(min > A[i]) min = A[i];
		}
		return min;
	}
	
	public static int[] normalize(int[] A, int min) 
	{
		for (int i = 0; i < A.length; i++) {
			A[i] += Math.abs(min);
		}
		
		return A;
	}
	
	public static int[] restore(int[] A, int min) 
	{
		for (int i = 0; i < A.length; i++) {
			A[i] -= Math.abs(min);
		}
		
		return A;
	}
	
	public static Integer[] toIntArray(int[] A) 
	{
		Integer[] array = new Integer[A.length];
		
		for (int i = 0; i < A.length; i++) {
			array[i] = A[i];
		}
		
		return array;
	}
	
	public static int[] tointArray(List<Integer> list) 
	{
		int[] array = new int[list.size()];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		
		return array;
	}
	
	public static List<Integer> toIntList(int[] A)
	{
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			list.add(A[i]);
		}
		return list;
	}
	
	public static int[] concat(List<Integer> left, int p, List<Integer> right) 
	{
		int[] result = new int[left.size() + 1 + right.size()];
		for (int i = 0; i < left.size(); i++) {
			result[i] = left.get(i);
		}
		
		result[left.size()] = p;
		
		for (int i = 0; i < right.size(); i++) {
			result[left.size() + i + 1] = right.get(i);
		}
		
		return result;
	}
	
	public static int[] concat(List<Integer>[] lists, int length) 
	{
		if(length == -1) {
			length = 0;
			for (int i = 0; i < lists.length; i++) {
				length += lists.length;
			}
		}
		
		int[] result = new int[length];
		
		int index = 0;
		
		for (int i = 0; i < lists.length; i++) {
			for(int j = 0; j < lists[i].size(); j++)
			{
				result[index] = lists[i].get(j);
				index++;
			}
		}
		
		return result;
	}
	
	public static int extractMin(List<Integer> list, int[] distances) 
	{
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if(distances[list.get(i)] < distances[list.get(index)]) index = i;
		}
		
		return list.remove(index);
	}
	
}
