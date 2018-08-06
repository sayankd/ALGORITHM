package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class graph_traverse {
	public boolean[] BFS(int s,int[][] adjmat)
	{
		//System.out.println("aa");
		boolean[] visited = new boolean[adjmat[0].length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		while(q.size()!=0)
		{
			int st = (int) q.poll();
			//System.out.println(st);
			for(int i=0;i<adjmat[st].length;i++)
			{
				if(adjmat[st][i]!=0 && visited[i]==false)
				{
					//System.out.print("aa"+i+" ");
					visited[i] = true;
					q.add(i);
				}
			}
			
		}
		return visited;
	}
	public void DFS(int v,int[][] adjmat)
	{
		boolean[] visited = new boolean[adjmat[0].length];
		DFSUtil(v,adjmat,visited); //Recursive Version
		DFS_IT(v,adjmat,visited); //Iterative Version
	}
	private void DFSUtil(int v, int[][] adjmat, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[v] = true;
		System.out.println(v+" ");
		for(int i=0;i<adjmat[v].length;i++)
		{
			if(visited[i]==false && adjmat[v][i]==1)
			{
				DFSUtil(i,adjmat,visited);
			}
		}
		
	}
	private void DFS_IT(int v,int[][] adjmat,boolean[] visited)
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(v);
		visited[v] = true;
		while(s.isEmpty()!=true)
		{
			v = s.pop();
			visited[v] = true;
			System.out.println(v+" ");
			for(int i=0;i<adjmat[v].length;i++)
			{
				if(visited[i]==false && adjmat[v][i]==1)
				{
					//System.out.println("a"+i);
					s.push(i);
				}
			}
		}
	}
	
}
