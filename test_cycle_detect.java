package algorithm;

import java.util.Scanner;

public class test_cycle_detect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int V = 4;
		sc.close();
		graph_adj_mat g = new graph_adj_mat(V);
		 g.add_edge(0, 1);
		 g.add_edge(0, 2);
		 g.add_edge(1, 2);
		 g.add_edge(2, 0);
		 g.add_edge(2, 3);
		 g.add_edge(3, 3);
		 graph_cycle x = new graph_cycle();
		 System.out.println(x.isCyclic(g.adjmat));


	}	

}
