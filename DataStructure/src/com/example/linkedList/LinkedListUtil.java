package com.example.linkedList;

import com.example.linkedList.LinkedList.Node;

public class LinkedListUtil {
	
	public void push(int data , LinkedList linkedList) {
		if(null == linkedList.node) {
			linkedList.node =new Node(data);
		}else {
			Node node = new Node(data);
			node.next = linkedList.node;
			linkedList.node = node;
		}
	}

	public void insertAfter(Node prev_node,int data) {
		if(null == prev_node) {
			System.out.println("Previous Node cannot be null");
		}else {
			Node node = new Node(data);
			node.next = prev_node.next;
			prev_node.next = node;
			
		}
	}

	public void insertLast(int data, LinkedList linkedList) {
		if(null == linkedList.node) {
			linkedList.node = new Node(data);
		}else {
			Node nodeLast = linkedList.node;
			while(nodeLast.next != null) {
				nodeLast = nodeLast.next;
			}
			nodeLast.next = new Node(data);
		}
	}
	
}
