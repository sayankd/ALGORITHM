package algorithm;

import java.util.Scanner;

public class test_topology_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int V = 6;
		sc.close();
		graph_adj_mat g = new graph_adj_mat(V);
		 g.add_edge(5, 2);
	     g.add_edge(5, 0);
	     g.add_edge(4, 0);
	     g.add_edge(4, 1);
	     g.add_edge(2, 3);
	     g.add_edge(3, 1);
		 topology_sort x = new topology_sort();
		 int[] arr;
		 arr = x.topology_sort_func(g.adjmat);
		 for(int i = 0;i<arr.length;i++)
		 {
			 System.out.println(arr[i]);
		 }

	}

}
