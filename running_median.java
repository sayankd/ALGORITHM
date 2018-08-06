package algorithm;

import java.util.Scanner;

public class running_median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] arr1 = new int[(n/2)+2];
		int[] arr2 = new int[(n/2)+2];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<arr2.length;i++)
		{
			arr2[i] = 100001;
		}
		min_heap x = new min_heap((n/2)+2);
		heap y = new heap((n/2)+2);
		x.extract_min(arr2);
		y.extract_min(arr1);
		if(arr[0]>arr[1])
		{
			arr2[1] = arr[0];
			arr1[1] = arr[1];
		//x.insert_key(arr2, arr[0]);
		//y.insertkey(arr1, arr[1]);
			x.build_min_heap(arr2);
			y.Build_Max_Heap(arr1);
		}
		else
		{
			arr2[1] = arr[1];
			arr1[1] = arr[0];
			x.build_min_heap(arr2);
			y.Build_Max_Heap(arr1);
			//System.out.println(arr1[1]+" "+arr2[1]);
			
		}
		/*for(int j=0;j<arr2.length;j++)
		{
			System.out.print(arr2[j]+" ");
		}*/
		//System.out.println();
		//System.out.println(x.extract_min(arr2)+" "+y.extract_min(arr1));
		System.out.println((double)arr[0]);
		double median = (double)(arr2[1]+arr1[1])/(double)2;
		System.out.println(median);
		for(int i=2;i<n;i++)
		{
		if(i%2==0)
		{
			
		if(arr[i]<median)
		{
			//System.out.println("aa");
			y.insertkey(arr1, arr[i]);
			//System.out.println(arr1[1]);
		}
		if(arr[i]>median)
		{
			//System.out.println("cc");
			//System.out.println();
			int min = x.extract_min(arr2);
			//System.out.println();
			//System.out.println(min+" "+arr[i]+" "+arr2[1]);
			y.insertkey(arr1, min);
			x.insert_key(arr2, arr[i]);
			//System.out.println("ll"+arr2[1]);
		}
		median = arr1[1];
		//System.out.println("dd"+median);
		}
		else
		{
			if(arr[i]>median)
			{
				//System.out.println("dd"+arr2[1]);
				x.insert_key(arr2, arr[i]);
				//System.out.println("dd"+arr2[1]);
			}
			if(arr[i]<median)
			{
				int min = y.extract_min(arr1);
				x.insert_key(arr2, min);
				//System.out.println(arr1[1]);
			}
			median = ((double)(arr2[1]+arr1[1])/(double)2);
		}
		//System.out.println("med"+median+" lne="+y.len+"n= "+x.n+" "+arr2[1]+" "+arr1[1]);
		//display(arr1);
		//display(arr2);
		System.out.println(median);
		}

	}
	public static void display(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			System.out.println(arr[i]+" ");
		}
		System.out.println();
	}

}
