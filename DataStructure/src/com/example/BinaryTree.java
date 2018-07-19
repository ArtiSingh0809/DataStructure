package com.example.simple.tree;

public class BinaryTree<T> {

	
	public Node<T> insert(Node<T> root, T key) {
		if (null == root) {
			root = new Node<T>(key);
		}else {
			if(root.getRight() == null) {
				root.setRight( insert(root.getRight(), key));
			}else {
				root.setLeft( insert(root.getLeft(), key));
			}
		}
		return root;
	}
	
	public boolean serach(Node<T> root, T key) {
		if(root == null)
			return false;
		if(root.getData() == key)
			return true;
		if(root.getLeft() != null)
			if(serach(root.getLeft(), key)) {
				return true;
			}
		if(root.getRight() != null)
			if(serach(root.getRight(), key)) {
				return true;
			}
		return false;
	}
	
	public void inOrder(Node<T> root) {
		if(root.getLeft() != null)
			inOrder(root.getLeft());
		System.out.print(root.getData()+"  ");
		if(root.getRight() != null)
			inOrder(root.getRight());
	}
	
	public void preOrder(Node<T> root) {
		System.out.print(root.getData()+"  ");
		if(root.getLeft() != null)
			preOrder(root.getLeft());
		if(root.getRight() != null)
			preOrder(root.getRight());
	}
	
	public void postOrder(Node<T> root) {
		if(root.getLeft() != null)
			postOrder(root.getLeft());
		if(root.getRight() != null)
			postOrder(root.getRight());
		System.out.print(root.getData()+"  ");
	}
	
	public int countNodes(Node<T> root) {
		if(root == null)
			return 0;
		else {
			int sum = 1;
			sum = sum + countNodes(root.getLeft());
			sum = sum + countNodes(root.getRight());
			return sum;
		}
		
	}
	
	
	public Node<Integer> insertBST(Node<Integer> root, Integer key) {
		if (null == root) {
			root = new Node<Integer>(key);
		}else {
			if(key > root.getData()) {
				root.setRight( insertBST(root.getRight(), key));
			}else if(key < root.getData()) {
				root.setLeft( insertBST(root.getLeft(), key));
			}
		}
		return root;
	}
}
