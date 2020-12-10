package com.luban.net2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendDemo2 {
	public static void main(String[] args) throws IOException {
		System.out.println("���Ͷ�����������������");

		/**
		 * ����UDP����ķ��Ͷ� ˼·�� 1������udp��socket���� 2����Ҫ���͵����ݷ�װ�����ݰ��� 3��ͨ��udp��socket�������ݰ����ͳ�ȥ��
		 * 4���ر�socket����
		 */
		// 1,updsocket����ʹ��DatagramSocket����

		DatagramSocket ds = new DatagramSocket();

		// 2����Ҫ���͵����ݷ�װ�����ݰ���
		// String str="upd������ʾ����������";
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		while ((line = bufr.readLine()) != null) {
			byte[] buf = line.getBytes();
			
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.80.1"), 10000);
			
			ds.send(dp);
			
			if ("over".equals(line))
				break;
		}

		// ͨ��udp��socket�������ݰ����ͳ�ȥ��ʹ��send����

		// �ر���Դ
		ds.close();

	}
}
