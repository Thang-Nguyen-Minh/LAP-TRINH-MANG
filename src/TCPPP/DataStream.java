package TCPPP;

import java.io.*;
import java.net.*;

public class DataStream {
	public static void main(String[] args) throws IOException,SocketTimeoutException {
		String host="203.162.10.109";
		int port=2207;
		String studentCode="B22DCVT525";
		String qCode="9eVuWekv";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			DataInputStream in=new DataInputStream(socket.getInputStream());
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			//a.Gửi chuỗi là mã sinh viên và mã câu hỏi
			String code=studentCode+";"+qCode;
			out.writeUTF(code);
			out.flush();
			System.out.println("code: "+code);
			//b.Nhận lần lượt hai số nguyên a và b từ server
			int a=in.readInt();
			int b=in.readInt();
			System.out.println("a: "+a+" b: "+b);
			//c.Thực hiện tính toán tổng, tích và gửi lần lượt từng giá trị theo đúng thứ tự trên lên server
			int tong=a+b;
			int tich=a*b;
			out.writeInt(tong);
			out.writeInt(tich);
			out.flush();
			System.out.println("tong: "+tong+" tich: "+tich);
			in.close();
			out.close();
			socket.close();
		}
	}
}
