package com.luban.thread14;

import javax.sql.rowset.spi.SyncFactory;

public class Demoxmh {
public static void main(String[] args) {
	Resourcexmh r=new Resourcexmh();
	inputxmh in=new inputxmh(r);
	ouputxmh ou=new ouputxmh(r);
	Thread t0=new Thread(in);
	Thread t1=new Thread(ou);
	t0.start();
	t1.start();
}
}


class Resourcexmh{
	String name;
	String sex;
	boolean flag=false;
}


class inputxmh implements Runnable{
	Resourcexmh r;
	Object obj=new Object();
	
	public inputxmh(Resourcexmh r) {
		this.r=r;
	}
	
	@Override
	public void run() {
		int x=0;
		while(true) {
				try {
					synchronized (r) {
						if(r.flag) {
							r.wait();
						}
						if(x==0) {
							r.name="mike";
							r.sex="nan";
						}else {
							r.name="丽丽";
							r.sex="女女女女女女女女女女";
						}
						r.flag=true;
						r.notify();
					}
					x=(x+1)%2;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
	}
	
}

class ouputxmh implements Runnable{
	Resourcexmh r;
	public ouputxmh(Resourcexmh r) {
		this.r=r;
	}
	@Override
	public void run() {
	
		while(true) {
			synchronized(r) {
				if(!r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(r.name+"....."+r.sex);
				r.flag=false;
				r.notify();
			}
		}
	}
	
}