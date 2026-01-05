package ONTHIRMI;

import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Data_kOyh45C5 {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String msv="b22dcvt525";
		String qc="kOyh45C5";
		Registry rs= LocateRegistry.getRegistry(host,port);
		DataService ds = (DataService) rs.lookup("RMIDataService");
		//Nhập là số nguyên thì phải chuyển từ Object về, nhận về là Object chứ không nhận thẳng số nguyên được
		Object obj=ds.requestData(msv,qc);
		int amount=Integer.parseInt(obj.toString());
		String kq="";
		int cnt=0;
		int[] xu={1,2,5,10};
		for(int i=3;i>=0;i--){
			//So sánh với đồng xu hiện tại chứ ai đi so sánh với 0, má lú thật chịu
			while(amount>=xu[i]){
				amount-=xu[i];
				kq+=xu[i]+",";
				cnt++;
			}
		}
		kq=kq.substring(0,kq.length()-1);
		System.out.println(kq);
		System.out.println(cnt);
		String kqq=String.valueOf(cnt)+"; "+kq;
		System.out.println(kqq);
		ds.submitData(msv,qc,kqq);
		//18 : 18%10=8%5=3%2=1%1=0
		//14 : 14%10=4%2=0%1=0
	}
}
