package com.luban.proxy;

import com.luban.dao.UserDaoImpl;

public class TimeUserProxy extends UserDaoImpl{

	public void query(String name) {
		System.out.println("Time name="+name);
		System.out.println("query name="+name);
	}

}
