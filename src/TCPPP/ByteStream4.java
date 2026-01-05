package TCPPP;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ByteStream4 {
	public static void main(String[] args) throws IOException, SocketTimeoutException {
		String host = "203.162.10.109";
		int port = 2206;
		String studentCode = "B22DCVT525";
		String qCode = "1YWKfT1a";

		try (Socket socket = new Socket(host, port)) {
			socket.setSoTimeout(5000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			// a. Gửi studentCode;qCode
			String sendCode = studentCode + ";" + qCode;
			out.write(sendCode.getBytes());
			out.flush();
			System.out.println("Send code : " + sendCode);

			// b. Nhận dữ liệu từ server
			byte[] buffer = new byte[1024];
			int byteRead = in.read(buffer);
			String input = new String(buffer, 0, byteRead).trim();
			System.out.println("Received: " + input);

			// c. Xử lý
			String[] list = input.split(",");
			List<Integer> nums = new ArrayList<>();
			for (String x : list) {
				nums.add(Integer.parseInt(x.trim()));
			}
			int totalSum = 0;
			for (int v : nums) totalSum += v;

			int minDiff = Integer.MAX_VALUE;
			int bestIndex = -1;
			int sumLeft = 0;

			for (int i = 0; i < nums.size(); i++) {
				int current = nums.get(i);
				int sumRight = totalSum - sumLeft - current; // bỏ phần tử i
				int diff = Math.abs(sumLeft - sumRight);
				if (diff < minDiff) {
					minDiff = diff;
					bestIndex = i;
				}
				sumLeft += current; // cập nhật cho bước sau
			}
			// Tính lại sumLeft, sumRight ở vị trí bestIndex
			sumLeft = 0;
			for (int i = 0; i < bestIndex; i++) sumLeft += nums.get(i);
			int sumRight = 0;
			for (int i = bestIndex + 1; i < nums.size(); i++) sumRight += nums.get(i);

			String result = bestIndex + "," + sumLeft + "," + sumRight + "," + minDiff;
			System.out.println("Result: " + result);
			out.write(result.getBytes());
			out.flush();
			// d. Đóng kết nối
			in.close();
			out.close();
			socket.close();
		}
	}
}
