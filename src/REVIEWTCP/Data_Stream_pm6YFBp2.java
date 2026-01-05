package REVIEWTCP;
import java.io.*;
import java.net.*;
public class Data_Stream_pm6YFBp2 {
	public static void main(String[] args) {
		String host = "203.162.10.109";
		int port = 2207;
		String studentCode = "B22DCVT525";
		String qCode = "pm6YFBp2";

		try (Socket socket = new Socket(host, port)) {
			socket.setSoTimeout(5000);

			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

			// a. Gửi studentCode;qCode
			String sendCode = studentCode + ";" + qCode;
			dos.writeUTF(sendCode);
			dos.flush();
			System.out.println("Send: " + sendCode);

			// b. Nhận n
			int n = dis.readInt();
			System.out.println("n = " + n);

			// b. Nhận n giá trị xúc xắc
			int[] count = new int[7]; // count[1..6]
			for (int i = 0; i < n; i++) {
				int val = dis.readInt();
				if (val >= 1 && val <= 6) {
					count[val]++;
				}
			}

			// In mảng kết quả nhận được
			for (int i = 1; i <= 6; i++) {
				System.out.println("Count[" + i + "] = " + count[i]);
			}

			// c. Tính xác suất
			for (int i = 1; i <= 6; i++) {
				float prob = (float) count[i] / n;
				dos.writeFloat(prob);
				System.out.println("Send P(" + i + ") = " + prob);
			}
			dos.flush();

			System.out.println("All probabilities sent!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
