package RMIClient;

import RMI.ByteService;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.Arrays;

public class Byte_MNVBRm8R {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		String host="203.162.10.109";
		int port=1099;
		String stc="B22DCVT525";
		String qc="MNVBRm8R";
		//1. Kết nối đến RMI Registry của Server
		Registry rs=LocateRegistry.getRegistry(host,port);
		//2. Tra cứu (lookup) đối tượng từ xa
		ByteService bs=(ByteService) rs.lookup("RMIByteService");
		//3. Gọi hàm từ xa để nhận dữ liệu nhị phân : input
		byte[] a=bs.requestData(stc,qc);
		//4. Xử lý
		int n=a.length;
		for(int i=0;i<n;i++){
			a[i]=(byte) (a[i]+n);
		}
		//5. Gửi kết quả mã hóa về server
		bs.submitData(stc,qc,a);

	}
}

