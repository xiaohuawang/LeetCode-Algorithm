package lc_att;

public class BST {

	TreeNode root;

	public void addNode(int val) {
		TreeNode newNode = new TreeNode(val);
		if (root == null) {
			root = newNode;
		} else {
			TreeNode currentNode;
			TreeNode parentNode;
			parentNode = currentNode = root;
			// start loop
			// for(int i=0;i<2;i++){
			while (currentNode != null) {
				parentNode = currentNode;
				if (newNode.val < currentNode.val) {
					if (currentNode.left == null) {
						currentNode.left = newNode;
						return;
					} else {
						currentNode = currentNode.left;
					}
				} else {
					if (currentNode.right == null) {
						currentNode.right = newNode;
						return;
					} else {
						currentNode = currentNode.right;
					}
				}

			}
			// end loop
		}
	}
	
}
