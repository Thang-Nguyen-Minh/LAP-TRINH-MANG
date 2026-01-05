//package WS;
//import java.io.*;
//public class DataService_IEkNkQh2 {
//	public static void main(String[] args) {
//		try {
//			String studentCode = "B22DCVT525";  // mã sinh viên
//			String qCode = "IEkNkQh2";          // mã câu hỏi
//
//			// 🛰️ Kết nối tới dịch vụ web
//			DataService_Service service = new DataService_Service();
//			DataService port = service.getDataServicePort();
//
//			// a) Gọi phương thức getData() để lấy danh sách số nguyên
//			List<Integer> numbers = port.getData(studentCode, qCode);
//			System.out.println("📥 Dữ liệu nhận từ server:");
//			System.out.println(numbers);
//
//			// b) Chuyển đổi từng số sang chuỗi nhị phân
//			List<String> binaryList = new ArrayList<>();
//			for (Integer num : numbers) {
//				String binary = Integer.toBinaryString(num);
//				binaryList.add(binary);
//			}
//
//			System.out.println("📤 Chuỗi nhị phân sau khi chuyển đổi:");
//			System.out.println(binaryList);
//
//			// c) Gửi chuỗi nhị phân về server
//			port.submitDataStringArray(studentCode, qCode, binaryList);
//			System.out.println("✅ Đã gửi kết quả thành công về server!");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
