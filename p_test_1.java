package algorithm;

import java.util.Scanner;

public class p_test_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new  Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		//int[] arr2 = new int[n];
		Self_BST_AVL tree = new Self_BST_AVL();
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			tree.root = tree.insert(tree.root, arr[i]);
		}
		//System.out.println(tree.root.left.key);
		while(m-->0)
		{
			int p = sc.nextInt();
			int q = sc.nextInt();
			query(arr[p],arr[q],tree.root);
			find_max(p,q,tree.root,arr);
		}

	}
	public static void query(int x,int y,avl_node root)
	{
		while(root!=null)
		{
			System.out.println(root.key);
			if((root.key> x) && (root.key>y))
			{
				root = root.left;
			}
			else if((root.key<x) & (root.key<y))
			{
				root = root.right;
			}
			else 
				break;
		}
		avl_node p = root;
		avl_node q = root;
		if(p.key==x)
		{
			p.add+=1;
		}
		else
		{
		while(p.key!=x)
		{
			if(p.key>x)
			{
				if(p.right!=null)
				{
					p.right.add +=1;
				}
				p = p.left;
			}
			else
				p = p.right;
		}
		}
		System.out.println(p.key+" "+q.key);
		if(q.key==y)
		{
			q.add+=1;
		}
		else
		{
		while(q.key!=y)
		{
			if(q.key<y)
			{
				if(q.left!=null)
				{
					q.left.add+=1;
				}
				q = q.right;
			}
			else
			{
				q = q.left;
			}
		}
		}
	}
	public static void find_max(int x,int y,avl_node root,int[] arr)
	{
		int max = find(arr[x],root);
		for(int i = x+1;i<=y;i++)
		{
			if(find(arr[i],root)>max)
			{
				max = arr[i];
			}
		}
		System.out.println(max);
		
		
	}
	private static int find(int p, avl_node root) {
		// TODO Auto-generated method stub
		int max = 0;
		if(root.key==p)
		{
			max = max+root.add;
		}
		else
		{
		while(root.key!=p)
		{
			if(root.key>p)
			{
				max += root.add;
				root = root.left;
			}
			else
			{
				max = max+root.add;
				root = root.right;
			}
		}
		}
		return max;
	}
	

}
