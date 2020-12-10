package com.luban.tcpnet3.uploadtext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.mina.filter.buffer.BufferedWriteFilter;

public class DemoXmm {
public static void main(String[] args) throws IOException {
	int count=0;
	String ip="192.168.80.1";
	String dir="C:\\pic";
	File file=new File(dir,ip+".jpg");
	//如果文件已经存在于服务端 
	while(file.exists()){
		System.out.println(111111111);
		file = new File(dir,ip+"("+(++count)+").jpg");
	}
	
	
}

}
