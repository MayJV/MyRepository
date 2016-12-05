package powerjava.com;

import java.util.ArrayList;
/**
 * 自定义分割
 * @author Administrator
 *
 */
public class MyJava {
	
	public static void main(String[] args) {
		st();
	}
	
	public static String[] st(){
		ArrayList<String> list=new ArrayList<String>();
		String string="1,2,3,4,5,6,7,8,9,10";
		int len;
		while ((len=string.indexOf(","))!=-1) {
			list.add(string.substring(0, len));
			string=string.substring(len+1);
			System.out.println(string+"-----");
		}
	list.add(string);
		for (String string2 : list) {
			System.out.print(string2);
		}
		System.out.println();
		System.out.println(System.currentTimeMillis());
		return null;
	}
	
	
}
