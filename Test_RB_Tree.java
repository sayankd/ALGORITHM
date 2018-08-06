package algorithm;
//true for Red false for Black
public class Test_RB_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RB_tree x = new RB_tree();
		x.root = x.insert(x.root,new RB_node(10));
		x.root = x.insert(x.root, new RB_node(20));
		x.root = x.insert(x.root, new RB_node(30));
		x.root = x.insert(x.root, new RB_node(15));
		x.root = x.insert(x.root, new RB_node(35));
		x.root = x.insert(x.root, new RB_node(13));
		x.root = x.insert(x.root, new RB_node(33));
		System.out.println(x.root.left.key+" "+x.root.right.key);
		x.preorder(x.root);
		
	}
		
}
	


