package algorithm;
//true for Red false for Black
class RB_tree {
	int blackheight;
	RB_node root;
	RB_tree()
	{
		blackheight = 0;
		root=null;
	}
	
	public RB_node insert(RB_node root,RB_node x)
	{
		RB_node l = root;
		if(root==null)
		{
			//System.out.println("a");
			x.color = color('b');
			root = x;
			return root;
		}
		else
		{
			x.color = color('r');
			root = BSTInsert(root,x);
			
		}
		
		//RB_node p = x.parent;
		while(root.key!=x.key)
		{
			if(root.key<x.key)
			{
				root = root.right;
			}
			else
			{
				root = root.left;
			}
		}
		root = l;
		if(color(x.parent)!='b')
		{
			//System.out.println("aaa");
			root = fixviolation(this.root,x);
		}
		//System.out.println("zz"+this.root.key+this.root.left.key);
		return root;
		
		
	}
	private RB_node left_left(RB_node g)
	{
		RB_node p = g.left;
		RB_node u = g.right;
		RB_node x = p.left;
		RB_node a1 = p.right;
		p.parent = null;
		p.left = x;
		x.parent = p;
		p.right = g;
		g.parent = p;
		g.left = a1;
		if(a1!=null)
		{
			a1.parent = g;
		}
		p.color = color('b');
		g.color = color('r');
		return p;
	}
	private RB_node left_right(RB_node g)
	{
		RB_node p = g.left;
		RB_node u = g.right;
		RB_node x = p.right;
		RB_node a1 = x.left;
		RB_node a2 = x.right;
		g.left = a2;
		g.right = u;
		u.parent = g;
		p.right = a1;
		x.left = p;
		p.parent = x;
		x.right = g;
		g.parent = x;
		if(a1!=null)
				a1.parent = p;
		if(a2!=null)
				a2.parent = g;
		g.color = color('r');
		x.color = color('b');
		x.parent = null;
		return x;
	}
	private RB_node right_right(RB_node g)
	{
		RB_node p = g.right;
		RB_node u = g.left;
		RB_node x = p.right;
		RB_node a1 = p.left;
		g.right = a1;
		if(a1!=null)
		{
			a1.parent = g;
		}
		p.left = g;
		g.parent = p;
		p.right = x;
		x.parent = p;
		p.parent = null;
		g.color = color('r');
		p.color = color('b');
		return p;
	}
	private RB_node right_left(RB_node g)
	{
		RB_node p = g.right;
		RB_node u = g.left;
		RB_node x = p.left;
		RB_node a1 = x.left;
		RB_node a2 = x.right;
		g.right = a1;
		if(a1!=null)
		{
			a1.parent = g;
		}
		p.left = a2;
		if(a2!=null)
		{
			a2.parent = p;
		}
		x.left = g;
		g.parent = x;
		x.right = p;
		p.parent = x;
		x.color = color('b');
		g.color = color('r');
		//p.color = color('r');
		x.parent = null;
		return x;
		
	}
	private RB_node fixviolation(RB_node root, RB_node x) {
		// TODO Auto-generated method stub
		//System.out.println("bbbb"+root.key+" "+root.right.key+" "+root.right.right.key);
		if(x.parent==null)
		{
			x.color = color('b');
			return root;
		}
		//RB_node l = root;
		while(root.key!=x.key)
		{
			if(root.key<x.key)
			{
				root = root.right;
			}
			else
			{
				root = root.left;
			}
		}
		x = root;
		RB_node p = x.parent;
		RB_node g = p.parent;
		RB_node u=null;
		if(g.key>x.key)
			u = g.right;
		else
			u = g.left;
		RB_node l = g.parent;
		if(color(u)=='r')
		{
			//System.out.println("aaaa"+u.key);
			g = recolor(g);
			x = g;
			root = fixviolation(this.root,x);
			//System.out.println("aaa"+color(g)+" "+color(p)+" "+color(u));
		}
		else if(color(u)=='b' && x.key<p.key && x.key<g.key)
		{
			g = left_left(g);
			//System.out.println("aa");
			if(l!=null)
			{
			if(l.key>g.key)
			{
				l.left = g;
			}
			else
				l.right = g;
			}
			g.parent = l;
			
		}
		else if(color(u)=='b' && x.key>p.key && x.key<g.key)
		{
			g = left_right(g);
			if(l!=null)
			{
			if(l.key>g.key)
			{
				l.left = g;
			}
			else
				l.right = g;
			}
			g.parent = l;
		}
		else if(color(u)=='b' && x.key>p.key && x.key>g.key)
		{
			g = right_right(g);
			if(l!=null)
			{
			if(l.key>g.key)
			{
				l.left = g;
			}
			else
				l.right = g;
			}
			g.parent = l;
		}
		else if(color(u)=='b' && x.key<p.key && x.key>g.key)
		{
			g = right_left(g);
			if(l!=null)
			{
			if(l.key>g.key)
			{
				l.left = g;
			}
			else
				l.right = g;
			}
			g.parent = l;
		}
		
		root = g;
		//System.out.println("bb"+root.parent);
		while(root.parent!=null)
		{
			//System.out.println("xx"+root.key);
			root = root.parent;
		}
		//System.out.println("yy"+root.key);
		return root;
	}

	private RB_node recolor(RB_node g) {
		// TODO Auto-generated method stub
		g.color = color('r');
		g.left.color = color('b');
		g.right.color = color('b');
		return g;
	}

	private RB_node BSTInsert(RB_node root,RB_node x) {
		// TODO Auto-generated method stub
		//System.out.println(x.key+" "+root.key);
		RB_node p=root;
		while(root!=null)
		{
			if(root.key>x.key)
			{
				p = root;
				root = root.left;
			}
			else
			{
				p = root;
				root = root.right;
			}
		}
		
		//root.parent = p;
		root = x;
		if(root.key>p.key)
		{
			p.right = root;
		}
		else
			p.left = root;
		root.parent = p;
		
		//System.out.println(this.root.key+" "+p.key);
		
		return this.root;
		
	}

	public boolean color(char c)
	{
		if(c=='r')
			return true;
		else
			return false;
	}
	public char color(RB_node x)
	{
		if(x==null)
		{
			return 'b';
		}
		if(x.color==true)
			return 'r';
		else
			return 'b';
	}
	public void preorder(RB_node root)
	{
		if(root!=null)
		{
			System.out.println(root.key+" "+color(root));
			preorder(root.left);
			preorder(root.right);
		}
		
	}
	
	
}
