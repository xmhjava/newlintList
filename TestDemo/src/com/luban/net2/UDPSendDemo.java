package com.luban.net2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendDemo {
public static void main(String[] args) throws IOException {
	System.out.println("���Ͷ�����������������");
	
	/**
	 * ����UDP����ķ��Ͷ�
	 * ˼·��
	 *1������udp��socket����
	 *2����Ҫ���͵����ݷ�װ�����ݰ��� 
	 *3��ͨ��udp��socket�������ݰ����ͳ�ȥ��
	 *4���ر�socket����
	 */
	//1,updsocket����ʹ��DatagramSocket����
	
	DatagramSocket ds=new DatagramSocket();
	
	//2����Ҫ���͵����ݷ�װ�����ݰ���
	String str="upd������ʾ����������";
	
	//ʹ��DatagramPacket�����ݷ�װ���ĸĶ������
	byte[] buf = str.getBytes();
	
	DatagramPacket dp = 
	new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.80.1"), 10000);
	
	
	//ͨ��udp��socket�������ݰ����ͳ�ȥ��ʹ��send����
	ds.send(dp);
	
	//�ر���Դ
	ds.close();
	
}
}
