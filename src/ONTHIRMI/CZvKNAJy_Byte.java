package ONTHIRMI;

import RMI.ByteService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class CZvKNAJy_Byte {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String msv="b22dcvt525";
		String qc="CZvKNAJy";
		Registry rs= LocateRegistry.getRegistry(host,port);
		ByteService bs = (ByteService) rs.lookup("RMIByteService");
		byte[] a=bs.requestData(msv,qc);
		List<Byte> list=new ArrayList<>();
		for(byte b:a){
			if(b%2==0) list.add(b);
		}
		for(byte b:a){
			if(b%2!=0) list.add(b);
		}
		for(int i=0;i<list.size();i++) a[i]=list.get(i);
		bs.submitData(msv,qc,a);
	}
}
