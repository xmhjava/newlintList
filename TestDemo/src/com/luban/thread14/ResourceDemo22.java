package com.luban.thread14;

/*
�ȴ�/���ѻ��ơ� 

�漰�ķ�����

1��wait(): ���̴߳��ڶ���״̬����wait���̻߳ᱻ�洢���̳߳��С�
2��notify():�����̳߳���һ���߳�(����).
3��notifyAll():�����̳߳��е������̡߳�

��Щ���������붨����ͬ���С�
��Ϊ��Щ���������ڲ����߳�״̬�ķ�����
����Ҫ��ȷ���ײ��������ĸ����ϵ��̡߳�


Ϊʲô�����̵߳ķ���wait notify notifyAll��������Object���У� 

��Ϊ��Щ�����Ǽ������ķ�������������ʵ��������
������������Ķ�������Ķ�����õķ�ʽһ��������Object���С�

*/
//��Դ
class Resourcetest2 {
	String name;
	String sex;
	boolean flag = false;
 
	public synchronized void set(String name, String sex) {
		if (flag) {
			try {
				this.wait();
			} catch (Exception e) {
			}
		}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}

	public synchronized void out() {
		if (!flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		System.out.println(name + "....." + sex);
		flag = false;
		this.notify();
	}

}

//����
class Inputtest2 implements Runnable {
	Resourcetest2 r;

//	Object obj = new Object();
	Inputtest2(Resourcetest2 r) {
		this.r = r;
	}

	public void run() {
		int x = 0;
		while (true) {
			if (x == 0) {
				r.set("mike", "nan");
			} else {
				r.set("����", "ŮŮŮŮŮŮ");
			}
			x = (x + 1) % 2;

		}
	}
}

//���
class Outputtest2 implements Runnable {

	Resourcetest2 r;

//	Object obj = new Object();
	Outputtest2(Resourcetest2 r) {
		this.r = r;
	}

	public void run() {
		while (true) {
			r.out();
		}
	}
}

public class ResourceDemo22 {
	public static void main(String[] args) {
		// ������Դ��
		Resourcetest2 r = new Resourcetest2();
		// ��������
		Inputtest2 in = new Inputtest2(r);
		Outputtest2 out = new Outputtest2(r);
		// �����̣߳�ִ��·����
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		// �����߳�
		t1.start();
		t2.start();
	}
}
