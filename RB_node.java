package algorithm;
//true for Red false for Black
public class RB_node {
	int key;
	RB_node parent,left,right;
	boolean color;
	RB_node(int x)
	{
		key = x;
		parent = null;
		left = null;
		right = null;
	}
}
