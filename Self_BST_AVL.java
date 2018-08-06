package algorithm;
class avl_node
{
	int key,height,num_element,max,add;
	avl_node left,right;
	avl_node(int d)
	{
		key=d;
		height=1;
		left=null;
		right=null;
		num_element = 1;
		max = 0;
		add = 0;
		
	}
}
public class Self_BST_AVL {
	avl_node root;
	int height(avl_node a)
	{
		if(a==null)
		{
			return 0;
		}
		else
			return a.height;
	}
	int max(int a,int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
	int max(avl_node x)
	{
		int a=0,b=0;
		if(x!=null)
		{
			a = x.max;
		}
		if(x!=null)
		{
			b = x.max;
		}
		return Math.max(a, b);
	}
	int find_max(avl_node x)
	{
		int c = 0;
		int d = 0;
		if(x.left!=null)
		{
			c = x.left.key;
		}
		if(x.right!=null)
		{
			d = x.right.key;
		}
		int a = Math.max(max(x.left), c);
		int b = Math.max(max(x.right), d);
		return Math.max(a, b);
	}
	avl_node Rightrotate(avl_node x)
	{
		
		avl_node y= x.left;
		avl_node t2 = y.right;
		y.right=x;
		x.left=t2;
		x.height=max(height(x.left),height(x.right)+1);
		y.height = max(height(y.left),height(y.right)+1);
		x.num_element = num_nodes(x.left)+num_nodes(x.right)+1;
		y.num_element = num_nodes(y.left)+num_nodes(y.right)+1;
		x.max = find_max(x);
		y.max = find_max(y);
		return y;
	}
	int num_nodes(avl_node x)
	{
		if(x==null)
		{
			return 0;
		}
		else
			return x.num_element;
	}
	avl_node Leftrotate(avl_node x)
	{
		//System.out.println("aaaaaaaaaaaaaa");

		avl_node y = x.right;
		avl_node t2 = y.left;
		y.left = x;
		x.right = t2;
		x.height=max(height(x.left),height(x.right)+1);
		y.height = max(height(y.left),height(y.right)+1);
		x.num_element = num_nodes(x.left)+num_nodes(x.right)+1;
		y.num_element = num_nodes(y.left)+num_nodes(y.right)+1;
		x.max = find_max(x);
		y.max = find_max(y);
		//System.out.println(x.num_element+" "+y.num_element);
		return y;
		
	}
	int getbalance(avl_node x)
	{
		if(x==null)
		{
			return 0;
		}
		else
			return height(x.left)-height(x.right);
	}
	avl_node insert(avl_node root,avl_node x)
	{
		//if(root!=null)
		//	System.out.println("a"+" "+root.key);
		if(root==null)
		{
			root=x;
		}
		if(x.key>root.key)
		{
			root.right = insert(root.right,x);
			
		}
		else if(x.key<root.key)
		{
			root.left = insert(root.left,x);
		}
		else
			return root;
		root.height = 1+max(height(root.left),height(root.right));
		//root.max = Math.max(root.key, w);
		root.num_element = num_nodes(root.right)+num_nodes(root.left)+1;
		//root.max_diff = max(max_diff(root.left),max_diff(root.right));
		//System.out.println("h"+root.height+" "+root.key);
		int getbal = getbalance(root);
		//System.out.println("a"+getbal+" "+root.key);
		if(getbal<-1 && (x.key>root.right.key))
		{
			//System.out.println(root.key+" "+root.num_element);
			return Leftrotate(root);
		}
		if(getbal>1 && (x.key<root.left.key))
		{
			return Rightrotate(root);
		}
		if(getbal<-1 && (x.key<root.right.key))
		{
			//System.out.println("xxxxxxxxxxx"+root.key);
			root.right = Rightrotate(root.right);
			return Leftrotate(root);
		}
		if(getbal>1 && (x.key>root.left.key))
		{
			root.left = Leftrotate(root.left);
			return Rightrotate(root);
		}
		else
		{
			//System.out.println("a");
			int a = 0,b = 0;
			if(root.left!=null)
			{
				a = root.left.num_element;
			}
			if(root.right!=null)
			{
				b = root.right.num_element;
			}
			//System.out.println(a+" "+b);
			root.num_element = Math.max(root.num_element,(a+b));
			root.max = find_max(root);
		}
		return root;
	}
	public avl_node insert(avl_node root2, int i) {
		// TODO Auto-generated method stub
		avl_node x = new avl_node(i);
		//System.out.println(root2.key);
		return insert(root2,x);
	}
	public avl_node delete(avl_node root,int key)
	{
		if(root==null)
		{
			return root;
		}
		if(key<root.key) {
			root.left = delete(root.left,key);
		}
		else if(key>root.key)
		{
			root.right = delete(root.right,key);
		}
		else
		{
			//System.out.println("aa"+root.key);
			if(root.left==null || root.right==null)
			{
				avl_node temp = null;
				if(root.left==null)
				{
					temp = root.right;
				}
				else
				{
					temp = root.left;
				}
				//System.out.println(temp.key);
				if(temp==null)
				{
					temp=root;
					root=null;
				}
				else
				{
					root = temp;
				}
			}
			else
			{
				avl_node temp = null;
				temp = minvalnode(root.right);
				root.key = temp.key;
				root.right = delete(root.right,temp.key);
			}
			
		}
		if(root==null)
		{
			return root;
		}
		root.height = 1+Math.max(height(root.left), height(root.right));
		root.num_element = num_nodes(root.right)+num_nodes(root.left)+1;
		root.max = find_max(root);
		//System.out.println(root.height+" "+root.key);
		int bal = getbalance(root);
		if(bal>1 && getbalance(root.left)>=0)
		{
			return Rightrotate(root);
		}
		if(bal>1 && getbalance(root.left)<0)
		{
			
			//System.out.println("dd"+root.left.key+" "+getbalance(root.left)+" "+root.left.left.height+" "+root.left.right.height);
			//System.out.println(root.left.left.height+" "+root.left.left.left.height);
			root.left = Leftrotate(root.left);
			return Rightrotate(root);
		}
		if (bal < -1 && getbalance(root.right) <= 0)
            return Leftrotate(root);
 
        // Right Left Case
        if (bal < -1 && getbalance(root.right) > 0)
        {
            root.right = Rightrotate(root.right);
            return Leftrotate(root);
        }
        else
        {
    		root.num_element = num_nodes(root.right)+num_nodes(root.left)+1;
    		root.max = find_max(root);
        }
 
        return root;
	}
	private avl_node minvalnode(avl_node root) {
		// TODO Auto-generated method stub
		while(root.left!=null)
		{
			root=root.left;
		}
		return root;
	}

}
