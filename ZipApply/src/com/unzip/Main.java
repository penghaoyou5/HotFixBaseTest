package com.unzip;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {  
//        test1();
    	testUnzipFile();
//    	testUpzipDir();
    }


	private static void testUpzipDir() throws IOException {
		UnZipFiles.upZipDirFiles("G:\\zip", "G:\\unzip");
	}
	
	private static void testUnzipFile() throws IOException {
		 /** 
         * 解压文件 
         */  
        File zipFile = new File("G:/zip/nihao.rar");  
        String path = "G:/upzip";  
        UnZipFiles.unZipFiles(zipFile, path);
	}

	private static void test1() throws IOException {
		/** 
         * 压缩文件 
         */  
        File[] files = new File[]{new File("d:/English"),new File("d:/发放数据.xls"),new File("d:/中文名称.xls")};  
        File zip = new File("d:/压缩.zip");  
        ZipFiles.ZipFiles(zip,"abc",files);  
          
        /** 
         * 解压文件 
         */  
        File zipFile = new File("d:/压缩.zip");  
        String path = "d:/zipfile/";  
        UnZipFiles.unZipFiles(zipFile, path);
	}  
}
