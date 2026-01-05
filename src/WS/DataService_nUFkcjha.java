//package WS;
//
//public class DataService_nUFkcjha {
//	public static void main(String[] args){
//		try{
//			String stc="B22DCVT525";
//			String qc="nUFkcjha";
//			// 🛰️ Kết nối tới dịch vụ web
//			DataService_Service ds=new DataService_Service();
//			DataService port=ds.getDataServicePort();
//			// a) Gọi phương thức getData() để lấy danh sách số nguyên
//			List<Integer> a=port.getData(stc, qc);
//			//Chuyển đổi số nguyên nhận được từ hệ thập phân sang cả hệ cơ số 8 (bát phân) và hệ cơ số 16 (thập lục phân)
//			List<String> kq=new ArrayList<>();
//			for(int x:a){
//				String oc=Integer.toOctalString(x);
//				String hex=Integer.toHexString(x);
//				String rs=oc+"|"+hex.toUpperCase();
//				kq.add(rs);
//			}
//			port.submitDataStringArray(stc, qc, kq);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//}
