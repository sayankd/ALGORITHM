package algorithm;

import java.util.LinkedList;

	
	class graph_adj_list
	{
		int v;
		LinkedList<Integer>adjListarray[];
		@SuppressWarnings("unchecked")
		public graph_adj_list(int v)
		{
			this.v = v;
			this.adjListarray = new LinkedList[v];
			for(int i=0;i<v;i++)
			{
				adjListarray[i] = new LinkedList<Integer>();
			}
		}
		public void add_edge(int v,int w)
		{
			adjListarray[v].add(w);
			adjListarray[w].add(v);
		}
	}

class graph_adj_mat
{
	int v;
	int[][] adjmat;
	graph_adj_mat(int v)
	{
		this.v = v;
		adjmat = new int[v][v];
	}
	public void add_edge(int v,int w)
	{
		adjmat[v][w] = 1;
		//adjmat[w][v] = 1;
	}
}
