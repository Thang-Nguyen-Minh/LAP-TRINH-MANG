package BAITYLECAO.ThuatToan;
import java.io.*;
import java.util.*;
public class TongGanNhatVoiK {
	public static void main(String[] args){
		//K là target=tbc*2
		Scanner sc = new Scanner(System.in);
		int[] a={1,2,4,6,8,9,12,15,18,21,36};
		int sum=0;
		for(int x:a) sum+=x;
		int n=a.length;
		double tbc=(double) sum/n;
		double k=2*tbc;
		System.out.println(k);
		//2 biến => 2 vòng for duyệt từng cặp số
		//độ lệch là abs tổng 2 cặp số trừ đi target, so sánh rồi gán lại vào kq
		int n1=0,n2=0;
		double minDiff=Double.MAX_VALUE;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				//Khởi tạo x,y như 2 biến tạm để gán lại vào kết quả.
				int x=a[i],y=a[j];
				double diff=Math.abs(x+y-k);
				if(diff<minDiff){
					minDiff=diff;
					n1=x;
					n2=y;
				}
			}
		}
		int min=Math.min(n1,n2);
		int max=Math.max(n1,n2);
		System.out.println(min+";"+max);
	}
}
