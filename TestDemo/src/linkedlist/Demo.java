package linkedlist;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.apache.commons.beanutils.PropertyUtils;

public class Demo {
	public static void main(String[] args) {
		
		Subject sub = new RealSubject();
		InvocationHandler hand = new InvocationHandlerImpl(sub);
		 Subject subject = (Subject)Proxy.newProxyInstance(Demo.class.getClassLoader(), sub
	                .getClass().getInterfaces(), hand);
		String sayHello = subject.SayHello("8888");
		System.out.println("===="+sayHello);
	}
}







