package algorithm;

import java.util.Scanner;

public class partiton_algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		//sc.close();
		//Random rn = new Random();
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			//System.out.print(arr[i]+" ");
		}
		sc.close();
		//System.out.println();
		int l = 0;
		int h = n-1;
		int x = median(arr,l,h,5);
		System.out.println(x);
		
		

	}
	public static int median(int[] arr,int l,int h,int k)
	{
		if(k>0 && k<=(h-l+1))
		{
			int pos = partition(arr,l,h);
			if(pos-l==k-1)
			{
				return arr[pos];
			}
			if(pos-l>k-1)
			{
				return median(arr,l,pos-1,k);
			}
			return median(arr,pos+1,h,k-pos+l-1);
		}
		return 0;
	}

	public static int partition(int[] arr,int l,int h)
	{
		pivot_find x = new pivot_find();
		int pivot = x.median_of_medians(arr, l, h);
		for(int i=l;i<=h;i++)
		{
			if(arr[i]==pivot)
            {
                int t = pivot;
                arr[i] = arr[h];
                arr[h] = t;
                break;
            }
		}
		int i = l;
		for(int j=l;j<h;j++)
		{
			if(arr[j]<=pivot)
			{
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				i++;
			}
		}
		int t = arr[i];
		arr[i] = arr[h];
		arr[h] = t;
		return i;
	}

}
