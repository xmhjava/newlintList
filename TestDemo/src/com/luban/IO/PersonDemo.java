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
		System.out.println("�Է�");
	}
}

//�����ĳ�����Ϊ����ǿPersion�����ֵ�
class NewPerson{
	private Person p;
	public NewPerson(Person p) {
		this.p=p;
	}
	
	public void chifan() {
		System.out.println("��θ��");
		p.chifan();
		System.out.println("���");
	}
	
}





