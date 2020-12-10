package com.luban.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeDemo {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * Runtime:没有构造方法摘要，说明了该类不可以创建对象。 又发现还有非静态的方法，说明该类应该提供静态的返回该类对象的方法。
		 * 而且只有一个，说明Runtime类使用了单例设计模式
		 */

		Runtime r = Runtime.getRuntime();

//   execute 执行。 xxx.exe
		try {
			Runtime.getRuntime().exec("cmd /c start c:\\test.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block\
			System.out.println("file not found");
		}
		System.out.println("file  found");
	}
}
