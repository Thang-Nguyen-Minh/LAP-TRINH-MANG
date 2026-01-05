package RMIClient;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ByteService;

public class Byte_yzYt0MN1 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=1099;
		String stc="B22DCVT525";
		String qc="yzYt0MN1";
		try{
			Registry rs=LocateRegistry.getRegistry(host,port);
			ByteService bs=(ByteService) rs.lookup("RMIByteService");
			byte[] a=bs.requestData(stc,qc);
			String kq="";
			for(byte b:a){
				//chuyển đổi thành hai ký tự hex tương ứng.
				kq+=String.format("%02x",b);
			}
			byte[] sendBack=kq.getBytes();
			bs.submitData(stc,qc,sendBack);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
