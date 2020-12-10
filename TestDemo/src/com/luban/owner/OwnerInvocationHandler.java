package com.luban.owner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler{
    PersonBean person;
 
    public OwnerInvocationHandler(PersonBean person){
        this.person = person;
    }
 
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
             System.out.println("==method=="+method.getName());
        try {
            if (method.getName().startsWith("get")){
            	System.out.println("aaa");
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
            	System.out.println("bbb");
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")) {
            	System.out.println("ccc");
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) { // 真正主题抛出异常
            e.printStackTrace();
        }
        return null; // 如果调用其他的方法，一律不理，返回null
    }


}
