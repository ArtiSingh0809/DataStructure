package com.example.stack;

public class CustStack<T> {
	private T[] stack;
	private int top;
	private int size;

	@SuppressWarnings("unchecked")
	public CustStack() {
		top = -1;
		this.size = 50;
		this.stack = (T[])(new Object[this.size]);
	}
	
	
	@SuppressWarnings("unchecked")
	public CustStack(int size) {
		top = -1;
		this.size = size;
		this.stack = (T[])(new Object[this.size]);
	}
	
	public boolean push(T item) {
		if(isFull()) 
			return false;
		top++;
		stack[top] = item;
		return true;
	}

	
	public T pop() {
		return stack[top--];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
	
	private boolean isFull() {
		return (top == (stack.length-1));
	}
	
	public int size() {
		return (top == -1 ? 0 : top) ;
	}
	
}
