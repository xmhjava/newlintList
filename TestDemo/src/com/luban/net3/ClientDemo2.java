package com.luban.net3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo2 {
public static void main(String[] args) throws Exception{
	/*�ͻ��˷������ݵ������
	 * 
	 * Tcp���䣬�ͻ���
	 * 1������tcp�ͻ���socket����ʹ�õ���Socker����
	 * ����ö���һ��������ȷĿ�ĵأ�Ҫ���ӵ�����
	 * 2��������ӽ����ɹ���˵�����ݴ���ͨ���ѽ���
	 * ��ͨ������socket�����ǵײ㽨���õģ���Ȼ������˵������������룬�������
	 * ��Ҫ���������������󣬿�����socket����ȡ
	 * ����ͨ��getOuputStream()��getInputStream()��ȡ�����ֽ���
	 * 3��ʹ���������������д����
	 * 4���ر���Դ
	 */
	
	Socket socket=new Socket("192.168.80.1", 10002);
	
	//��ȡsocket���е������
	OutputStream out = socket.getOutputStream();
	
	
	
	//ʹ���������ָ��������д��ȥ
	out.write("tcp��ʾ������������".getBytes());
	
	//��ȡ����˷��ص�����
	InputStream in=socket.getInputStream();
	byte[] buf=new byte[1024];
	int len = in.read(buf);
	
	String text=new String(buf,0,len);
	System.out.println("==text=="+text);
	
	
	//�ر���Դ
	socket.close();
}
	

}
