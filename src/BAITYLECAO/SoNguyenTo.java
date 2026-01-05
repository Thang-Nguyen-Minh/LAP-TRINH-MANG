package BAITYLECAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoNguyenTo {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		boolean ok=check(n);
		List<Integer> a=pt(n);
		List<Integer> x=inNgto(n);
		List<Integer> x1=inNgto2(n);
		System.out.println(n);
		System.out.println(ok);
		System.out.println(a);
		System.out.println(x);
		System.out.println(x1);
	}
	public static boolean check(int n){
		if(n<2) return false;
		for (int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0) return false;
		}
		return true;
	}
	public static List<Integer> pt(int n){
		List<Integer> kq=new ArrayList<>();
		for(int i=2;i<=Math.sqrt(n);i++){
			while (n%i==0){
				kq.add(i);
				n/=i;
			}
		}
		if (n>1) kq.add(n);
		return kq;
	}
	public static List<Integer> inNgto(int n){
		List<Integer> nt =new ArrayList<>();
		List<Integer> kq= new ArrayList<>();
		for(int i=2;i<=10000001;i++){
			if(check(i)) nt.add(i);
		}
		for (int i=0;i<n;i++){
			kq.add(nt.get(i));
		}
		return kq;
	}

	public static List<Integer> inNgto2(int n){
		List<Integer> kq=new ArrayList<>();
		int dem=0,i=2;
		while (dem<n){
			if(check(i)){
				kq.add(i);
				++dem;
			}
			++i;
		}
		return kq;
	}
}
