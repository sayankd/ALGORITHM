package algorithm;

import java.util.Scanner;

public class peak_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println(arr[BinarySearch(arr)]);
		}
		sc.close();
	}

	private static int BinarySearch(int[] arr) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = arr.length-1;
		while(i<=j)
		{
			System.out.println(i+" "+j);
			int mid = i+(j-i)/2;
			if((mid==0 || arr[mid-1]<= arr[mid])&&(mid==arr.length-1 || arr[mid]>=arr[mid+1]))
			{
				return mid;
			}
			else if(arr[mid-1]>arr[mid])
			{
				j = mid-1;
			}
			else
			{
				i = mid+1;
			}
			
		}
		return 0;
		
	}

}
