package com.luban.proxy;

import com.luban.dao.UserDaoImpl;

public class LogUserProxy extends UserDaoImpl{

	public void query(String name) {
		System.out.println("log name="+name);
		System.out.println("query name="+name);
	}

}
