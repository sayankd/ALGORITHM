package algorithm;
class heap_node
{
	int v;
	int weight;
	heap_node(int x,int y)
	{
		v = x;
		weight = y;
	}
}
class heap_m {
	private static final int INT_MIN = -1000000001;
	heap_node[] harr;
	int capacity;
	int heap_size;
	heap_m(int x)
	{
		harr = new heap_node[x];
		capacity = x;
	}
	int left(int i)
	{
		return (2*i)+1;
	}
	int right(int i)
	{
		return (2*i)+2;
	}
	int parent(int i)
	{
		return (i-1)/2;
	}
	void insert_key(heap_node x)
	{
		heap_size++;
		harr[heap_size-1] = x;
		int i = heap_size-1;
		while(i!=0 && harr[parent(i)].weight>harr[i].weight)
		{
			heap_node t = harr[i];
			harr[i] = harr[parent(i)];
			harr[parent(i)] = t;
			i = parent(i);
		}
	}
	void decrease_key(int old,heap_node new_el)
	{
		int i;
		for(i=0;i<heap_size;i++)
		{
			if(harr[i].v==old)
			{
				harr[i] = new_el;
				break;
			}
		}
		//System.out.println(i);
		while(i!=0 && harr[parent(i)].weight>harr[i].weight)
		{
			heap_node t = harr[i];
			harr[i] = harr[parent(i)];
			harr[parent(i)] = t;
			i = parent(i);
		}
		
	}
	heap_node extract_min()
	{
		heap_node x = harr[0];
		harr[0] = harr[heap_size-1];
		heap_size--;
		heapify(0);
		return x;
	}
	void delete_key(heap_node x)
	{
		int i = 0;
		/*for(int j=0;j<heap_size;j++)
		{
			if(harr[j].v==x.v)
			{
				i = j;
			}
		}*/
		heap_node p = new heap_node(-100,-1000000001);
		//heap_node t = harr[i];
		decrease_key(x.v,p);
		extract_min();
		//return t;
	}
	private void heapify(int i) {
		// TODO Auto-generated method stub
		int l = left(i);
		int r = right(i);
		int min = i;
		if(l<heap_size && harr[l].weight<harr[i].weight)
		{
			min = l;
		}
		if(r<heap_size && harr[r].weight<harr[min].weight)
		{
			min = r;
		}
		if(min!=i)
		{
			heap_node t = harr[min];
			harr[min] = harr[i];
			harr[i] = t;
			heapify(min);
		}
	}
	public void display()
	{
		for(int i=0;i<heap_size;i++)
		{
			System.out.print(harr[i]+" ");
		}
		System.out.println();
	}

}
