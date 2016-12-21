package testfor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFor {
 public static void main(String[] args){
	 List<Integer> list = new ArrayList<Integer>();
	 
	 
	 for(int i =0;i<1000000;i++){
		 list.add(i);
	 }
	 
	 
	 Long t1 = System.currentTimeMillis();
	 
	 for(int i=0;i<1000;i++){
		 for(int j=0;j<list.size();j++){
			 list.get(i);
		 }
	 }
	 
	 Long t2 = System.currentTimeMillis();
	 
	 for(int i=0;i<1000;i++){
		 for(Integer obj : list){
			 
		 }
	 }
	 
	 Long t3 = System.currentTimeMillis();
	 
	 for(int i=0;i<1000;i++){
		 Iterator iterator = list.iterator();
		 while(iterator.hasNext()){
			 iterator.next();
		 }
	 }
	 Long t4 = System.currentTimeMillis();
	 System.out.println("for:"+(t2-t1));
	 System.out.println("foreach:"+(t3-t2));
	 System.out.println("iterator:"+(t4-t3));
	 
 }
}
