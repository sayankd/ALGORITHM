package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class test_heap_m {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 3;
		heap_m h = new heap_m(n);
		//h.insert_key(2);
		//h.insert_key(5);
		//h.insert_key(7);
		//System.out.println(h.harr[0]+" "+h.harr[1]+" "+h.harr[2]);
		//h.decrease_key(5, 1);
		System.out.println(h.extract_min());
		sc.close();
	}

	
	
}
