package algorithm;
public class shortest_path {
	private static final int INT_MAX = 999999999;

	public int[] dijkstra(int[][] adjmat,int s)
	{
		int V = adjmat[0].length;
		boolean[] visited = new boolean[V];
		int[] parent = new int[V];
		int[] dist = new int[V];
		heap_m pq = new heap_m(V);
		for(int i = 0;i<V;i++)
		{
			heap_node x = new heap_node(i,INT_MAX);
			dist[i] = INT_MAX;
			parent[i] = -1;
			pq.insert_key(x);
		}
		dist[s] = 0;
		pq.decrease_key(s, new heap_node(s,0));
		//visited[s.v] = true;
		while(pq.heap_size!=0)
		{
			heap_node u = pq.extract_min();
			visited[u.v] = true;
			for(int i=0;i<V;i++)
			{
				if(adjmat[u.v][i]>0 && visited[i]==false && dist[i]>dist[u.v]+adjmat[u.v][i])
				{
					pq.decrease_key(i, new heap_node(i,(dist[u.v]+adjmat[u.v][i])));
					dist[i] = dist[u.v]+adjmat[u.v][i];
					parent[i] = u.v;
				}
			}
		}
		/*for(int i=0;i<V;i++)
		{
			System.out.println(dist[i]);
		}*/
		return dist;
		
	}

}
