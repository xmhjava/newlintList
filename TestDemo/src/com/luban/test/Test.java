package com.luban.test;

import java.io.File;
import java.io.IOException;

import com.luban.dao.UserDao;
import com.luban.dao.UserDaoImpl;
import com.luban.proxy2.LogUserProxy;
import com.luban.proxy2.TimerUserProxy;
import com.luban.utils.ProxyUtil;

public class Test {
public static void main(String[] args) throws Exception {
	
	/**
	 * 得到一个Java文件
	 * 编译成一个class
	 * 通过反射得到一个对象
	 * return
	 */
	
    //静态代理聚合	
    UserDao userDao = new UserDaoImpl();
//    UserDao proxy1 = new LogUserProxy(userDao);
//    UserDao proxy2 = new TimerUserProxy(proxy1);
//    proxy2.query("华安");
    
    
    UserDao Proxy = (UserDao) ProxyUtil.newProxyInstance(userDao);
    Proxy.query("华安");
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

    
	
	
	
	
}
}
