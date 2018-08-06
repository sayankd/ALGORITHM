package algorithm;

class node {
	int data;
	node prev;
	node next;
	node()
	{
		data = 0;
		prev = null;
		next = null;
	}

}
class Dequeue
{
	node f,r;
	Dequeue()
	{
		f = null;
		r = null;
	}
	public void add_rear(int x)
	{
		node a = new node();
		a.data = x;
		a.prev = null;
		a.next = null;
		if(r==null)
		{
			f = a;
			r = a;
		}
		else
		{
			r.next = a;
			a.prev = r;
			a.next = null;
			r = a;
		}
	}
	public int delete_rear()
	{
		node x=null;
		if(r!=null)
		{
			x = r;
			r = r.prev;
		}
		return x.data;
	}
	public void add_front(int x)
	{
		node a = new node();
		a.data = x;
		a.prev = null;
		a.next = null;
		if(f==null)
		{
			f = a;
			r = a;
		}
		else
		{
			f.prev = a;
			a.next = f;
			a.prev = null;
			f = a;
		}
	}
	public int delete_front()
	{
		node x = f;
		f = f.next;
		return x.data;
	}
	public boolean is_empty()
	{
		if((f==null)&&(r==null))
			return true;
		else
			return false;
	}
	public void printarray()
	{
		while(f.next!=null)
		{
			System.out.println(f.data);
			f = f.next;
		}
	}
}

