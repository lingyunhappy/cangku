package file;
import java.util.*;
import java.io.*;
public class TestReadProject {

	// 文件所在的层数   
    private int fileLevel;  

    /** 
     * 生成输出格式 
     * @param name 输出的文件名或目录名 
     * @param level 输出的文件名或者目录名所在的层次 
     * @param type 文件夹或者文件的类型
     * @return 输出的字符串 
     */  
    public String createPrintStr(String name, int level,String type,String absolutePath) {  
            // 输出的前缀   
            String printStr = "";  
            // 按层次进行缩进   
            for (int i = 0; i < level; i ++) {  
                    printStr  = printStr + "	";  
            }  
            printStr = printStr + "<li><a href='"+absolutePath+"'>"+type + name+"</a></li>";  
            return printStr;  
    }  
    
    /** 
     * 生成HTML
     * @param name 输出的文件名或目录名 
     * @param level 输出的文件名或者目录名所在的层次 
     * @param type 文件夹或者文件的类型
     * @return 输出的字符串 
     */  
    
    public String createHtmlStr(String name, int level, String type){
    	
    	 // 输出的前缀   
        String printStr = "";  
        // 按层次进行缩进   
        for (int i = 0; i < level; i ++) {  
                printStr  = printStr + "      ";  
        }  
        printStr = printStr + type + name;  
        return printStr;  
    	
    }
    
    
    /** 
     * 输出初始给定的目录 
     * @param dirPath 给定的目录 
     */  
    public void printDir(String dirPath){  
            // 将给定的目录进行分割   
            String[] dirNameList = dirPath.split("\\\\");  
            // 设定文件level的base   
            fileLevel = dirNameList.length;  
            // 按格式输出   
            for (int i = 0; i < dirNameList.length; i ++) {  
                    System.out.println(createPrintStr(dirNameList[i], i,"",dirPath));  
            }  
    }  

    /** 
     * 输出给定目录下的文件，包括子目录中的文件 
     * @param dirPath 给定的目录 
     */  
    public void readFile(String dirPath) {  
            // 建立当前目录中文件的File对象   
            File file = new File(dirPath);  
            // 取得代表目录中所有文件的File对象数组   
            File[] list = file.listFiles();  
            // 遍历file数组   
            for (int i = 0; i < list.length; i++) {  
                    if (list[i].isDirectory()&&!".svn".equals(list[i].getName())&&new File(list[i].getAbsolutePath()).list()!=null) {  
	                    	System.out.println("<ul>");
                            System.out.println(createPrintStr(list[i].getName(), fileLevel,"",list[i].getAbsolutePath()));  
                            fileLevel ++;  
                            // 递归子目录   
                            readFile(list[i].getPath());  
                            fileLevel --;  
                            System.out.println("</ul>");
                    } else {
//                    		if(list[i].getName().contains(".docx"))
                            System.out.println(createPrintStr(list[i].getName(), fileLevel,"",list[i].getAbsolutePath()));  
                    }  
            }
    }  
      
    public static void main(String[] args) {  
    	TestReadProject rd = new TestReadProject();  
            String dirPath = "D:\\资料\\项目文档\\中海油";  
//            rd.printDir(dirPath);  
            
            System.out.println("<html><head>"+"中海油"+"</head>");
            System.out.println("<link rel='stylesheet' href='./cnooc.css' type='text/css' />");
            System.out.println("<body>");
            rd.readFile(dirPath);  
            System.out.println("</body>");
    }  
}  


