package com.luban.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo extends Object{
public static void main(String[] args) throws UnknownHostException {
	//��ȡ��������ip��ַ����
	InetAddress ip = InetAddress.getLocalHost();
	
	//��ȡ����������ip��ַ����
	ip = InetAddress.getByName("www.baidu.com");
	
	System.out.println(ip.getHostAddress());
	System.out.println(ip.getHostName());
	
	
	
	
}
}
