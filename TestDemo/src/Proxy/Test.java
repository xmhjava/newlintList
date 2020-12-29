package Proxy;

public class Test {
public static void main(String[] args) {
	//目标对象
	StudentDao sd=new StudentDaoImpl();
	//代理对象
	InvocationHandler h1=new StudentDaoImplTimeProxy(sd);
	StudentDao dao1=(StudentDao)Proxy.newProxyInstance(StudentDao.class,h1);  	
	dao1.query(1, "www");
	String enter="\n";
	String tab="\t";
	
	System.out.println("8888"+tab+"9999");
}
}
