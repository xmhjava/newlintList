package com.luban.net2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceDemo2 {

	public static void main(String[] args) throws Exception {
		System.out.println("接收端启动。。。。。。。");
		
		/**
		 * 建立UDP接收端的思路
		 * 1，建立udp socket服务，因为是接收数据，必须要明确一个端口号
		 * 2，创建数据包，用于存储接收到的数据。方便用数据包对象的方法解析
		 * 3，使用socket服务的receive方法将接收的数据存储到数据包中
		 * 4，通过数据包的方法解析数据包中的数据
		 * 5，关闭资源
		 */
		
		//建立udp socket服务
		DatagramSocket ds=new DatagramSocket(10000);
		
		//2创建数据包
		while(true) {
		byte[] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		
		//使用接收方法将数据存储到数据包中
		ds.receive(dp);//堵塞式的
		
		//通过数据包对象的方法，解析其中的数据，比如，地址，端口，数据内容
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		System.out.println("==ip=="+ip);
		String text=new String(dp.getData(),0,dp.getLength());
		System.out.println(ip+":"+port+":"+text);
		}
		//关闭资源
	//	ds.close();
		
		
		
		
		
		
	}

}
