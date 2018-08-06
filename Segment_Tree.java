package algorithm;

class segment_node
{
	int max,min;
	segment_node left,right;
}
class Segment_Tree
{
	int[] arr;
	segment_node root;
	Segment_Tree(int[] x)
	{
		this.arr = x;
		this.root = new segment_node();
	}
	public void build_tree(segment_node root,int l,int h)
	{
		if(l>h)
		{
			return;
		}
		if(l==h)
		{
			root.max = arr[l];
			root.min = arr[l];
			root.left = root.right = null;
		}
		else
		{
			//System.out.println(root);
			root.left = new segment_node();
			root.right = new segment_node();
			int m = (l+((h-l)/2));
			build_tree(root.left,l,m);
			build_tree(root.right,m+1,h);
			root.min = root.left.min+root.right.min;
			root.max = Math.max(root.left.max, root.right.max);
		}
		
	}
	public int minquery(segment_node root,int l,int r,int s,int e)
	{
		if(l>r)
			return 0;
		if(l==s && r==e)
		{
			//System.out.println("aa");
			return root.min;
		}
		int mid = s+(e-s)/2;
		//System.out.println(mid);
		if(r<=mid)
		{
			return minquery(root.left,l,r,s,mid);
		}
		else if(l>mid)
		{
			return minquery(root.right,l,r,mid+1,e);
		}
		else
		{
			return Math.min(minquery(root.left, l, mid, s, mid), minquery(root.right, mid+1, r, mid+1, e));
		}
	}
	
}
