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
         * ��ѹ�ļ� 
         */  
        File zipFile = new File("G:/zip/nihao.rar");  
        String path = "G:/upzip";  
        UnZipFiles.unZipFiles(zipFile, path);
	}

	private static void test1() throws IOException {
		/** 
         * ѹ���ļ� 
         */  
        File[] files = new File[]{new File("d:/English"),new File("d:/��������.xls"),new File("d:/��������.xls")};  
        File zip = new File("d:/ѹ��.zip");  
        ZipFiles.ZipFiles(zip,"abc",files);  
          
        /** 
         * ��ѹ�ļ� 
         */  
        File zipFile = new File("d:/ѹ��.zip");  
        String path = "d:/zipfile/";  
        UnZipFiles.unZipFiles(zipFile, path);
	}  
}
