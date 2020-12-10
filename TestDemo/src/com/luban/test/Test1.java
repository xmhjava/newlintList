package com.luban.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
//静态代理
	public static void main(String[] args) {
//		UserDaoImpl userDao=new LogUserProxy();
//		userDao.query("华安");
		
		final List<String> list = new ArrayList<String>();
		List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				return method.invoke(list, args);
			}
		});
		proxyInstance.add("888");
		System.out.println(list);
	}
}
