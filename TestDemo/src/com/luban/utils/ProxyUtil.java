package com.luban.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.luban.dao.UserDao;
import com.mysql.jdbc.log.Log;

public class ProxyUtil {

 public static Object newProxyInstance(Object target) throws Exception {
	 String content="";
	 String packageContent="package com.luban;";
	 Class targetInfo = target.getClass().getInterfaces()[0];
	 String targetInfoName = targetInfo.getSimpleName();
	 System.out.println("===targetInfoName==="+targetInfoName+"===="+targetInfo.getName());
	 String importContent="import "+targetInfo.getName()+";";
	 String classContent="public class $Proxy implements "+targetInfoName+"{";
	 /**
	  *     public UserDao userDao;
	
	
	        public LogUserProxy(UserDao userDao) {
		        this.userDao=userDao;
	        }

	  */
	 
	 String fieldContent="private "+targetInfoName+" target;";
	 String construterContent="public $Proxy("+targetInfoName+" target){"
	 		+ " this.target=target;}";
			 
	 String methodsContent="";
	 Method[] methods=targetInfo.getDeclaredMethods();
	 for (Method method : methods) {
		/**
		 * public void query(String name) {
		   System.out.println("log...");
		    userDao.query("¡¶¡¶¡·¡·"+name);
	        }
		 */
		 String methodsName=method.getName();
		 Class returnType = method.getReturnType();
		 Class<?>[] parameterTypes = method.getParameterTypes();
		 String argsContent="";
		 String argsNames="";
		 int i=0;
		 for (Class<?> parameterType : parameterTypes) {
			String simpleName=parameterType.getSimpleName();
			argsContent+=simpleName+" p"+i+",";
			argsNames+="p"+i+",";
			i++;
		}
		 
		 
		 if(argsContent.length()>0){
			 argsContent=argsContent.substring(0, argsContent.lastIndexOf(",")-1);
			 argsNames=argsNames.substring(0, argsNames.lastIndexOf(",")-1);
		 }
		 methodsContent="public "+returnType+" "+methodsName+"("+argsContent+") {"
		 		+ "System.out.println(\"log....\");"
		 		+ "target."+methodsName+"("+argsNames+");}";
		 
		 
		 
	}
	 
	 content+=packageContent+importContent+classContent+fieldContent+construterContent+methodsContent+"}";
	 File file=new File("D:/com/luban/$Proxy.java");
	 File parentFile = file.getParentFile();
	 if(!file.exists()) {
		 parentFile.mkdirs();
	 }
	 file.createNewFile();
	 FileWriter fileWriter = new FileWriter(file);
	 fileWriter.write(content);
	 fileWriter.flush();
	 fileWriter.close();
	 
	 JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	 StandardJavaFileManager fileManager=compiler.getStandardFileManager(null, null, null);
	 Iterable units = fileManager.getJavaFileObjects(file);
	 JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);
	 task.call();
	 fileManager.close();
	 
	 URL[] urls=new URL[] {new URL("file:D:////")};
	 URLClassLoader urlClassLoader = new URLClassLoader(urls);
	 Class clazz = urlClassLoader.loadClass("com.luban.$Proxy");
	 Constructor constructor = clazz.getConstructor(targetInfo);
	 Object proxy = constructor.newInstance(target);
	 
	  return proxy;
	 
 }

}




