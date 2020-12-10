package com.luban.thread;

public class Single {

	private static  Single s=null;
	
	public Single() {
		
	}
	
	public static Single getInstance() {
		if(s==null) {
			s=new Single();
		}
		return s;
	}

}
