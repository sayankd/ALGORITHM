package algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		arr = generatearray(n);
		printarray(arr);
		int m = sc.nextInt();
		int bn = BinarySearch(arr,m,0,n-1);
		int bnr = BinarySearch_repeat(arr,m,0,n-1);
		System.out.println(bn+" "+bnr);
		sc.close();

	}

	private static void printarray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]+" ");
		}
		
	}

	private static int BinarySearch(int[] arr,int m,int l,int h) {
		// TODO Auto-generated method stub
		int mid = (l+((h-l)/2));
		if(l>h)
			return -1;
		else if(arr[mid]==m)
			return mid;
		else if(arr[mid]>m)
		{
			return BinarySearch(arr,m,l,mid-1);
		}
		else
			return BinarySearch(arr,m,mid+1,h);
	}
	private static int BinarySearch_repeat(int[] arr,int m,int l,int h) {
		// TODO Auto-generated method stub
		//System.out.println(l+" "+h);

		int mid = (l+((h-l)/2));
		if(l>h)
			return h;
		else if(arr[mid]==m)
		{
			if((mid+1)<=h)
			{
				return BinarySearch_repeat(arr,m,mid+1,h);
			}
			return mid;
			
		}
		else if(arr[mid]>m)
		{
			return BinarySearch(arr,m,l,mid-1);
		}
		else
			return BinarySearch(arr,m,mid+1,h);
	}

	

	private static int[] generatearray(int n) {
		// TODO Auto-generated method stub
		int[] arr = new int[n];
		Random rn = new Random();
		for(int i=0;i<n;i++)
		{
			arr[i] = rn.nextInt()%1000;
		}
		Arrays.sort(arr);
		return arr;
	}

}
