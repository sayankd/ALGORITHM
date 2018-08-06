package algorithm;

import java.util.Scanner;

//import java.util.Random;

public class heap_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt()+1;
		int n = sc.nextInt();
		int[] arr = new int[m];
		for(int i=1;i<m;i++)
		{
			arr[i] = sc.nextInt();
		}
		int c = 0;
		heap x = new heap(arr.length);
		x.Build_Max_Heap(arr);
		for(int i=1;i<=n;i++)
		{
			int p = x.extract_min(arr);
			System.out.println(p);

			c = c+p;
			x.insertkey(arr, p-1);
		}
		System.out.println(c);
		sc.close();
	}
	

}
