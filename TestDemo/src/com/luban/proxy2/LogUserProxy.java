package com.luban.proxy2;

import com.luban.dao.UserDao;

public class LogUserProxy implements UserDao{
    public UserDao userDao;
	
	
	public LogUserProxy(UserDao userDao) {
		this.userDao=userDao;
	}

	
	public void query(String name) {
		System.out.println("log...");
		userDao.query("¡¶¡¶¡·¡·"+name);
	}
	
}
