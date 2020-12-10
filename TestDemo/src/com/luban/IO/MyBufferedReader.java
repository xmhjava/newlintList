package com.luban.IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * �Զ���Ķ�ȡ����������ʵ����ģ��һ��BufferedReader
 * 
 * ������
 * ���������޷Ǿ��Ƿ�װ��һ������
 * �������ṩ�˸���ķ�����������з���
 * ��ʵ��Щ�������ղ����Ķ�������ĽǱ�
 * 
 * �����ԭ��
 * ��ʵ���Ǵ�Դ�л�ȡһ������װ���������С�
 * �ڴӻ������в��ϵ�ȡ��һ��һ������
 * 
 * �ڴ˴�ȡ����ڴ�Դ�м���ȡһ�����ݽ�������
 */
public class MyBufferedReader {
	private FileReader r;
	
	//����һ��������Ϊ������
	private char[] buf=new char[1024];
	
	//����һ��ָ�����ڲ�����������е�Ԫ�أ������������һ��Ԫ�غ�ָ��Ӧ�ù���
	private int pos=0;
	
	//����һ�����������ڼ�¼�������е����ݸ������������ݼ���0���ʹ�Դ�м�����ȡ���ݵ���������
	private int count=0;
	
	MyBufferedReader(FileReader r){
		this.r=r;
	}
	
	public int myRead() throws IOException {
		//��Դ�л�ȡһ�����ݵ��������У���Ҫ�����жϣ�ֻ�м�����Ϊ0������Ҫ��Դ�л�ȡ����
		if(count==0) {
			count=r.read(buf);
			pos=0;
		}
		if(count<0) {
			return -1;
		}
		System.out.println(111);
		char ch=buf[pos++];
		count--;
		return ch;
		
	}
	  
	public String myReadLine() throws IOException {
		StringBuffer sb=new StringBuffer();
		
		int ch=0;
		while((ch=myRead())!=-1) {
			System.out.println(222);
			if(ch=='\r') {
				continue;
			}
			if(ch=='\n') {
				return sb.toString();
				//���ӻ������ж�ȡ�����ַ����洢�����������ݵĻ�������
			}
			
			sb.append((char)ch);
		}
		
		if(sb.length()!=0) {
			return sb.toString();
		}
		
		return null;
		
		
	}
	
	
	public void myClose() throws IOException {
		r.close();
	}
	
}
























