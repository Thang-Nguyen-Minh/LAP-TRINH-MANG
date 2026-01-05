package REVIEWTCP;

import java.io.*;
import java.net.*;

public class Data_Stream_M6aegP5W {
	public static void main(String[] args) {
		String host = "203.162.10.109";
		int port = 2207;
		String studentCode = "B22DCVT525";
		String qCode = "M6aegP5W";

		try (Socket socket = new Socket(host, port)) {
			socket.setSoTimeout(5000);

			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

			// a. Gửi studentCode;qCode
			String sendCode = studentCode + ";" + qCode;
			dos.writeUTF(sendCode);
			dos.flush();
			System.out.println("Send: " + sendCode);

			// b. Nhận mảng số nguyên
			int n = dis.readInt(); // số phần tử
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = dis.readInt();
			}

			System.out.print("Received array: ");
			for (int x : arr) System.out.print(x + " ");
			System.out.println();

			// c. Tính toán
			int sum = 0;
			for (int x : arr) sum += x;

			float mean = (float) sum / n;

			float variance = 0;
			for (int x : arr) {
				variance += (x - mean) * (x - mean);
			}
			variance /= n;

			System.out.println("Sum = " + sum);
			System.out.println("Mean = " + mean);
			System.out.println("Variance = " + variance);

			// Gửi kết quả lên server
			dos.writeInt(sum);
			dos.writeFloat(mean);
			dos.writeFloat(variance);
			dos.flush();

			System.out.println("Results sent!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

