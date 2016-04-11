package com.example.threadclassloader;

public class ThreadClassLoaderTest {

	public static void main(String[] args) {
		testThreadContext();
	}
	
	public static void testThreadContext(){
		Thread currentThread = Thread.currentThread();
		ClassLoader contextClassLoader = currentThread.getContextClassLoader();
//		currentThread.setContextClassLoader(cl);
		System.out.println(contextClassLoader.getClass().getName());
	}
}
