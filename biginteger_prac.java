package algorithm;
import java.math.*;
import java.util.*;
public class biginteger_prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		BigInteger x = new BigInteger(str1);
		BigInteger y = new BigInteger(str2);
		sc.close();
		System.out.println(x.add(y));

	}

}
