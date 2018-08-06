package algorithm;

class min_heap {
	int n;
	//int[] arr = new int[n];
	min_heap(int n)
	{
		this.n = n;
	}
	public int left(int i)
	{
		return 2*i;
	}
	public int right(int i)
	{
		return ((2*i)+1);
	}
	public int parent(int i)
	{
		return (i/2);
	}
	public void min_heapify(int[] arr,int i)
	{
		//System.out.println("aa"+i);
		int l = left(i);
		int r = right(i);
		int min = i;
		//if(l<n && r<n)
			//System.out.println(arr[min]+" "+arr[l]+" "+arr[r]);
		if(l<n)
		{
		if((arr[l]<arr[i]))
		{
			min = l;
		}
		}
		if(r<n)
		{
		if((arr[r]<arr[min])&&(r<=n))
		{
			min = r;
		}
		}
		//System.out.println(arr[min]);
		if(min!=i)
		{
			int t = arr[i];
			arr[i] = arr[min];
			arr[min] = t;
			min_heapify(arr,min);
		}
	}
	public int[] build_min_heap(int[] arr)
	{
		for(int i=n/2-1;i>=1;i--)
		{
			min_heapify(arr,i);
		}
		return arr;
	}
	public int extract_min(int[] arr)
	{
		//System.out.println("pp");
		int t = arr[1];
		arr[1] = arr[n-1];
		arr[n-1] = -1;
		n--;
		min_heapify(arr,1);
		return t;
	}
	public void insert_key(int[] arr,int k)
	{
		//System.out.println("ll"+arr[n-1]+arr[parent(n-1)]);
		if(arr[n-1]==100001)
		{
			arr[n-1] = k;
			/*System.out.println("aaa");
			for(int j=1;j<n;j++)
			{
				System.out.print(arr[j]+" ");
			}
			System.out.println();*/
		}
		else
		{
		n++;
		arr[n-1] = k;
		}
		int i = n-1;
		while((i>1)&&(arr[parent(i)]>arr[i]))
		{
			int  t = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = t;
			i = parent(i);
		}
		
	}
}
