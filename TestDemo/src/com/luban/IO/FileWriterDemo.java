package com.luban.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
private static final String LINE_SEPARATOR = System.getProperty("line.separator");

public static void main(String[] args) throws IOException {
   //创建一个可以往文件中写入字符数据的字符输出流对象
	/**
	 * 既然是往一个文件中写入文字数据，那么在创建对象时，就必须明确该文件（用于存储数据的目的地）
	 * 
	 * 如果文件不存在，则会自动创建
	 * 如果文件存在，则会被覆盖
	 * 
	 * 如果构造函数中加入true，可以实现对文件进行续写
	 */
	
	FileWriter fw=new FileWriter("demo.txt");
	BufferedWriter bw=new BufferedWriter(fw);
	FileReader fr=new FileReader("");
	BufferedReader bufr=new BufferedReader(fr);
			bufr.readLine();
			bufr.read();
			char[] ch=new char[1024];
			bufr.read(ch);
			
	
	
	bw.write("");
	/**
	 * 调用write(String)方法，写入数据
	 * 其实数据写入到临时存储缓冲区中
	 */
	fw.write("abcde"+LINE_SEPARATOR+"hahaha");
	/**
	 * 进行刷新，将数据直接写到目的地中
	 */
	fw.flush();
	/**
	 * 关闭流，关闭资源，在关闭会先调用flush刷新缓存中的数据到目的地
	 */
	fw.close();
}
}














