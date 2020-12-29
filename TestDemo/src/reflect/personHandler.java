package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class personHandler implements InvocationHandler{
	Person p;
	
	public personHandler(Person p) {
		this.p=p;
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	System.out.println("执行代理之前");
	method.invoke(p, args);
	System.out.println("执行代理之后");
		return null;
	}

}
