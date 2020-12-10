package com.luban.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderDemo {
public static void main(String[] args) throws IOException {
	FileReader fr=new FileReader("demo.txt");
	MyBufferedReader bufr = new MyBufferedReader(fr);
	String line=null;
	while((line=bufr.myReadLine())!=null) {
		System.out.println(line);
	}
	bufr.myClose();
	
	
}
}


class Test implements Runnable{

	public void run(Thread t) {
		
		
	}

	@Override
	public void run() {
		
		
	}
	
}