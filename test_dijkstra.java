package algorithm;

import java.util.Random;

public class test_dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph1 = take_input(10);
		
		/*shortest_path sp = new shortest_path();
		sp.dijkstra(graph, 0);*/
		graph_traverse l = new graph_traverse();
		boolean[] visit = l.BFS(0, graph1);
		int i;
		for(i=0;i<visit.length;i++)
		{
			if(visit[i]==false)
			{
				System.out.println("-1");
				break;
			}
		}
		if(i==visit.length)
		{
		test_2 x = new test_2();
		System.out.println(x.find_node(graph1));
		}
		

	}

	private static int[][] take_input(int n) {
		// TODO Auto-generated method stub
		//n = 10000
		Random rn = new Random();
		int[][] graph = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				graph[i][j] = Math.abs(rn.nextInt()%10);
			}
		}
		return graph;
	}

}
