package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class test_pivot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//sc.close();
		int[] arr = new int[n];
		//Random rn = new Random();
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt()%100;
			//System.out.println(arr[i]+" ");
		}
		sc.close();
		Arrays.sort(arr);
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]);
		}
		pivot_find x = new pivot_find();
		System.out.println(x.median_of_medians(arr, 0, n-1));

	}
	

}
