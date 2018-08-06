package algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Quick_Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int n = 5;
		int[] x = new int[n];//{5,4,3,2,1 };
		Random rn = new Random();
		for(int i=0;i<n;i++)
		{
			x[i] = rn.nextInt()%100;
			System.out.print(x[i]+" ");
		}
		/*for(int i=0;i<x.length;i++)
		{
			System.out.print(x[i]+" ");
		}
		System.out.println();*/
		System.out.println();
		sc.close();
		int low = 0;
		int high = x.length - 1;
		x = quickSort(x, low, high,n/2);
		for(int i=0;i<x.length;i++)
		{
			System.out.print(x[i]+" ");
		}
		System.out.println();
		System.out.println();
	}

	private static int[] quickSort(int[] x, int low, int high,int m) {
		// TODO Auto-generated method stub
		if(low<high)
		{
		int mid = low+((high-low)/2);
		int pivot = x[mid];
		int i = low;
		int j = high;
		while(i<=j)
		{
			//System.out.println(i+" "+j);
			while(x[i]<pivot && i<j)
			{
				//System.out.println("aa");
				i++;
			}
			//System.out.println(i);
			while(x[j]>pivot && i<j)
			{
				j--;
			}
			//System.out.println(i+" "+j);

			if(i<=j)
			{
				int t = x[j];
				x[j] = x[i];
				x[i] = t;
				i++;
				j--;
			}
			
		}
		for(int w=0;w<x.length;w++)
		{
			System.out.print(x[w]+" ");
		}
		System.out.println();
		System.out.println(pivot+" "+(i+1));
		System.out.println(low+" "+high);
		if((i+1)==m)
		{
			return x;
		}
		else if((i+1)>m)
		{
			x = quickSort(x,low,i-1,m);
		}
		else
			x = quickSort(x,i+1,high,m-i);
		
		
		}
		return x;
	}
 
}