package com.example.stack;

import com.example.queue.CustQueue;

public class Test1 {

	public static void main(String[] args) {
		CustStack<Integer> intStack = new CustStack<>(10);
		System.out.println(intStack.size());
		intStack.push(10);
		intStack.push(20);
		intStack.push(30);
		intStack.push(40);
		intStack.push(50);
		System.out.println(intStack.isEmpty());
		System.out.println(intStack.pop());
		System.out.println(intStack.size());
		intStack.push(10);
		System.out.println(intStack.size());
		System.out.println(intStack.isEmpty());
		System.out.println(intStack.pop());
	
		
		
		CustStack<String> strStack = new CustStack<>();
		strStack.push("A");
		strStack.push("Aa");
		strStack.push("Ab");
		strStack.push("Ac");
		strStack.push("Ad");
		System.out.println(strStack.isEmpty());
		System.out.println(strStack.pop());
		strStack.push("Ae");
		System.out.println(strStack.isEmpty());
		System.out.println(strStack.pop());
		
		CustStack<Employee> empStack = new CustStack<Employee>();
		empStack.push(new Employee(1,"A","Add"));
		empStack.push(new Employee(2,"A","Add"));
		empStack.push(new Employee(3,"A","Add"));
		empStack.push(new Employee(4,"A","Add"));
		System.out.println(empStack.pop().toString());
		System.out.println(empStack.size());
		System.out.println(empStack.pop().toString());
		System.out.println(empStack.size());
		
		System.out.println("****************** Queue Testing***********");
		CustQueue<Integer> custQueue = new CustQueue<>();
		custQueue.enqueue(10);
		custQueue.enqueue(20);
		custQueue.enqueue(30);
		custQueue.enqueue(40);
		custQueue.enqueue(50);
		System.out.println(custQueue.dequeue());
		System.out.println(custQueue.size());
		
		CustQueue<Employee> empCustQueue = new CustQueue<>();
		empCustQueue.enqueue(new Employee(1,"A","Add"));
		empCustQueue.enqueue(new Employee(2,"A","Add"));
		empCustQueue.enqueue(new Employee(3,"A","Add"));
		empCustQueue.enqueue(new Employee(4,"A","Add"));
		empCustQueue.enqueue(new Employee(5,"A","Add"));
		System.out.println(empCustQueue.dequeue().toString());
		System.out.println(empCustQueue.dequeue().toString());
		System.out.println(empCustQueue.dequeue().toString());
		System.out.println(empCustQueue.dequeue().toString());
		System.out.println(empCustQueue.size());
	}

}
