package TCPPP;

import java.io.*;
import java.net.*;

public class CharacterStream2 {
	public static void main(String[] args) {
		String host = "203.162.10.109";
		int port = 2208;
		String studentCode = "B22DCVT525";
		String qCode = "EwqdomGk";

		try (Socket socket = new Socket(host, port)) {
			socket.setSoTimeout(5000);

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));

			// (a) Gửi "studentCode;qCode"
			String sendMsg = studentCode + ";" + qCode;
			writer.write(sendMsg);
			writer.newLine();
			writer.flush();
			System.out.println("Sent: " + sendMsg);

			// (b) Nhận từ server một chuỗi chứa nhiều từ
			String tu = reader.readLine();
			System.out.println("Received: " + tu);

			// (c) Đảo ngược từng từ và RLE
			StringBuilder resultBuilder = new StringBuilder();
			String[] words = tu.split("\\s+");
			for (int i = 0; i < words.length; i++) {
				String reversed = new StringBuilder(words[i]).reverse().toString();
				String encoded = rleEncode(reversed);
				resultBuilder.append(encoded);
				if (i < words.length - 1) {
					resultBuilder.append(" ");
				}
			}
			String finalResult = resultBuilder.toString();

			// Gửi kết quả lên server
			writer.write(finalResult);
			writer.newLine();
			writer.flush();
			System.out.println("Sent processed: " + finalResult);

			// Đóng kết nối
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

	// Hàm RLE encode (ví dụ: aabb -> a2b2)
	private static String rleEncode(String input) {
		if (input == null || input.isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		int count = 1;
		char prev = input.charAt(0);

		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == prev) {
				count++;
			} else {
				sb.append(prev);
				if (count > 1) sb.append(count);
				count = 1;
				prev = c;
			}
		}
		sb.append(prev);
		if (count > 1) sb.append(count);
		return sb.toString();
	}
}
