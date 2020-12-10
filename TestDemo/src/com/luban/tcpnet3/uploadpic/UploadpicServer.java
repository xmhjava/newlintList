package com.luban.tcpnet3.uploadpic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadpicServer {

	public static void main(String[] args) throws Exception {
     //创建tcp的socket服务端
		ServerSocket ss=new ServerSocket(10006);
		
		
		while(true) {
			//获取客户端
			Socket s = ss.accept();
			new Thread(new UploadTask(s)).start();
			
		}
		
		
		

//		ss.close();
		
		
	}

}
