package com.luban.thread14;

//wait �� sleep ����
//
//1��wait����ָ��ʱ��Ҳ���Բ�ָ����
//   sleep����ָ��ʱ�䡣
//
//2����ͬ����ʱ����cpu��ִ��Ȩ�����Ĵ���ͬ��
//	wait���ͷ�ִ��Ȩ���ͷ�����
//	sleep:�ͷ�ִ��Ȩ�����ͷ�����
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
