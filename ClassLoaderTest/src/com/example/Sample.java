package com.example;

import java.lang.reflect.Method;

public class Sample {

	/**
	 * �ò�ͬ����������ص������ �Ƿ���ͬһ����
	 * @param object
	 */
	public static void main(String[] args) {
		new Sample().testClassLoaderIdentity();
	}
	
	
	public void setSample(Object object){
		Sample sample = (Sample)object;
	}
	
	
	public void testClassLoaderIdentity(){
		//���������·��   �Ҽ�����
		String classDataRelativePath = "\\ClassLoaderTest\\src";
//		classDataRelativePath = "D:\\HotFixBaseTest\\ClassLoaderTest\\src";
		//��ʼ���������
		FileSystemClassLoader fileSystemClassLoader1 = new FileSystemClassLoader(classDataRelativePath);
		FileSystemClassLoader fileSystemClassLoader2 = new FileSystemClassLoader(classDataRelativePath);
		String className = "com.example.Sample";
		
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
			method.invoke(object2, object1);
			System.out.println("�ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}