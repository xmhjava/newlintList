package com.luban.thread14;

//wait 和 sleep 区别？
//
//1，wait可以指定时间也可以不指定。
//   sleep必须指定时间。
//
//2，在同步中时，对cpu的执行权和锁的处理不同。
//	wait：释放执行权，释放锁。
//	sleep:释放执行权，不释放锁。
public class WaitSleep {
	void show() {
		synchronized (this)//
		{

			try {
				wait();// t0 t1 t2
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 

		}
	}

	void method() {
		synchronized (this)// t4
		{

			// wait();

			notifyAll();

		} // t4
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

}
