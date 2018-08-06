package algorithm;

import java.util.Stack;

public class topology_sort {
	public int[] topology_sort_func(int[][] adjmat)
	{
		Stack<Integer> st = new Stack<Integer>();
		int V = adjmat[0].length;
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++)
		{
			visited[i] = false;
		}
		for(int i=0;i<V;i++)
		{
			if(visited[i] == false)
			{
				topology_util(adjmat,visited,st,i);
			}
		}
		int[] arr = new int[V];
		for(int i = 0;i<V;i++)
		{
			arr[i] = st.pop();
		}
		return arr;
	}

	private void topology_util(int[][] adjmat, boolean[] visited, Stack<Integer> st, int v) {
		// TODO Auto-generated method stub
		visited[v] = true;
		int V = adjmat[0].length;
		for(int i = 0;i<V;i++)
		{
			if(adjmat[v][i]==1 && visited[i] == false)
			{
				topology_util(adjmat, visited, st, i);
			}
		}
		st.push(v);
	}

}
