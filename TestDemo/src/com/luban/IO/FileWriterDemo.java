package com.luban.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
private static final String LINE_SEPARATOR = System.getProperty("line.separator");

public static void main(String[] args) throws IOException {
   //����һ���������ļ���д���ַ����ݵ��ַ����������
	/**
	 * ��Ȼ����һ���ļ���д���������ݣ���ô�ڴ�������ʱ���ͱ�����ȷ���ļ������ڴ洢���ݵ�Ŀ�ĵأ�
	 * 
	 * ����ļ������ڣ�����Զ�����
	 * ����ļ����ڣ���ᱻ����
	 * 
	 * ������캯���м���true������ʵ�ֶ��ļ�������д
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
	 * ����write(String)������д������
	 * ��ʵ����д�뵽��ʱ�洢��������
	 */
	fw.write("abcde"+LINE_SEPARATOR+"hahaha");
	/**
	 * ����ˢ�£�������ֱ��д��Ŀ�ĵ���
	 */
	fw.flush();
	/**
	 * �ر������ر���Դ���ڹرջ��ȵ���flushˢ�»����е����ݵ�Ŀ�ĵ�
	 */
	fw.close();
}
}














