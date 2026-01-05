package CodeMau;
import java.io.*;
import java.util.*;
public class SoLanXuatHienMax {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String s="ababaabab8742974a";
		int[] cnt=new int[1000001];
		for(char x:s.toCharArray()) cnt[x]++;
		int max=Integer.MIN_VALUE;
		//char là kiểu dữ liệu => phải có 1 ký tự => khởi tạo là 0
		char x=0;
		for(char c:s.toCharArray()){
			if(cnt[c]>max){
				x=c;
				max=cnt[c];
			}
		}
		String kq="";
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==x) kq+=i+",";
		}
		kq=kq.substring(0,kq.length()-1);
		System.out.println(x+";"+kq);
	}
}
