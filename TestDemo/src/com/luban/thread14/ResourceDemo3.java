package com.luban.thread14;
class Resourcetest
{
	private String name;
	private String sex;
	private boolean flag = false;

	public synchronized void set(String name,String sex)
	{
		if(flag)
			try{this.wait();}catch(InterruptedException e){}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}

	public synchronized void out()
	{
		if(!flag)
			try{this.wait();}catch(InterruptedException e){}
		System.out.println(name+"...+...."+sex);
		flag = false;
		notify();
	}
}


//����
class Inputtest implements Runnable
{
	Resourcetest r ;
//	Object obj = new Object();
	Inputtest(Resourcetest r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			if(x==0)
			{
				r.set("mike","nan");
			}
			else
			{
				r.set("����","ŮŮŮŮŮŮ");
			}
			x = (x+1)%2;
		}
	}
}
//���
class Outputtest implements Runnable
{

	Resourcetest r;
//	Object obj = new Object();
	Outputtest(Resourcetest r)
	{
		this.r = r;
	}

	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}



class  ResourceDemo3
{
	public static void main(String[] args) 
	{
		//������Դ��
		Resourcetest r = new Resourcetest();
		//��������
		Inputtest in = new Inputtest(r);
		Outputtest out = new Outputtest(r);
		//�����̣߳�ִ��·����
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//�����߳�
		t1.start();
		t2.start();
	}
}
