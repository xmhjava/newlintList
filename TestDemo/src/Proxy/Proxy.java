package Proxy;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
public class Proxy {
	/**
	 * 动态生成一个动态代理类
	 * @param interfaceClass 实现的接口
	 * @param handler 处理的业务逻辑
	 * @return
	 */                                          
	public static Object newProxyInstance(Class interfaceClass,InvocationHandler handler){
		String interfaceName=interfaceClass.getName();
		String interfaceSimpleName=interfaceClass.getSimpleName();
		String enter="\n";
		String tab="\t";
 
		//生成代码字符串1
		String proxyStr1="import "+interfaceName+";\n"
				+ "import Proxy.InvocationHandler;\n"
				+ "import java.lang.reflect.Method;"+
				enter+"public class Proxy$ implements "+interfaceSimpleName+"{"+
				enter+tab+"InvocationHandler handler;"+
				enter+tab+"public Proxy$("+handler.getClass().getName()+" handler){"+
				enter+tab+tab+"this.handler=handler;"+
				enter+tab+"}";
		
		//生成代码字符串2
		String proxyStr2="";
		//获得所接口的所有方法
		Method me[]=interfaceClass.getMethods();
		for (Method method : me) {
			
			String paramStr="";  //形参字符串
			String paramName=""; //参数名字字符串
			String paramClass="";//参数类型字符串
			int i=1;
			
			//得到方法所有参数
			Class paramTypeClass[]=method.getParameterTypes();
			for (Class class1 : paramTypeClass) {			//遍历所有的参数
				paramStr+=class1.getSimpleName()+" args"+i+","; //动态得到形参
				paramName+="args"+i+",";			//动态创建各个参数名字
				paramClass+=class1.getSimpleName()+".class,";	//动态创建获得“参数类型”的“类对象”字符串
				 i++;
			}
			
			//判断该方法是否有参数，有参数的话 length一定会大于0的
			if(paramStr.length()>0){     
				//截取掉最后一个"," 
				paramStr=paramStr.substring(0,paramStr.length()-1);  
				paramName=paramName.substring(0,paramName.length()-1);
				paramClass=","+paramClass.substring(0,paramClass.length()-1);		
			}
			
			//得到返回值类型
			String returnType=method.getReturnType().getSimpleName();
			proxyStr2+=enter+tab+"public "+returnType+" "+method.getName()+"("+paramStr+") {"+
					
			enter+tab+tab+"try{";
			//判断是否有返回值
			if(returnType.equals("void")){ 
	                        //生成获得Method的字符串							
				proxyStr2+=enter+tab+tab+"Method md ="+interfaceSimpleName+".class.getMethod(\""+method.getName()+"\""+paramClass+");";
				//调用传入handler的invoke方法，实现代理功能		
				proxyStr2+=enter+tab+tab+"handler.invoke(md,new Object[]{"+paramName+"});";
				proxyStr2+=enter+tab+tab+"} catch (Exception e) {"+
						enter+tab+tab+"e.printStackTrace();"+
						enter+tab+tab+"}";
				proxyStr2+=enter+tab+"}";
			}else{
				proxyStr2+=enter+tab+tab+"Method md ="+interfaceSimpleName+".class.getMethod(\""+method.getName()+"\""+paramClass+");";	
				proxyStr2+=enter+tab+tab+"return ("+returnType+") handler.invoke(md,new Object[]{"+paramName+"});";
				proxyStr2+=enter+tab+tab+"} catch (Exception e) {"+
						enter+tab+tab+"e.printStackTrace();"+
						enter+tab+tab+"}";
						
						//判断返回类型是否为基本数据类型
						if( returnType.equals("int")||
						  returnType.equals("short")||
						   returnType.equals("long")||
						   returnType.equals("char")||
						  returnType.equals("float")||
						 returnType.equals("double")||
						   returnType.equals("byte")){
							proxyStr2+=enter+tab+tab+"return 0;";
						}else if(returnType.equals("boolean")){
							proxyStr2+=enter+tab+tab+"return false;";
						}else{
							proxyStr2+=enter+tab+tab+"return null;";
						}
						
				proxyStr2+=enter+tab+"}";
			}
			
		}
	 proxyStr2+=enter+tab+"}";
 
	 //创建proxy$.java文件到项目外的一个目录下
	 File file=new File("D:\\Users\\Proxy$.java");
	 try {
		file.createNewFile();
		FileWriter fw=new FileWriter(file);
		fw.write(proxyStr1+proxyStr2);//把生成的代码字符串写入到创建的java文件中
		fw.flush();
		
		//使用javaCompiler(java编译器)编译刚才创建的java类
		JavaCompiler  compiler = ToolProvider.getSystemJavaCompiler();
		//文件管理者
		StandardJavaFileManager fileMange = compiler.getStandardFileManager(null, null, null);
		//获取文件
		Iterable it=fileMange.getJavaFileObjects(file.getPath());
		//编译任务
		CompilationTask t = compiler.getTask(null, fileMange, null, null, null, it);
		//进行编译
		t.call();
		
		//使用URL得到该java类所在的路径，并放入URL数组中
		URL url = new URL("file:/D:\\Users\\");
		URL[] urls = new URL[]{url};
		
		//通过URLClassLoader（URL类加载器）加载urls里面的类到内存中
		URLClassLoader  urlClassLoader = new URLClassLoader(urls);
		//通过类全名得到类加载器中的代理类的类对象	（这里填写类全名，因为该类没有包名，所以这里的全名就是该java文件名）
		Class clazzProxy =urlClassLoader.loadClass("Proxy$");
		
		//因为我们产生的java类不是在我们的项目中，所以，我们不能使用 Class.forName()来得到该类的实例，
		//那么我们可以通过“Constructor(构造器)”来得到一个类的实例
		@SuppressWarnings("unchecked")
		//从代理类中得到一个构造方法，通过构造方法来实例该类
		Constructor constructor= clazzProxy.getConstructor(handler.getClass());
		Object object =constructor.newInstance(handler);
		//返回代理类
		return object;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		
		return null;
	}

}
