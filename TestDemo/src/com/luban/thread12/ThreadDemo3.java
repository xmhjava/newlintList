package com.luban.thread12;

public class ThreadDemo3 {

	public static void main(String[] args) 
	{
		DemoTest2 d1 = new DemoTest2("Íú²Æ");
		DemoTest2 d2 = new DemoTest2("xiaoqiang");
		d1.start();
		
		d2.start();

		System.out.println(4/0);//throw new ArithmeticException();

		for(int x=0; x<20; x++)
		{
			System.out.println(x+"...."+Thread.currentThread().getName());
		}
	}

}

class DemoTest2 extends Thread
{
	private String name;
	DemoTest2(String name)
	{
//		super(name);
		this.name = name;
	}
	public void run()
	{
		int[] arr = new int[3];
		System.out.println(arr[3]);
		for(int x=0; x<10; x++)
		{
			System.out.println("....x="+x+".....name="+Thread.currentThread().getName());
		}
	}
}
