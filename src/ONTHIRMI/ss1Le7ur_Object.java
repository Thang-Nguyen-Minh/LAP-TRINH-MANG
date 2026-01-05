package ONTHIRMI;

import RMI.ObjectService;
import RMI.ProductX;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ss1Le7ur_Object {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String msv="b22dcvt525";
		String qc="ss1Le7ur";
		Registry rs= LocateRegistry.getRegistry(host,port);
		ObjectService os = (ObjectService) rs.lookup("RMIObjectService");
		ProductX productX=(ProductX) os.requestObject(msv,qc);
		productX.Solve();
		os.submitObject(msv,qc,productX);
	}
}
