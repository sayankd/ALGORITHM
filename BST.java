package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	Node_BST root;
	BST()
	{
		root = null;
	}
	public Node_BST insert(Node_BST x)
	{
		return InsertBST(root,x);
	}
	public Node_BST InsertBST(Node_BST root,Node_BST x)
	{
		if(this.root==null)
		{
			//System.out.println("cc");
			this.root = x;
			this.root.rank = 0;
		}
		if(root==null)
		{
			//System.out.println("aa");
			x.parent = root;
			root = x;
			//this.root = x;
		}
		else if(x.data>root.data)
		{
			//System.out.println("dd");
			Node_BST r = InsertBST(root.right,x);
			root.right = r;
			r.parent = root;
			if(root.right!=null)
			{
			root.rank = root.right.rank+1;
			}
		}
		else
		{
			Node_BST s = InsertBST(root.left,x);
			root.left = s;
			if(root.right!=null)
			{
			root.rank = root.right.rank+1;
			}
			s.parent = root;
		}
		return root;
	}
	public void SearchBST(int key)
	{
		//System.out.println(SearchBST(root,key).data);
		Node_BST z = SearchBST(root,key);
		System.out.println(z.data);
	}
	public Node_BST SearchBST(Node_BST root,int key)
	{
		//System.out.println(root);
		if(root==null)
		{
			System.out.println("Not Found");
			return null;
		}
		if(root.data==key)
		{
			
			System.out.println("Found"+" "+root.data);
			return root;
		}
		else if(root.data<key)
		{
			return SearchBST(root.right,key);
		}
		else
			return SearchBST(root.left,key);
		//System.out.println("Not Found");
		//return null;
	}
	public void inorderhelp()
	{
		inorder(this.root);
	}
	public void inorder(Node_BST root)
	{
		//System.out.println("bb");
		//System.out.println(root.data);
		if(root!=null)
		{
			//System.out.println(root.data+" "+root.right.data);
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
	public void predecessor(int key)
	{
		Node_BST x = SearchBST(root,key);
		System.out.println(predecessor(x).data);
	}
	public Node_BST predecessor(Node_BST root)
	{
		if(root.left!=null)
		{
			Node_BST x = root.left;
			while(x.right!=null)
			{
				x = x.right;
			}
			return x;
		}
		else
		{
			Node_BST x = root;
			Node_BST y = x.parent;
			while(y.left==x && y!=null)
			{
				x = y;
				y = x.parent;
			}
			return y;
		}
	}
	public void Successor(int key)
	{
		Node_BST x = SearchBST(root,key);
		System.out.println(Successor(x).data);
	}
	public Node_BST Successor(Node_BST root)
	{
		if(root.right!=null)
		{
			Node_BST x = root.right;
			while(x.left!=null)
			{
				x = x.left;
			}
			return x;
		}
		else
		{
			
			Node_BST x = root;
			Node_BST y = x.parent;
			while(y!=null && y.right==x)
			{
				x = y;
				y = x.parent;
			}
			return y;
		}
	}
	public int height(Node_BST root)
	{
		if(root==null)
			return 0;
		else
		{
			return 1+Math.max(height(root.left), height(root.right));
		}
	}
	public int count_nodeshelp()
	{
		return count_nodes(root);
	}
	public int count_nodes(Node_BST root)
	{
		if(root==null)
		{
			return 0;
		}
		int l = count_nodes(root.left);
		int r = count_nodes(root.right);
		return l+r+1;
	}
	public int findmedian(int k)
	{
		return findmedian(root,k).data;
	}
	public Node_BST findmedian(Node_BST root,int k)
	{
		//System.out.println(root.data+" "+k);
		if(count_nodes(root.left)>k)
		{
			return findmedian(root.left,k);
		}
		else if(count_nodes(root.left)+1==k)
		{
			return root;
		}
		else
		{
			
			return findmedian(root.right,k-(count_nodes(root.left)+1));
		}
	}
	public Node_BST lowest_ancestor(Node_BST root,int a,int b)
	{
		if(root.data<a && root.data>b)
		{
			return root;
		}
		else if(root.data==a || root.data==b)
		{
			return root;
		}
		else if(root.data>a && root.data>b)
		{
			return lowest_ancestor(root.left, a, b);
		}
		else
			return lowest_ancestor(root.right, a, b);
	}
	public int caller()
	{
		level_traversal(root);
		return 0;
	}
	public void level_traversal(Node_BST root)
	{
		Queue<Node_BST> x = new LinkedList<Node_BST>();
		Node_BST temp;
		x.add(root);
		while(x.isEmpty()==false)
		{
			temp = x.poll();
			System.out.println(temp.data);
			if(temp.left!=null)
			{
				x.add(temp.left);
			}
			if(temp.right!=null)
			{
				x.add(temp.right);
			}
		}
		
		
	}

}
