package algorithm;

import java.util.List;
import java.util.Stack;

public class Test_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST x = new BST();
		x.insert(new Node_BST(20));
		x.insert(new Node_BST(8));
		x.insert(new Node_BST(32));
		x.insert(new Node_BST(4));
		x.insert(new Node_BST(12));
		x.insert(new Node_BST(10));
		x.insert(new Node_BST(14));		
		//System.out.println(x.root.data);
		x.inorderhelp();
		//static int int 
		int c = 0;
		
		//System.out.println("aa"+x.root.rank);
		//System.out.println("aa"+x.count_nodeshelp());
		//System.out.println("bb"+x.findmedian(5));
		//preorder(x.root);
		count p = new count();
		kthsmall(x.root,p);

	}
	public static int kthsmall(Node_BST root,count p)
	{
		

		
		if(root==null)
			return 0;
		//System.out.println(root.data+" "+c);
		kthsmall(root.right,p);
		//System.out.println(root.data+" "+c);
		p.c++;
		if(p.c<=3)
		{
			p.sum = p.sum+root.data;
			System.out.println("aa"+p.sum);
		}
		if(p.c>3)
		{
			//System.out.println(p.sum);
			return p.sum;
		}
		kthsmall(root.left,p);
		return 0;
	}
	
}
class count
{
	int c=0;
	int sum = 0;
}