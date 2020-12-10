package com.luban.tcpnet3.ie_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrowser {
public static void main(String[] args) throws Exception {
	
	Socket s=new Socket("192.168.80.1",8080);
	
	//模拟浏览器，给Tomcat服务端发送符合http协议的请求消息
	PrintWriter out = new PrintWriter(s.getOutputStream(),true);
	out.println("GET / HTTP/1.1");
	out.println("Accept: */*");
	out.println("Host: 192.168.1.80:8080");
	out.println("Connection: closes");
	out.println("");
	out.println("");
	
	InputStream in = s.getInputStream();
	
	byte[] buf=new byte[1024];
	int len=in.read(buf);
	
	String str = new String(buf,9,len);
	System.out.println(str);
}
}



