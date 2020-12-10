package com.luban.net3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceDemo {
public static void main(String[] args) throws Exception {
	//����˽��տͻ��˷��͹��������ݣ�����ӡ�ڿ���̨��
	/*
	 * ����tcp����˵�˼·
	 * 1�����������socket����ͨ��ServerSocket����
	 * 2������˱�������ṩһ���˿ڣ���զ�ͻ����޷�����
	 * 3����ȡ���ӹ����Ŀͻ��˶���
	 * 4��ͨ���ͻ��˶����ȡsocket����ȡ�ͻ��˷���������
	 * 5���ر���Դ���ؿͻ��ˣ��ط����
	 */
	
	//��������˶���
	ServerSocket ss=new ServerSocket(10002);
	
	//��ȡ���ӹ����Ŀͻ��˶���
	Socket s = ss.accept();
	
	String ip=s.getInetAddress().getHostAddress();
	
	
	//3,ͨ��socket�����ȡ��������Ҫ��ȡ�ͻ��˷���������
	InputStream in = s.getInputStream();
	
	byte[] buf=new byte[1024];
	int len = in.read(buf);
	String text = new String(buf,0,len);
	System.out.println(ip+"server:"+text);
	
	s.close();
	ss.close();
	
	
}

}
