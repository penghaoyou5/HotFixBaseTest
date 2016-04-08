package com.example.myclassloader;

import com.example.FileSystemClassLoader;

public class FileSystemClassLoaderTwoChilder extends FileSystemClassLoader {

	public FileSystemClassLoaderTwoChilder(String rootDir) {
		super(rootDir);
	}

}
