package algorithm;

import java.util.Scanner;

public class Next_Greater_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		sc.close();
		printNGE(arr,n);

	}

	private static void printNGE(int[] arr, int n) {
		// TODO Auto-generated method stub
		//System.out.println("a");
		stack st = new stack();
		st.push(arr[0]);
		st.printarray();
		for(int i=1;i<n;i++)
		{
			if(st.isEmpty()==false)
			{
				if(arr[i]<st.peek())
				{
					
					st.push(arr[i]);
				}
				else
				{
					while((st.isEmpty()==false)&&(arr[i]>st.peek()))
					{
						st.pop();
						System.out.println(arr[i]);
						
					}
					st.push(arr[i]);
				}
			}
		}
		while(st.isEmpty()==false)
		{
			System.out.print("-1");
			st.pop();
		}
		
	}

}
