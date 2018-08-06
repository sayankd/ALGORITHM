package algorithm;

class heap {
	int len;
	heap(int a)
	{
		len = a;
	}
	public int Parent(int i)
	{
		return i/2;
	}
	public int Left(int i)
	{
		return 2*i;
	}
	public int Right(int i)
	{
		return (2*i)+1;
	}
	public void Max_Heapify(int[] a,int i)
	{
		int n = len-1;
		//int n = a.length-1;
		int l = Left(i);
		int r = Right(i);
		//System.out.println("aaaa"+l+" "+r+" ");
		int max = 0;
		if((l<=n)&&(a[l]>a[i]))
		{
			//System.out.println("bbb"+a[l]);
			max = l;
		}
		else
		{
			max = i;
		}
		if((r<=n)&&(a[r]>a[max]))
		{
			max = r;
		}
		if(max != i)
		{
			int t = a[max];
			a[max] = a[i];
			a[i] = t;
			Max_Heapify(a,max);
		}
		
		
	}
	public int[] Build_Max_Heap(int[] a)
	{
		int i;
		//System.out.println(a.length);
		for(i=a.length/2;i>=1;i--)
		{
			//System.out.println(i);
			Max_Heapify(a,i);
		}
		return a;
	}
	public int extract_min(int[] arr)
	{
		int t = arr[1];
		arr[1] = arr[len-1];
		arr[len-1] = -1;
		len = len-1;
		Max_Heapify(arr,1);
		return t;
	}
	public void insertkey(int[] arr,int k)
	{
		if(arr[len-1]==0)
		{
			arr[len-1] = k;
		}
		else
		{
		len++;
		arr[len-1] = k;
		}
		int i = len -1;
		
		while((i>1)&&(arr[Parent(i)]<arr[i]))
		{
			//System.out.println(i);
			int t = arr[Parent(i)];
			arr[Parent(i)] = arr[i];
			arr[i] = t;
			//System.out.println(arr[i]);
			i = Parent(i);
		}
		
		
	}

}
