package BAITYLECAO.ThuatToan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DaoNguocMangTheoK {
	public static void main(String[] args){
		int[] a={10, 20, 30, 40, 50, 60};
		List<Integer> x=new ArrayList<>();
		for(int z:a) x.add(z);
		int k=3;
		int n=a.length;
		//2 con trỏ với start là i và kết thúc là min(i+k-1,n-1);
		//vì i+k-1 có thể lớn hơn kích thước mảng nên phải giới hạn là n-1
		//Bước nhảy là k
		for(int i=0;i<n;i+=k){
			int start=i;
			int end=Math.min(i+k-1,n-1);
			while (start<end){
				Collections.swap(x,start,end);
				start++;end--;
			}
		}
		String kq="";
		for(int i=0;i<n;i++){
			if(i<n-1) kq+=x.get(i)+",";
			else kq+=x.get(i);
		}
		System.out.println(kq);
	}
}
