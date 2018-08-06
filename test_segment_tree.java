package algorithm;

import java.util.Scanner;

public class test_segment_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		sc.close();
		Segment_Tree x = new Segment_Tree(arr);
		x.build_tree(x.root, 0, n-1);
		System.out.println(x.minquery(x.root, 1, 1, 0, n-1));
		//inorder(x.root);
	}
	public static void inorder(segment_node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.println(root.min);
			inorder(root.right);
		}
	}

}
