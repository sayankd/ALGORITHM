package algorithm;

import java.util.Scanner;

public class rotated_array_binary_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		Binary_Search(arr);

	}

	private static int Binary_Search(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int i = 0;
		int j = n-1;
		while(i<=j)
		{
			int mid = i+(j-i)/2;
			System.out.println(i+" "+j);
			if(arr[mid]==mid)
			{
				return mid;
			}
			else if(arr[mid]<mid)
			{
				i = mid+1;
			}
			else
				j = mid-1;
		}
		return -1;
	}

}
