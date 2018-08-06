package algorithm;

public class test_mst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   int graph[][] = new int[][] {{0, 2, 0, 6, 0},
	                                {2, 0, 3, 8, 5},
	                                {0, 3, 0, 0, 7},
	                                {6, 8, 0, 0, 9},
	                                {0, 5, 7, 9, 0},
	                               };
	   min_span_tree x = new min_span_tree();
	   x.mst_tree(graph);

	}

}
