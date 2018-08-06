package algorithm;

class transitive_closure_graph {
	public int[][] transitive_closure(int[][] adjmat)
	{
		int V = adjmat[0].length;
		int[][] reach = adjmat;
		/*for(int i = 0;i<V;i++)
		{
			for(int j = 0;j<V;j++)
			{
				reach[i][j] = adjmat[i][j];
			}
		}*/
		for(int k = 0;k<V;k++)
		{
			for(int i = 0;i<V;i++)
			{
				for(int j = 0;j<V;j++)
				{
					//reach[i][j] = reach[i][j]|(reach[i][k]&reach[k][j]);
					if((reach[i][k]+reach[k][j])<reach[i][j])
					{
						reach[i][j] = reach[i][k]+reach[k][j];
					}
					
				}
			}
		}
		return reach;
	}

}
