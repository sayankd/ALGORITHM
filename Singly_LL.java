package algorithm;

public class Singly_LL {
	LL_node head;
	Singly_LL()
	{
		head=null;
	}
	public LL_node insert(int z)
	{
		LL_node x = new LL_node(z);
		if(head==null)
		{
			head=x;
		}
		else
		{
			LL_node p = head;
			while(p.next!=null)
			{
				p=p.next;
			}
			p.next=x;
		}
		return head;
	}
	public void display()
	{
		while(head!=null)
		{
			System.out.println(head.key);
			head=head.next;
		}
	}

}
