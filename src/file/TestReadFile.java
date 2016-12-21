package file;

import java.io.*;;
public class TestReadFile {
	public static int count = 0;
	public static void main(String[] args){
		File f = new File("D:\\study\\code\\零基础Struts\\源代码");
		File[] files = f.listFiles();
		
		for(File nFile:files){
//			System.out.println(nFile.getName());
			if(nFile.isDirectory()){
				File[] pFile=nFile.listFiles();
				for(File ppFile : pFile){
					for(File webroot :ppFile.listFiles()){
						if(webroot.getName().contains("WebRoot")){
							
							System.out.println("******************************");
							System.out.println(++count +" . 项目路径："+nFile.getName()+" "+ppFile.getName());
							System.out.println(webroot.getAbsolutePath());
							System.out.println("<Context debug=\"0\" path=\"/"+ppFile.getName()+"\" docBase=\""+webroot.getAbsolutePath()+"\" reloadable=\"false\"/>");
							
							for(File jsp :webroot.listFiles()){
								if(jsp.getName().contains(".jsp")){
									System.out.println("访问路径：");
									System.out.println("http://localhost:8080/"+ppFile.getName()+"/"+jsp.getName());
								}
							}
						}
						
					}
				}
			}
			
		}
		
		
	}

}
