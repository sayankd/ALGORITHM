package algorithm;

import java.util.Scanner;

public class test_graph_traverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		sc.close();
		graph_adj_mat x = new graph_adj_mat(V);
		x.add_edge(0, 1);
		x.add_edge(0, 2);
		x.add_edge(1, 2);
		x.add_edge(2, 0);
		x.add_edge(2, 3);
		x.add_edge(3, 3);
		graph_traverse l = new graph_traverse();
		//l.BFS(2, x.adjmat);
		l.DFS(2, x.adjmat);
		//l.DFS(2, x.adjmat);

	}

}
