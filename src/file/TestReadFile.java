package file;

import java.io.*;;
public class TestReadFile {
	public static int count = 0;
	public static void main(String[] args){
		File f = new File("D:\\study\\code\\�����Struts\\Դ����");
		File[] files = f.listFiles();
		
		for(File nFile:files){
//			System.out.println(nFile.getName());
			if(nFile.isDirectory()){
				File[] pFile=nFile.listFiles();
				for(File ppFile : pFile){
					for(File webroot :ppFile.listFiles()){
						if(webroot.getName().contains("WebRoot")){
							
							System.out.println("******************************");
							System.out.println(++count +" . ��Ŀ·����"+nFile.getName()+" "+ppFile.getName());
							System.out.println(webroot.getAbsolutePath());
							System.out.println("<Context debug=\"0\" path=\"/"+ppFile.getName()+"\" docBase=\""+webroot.getAbsolutePath()+"\" reloadable=\"false\"/>");
							
							for(File jsp :webroot.listFiles()){
								if(jsp.getName().contains(".jsp")){
									System.out.println("����·����");
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
