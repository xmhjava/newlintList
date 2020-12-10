package com.luban.owner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler{
	   PersonBean person;
	   
	    public NonOwnerInvocationHandler(PersonBean person) {
	        this.person = person;
	    }
	 
	    @Override
	    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
	        try {
	            if (method.getName().startsWith("get")){
	                return method.invoke(person, args);
	            } else if (method.getName().equals("setHotOrNotRating")) {
	                return method.invoke(person, args);
	            } else if (method.getName().startsWith("set")) {
	                throw  new IllegalAccessException();
	            }
	        } catch (InvocationTargetException e) { // 真正主题抛出异常
	            e.printStackTrace();
	        }
	        return null; // 如果调用其他的方法，一律不理，返回null
	    }

}
