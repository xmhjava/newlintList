package com.luban.tcpnet3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {
public static void main(String[] args) throws Exception {
	/*˼·��
	 * �ͻ��ˣ�
	 * 1����Ҫ����socket�˵㡣
	 * 2���ͻ��˵�����Դ������
	 * 3���ͻ��˵�Ŀ�ģ�socket
	 * 4�����շ���˵����ݣ�Դ:socket
	 * 5����������ʾ�ڴ�ӡ������ Ŀ�ģ�����̨
	 * 6������Щ���в��������ݣ������ı�����
	 * 
	 * ת���ͻ���
	 * 1������socket�ͻ��˶���
	 * 2����ȡ����¼��
	 * 3����¼�����Ϣ���͸�socket�����
	 */
	
	//����socket�ͻ��˶���
	Socket s=new Socket("192.168.80.1", 10004);
	
	//��ȡ����¼��
	BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
	
	//3,socket�����
	PrintWriter out=new PrintWriter(s.getOutputStream());
	
	//socket����������ȡ����˷��صĴ�д����
	BufferedReader burIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
	
	String line=null;
	while((line=bufr.readLine())!=null) {
		if("over".equals(line)) {
			break;
		}
		out.print(line+"\r\n");
		out.flush();
		//��ȡ����˷��ص�һ�д�д����
		String upperStr = burIn.readLine();
		System.out.println("==upperStr=="+upperStr);
	}
}

}






