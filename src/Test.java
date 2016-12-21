import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args){
		
		System.out.println(System.getProperty("java.library.path"));
		Map<String,String> map = new HashMap<String,String>();
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        
        float f=3.4f;
        
        short ss=1;
        ss += 1;
        
        System.out.println(2>>4);
		
        System.out.println("".equals(""));
        
        int x = 3;
        int y = 5;
        change(x,y);
        System.out.println(x+" "+y);
        
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        
        System.out.println(change(s1));
	}
	
	
	public static void change(int x,int y){
		x=1;
		y=2;
		System.out.println(x+" "+y);
	}
	
	public static String change(String x){
		return x+x;
	}
	
}
