package com.unrar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import de.innosystec.unrar.Archive;
import de.innosystec.unrar.rarfile.FileHeader;  
  
public class UnRARTools { 
	
	/**
	 * 解压一个目录下这一层的压缩文件到指定目录
	 * @param zipDir
	 * @param descDir
	 * @throws Exception 
	 */
	public static void upRarDirFiles(String zipDir,String descDir) throws Exception{
		File file = new File(zipDir);
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			unrar(listFiles[i].getAbsolutePath(),descDir+File.separator+listFiles[i].getName());
		}
	}
	
	
	 public static void unrar(String sourceRar, String destDir) throws Exception{
		 unrar(new File(sourceRar),new File(destDir));
	 }
  
    public static void unrar(File sourceRar, File destDir) throws Exception {  
        Archive archive = null;  
        FileOutputStream fos = null;  
        System.out.println("Starting...");  
        try {  
            archive = new Archive(sourceRar);  
            FileHeader fh = archive.nextFileHeader();  
            int count = 0;  
            File destFileName = null;  
            while (fh != null) {  
                System.out.println((++count) + ") " + fh.getFileNameString());  
                String compressFileName = fh.getFileNameString().trim();  
                destFileName = new File(destDir.getAbsolutePath() + "/" + compressFileName);  
                if (fh.isDirectory()) {  
                    if (!destFileName.exists()) {  
                        destFileName.mkdirs();  
                    }  
                    fh = archive.nextFileHeader();  
                    continue;  
                }   
                if (!destFileName.getParentFile().exists()) {  
                    destFileName.getParentFile().mkdirs();  
                }  
                fos = new FileOutputStream(destFileName);  
                archive.extractFile(fh, fos);  
                fos.close();  
                fos = null;  
                fh = archive.nextFileHeader();  
            }  
  
            archive.close();  
            archive = null;  
            System.out.println("Finished !");  
        } catch (Exception e) {  
            throw e;  
        } finally {  
            if (fos != null) {  
                try {  
                    fos.close();  
                    fos = null;  
                } catch (Exception e) {  
                    //ignore  
                }  
            }  
            if (archive != null) {  
                try {  
                    archive.close();  
                    archive = null;  
                } catch (Exception e) {  
                    //ignore  
                }  
            }  
        }  
    }  
}