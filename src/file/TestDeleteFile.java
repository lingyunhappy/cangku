package file;

import java.io.File;

public class TestDeleteFile {
	
	
	
	
	public void deleteFile(String dirPath){
		
		  File file = new File(dirPath);  
          // ȡ�ô���Ŀ¼�������ļ���File��������   
          File[] list = file.listFiles();  
          // ����file����   
          for (int i = 0; i < list.length; i++) {  
        	  
        	  if(list[i].isDirectory()){
//        		  System.out.println(list[i].getName());
        		  deleteFile(list[i].getPath()); 
        	  }else if(list[i].isFile()){
        		  if(list[i].getName().equals("readme.txt")||list[i].getName().equals("���ʽű�֮��.html"))
//        			  System.out.println(list[i].getName());	  
        		  list[i].delete();
        	  }
          }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDeleteFile tdf = new TestDeleteFile();
		tdf.deleteFile("D:\\study\\book\\fengli_jquery");

	}

}
