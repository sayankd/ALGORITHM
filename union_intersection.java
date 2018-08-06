package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class union_intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n<m)
		{
			int t = n;
			n = m;
			m = t;
		}			
		int[] arr = new int[n];
		int[] arr1 = new int[m];
		int[] arr2 = new int[m];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<m;i++)
		{
			arr1[i] = sc.nextInt();
		}
		//Arrays.sort(arr);
		Arrays.sort(arr1);
		int k =0;
		for(int i=0;i<m;i++)
		{
			Arrays.sort(arr);
			int x = bsearch(arr,arr1[i]);
			for(int j=0;j<arr.length;j++)
			{
				System.out.print(arr[j]+" ");
			}
			System.out.println();
			arr2[k++] = x;
			
		}
		for(int i=0;i<arr2.length;i++)
		{
			System.out.println(arr2[i]);
		}
	}
	public static int bsearch(int[] arr,int x)
	{
		int low = 0;
		int high = arr.length-1;
		while(low<=high)
		{
			int mid = low+(high-low)/2;
			if(arr[mid]>x)
			{
				high = mid-1;
			}
			else if(arr[mid]<x)
			{
				low = mid+1;
			}
			else
			{
				arr[mid]=-1;
				return mid;
			}
			//System.out.println(low+" "+high);

		}
		return 0;
	}

}
