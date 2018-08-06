package algorithm;

public class stack {

	int t;
	int[] arr = new int[100];
	stack()
	{
		this.t= -1;
	}
	public boolean isEmpty()
	{
		if(t==-1)
		{
			return true;
		}
		else
			return false;
	}
	public void push(int x)
	{
		arr[++t] = x;
	}
	public int pop()
	{
		return arr[t--];
	}
	public int peek()
	{
		return arr[t];
	}
	public void printarray()
	{
		for(int i=0;i<=t;i++)
		{
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	

}
