package com.luban.thread13;

public class SingleDemo {
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}

}
/*
���߳��µĵ���

*/

//����ʽ
class Single
{
	private static final Single s = new Single();
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
}



//����ʽ

//����ͬ��Ϊ�˽�����̰߳�ȫ���⡣
//����˫���ж���Ϊ�˽��Ч�����⡣

class Singletest
{
	private static Singletest s = null;

	private Singletest(){}

	public static Singletest getInstance()
	{
		if(s==null)
		{
			synchronized(Singletest.class)		
			{
				if(s==null)
		//				-->0 -->1
					s = new Singletest();
			}
		}
		return s;
	}
}