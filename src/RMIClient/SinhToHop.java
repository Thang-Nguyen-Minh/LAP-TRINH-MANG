package RMIClient;

import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SinhToHop {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2209;
		String msv="b22dcvt525";
		String qc="SfjzO8UZ";
		Registry rs= LocateRegistry.getRegistry(host,port);
		DataService ds = (DataService) rs.lookup("RMIDataService");
		String input=ds.requestData(msv,qc).toString();
		String[] so=input.split("\\s*,\\s*");
		List<Integer> a=new ArrayList<>();
		for(String x:so) a.add(Integer.parseInt(x.trim()));
		sinh(a);
		String kq="";
		for(int i=0;i<a.size();i++){
			kq+=a.get(i)+",";
		}
		kq=kq.substring(0,kq.length()-1);
		ds.submitData(msv,qc,kq);
	}
	public static void sinh(List<Integer> a){
		int n=a.size();
		if(n<=1) return;
		//1. Tìm i là vị trí đầu tiên từ cuối mà a[i] < a[i+1] . While
		int i=n-2;
		while (i>=0 && a.get(i)>=a.get(i+1)) --i;
		if(i>=0){
			int j=n-1;
			//2. Tìm j là phần tử nhỏ nhat bên phải i mà lớn hơn a[i]
			while (a.get(j)<=a.get(i)) --j;
			//3. Hoán đổi a[i] và a[j];
			Collections.swap(a,i,j);
		}
		//4. Đảo ng ược đoạn sau  để có thứ tự nhỏ nhất
		Collections.reverse(a.subList(i+1,n));
	}
}
