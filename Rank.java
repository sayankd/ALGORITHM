//package algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Rank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		arr = generatearr(n);
		//System.out.println(findrank(arr,0,n-1,4));
		System.out.println(partiton(arr,0,n-1,2));
		Arrays.sort(arr);
		printarray(arr,arr.length);
		System.out.println(arr[arr.length/2]);
		sc.close();
	}

	/*private static int findrank(int[] arr, int l, int h, int k) {
		// TODO Auto-generated method stub
		int p = (l+((h-l)/2));
		int a = partiton(arr,l,h,p);
		printarray(arr,arr.length);
		if(k==h-a+1)
		{
			return arr[a];
		}
		else if(k<h-a+1)
		{
			return findrank(arr,a+1,h,k);
		}
		else
			return findrank(arr,l,a,k-(h-a+1));
	}*/

	private static int partiton(int[] arr, int l, int h, int k) {
		// TODO Auto-generated method stub
		int x = arr[k];
		int i = l;
		int j = h;
		while(i<=j)
		{
			while(arr[i]<x)
			{
				i++;
			}
			while(arr[j]>x)
			{
				j--;
			}
			if(i<=j)
			{
				int tem = arr[j];
				arr[j] = arr[i];
				arr[i] = tem;
				i++;
				j--;
			}
		}
		
		System.out.println(l+" "+h+" "+x+" "+(i-1)); 
		return i-1;
	}

	private static int[] generatearr(int n) {
		// TODO Auto-generated method stub
		int[] arr = new int[n];
		Scanner  sc = new Scanner(System.in);
		//Random rn = new Random();
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt()%100;
		}
		sc.close();
		return arr;
	}
	private static void printarray(int[] arr,int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	

}
