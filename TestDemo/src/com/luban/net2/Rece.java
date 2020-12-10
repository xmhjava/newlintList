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

				// 使用接收方法将数据存储到数据包中
				ds.receive(dp);// 堵塞式的

				// 通过数据包对象的方法，解析其中的数据，比如，地址，端口，数据内容
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				System.out.println("==ip==" + ip);
				String text = new String(dp.getData(), 0, dp.getLength());
				if(text.equals("886")) {
					System.out.println(ip+"....退出聊天室");
				}
				
				System.out.println(ip + ":" + port + ":" + text);
			}
		} catch (Exception e) {

		}

	}

}
