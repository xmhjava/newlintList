package com.luban.net2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceDemo {

	public static void main(String[] args) throws Exception {
		System.out.println("���ն�������������������");
		
		/**
		 * ����UDP���ն˵�˼·
		 * 1������udp socket������Ϊ�ǽ������ݣ�����Ҫ��ȷһ���˿ں�
		 * 2���������ݰ������ڴ洢���յ������ݡ����������ݰ�����ķ�������
		 * 3��ʹ��socket�����receive���������յ����ݴ洢�����ݰ���
		 * 4��ͨ�����ݰ��ķ����������ݰ��е�����
		 * 5���ر���Դ
		 */
		
		//����udp socket����
		DatagramSocket ds=new DatagramSocket(10000);
		
		//2�������ݰ�
		byte[] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		
		//ʹ�ý��շ��������ݴ洢�����ݰ���
		ds.receive(dp);//����ʽ��
		
		//ͨ�����ݰ�����ķ������������е����ݣ����磬��ַ���˿ڣ���������
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		System.out.println("==ip=="+ip);
		String text=new String(dp.getData(),0,dp.getLength());
		System.out.println(ip+":"+port+":"+text);
		//�ر���Դ
		ds.close();
		
		
		
		
		
		
	}

}
