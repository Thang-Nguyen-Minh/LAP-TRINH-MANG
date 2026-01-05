//package WS;
//import java.util.*;
//public class DataService_19P2V1rc {
//	public static void main(String[] args) {
//		String studentCode = "B22DCVT525";  // mã sinh viên
//		String qCode = "19P2V1rc";          // mã câu hỏi
//
//		try {
//			// 1️⃣ Kết nối tới Web Service
//			DataService_Service service = new DataService_Service();
//			DataService port = service.getDataServicePort();
//
//			// 2️⃣ Gọi phương thức getData để nhận danh sách số nguyên
//			List<Integer> numbers = port.getData(studentCode, qCode);
//			System.out.println("📥 Danh sách số nhận từ server:");
//			System.out.println(numbers);
//
//			// 3️⃣ Với mỗi số, phân tích thành thừa số nguyên tố
//			List<String> resultList = new ArrayList<>();
//
//			for (Integer n : numbers) {
//				List<Integer> factors = primeFactorization(n);
//				String factorStr = listToString(factors);
//				resultList.add(factorStr);
//			}
//
//			System.out.println("📤 Danh sách chuỗi thừa số nguyên tố:");
//			for (String s : resultList) {
//				System.out.println(s);
//			}
//
//			// 4️⃣ Gửi danh sách chuỗi kết quả lên server
//			port.submitDataStringArray(studentCode, qCode, resultList);
//			System.out.println("✅ Gửi kết quả thành công!");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	// 🧩 Hàm phân tích thừa số nguyên tố
//	private static List<Integer> primeFactorization(int n) {
//		List<Integer> res = new ArrayList<>();
//		for (int i = 2; i * i <= n; i++) {
//			while (n % i == 0) {
//				res.add(i);
//				n /= i;
//			}
//		}
//		if (n > 1) res.add(n);
//		return res;
//	}
//
//	// 🧩 Hàm chuyển danh sách số thành chuỗi "2, 2, 7"
//	private static String listToString(List<Integer> list) {
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < list.size(); i++) {
//			sb.append(list.get(i));
//			if (i < list.size() - 1) sb.append(", ");
//		}
//		return sb.toString();
//	}
//}
