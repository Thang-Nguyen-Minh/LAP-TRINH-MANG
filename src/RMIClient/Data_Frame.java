package RMIClient;
import java.io.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.DataService;
public class Data_Frame {
	public static void main(String args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String stc="B22DCVT525";
		String qc="SfjzO8UZ";
		Registry rs=LocateRegistry.getRegistry(host,port);
		DataService ds=(DataService) rs.lookup("RMIDataService");
		String input=ds.requestData(stc,qc).toString();
		String[] a=input.split("\\s*,\\s*");
		int []x=new int[a.length];
		for(int i=0;i<a.length;i++) x[i]=Integer.parseInt(a[i]);
		sinh(x);
		String kq="";
		for(int i=0;i<x.length;i++) kq+=x[i]+",";
		kq=kq.substring(0,kq.length()-1);
		ds.submitData(stc,qc,kq);
	}
	public static void sinh(int []a){
		int n=a.length;
		int i=n-2;
		while(i>=0 && a[i]>=a[i-1]) --i;
		if(i>=0){
			int j=n-1;
			while(a[j]<=a[i]) --j;
			swap(a,i,j);
		}
		reverse(a,i+1,n-1);
	}
	static void swap(int []a,int l,int r){
		int tmp=a[l];
		a[l]=a[r];
		a[r]=tmp;
	}
	static void reverse(int []a,int l,int r){
		while(l<r){
			swap(a,l++,r--);
		}
	}
}
