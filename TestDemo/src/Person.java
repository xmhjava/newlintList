import java.util.Date;

public class Person {
	
	private String name;
	private String password;
	private int age;
	private Date birthday;
	public Person() {
		System.out.println(111);
	}
	
	public Person(String name,int age) {
		System.out.println("==="+name+"==="+age);
	}
 
 public Date getBirthday(int age) {
	 System.out.println(2222+"====="+age);
	return birthday;
}

public String getab() {
	 return null;
 }


 
 
	
}
