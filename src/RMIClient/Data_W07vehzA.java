package RMIClient;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_W07vehzA {
	public static void main(String[] args) throws Exception {
		String host = "203.162.10.109";
		int port = 1099;
		String stc = "B22DCVT525";   // Mã sinh viên
		String qc  = "W07vehzA";     // Mã câu hỏi

		// 1️⃣ Kết nối tới Registry
		Registry registry = LocateRegistry.getRegistry(host, port);
		DataService ds = (DataService) registry.lookup("RMIDataService");

		// 2️⃣ Nhận dữ liệu từ server
		Object obj = ds.requestData(stc, qc);
		int N = Integer.parseInt(obj.toString()); // ép về int

		// 3️⃣ Phân tích thừa số nguyên tố
		List<Integer> factors = primeFactorization(N);

		// 4️⃣ Gửi danh sách kết quả về server
		ds.submitData(stc, qc, factors);
	}
	// Hàm phân tích thừa số nguyên tố
	private static List<Integer> primeFactorization(int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				result.add(i);
				n /= i;
			}
		}
		if (n > 1) result.add(n);
		return result;
	}
}
