package algorithm;

public class Disjoint_Set {
	int[] rank,parent,size;
	int length;
	public  Disjoint_Set(int n)
	{
		this.length = n;
		rank = new int[n];
		parent = new int[n];
		size = new int[n];
		makeset();
	}
	private void makeset() {
		// TODO Auto-generated method stub
		for(int i=0;i<length;i++)
		{
			rank[i] = -1;
			parent[i] = -i;
			size[i] = -1;
		}
		
	}
	public int find(int x)
	{
		
		if(rank[x]<0 && parent[x]<0)
		{
			//System.out.println("bb"+x+" "+y);
			rank[x] = 1;
			parent[x] = x;
			size[x] = 1;
		}
		//System.out.println("a"+x+parent[x]);
		if(parent[x] == x)
		{
			//System.out.println("aa");
			
			//System.out.println("c"+y);
		}
		else
		{
			parent[x] = find(parent[x]);
		}
		//System.out.println("zz"+parent[x]);
		return parent[x];
	}
	public int union(int x,int y)
	{
		//System.out.println("aa"+rank[x]+" "+parent[x]);
		
		if(rank[x]<0 && parent[x]<0)
		{
			//System.out.println("bb"+x+" "+y);
			rank[x] = 1;
			parent[x] = x;
			size[x] = 1;
		}
		if(rank[y]<0 && parent[y]<0)
		{
			rank[y] = 1;
			parent[y] = y;
			size[y] = 1;
		}
		//System.out.println(parent[x]+" "+parent[y]);
		int xroot = find(x);
		int yroot = find(y);
		if(xroot == yroot)
		{
			//System.out.println("aa");
			return 0;
		}			
		if(rank[xroot]>rank[yroot])
		{
			parent[yroot] = xroot;
			size[xroot] = size[xroot]+size[yroot];
			size[yroot] = -1;
			return 1;
		}
		else if(rank[yroot]>rank[xroot])
		{
			parent[xroot] = yroot;
			size[yroot] = size[yroot]+size[xroot];
			size[xroot] = -1;
			return 1;
		}
		else
		{
			//System.out.println("aaa");
			parent[xroot] = yroot;
			//int l = find(4);
			//System.out.println("b"+l);
			//System.out.println(find(3)+" "+find(4)+" "+parent[4]);

			rank[yroot] = rank[yroot]+1;
			size[yroot] = size[yroot]+size[xroot];
			size[xroot] = -1;
			return 1;
		}
			
	}

}
