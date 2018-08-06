package algorithm;

public class min_span_tree {
	private static final int INT_MAX = 9999999;

	public void mst_tree(int[][]adjmat)
	{
		int V = adjmat[0].length;
		int[] parent = new int[V];
		int[] key = new int[V];
		boolean[] mstset = new boolean[V];
		heap_m pq = new heap_m(V);
		for(int i = 0;i<V;i++)
		{
			key[i] = INT_MAX;
			mstset[i] = false;
			pq.insert_key(new heap_node(i,key[i]));
		}
		key[0] = 0;
		parent[0] = -1;
		pq.decrease_key(0, new heap_node(0,0));
		for(int i = 0;i<V-1;i++)
		{
			heap_node u = pq.extract_min();
			mstset[u.v] = true;
			for(int j = 0;j<V;j++)
			{
				if(adjmat[u.v][j]!=0 && mstset[j]==false && adjmat[u.v][j]<key[j])
				{
					parent[j] = u.v;
					key[j] = adjmat[u.v][j];
					pq.decrease_key(j, new heap_node(j,adjmat[u.v][j]));
				}
			}
		}
		for(int i = 1;i<V;i++)
		{
			System.out.println("edge: "+parent[i]+"-"+i+":"+adjmat[i][parent[i]]);
		}
	}
	

}
