package com.luban.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeDemo {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * Runtime:û�й��췽��ժҪ��˵���˸��಻���Դ������� �ַ��ֻ��зǾ�̬�ķ�����˵������Ӧ���ṩ��̬�ķ��ظ������ķ�����
		 * ����ֻ��һ����˵��Runtime��ʹ���˵������ģʽ
		 */

		Runtime r = Runtime.getRuntime();

//   execute ִ�С� xxx.exe
		try {
			Runtime.getRuntime().exec("cmd /c start c:\\test.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block\
			System.out.println("file not found");
		}
		System.out.println("file  found");
	}
}
