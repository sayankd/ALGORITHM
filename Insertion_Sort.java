package algorithm;

import java.util.Scanner;

public class Insertion_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		arr = insertionsort(arr,n-1);
		for(i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		sc.close();

	}
	public static int[] insertionsort(int[] arr,int x)
	{
		//int n;
		//System.out.println("b"+x);
			if(x>1)
				arr = insertionsort(arr,x-1);
			//System.out.println("a"+x);
			int n = x-1,i,t;
			t = arr[x];
			//System.out.println(n);
			for(i=n;i>=0;i--)
			{
				//System.out.println("zzz"+" "+arr[i]);
				if(t<arr[i])
				{
					//System.out.println("zzzaaa"+i);
					arr[i+1] = arr[i];
					//System.out.println(arr[i+1]);
				}
				else
					break;
			}
			arr[i+1] = t;
			//System.out.println(arr[i]+" "+i);
			/*for(i=0;i<5;i++)
				System.out.print(" "+arr[i]);
			System.out.println();*/
			return arr;
			//return 0;
	}

}
