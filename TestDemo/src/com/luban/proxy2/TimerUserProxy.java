package com.luban.proxy2;

import com.luban.dao.UserDao;
import com.luban.dao.UserDaoImpl;

public class TimerUserProxy implements UserDao
{
	public UserDao userDao;
	
	public TimerUserProxy(UserDao userDao) {
		this.userDao=userDao;
	}
	
	public void query(String name) {
		System.out.println("Time ...");
		userDao.query(name);
	}
	

}
