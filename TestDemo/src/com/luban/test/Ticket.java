package com.luban.test;
public class Ticket extends Thread{
	public static void main(String[] args) {
		
		Ticket t1=new Ticket();
		Ticket t2=new Ticket();
		Ticket t3=new Ticket();
		Ticket t4=new Ticket();
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	static int num=100;
	@Override
	public void run() {
		
		while(true) {
				
					if(num>0)
					{
				System.out.println(Thread.currentThread().getName()+".....sale...."+num--);
			}
		
		 }
	}

}
