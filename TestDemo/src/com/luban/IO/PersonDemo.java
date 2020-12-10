package com.luban.IO;

public class PersonDemo {
	public static void main(String[] args) {
		Person p=new Person();
		//p.chifan();
		
		
		NewPerson p1=new NewPerson(p);
		p1.chifan();
		
	}

}

class Person{
	void chifan() {
		System.out.println("吃饭");
	}
}

//这个类的出现是为了增强Persion而出现的
class NewPerson{
	private Person p;
	public NewPerson(Person p) {
		this.p=p;
	}
	
	public void chifan() {
		System.out.println("开胃酒");
		p.chifan();
		System.out.println("甜点");
	}
	
}





