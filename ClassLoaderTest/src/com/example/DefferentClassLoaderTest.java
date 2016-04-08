package com.example;

import java.lang.reflect.Method;

import com.example.myclassloader.FileSystemClassLoaderOneChilder;
import com.example.myclassloader.FileSystemClassLoaderTwoChilder;

public class DefferentClassLoaderTest {

	/**
	 * 用不同类加载器加载的类测试 是否是同一个类
	 * @param object
	 */
	public static void main(String[] args) {
		new DefferentClassLoaderTest().testClassIdentity();
	}
	

	private void testClassLoaderIdentity(){
		//获得类的相对路径   右键属性
		String classDataRelativePath = "\\ClassLoaderTest\\src";
//		classDataRelativePath = "D:\\HotFixBaseTest\\ClassLoaderTest\\src";
		//初始化类加载器
		FileSystemClassLoader fileSystemClassLoader1 = new FileSystemClassLoader(classDataRelativePath);
		FileSystemClassLoader fileSystemClassLoader2 = new FileSystemClassLoader(classDataRelativePath);
		String className = "Sample";
		
		try {
			//获得类加载器 加载的类
			Class<?> class1 = fileSystemClassLoader1.loadClass(className);
			Class<?> class2 = fileSystemClassLoader2.loadClass(className);
			//反射获取类的实例
			Object object1 = class1.newInstance();
			Object object2 = class2.newInstance();
			//反射获取类的方法  	参数 方法名，参数类型的Class类
			Method method = class1.getMethod("setSample", Object.class);
			//执行方法
			method.invoke(object1, object2);
			System.out.println("成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	private void testClassIdentity() { 
		    String classDataRootPath = "F:\\HotFixBaseTest"; 
		    FileSystemClassLoader fscl1 = new FileSystemClassLoaderOneChilder(classDataRootPath); 
		    FileSystemClassLoader fscl2 = new FileSystemClassLoaderTwoChilder(classDataRootPath); 
		    String className = "Sample"; 	
		    try { 
		        Class<?> class1 = fscl1.loadClass(className); 
		        Object obj1 = class1.newInstance(); 
		        Class<?> class2 = fscl2.loadClass(className); 
		        Object obj2 = class2.newInstance(); 
		        System.out.println("obj1="+obj1.getClass().getClassLoader().getClass().getName());
		        System.out.println("obj2="+obj2.getClass().getClassLoader().getClass().getName());
		        Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class); 
		        setSampleMethod.invoke(obj1, obj2); 
		        System.out.println("testClassIdentity");

		    } catch (Exception e) { 
		        e.printStackTrace(); 
		    } 
		 }
}
