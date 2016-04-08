package com.example;

import java.lang.reflect.Method;

public class DefferentClassLoaderTest {

	/**
	 * 用不同类加载器加载的类测试 是否是同一个类
	 * @param object
	 */
	public static void main(String[] args) {
		new DefferentClassLoaderTest().testClassLoaderIdentity();
	}
	

	public void testClassLoaderIdentity(){
		//获得类的相对路径   右键属性
		String classDataRelativePath = "\\ClassLoaderTest\\src";
//		classDataRelativePath = "D:\\HotFixBaseTest\\ClassLoaderTest\\src";
		//初始化类加载器
		FileSystemClassLoader fileSystemClassLoader1 = new FileSystemClassLoader(classDataRelativePath);
		FileSystemClassLoader fileSystemClassLoader2 = new FileSystemClassLoader(classDataRelativePath);
		String className = "com.example.Sample";
		
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
}
