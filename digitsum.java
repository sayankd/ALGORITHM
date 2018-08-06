package algorithm;
public class digitsum
{
	public static int count(int n,int s)
	{
		int modx = 1000000007;
		int[][] memory = new int[101][501];
		for(int i = 1;i<=9;i++)
		{
			memory[1][i] = 1;
		}
		for(int i = 10;i<501;i++)
		{
			memory[1][i] = 0;
		}
		for(int S = 1;S<=s;S++)
		{
			for(int i = 2;i<=n;i++)
			{
				for(int k = 0;k<10;k++)
				{
					if(S>(1*k))
					{
							//System.out.println((i-(j+1))+" "+(s-(exp*k))+" "+k);
						memory[i][S] = ((memory[i][S]%modx)+(memory[i-1][S-(1*k)]%modx))%modx;
					}
				}
			}
		}
		//printarray(memory);
		return memory[n][s];
	}
	public static void main(String args[])
	{
		System.out.println(count(2,4));
	}
}
