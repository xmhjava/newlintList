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
	 * �õ�һ��Java�ļ�
	 * �����һ��class
	 * ͨ������õ�һ������
	 * return
	 */
	
    //��̬����ۺ�	
    UserDao userDao = new UserDaoImpl();
//    UserDao proxy1 = new LogUserProxy(userDao);
//    UserDao proxy2 = new TimerUserProxy(proxy1);
//    proxy2.query("����");
    
    
    UserDao Proxy = (UserDao) ProxyUtil.newProxyInstance(userDao);
    Proxy.query("����");
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

    
	
	
	
	
}
}
