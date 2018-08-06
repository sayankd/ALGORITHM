package algorithm;

public class Test_sbst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Self_BST_AVL tree = new Self_BST_AVL();
		tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 13);       
        tree.root = tree.delete(tree.root, 7);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.delete(tree.root, 10);
        
        //System.out.println(tree.root.right.key+" "+tree.root.right.left.key+" "+tree.root.right.right.key);
        //tree.root = tree.insert(tree.root, 4);
        //System.out.println(tree.root.right.key+" "+tree.root.right.left.key+" "+tree.root.right.right.key);
	    //System.out.println("aaaaaaaaaaaaa");
        //tree.root = tree.insert(tree.root, 1);		//System.out.println(tree.root.right.key+" "+tree.root.right.left.key+" "+tree.root.right.right.key);
       //System.out.println(tree.root.key+" "+tree.root.num_element);
        preorder(tree.root);

	}

	private static void preorder(avl_node root) {
		// TODO Auto-generated method stub
		if(root!=null)
		{
			System.out.println(root.key+" "+root.max);
			preorder(root.left);
			preorder(root.right);
		}
		
	}

}
