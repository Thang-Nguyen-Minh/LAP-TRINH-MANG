package RMIClient;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ByteService;
public class Byte_Frame {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String stc="B22DCVT525";
		String qc="MNVBRm8R";
		Registry rs=LocateRegistry.getRegistry(host,port);
		ByteService bs=(ByteService) rs.lookup("RMIByteService");
		byte[] a=bs.requestData(stc,qc);
//		int n=a.length;
//		for(int i=0;i<n;i++){
//			a[i]=(byte)(a[i]+n);
//		}
		String kq="";
		for(byte b:a){
			kq+=String.format("%02x",b);
		}
		byte[] sendData=kq.getBytes();
		bs.submitData(stc,qc,sendData);
	}
}
