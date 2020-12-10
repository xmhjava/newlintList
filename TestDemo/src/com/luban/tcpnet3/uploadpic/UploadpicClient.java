package com.luban.tcpnet3.uploadpic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadpicClient {
public static void main(String[] args) throws Exception {
	
	//1,�����ͻ���socket
	Socket s=new Socket("192.168.80.1",10006);
	
	//2��ȡ�ͻ���Ҫ�ϴ���ͼƬ�ļ�
	FileInputStream fis = new FileInputStream("C:\\Users\\asus\\Desktop\\789.jpg");
	
	//3��ȡsocket�������������ͼƬ���ݷ��͵������
	OutputStream out = s.getOutputStream();
	
	byte[] buf=new byte[1024];
	
	int len=0;
	
	while((len=fis.read(buf))!=-1) {
		out.write(buf,0,len);
	}
			
	//���߷�������˵����ߵ����ݷ�����ϣ��ÿͻ���ֹͣ��ȡ
	s.shutdownOutput();
	
	//���ط���˷��ص�����
	InputStream in = s.getInputStream();
	byte[] bufIn=new byte[1024];
	
	int lenIn = in.read(bufIn);
	String text=new String(buf,0,lenIn);
	System.out.println(text);
	
	fis.close();
	s.close();
	
	
}
}
