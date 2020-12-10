package com.luban.thread13;

public class DemoTest {
	public static void main(String[] args) {
		Number n = new Number();
		Thread t1 = new Thread(n);
		Thread t2 = new Thread(n);

		t1.start();
		t2.start();
	}

}

class Number implements Runnable {
	private int number = 100;

	@Override
	public void run() {
		while (true) {
				if (number > 0) {
					try {
						Thread.sleep(10);
						System.out.println(Thread.currentThread().getName() + "..........." + number--);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}
	}
}