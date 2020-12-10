package com.luban.thread14;

import java.util.ArrayList;

class Resourcexmh2 {
	private String name;
	private int count = 1;
	private boolean flag = false;

	public synchronized void set(String name)//
	{
		while (flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
			} // t1 t0

		this.name = name + count;// 烤鸭1 烤鸭2 烤鸭3
		count++;// 2 3 4
		System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);// 生产烤鸭1 生产烤鸭2 生产烤鸭3
		flag = true;
		this.notifyAll();
	}

	public synchronized void out()// t3
	{
		while (!flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
			} // t2 t3
		System.out.println(Thread.currentThread().getName() + "...消费者........" + this.name);// 消费烤鸭1
		flag = false;
		this.notifyAll();
	}
}

class Producerxmh implements Runnable {
	private Resourcexmh2 r;

	Producerxmh(Resourcexmh2 r) {
		this.r = r;
	}

	public void run() {
		while (true) {
			r.set("烤鸭");
		}
	}
}

class Consumerxmh implements Runnable {
	private Resourcexmh2 r;

	Consumerxmh(Resourcexmh2 r) {
		this.r = r;
	}

	public void run() {
		while (true) {
			r.out();
		}
	}
}


public class Demoxmh2 {
public static void main(String[] args) {
	Resourcexmh2 r = new Resourcexmh2();
	Producerxmh pro = new Producerxmh(r);
	Consumerxmh con = new Consumerxmh(r);

	Thread t0 = new Thread(pro);
	Thread t1 = new Thread(pro);
	Thread t2 = new Thread(con);
	Thread t3 = new Thread(con);
	t0.start();
	t1.start();
	t2.start();
	t3.start();
}
	

}
