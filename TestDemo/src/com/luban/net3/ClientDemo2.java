package com.luban.net3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo2 {
public static void main(String[] args) throws Exception{
	/*客户端发送数据到服务端
	 * 
	 * Tcp传输，客户端
	 * 1，创建tcp客户端socket服务，使用的是Socker对象
	 * 建议该对象一创建就明确目的地，要连接的主机
	 * 2，如何连接建立成功，说明数据传输通道已建立
	 * 该通道就是socket流，是底层建立好的，既然是流，说明这里既有输入，又有输出
	 * 想要输入或者输出流对象，可以找socket来获取
	 * 可以通过getOuputStream()和getInputStream()获取两个字节流
	 * 3，使用输出流：将数据写出。
	 * 4，关闭资源
	 */
	
	Socket socket=new Socket("192.168.80.1", 10002);
	
	//获取socket流中的输出流
	OutputStream out = socket.getOutputStream();
	
	
	
	//使用输出流将指定的数据写出去
	out.write("tcp演示；哥们又来了".getBytes());
	
	//读取服务端返回的数据
	InputStream in=socket.getInputStream();
	byte[] buf=new byte[1024];
	int len = in.read(buf);
	
	String text=new String(buf,0,len);
	System.out.println("==text=="+text);
	
	
	//关闭资源
	socket.close();
}
	

}
