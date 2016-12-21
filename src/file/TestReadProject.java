package file;
import java.util.*;
import java.io.*;
public class TestReadProject {

	// �ļ����ڵĲ���   
    private int fileLevel;  

    /** 
     * ���������ʽ 
     * @param name ������ļ�����Ŀ¼�� 
     * @param level ������ļ�������Ŀ¼�����ڵĲ�� 
     * @param type �ļ��л����ļ�������
     * @return ������ַ��� 
     */  
    public String createPrintStr(String name, int level,String type,String absolutePath) {  
            // �����ǰ׺   
            String printStr = "";  
            // ����ν�������   
            for (int i = 0; i < level; i ++) {  
                    printStr  = printStr + "	";  
            }  
            printStr = printStr + "<li><a href='"+absolutePath+"'>"+type + name+"</a></li>";  
            return printStr;  
    }  
    
    /** 
     * ����HTML
     * @param name ������ļ�����Ŀ¼�� 
     * @param level ������ļ�������Ŀ¼�����ڵĲ�� 
     * @param type �ļ��л����ļ�������
     * @return ������ַ��� 
     */  
    
    public String createHtmlStr(String name, int level, String type){
    	
    	 // �����ǰ׺   
        String printStr = "";  
        // ����ν�������   
        for (int i = 0; i < level; i ++) {  
                printStr  = printStr + "      ";  
        }  
        printStr = printStr + type + name;  
        return printStr;  
    	
    }
    
    
    /** 
     * �����ʼ������Ŀ¼ 
     * @param dirPath ������Ŀ¼ 
     */  
    public void printDir(String dirPath){  
            // ��������Ŀ¼���зָ�   
            String[] dirNameList = dirPath.split("\\\\");  
            // �趨�ļ�level��base   
            fileLevel = dirNameList.length;  
            // ����ʽ���   
            for (int i = 0; i < dirNameList.length; i ++) {  
                    System.out.println(createPrintStr(dirNameList[i], i,"",dirPath));  
            }  
    }  

    /** 
     * �������Ŀ¼�µ��ļ���������Ŀ¼�е��ļ� 
     * @param dirPath ������Ŀ¼ 
     */  
    public void readFile(String dirPath) {  
            // ������ǰĿ¼���ļ���File����   
            File file = new File(dirPath);  
            // ȡ�ô���Ŀ¼�������ļ���File��������   
            File[] list = file.listFiles();  
            // ����file����   
            for (int i = 0; i < list.length; i++) {  
                    if (list[i].isDirectory()&&!".svn".equals(list[i].getName())&&new File(list[i].getAbsolutePath()).list()!=null) {  
	                    	System.out.println("<ul>");
                            System.out.println(createPrintStr(list[i].getName(), fileLevel,"",list[i].getAbsolutePath()));  
                            fileLevel ++;  
                            // �ݹ���Ŀ¼   
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
            String dirPath = "D:\\����\\��Ŀ�ĵ�\\�к���";  
//            rd.printDir(dirPath);  
            
            System.out.println("<html><head>"+"�к���"+"</head>");
            System.out.println("<link rel='stylesheet' href='./cnooc.css' type='text/css' />");
            System.out.println("<body>");
            rd.readFile(dirPath);  
            System.out.println("</body>");
    }  
}  


