package com.luban.tcpnet3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {
public static void main(String[] args) throws Exception {
	/*思路：
	 * 客户端：
	 * 1：需要现有socket端点。
	 * 2：客户端的数据源：键盘
	 * 3：客户端的目的：socket
	 * 4：接收服务端的数据，源:socket
	 * 5：将数据显示在打印出来： 目的：控制台
	 * 6：在这些流中操作的数据，都是文本数据
	 * 
	 * 转换客户端
	 * 1，创建socket客户端对象
	 * 2，获取键盘录入
	 * 3，将录入的信息发送给socket输出流
	 */
	
	//创建socket客户端对象
	Socket s=new Socket("192.168.80.1", 10004);
	
	//获取键盘录入
	BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
	
	//3,socket输出流
	PrintWriter out=new PrintWriter(s.getOutputStream());
	
	//socket输入流，读取服务端返回的大写数据
	BufferedReader burIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
	
	String line=null;
	while((line=bufr.readLine())!=null) {
		if("over".equals(line)) {
			break;
		}
		out.print(line+"\r\n");
		out.flush();
		//读取服务端返回的一行大写数据
		String upperStr = burIn.readLine();
		System.out.println("==upperStr=="+upperStr);
	}
}

}






