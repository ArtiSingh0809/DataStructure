package com.example.queue;

public class CustQueue<T> {
	private int size;
	private int total;
	private int front;
	private int rear;
	private T[] queue;
	
	@SuppressWarnings("unchecked")
	public CustQueue() {
		this.total = 0;
		this.front = 0;
		this.rear = 0;
		this.size = 50;
		this.queue = (T[])(new Object[this.size]);
	}
	
	public boolean enqueue(T item) {
		if(isFull()) {
			return false;
		}
		total++;
		queue[rear++] = item;
		return true;
	}

	private boolean isFull() {
		return (total == size);
	}
	
	public T dequeue() {
		total--;
		return queue[front++];
	}
	public int size() {
		return total;
	}
}
