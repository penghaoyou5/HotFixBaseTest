package com.example.myclassloader;

import com.example.FileSystemClassLoader;

public class FileSystemClassLoaderOneChilder extends FileSystemClassLoader {

	public FileSystemClassLoaderOneChilder(String rootDir) {
		super(rootDir);
	}
	
	public static void main(String[] args) {
		FileSystemClassLoaderOneChilder fileSystemClassLoaderOneChilder = new FileSystemClassLoaderOneChilder("");
		ClassLoader parent2 = fileSystemClassLoaderOneChilder.getParent();
		System.out.println(parent2.getClass().getName());
	}

}
