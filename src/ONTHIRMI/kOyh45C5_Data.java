package ONTHIRMI;

import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class kOyh45C5_Data {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String msv="b22dcvt525";
		String qc="kOyh45C5";
		Registry rs= LocateRegistry.getRegistry(host,port);
		DataService ds = (DataService) rs.lookup("RMIDataService");
		Object obj = ds.requestData(msv,qc);
		int amount=Integer.parseInt(obj.toString());
		String xu="";
		int cnt=0;
		int[] a={10,5,2,1};
		for(int i=0;i<a.length;i++){
			while (amount>=a[i]){
				amount-=a[i];
				xu+=a[i]+",";
				cnt++;
			}
		}
		xu=xu.substring(0,xu.length()-1);
		String kq=cnt+"; "+xu;
		ds.submitData(msv,qc,kq);
	}
}
