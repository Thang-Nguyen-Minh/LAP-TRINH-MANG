package RMIClient;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Product;
public class Object_nQDap22F {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String stc="B22DCVT525";
		String qc="nQDap22F";
		Registry rs=LocateRegistry.getRegistry(host,port);
		ObjectService os=(ObjectService) rs.lookup("RMIObjectService");
		Product p=(Product) os.requestObject(stc,qc);
		p.Solve();
		os.submitObject(stc,qc,p);
	}
}
