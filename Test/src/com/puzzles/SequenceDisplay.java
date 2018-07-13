package com.puzzles;

public class SequenceDisplay {

   static Object monitor = new Object();
	volatile static int i =15;
	static boolean one = true;
	static boolean two = false;
	static boolean three = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new SequenceDisplayImpl1());
		Thread t2 = new Thread(new SequenceDisplayImpl2());
		Thread t3 = new Thread(new SequenceDisplayImpl3());
		
		t3.start();
		t2.start();
		t1.start();
		
	}

	static class SequenceDisplayImpl1 implements Runnable {

		@Override
		public void run() {
			while(i > 0) {
				
				try {
					Thread.sleep(500);
					synchronized (monitor) {
						if (!one) {
							monitor.wait();
						} else {
							System.out.print( "1 ");
							one = false;
							two = true;
							three = false;
							monitor.notifyAll();
						}
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}
	
	static class SequenceDisplayImpl2 implements Runnable {
		
		@Override
		public void run() {
			while(i > 0) {
				try {
					Thread.sleep(500);
					synchronized (monitor) {
						if (!two) {
							monitor.wait();
						} else {
							System.out.print( "2 ");
							one = false;
							two = false;
							three = true;
							monitor.notifyAll();
						}
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
			
			}
			
		}
		
	}
	static class SequenceDisplayImpl3 implements Runnable {

		@Override
		public void run() {
			while(i > 0) {
				try {
					Thread.sleep(500);
					synchronized (monitor) {
						if (!three) {
							monitor.wait();
						} else {
							System.out.print( "3 ");
							one = true;
							two = false;
							three = false;
							monitor.notifyAll();
						}
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
			
			}
			
		}
		
	}

}
