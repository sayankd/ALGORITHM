package algorithm;

import java.util.Arrays;

class pivot_find {
	int find_median(int[] arr,int s,int n)
	{
		int[] arr1 = new int[n];
		int k = 0;
		for(int i=s;i<(s+n);i++)
		{
			//System.out.println(arr[i]);
			arr1[k++] = arr[i];
		}
		//System.out.println(n+" "+arr1[0]);
		Arrays.sort(arr1);
		return arr1[n/2];
	}
	int median_of_medians(int[] arr,int l,int r)
	{
			//System.out.println("aa");
			int n = r-l+1,i;
			int[] median = new int[(n+4)/5];
			for(i=0;i<n/5;i++)
			{
				median[i] = find_median(arr,(l+i*5),5);
			}
			if((i*5)<n)
			{
				//System.out.println("i="+i);
				median[i] = find_median(arr, l+i*5, n%5);
				i++;
			}
			if(i==1)
			{
				return median[i-1];
			}
			else
			{
				//System.out.println("ai="+i);
				return median_of_medians(median, 0, i-1);
			}
		
	}

}
