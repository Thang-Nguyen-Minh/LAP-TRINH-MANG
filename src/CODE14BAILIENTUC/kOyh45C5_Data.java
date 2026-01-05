package CODE14BAILIENTUC;

import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class kOyh45C5_Data {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String msv="b22dcvt525";
		String qc="kOyh45C5";
		Registry rs = LocateRegistry.getRegistry(host,port);
		DataService ds = (DataService) rs.lookup("RMIDataService");
		Object object = ds.requestData(msv,qc);
		int amount=Integer.parseInt(object.toString());
		int cnt=0;
		String kq="";
		int[] a={10,5,2,1};
		for(int i=0;i<a.length;i++){
			while (amount>=a[i]){
				amount-=a[i];
				kq+=a[i]+",";
				cnt++;
			}
		}
		kq=kq.substring(0,kq.length()-1);
		String ch=cnt+"; "+kq;
		ds.submitData(msv,qc,ch);
	}
}
