package com.example;

import java.lang.reflect.Method;

import com.example.myclassloader.FileSystemClassLoaderOneChilder;
import com.example.myclassloader.FileSystemClassLoaderTwoChilder;

public class DefferentClassLoaderTest {

	/**
	 * �ò�ͬ����������ص������ �Ƿ���ͬһ����
	 * @param object
	 */
	public static void main(String[] args) {
		new DefferentClassLoaderTest().testClassIdentity();
	}
	

	private void testClassLoaderIdentity(){
		//���������·��   �Ҽ�����
		String classDataRelativePath = "\\ClassLoaderTest\\src";
//		classDataRelativePath = "D:\\HotFixBaseTest\\ClassLoaderTest\\src";
		//��ʼ���������
		FileSystemClassLoader fileSystemClassLoader1 = new FileSystemClassLoader(classDataRelativePath);
		FileSystemClassLoader fileSystemClassLoader2 = new FileSystemClassLoader(classDataRelativePath);
		String className = "Sample";
		
		try {
			//���������� ���ص���
			Class<?> class1 = fileSystemClassLoader1.loadClass(className);
			Class<?> class2 = fileSystemClassLoader2.loadClass(className);
			//�����ȡ���ʵ��
			Object object1 = class1.newInstance();
			Object object2 = class2.newInstance();
			//�����ȡ��ķ���  	���� ���������������͵�Class��
			Method method = class1.getMethod("setSample", Object.class);
			//ִ�з���
			method.invoke(object1, object2);
			System.out.println("�ɹ�");
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
