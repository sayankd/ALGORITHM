package algorithm;

import java.util.Scanner;

public class test_min_heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int k = sc.nextInt();
		int[] arr = new int[n];
		int[] arr1 = new int[n+1];
		int[] arr2 = new int[n+1];
		for(int i=1;i<arr1.length;i++)
		{
			arr1[i] = 100001;
		}
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		int c = 0;
		//System.out.println();
		min_heap min_heap = new min_heap(arr1.length);
		heap max = new heap(arr2.length);
		min_heap.build_min_heap(arr1);
		max.Build_Max_Heap(arr2);
		if(arr[0]>arr[1])
		{
			min_heap.insert_key(arr1, arr[0]);
			max.insertkey(arr2, arr[1]);
		}
		else
		{
			min_heap.insert_key(arr1, arr[1]);
			max.insertkey(arr2, arr[0]);
		}
		display(arr1);
		display(arr2);
		System.out.println(arr[0]);
		double median = (double)(arr1[1] +arr2[1])/(double)2;
		System.out.println(median);
		for(int i=2;i<arr.length;i++)
		{
			if(i%2==0)
			{
				if(arr[i]>median)
				{
					max.insertkey(arr2, min_heap.extract_min(arr1));
					min_heap.insert_key(arr1, arr[i]);
				}
				else
				{
					max.insertkey(arr2, arr[i]);
				}
				median = arr2[1];
			}
			else
			{
				if(arr[i]>median)
				{
					min_heap.insert_key(arr1, arr[i]);
				}
				else
				{
					min_heap.insert_key(arr1, max.extract_min(arr2));
					max.insertkey(arr2, arr[i]);
				}
				//System.out.println("aa"+arr2[1]+" "+arr1[1]);
				median = (double)(arr2[1]+arr1[1])/(double)2;
			}
			System.out.println(median);
			display(arr1);
			display(arr2);
		}

	}
	public static void display(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
