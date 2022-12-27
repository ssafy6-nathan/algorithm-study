import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		String s = br.readLine();
        while(!s.equals(".")) {
			String res = "yes";
			char[] stack = new char[100];
			int size = 0;
			boolean first = false;
			for(char tmp : s.toCharArray()) {
				if(tmp=='('||tmp=='[') {
					stack[size++]=tmp;
					first = true;
				}
				else if(tmp==')') {
					if(size==0) {
					     res="no";
					     break;
					}
					else if(stack[--size]!='(') {
					    res="no";
					    break;
					}
				}
				else if(tmp==']') {
					if(size==0) {
					    res="no";
					    break;
					}
					else if(stack[--size]!='[') {
					    res="no";
					    break;
					}
				}
			}
			if(size>0 && first) res = "no";
			System.out.println(res);
			s = br.readLine();
		}
		    br.close();
    }
}
