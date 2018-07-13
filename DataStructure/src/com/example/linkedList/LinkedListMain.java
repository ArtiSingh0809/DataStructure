package com.example.linkedList;

import com.example.linkedList.LinkedList.Node;

public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
		linkedList.node  = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		linkedList.node.next = node1;
		node1.next = node2;
		
		Node node = linkedList.node;
		while(node != null) {
			System.out.println(node.data);
			node = node.next ;
		}
	}

}
