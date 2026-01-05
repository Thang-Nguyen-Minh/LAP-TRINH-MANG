package BAITYLECAO.ThuatToan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoNguocMangTheoK2 {
	public static void main(String[] args){
		int[] a={10,20,30,40,50,60};
		int k=3;
		int n=a.length;
		List<Integer> kq=new ArrayList<>();
		for (int x:a) kq.add(x);
		for(int i=0;i<n;i+=k){
			int start=i;
			int end=Math.min(i+k-1,n-1);
			while (start<end){
				Collections.swap(kq,start,end);
				start++;end--;
			}
		}
		for(int x:kq) System.out.print(x+" ");
		System.out.println();
	}
}
