package com.example;

public class ThreadGroupExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup().getParent();

	}

}

