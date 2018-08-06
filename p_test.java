package algorithm;

import java.util.Scanner;
public class p_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new  Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int[] arr2 = new int[n];
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			arr2[i] = 0;
		}
		while(m-->0)
		{
			int i = sc.nextInt();
			int j = sc.nextInt();
			for(int k = i;k<=j;k++)
			{
				arr2[k]++;
			}
			int max = arr2[0];
			int ind = 0;
			for(int k = i;k<=j;k++)
			{
				if(arr2[k]>max)
				{
					max = arr2[k];
					ind = k;
				}
			}
			System.out.println(ind);
		}
	}

}
