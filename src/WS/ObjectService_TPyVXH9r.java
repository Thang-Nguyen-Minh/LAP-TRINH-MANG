//package WS;
//import java.util.*;
//public class ObjectService_TPyVXH9r {
//	public static void main(String[] args){
//		String stc="B22DCVT525";
//		String qc="TPyVXH9r";
//		try{
//			ObjectService_Service os=new ObjectService_Service();
//			ObjectService port=os.getObjectServicePort();
//			//input
//			List<EmployeeY> emp=port.requestListEmployeeY(stc,qc);
//			emp.sort(Comparator.comparing(e -> e.getStartDate().toGregorianCalendar().getTime()));
//			port.submitListEmployeeY(stc, qc, emp);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//}
