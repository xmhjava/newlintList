package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	System.out.println(11);
	Class forName = Class.forName("reflect.proxytest");
	Constructor constructor = forName.getConstructor(int.class);
	Object newInstance = constructor.newInstance(13);
	
	
}
}
