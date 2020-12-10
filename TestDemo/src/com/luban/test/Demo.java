package com.luban.test;

public class Demo {
	
	void aa() {
		this.bb();
		System.out.println(222);
	}
	
	void bb() {
		System.out.println(333);
	}
public static void main(String[] args) {
	Demo d=new Demo();
	d.aa();
	
}
}
