package RMIClient;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

import RMI.DataService;
public class Data_Ngto {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=1099;
		String stc="B22DCVT525";
		String qc="W07vehzA";
		try{
			Registry rs=LocateRegistry.getRegistry(host,port);
			DataService ds=(DataService) rs.lookup("RMIDataService");
			Object obj=ds.requestData(stc,qc);
			int n=Integer.parseInt(obj.toString());
			List<Integer> kq=pt(n);
			ds.submitData(stc,qc,kq);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static List<Integer> pt(int n){
		List<Integer> kq=new ArrayList<>();
		for(int i=2;i<=Math.sqrt(n);i++){
			while(n%i==0){
				kq.add(i);
				n/=i;
			}
		}
		if(n>1) kq.add(n);
		return kq;
	}
}
