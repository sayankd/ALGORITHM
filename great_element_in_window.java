package algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class great_element_in_window {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		sc.close();
		int k = 3;
		printmax(arr,k);
	}

	private static void printmax(int[] arr, int k) {
		// TODO Auto-generated method stub
		Deque<Integer> dq = new LinkedList<Integer>();
		dq.addLast(0);
		int i;
		for(i=1;i<k;i++)
		{
			while((!dq.isEmpty())&&(arr[dq.peekLast()]<=arr[i]))
			{
				dq.removeLast();
			}
			dq.addLast(i);
		}
		//System.out.println("a");
		for(;i<arr.length;i++)
		{
			System.out.println(arr[dq.peekFirst()]);
			while((!dq.isEmpty())&&(dq.peekFirst()<=i-k))
			{
				dq.removeFirst();
			}
			while((!dq.isEmpty())&&(arr[dq.peekLast()]<=arr[i]))
			{
				dq.removeLast();
			}
			dq.addLast(i);
			
			
		}
		System.out.println(arr[dq.peekFirst()]);
		
	}

}
