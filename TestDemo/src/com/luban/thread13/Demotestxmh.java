package com.luban.thread13;
//死锁造成原因，
public class Demotestxmh {
	public static void main(String[] args) {
		cust c1=new cust(true);
		cust c2=new cust(false);
		Thread t1=new Thread(c1);
		Thread t2=new Thread(c2);
		t1.start();
		t2.start();
		
	}
	
	

}

class cust implements Runnable{
	boolean fal=false;
	public  cust(boolean fal) {
		this.fal=fal;
	}
	
	@Override
	public void run() {
	if(fal)	{
		while(true) {
		synchronized (locktest.a) {
			System.out.println("if a "+Thread.currentThread().getName());
			synchronized (locktest.b) {
				System.out.println("if b "+Thread.currentThread().getName());
			}
		}
		}
	}else {
		while(true) {
		synchronized (locktest.b) {
			System.out.println("else b "+Thread.currentThread().getName());
			synchronized (locktest.a) {
				System.out.println("else a "+Thread.currentThread().getName());
			}
		}
		}
	}
		
	}
	
	
}




class locktest{
	public static final Object a=new Object();
	public static final Object b=new Object();
}
