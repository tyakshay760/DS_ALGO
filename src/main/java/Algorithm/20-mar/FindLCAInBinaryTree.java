public class BinaryTree {
     Node root;
     static boolean v1 = false, v2=false;
   
	public Node findLCAUtil(Node root, int n1, int n2) {
		if (root != null) {
		    
		    Node temp = null;
		    
		    if(root.key == n1){
		        v1 = true;
		        temp = root;
		    }
		    if(root.key == n2){
		        v2 = true;
		        temp = root;
		    }
			
			Node left = this.findLCAUtil(root.left, n1, n2);
			Node right = this.findLCAUtil(root.right, n1, n2);
			
			if(temp != null){
			    return temp;
			}

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}
	
	public Node findLCA(int n1, int n2){
	    v1 = false;
	    v2 = false;
	    
	    Node lca = findLCAUtil(root, n1, n2);
	    
	    if(v1 && v2){
	        return lca;
	    }
	    return null;
	}
    
   	public static void main(String[] args) throws java.lang.Exception {
	 
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        Node lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.key);
        else
            System.out.println("Keys are not present");
 
        lca = tree.findLCA(4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.key);
        else
            System.out.println("Keys are not present");
    
	}
}

class Node{
    int key;
    Node left, right;
    
	
    Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}