package com.example.simple.tree;

public class TestBinaryTree {
	
	public static void main(String[] args) {
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		Node<Integer> root = new Node<Integer>(42);
		binaryTree.insert(root, 10);
		binaryTree.insert(root, 15);
		binaryTree.insert(root, 25);
		binaryTree.insert(root, 17);
		binaryTree.insert(root, 5);
		
		binaryTree.preOrder(root);
		System.out.println(binaryTree.countNodes(root));
		
		root = new Node<Integer>(50);
		binaryTree.insertBST(root, 30);
		binaryTree.insertBST(root, 20);
		binaryTree.insertBST(root, 40);
		binaryTree.insertBST(root, 70);
		binaryTree.insertBST(root, 60);
		binaryTree.insertBST(root, 80);
		binaryTree.insertBST(root, 35);
		binaryTree.insertBST(root, 55);
		binaryTree.insertBST(root, 45);
		binaryTree.insertBST(root, 65);
		binaryTree.preOrder(root);
		
	}

}
