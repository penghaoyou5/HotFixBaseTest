package com.example.myclassloader;

import com.example.FileSystemClassLoader;

public class FileSystemClassLoaderOneChilder extends FileSystemClassLoader {

	public FileSystemClassLoaderOneChilder(String rootDir) {
		super(rootDir);
	}

}
