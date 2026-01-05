//package WS;
//
//public class Object_RoSucBqt {
//	public static void main(String[] args) {
//		String studentCode = "B22DCVT525";  // mã sinh viên
//		String qCode = "RoSucBqt";          // mã câu hỏi
//
//		try {
//			// 1️⃣ Kết nối tới Web Service
//			ObjectService_Service service = new ObjectService_Service();
//			ObjectService port = service.getObjectServicePort();
//
//			// 2️⃣ Gọi phương thức requestListCustomer để nhận danh sách khách hàng
//			List<Customer> customers = port.requestListCustomer(studentCode, qCode);
//
//
//			// 3️⃣ Lọc khách hàng tiềm năng:
//			// Điều kiện: totalSpent > 5000 && purchaseCount >= 5
//			List<Customer> potentialCustomers = new ArrayList<>();
//			for (Customer c : customers) {
//				if (c.getTotalSpent() > 5000 && c.getPurchaseCount() >= 5) {
//					potentialCustomers.add(c);
//				}
//			}
//
//
//
//			// 4️⃣ Gửi danh sách khách hàng tiềm năng lên server
//			port.submitListCustomer(studentCode, qCode, potentialCustomers);
//			System.out.println("\n✅ Gửi danh sách khách hàng tiềm năng thành công!");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
