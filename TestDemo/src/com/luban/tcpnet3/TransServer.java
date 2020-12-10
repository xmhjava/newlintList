package com.luban.tcpnet3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {
public static void main(String[] args) throws Exception {
	/*
	 * ת�������
	 * ����
	 * 1��serversocket����
	 * 2����ȡsocket����
	 * 3��Դ��socket,��ȡ�ͻ��˷���������Ҫת��������
	 * 4��Ŀ�ģ���ʾ�ڿ���̨��
	 * 5��������ת�ɴ�д���Ϳͻ���
	 */
	
	//1
	ServerSocket ss=new ServerSocket(10004);
	
	//��ȡsocket����
	Socket s = ss.accept();
	
	//��ȡip
	String ip=s.getInetAddress().getHostAddress();
	System.out.println(ip+".....connected");
	
	
	//3��ȡsocket��ȡ������װ��
	BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
	
	//4��ȡsocket�����������װ��
	PrintWriter out=new PrintWriter(s.getOutputStream());
	
	String line=null;
	while((line=bufIn.readLine())!=null) {
		System.out.print(line);
		out.println(line.toUpperCase()+"\r\n");
		out.flush();
	}
	
	s.close();
	ss.close();
	
	
}

}





