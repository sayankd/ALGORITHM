package algorithm;

public class test_2 {

		private static final int INT_MAX = 999999;

		public int find_node(int[][] adjmat)
		{
			int[] arr;
			int x=-1,res=INT_MAX;
			shortest_path sp = new shortest_path();
			int sum = 0;
			for(int i=0;i<adjmat[0].length;i++)
			{
				arr = sp.dijkstra(adjmat, i);
				for(int j=0;j<arr.length;j++)
				{
					sum = sum+arr[j];
				}
				System.out.println(sum);
				if(res>sum)
				{
					System.out.println(sum);
					res = sum;
					x = i;
				}
			}
			return x;

		}

}
