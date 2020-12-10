package com.luban.net2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable {

	private DatagramSocket ds;

	public Rece(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);

				// ʹ�ý��շ��������ݴ洢�����ݰ���
				ds.receive(dp);// ����ʽ��

				// ͨ�����ݰ�����ķ������������е����ݣ����磬��ַ���˿ڣ���������
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				System.out.println("==ip==" + ip);
				String text = new String(dp.getData(), 0, dp.getLength());
				if(text.equals("886")) {
					System.out.println(ip+"....�˳�������");
				}
				
				System.out.println(ip + ":" + port + ":" + text);
			}
		} catch (Exception e) {

		}

	}

}
