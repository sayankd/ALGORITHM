package algorithm;

public class graph_cycle {
	public boolean isCyclic(int[][]adjmat)
	{
		int V = adjmat[0].length;
		boolean[] visited = new boolean[adjmat[0].length];
		boolean[] instack = new boolean[adjmat[0].length];
		for(int i=0;i<V;i++)
		{
			visited[i] = false;
			instack[i] = false;
		}
		for(int i=0;i<1;i++)
		{
			//System.out.println("aa");
			if(isCycleCheck(i,visited,instack,adjmat)==true)
			{
				return true;
			}
		}
		return false;
	}

	private boolean isCycleCheck(int v, boolean[] visited, boolean[] instack,int[][] adjmat) {
		// TODO Auto-generated method stub
		//System.out.println(adjmat[v][1]);
		int V = adjmat[0].length;
		if(visited[v] == false)
		{
			//System.out.println("bb");
			visited[v] = true;
			instack[v] = true;
			for(int i=0;i<V;i++)
			{
				if(adjmat[v][i]==1 && visited[i]==false)
				{
					isCycleCheck(i, visited, instack, adjmat);
				}
				else if(adjmat[v][i]==1 && visited[i]==true && instack[i] == true && i!=v)
				{
					return true;
				}
			}
		}
		instack[v] = false;
		return false;
	}
	

}
