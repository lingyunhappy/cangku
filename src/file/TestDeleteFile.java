package file;

import java.io.File;

public class TestDeleteFile {
	
	
	
	
	public void deleteFile(String dirPath){
		
		  File file = new File(dirPath);  
          // 取得代表目录中所有文件的File对象数组   
          File[] list = file.listFiles();  
          // 遍历file数组   
          for (int i = 0; i < list.length; i++) {  
        	  
        	  if(list[i].isDirectory()){
//        		  System.out.println(list[i].getName());
        		  deleteFile(list[i].getPath()); 
        	  }else if(list[i].isFile()){
        		  if(list[i].getName().equals("readme.txt")||list[i].getName().equals("访问脚本之家.html"))
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
