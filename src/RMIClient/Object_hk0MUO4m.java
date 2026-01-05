package RMIClient;
import RMI.ObjectService;
import RMI.Student;

import java.rmi.*;
import java.rmi.registry.*;
public class Object_hk0MUO4m {
	public static void main(String[] args) throws Exception{
		String host = "203.162.10.109";
		int port = 1099;
		String stc = "B22DCVT525";   // Mã sinh viên
		String qc  = "hk0MUO4m";
		Registry rs=LocateRegistry.getRegistry(host,port);
		ObjectService os=(ObjectService) rs.lookup("RMIObjectService");
		Student st=(Student) os.requestObject(stc,qc);
		st.Solve();
		System.out.println(st.code);
		System.out.println(st.name);
		os.submitObject(stc,qc,st);
	}
}
