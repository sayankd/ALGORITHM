package algorithm;

import java.util.Random;

public class list_reversal {
	public static void main(String args[])
	{
		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		node head = null;
		node x = null;
		for(int i=0;i<10;i++)
		{
		node y = createnode();
		if(head==null)
		{
			head = y;
			x = head;
		}
		else
		{
			x.next = y;
			x = y;
		}
		
		}
		x = head;
		while(head!=null)
		{
			System.out.print(head.data+"->");
			head = head.next;
		}
		head = x;
		System.out.println("null");
		head = reverse_linklist(head);
		while(head!=null)
		{
			System.out.print(head.data+"->");
			head = head.next;
		}
		System.out.println("null");
		
	}

	private static node reverse_linklist(node head) {
		// TODO Auto-generated method stub
		node curr=null,prev=null,next=null;
		curr = head;
		while(curr!=null)
		{	
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}

	private static node createnode() {
		// TODO Auto-generated method stub
		node x = new node();
		Random rn = new Random();
		x.data = rn.nextInt()%10;
		return x;
	}
	
	

}
