import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class Demo2 {

	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Person p=new Person();
	    BeanUtils.setProperty(p, "name", "xzz");
	    
	    System.out.println(BeanUtils.getProperty(p, "name"));
	}
	
	
	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException {
		String name="aaaa";
		String password="123";
		String age="34";
		String birthday="1980-09-09";
		Person p=new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday());
		
	}
	
	
	@Test
	public void test3() throws IllegalAccessException, InvocationTargetException {
		String name="aaaa";
		String password="123";
		String age="34";
		String birthday="";
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) {
				if(value==null) {
					return null;
				}
				if(!(value instanceof String)) {
					throw new ConversionException("只支持String类型的转换");
				}
				String str=(String)value;
				if(str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				
			}
			
		}, Date.class);
		
		
		Person p=new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);
		
		
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday().toLocaleString());
		
	}
	
	
	@Test
	public void test5() throws IllegalAccessException, InvocationTargetException {
		Map map=new HashMap();
		map.put("name", "aaa");
		map.put("password", "123");
		map.put("age", "23");
		map.put("birthday", "1980-09-09");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		Person bean=new Person();
		BeanUtils.populate(bean, map);
		System.out.println(bean.getName());
		System.out.println(bean.getPassword());
		System.out.println(bean.getAge());
		System.out.println(bean.getBirthday()); 
		
		 
		
	}
	
	
	
	
	
	
	
	
}
