import java.io.*;
import java.net.*;
import java.util.*;

public class DomainClient {
	public static void main(String[] args) {
		String host = "203.162.10.109";   // IP server, không có http://
		int port = 2208;
		String studentCode = "B22DCVT525";
		String qCode = "LTN1AxpF";

		try (Socket socket = new Socket(host, port)) {
			// Thiết lập timeout 5s
			socket.setSoTimeout(5000);

			// Tạo luồng đọc/ghi
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));

			// (a) Gửi "studentCode;qCode"
			String sendMsg = studentCode + ";" + qCode;
			writer.write(sendMsg);
			writer.newLine();
			writer.flush();
			System.out.println("Sent to server: " + sendMsg);

			// (b) Nhận danh sách tên miền
			String domainList = reader.readLine();
			if (domainList == null || domainList.trim().isEmpty()) {
				System.out.println("Server returned empty/null data!");
				return; // kết thúc luôn
			}
			System.out.println("Received from server: " + domainList);

			// (c) Lọc domain .edu
			String[] domains = domainList.split(",\\s*");
			List<String> eduDomains = new ArrayList<>();
			for (String d : domains) {
				if (d != null && d.trim().toLowerCase().endsWith(".edu")) {
					eduDomains.add(d.trim());
				}
			}

			// Ghép lại thành chuỗi
			String eduResult = String.join(", ", eduDomains);
			writer.write(eduResult);
			writer.newLine();
			writer.flush();
			System.out.println("Sent edu domains: " + eduResult);

			// (d) Đóng kết nối
			writer.close();
			reader.close();
			socket.close();
			System.out.println("Connection closed.");

		} catch (SocketTimeoutException e) {
			System.out.println("Timeout: Server did not respond within 5 seconds.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
