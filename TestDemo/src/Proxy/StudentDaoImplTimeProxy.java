package Proxy;

import java.lang.reflect.Method;

public class StudentDaoImplTimeProxy implements InvocationHandler{
	Object obj;
	public StudentDaoImplTimeProxy(Object obj) {
		this.obj=obj;
	}
		@Override
		public Object invoke(Method method, Object[] args) {	
			Object ob=null;
			try {
				 System.out.println("===========开始记录日志===========");		 
				ob=method.invoke(obj,args);
				 System.out.println("===========结束记录===========");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ob;
		}

}
