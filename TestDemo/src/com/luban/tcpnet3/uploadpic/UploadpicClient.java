package com.luban.tcpnet3.uploadpic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadpicClient {
public static void main(String[] args) throws Exception {
	
	//1,创建客户端socket
	Socket s=new Socket("192.168.80.1",10006);
	
	//2读取客户端要上传的图片文件
	FileInputStream fis = new FileInputStream("C:\\Users\\asus\\Desktop\\789.jpg");
	
	//3获取socket输出流。将读到图片数据发送到服务端
	OutputStream out = s.getOutputStream();
	
	byte[] buf=new byte[1024];
	
	int len=0;
	
	while((len=fis.read(buf))!=-1) {
		out.write(buf,0,len);
	}
			
	//告诉服务器端说：这边的数据发送完毕，让客户端停止读取
	s.shutdownOutput();
	
	//返回服务端发回的内容
	InputStream in = s.getInputStream();
	byte[] bufIn=new byte[1024];
	
	int lenIn = in.read(bufIn);
	String text=new String(buf,0,lenIn);
	System.out.println(text);
	
	fis.close();
	s.close();
	
	
}
}
