package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class refletDemo {
public static void main(String[] args) {
	Person p=new childPerson();
	ClassLoader classLoader = p.getClass().getClassLoader();
	Class<?>[] interfaces = p.getClass().getInterfaces();
	InvocationHandler hand=new personHandler(p);
	
	Person instance = (Person) Proxy.newProxyInstance(classLoader, interfaces, hand);
	instance.eat();
	
}
}
