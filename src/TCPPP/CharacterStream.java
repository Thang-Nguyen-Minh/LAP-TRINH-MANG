package TCPPP;

import java.io.*;
import java.util.*;
import java.net.*;

public class CharacterStream {
	public static void main(String[] args){
		//Lấy thông tin cơ bản : host,port, studentCode,qCode
		String host="203.162.10.109";
		int port=2208;
		String studentCode="B22DCVT525";
		String qCode="LTN1AxpF";
		//Try với Socket
		try(Socket socket=new Socket(host,port)) {
			socket.setSoTimeout(5000);
			//Tạo luồng đọc/ghi
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//(a). Gửi "studentCode;qCode"
			String sendCode=studentCode+";"+qCode;
			writer.write(sendCode);
			writer.newLine();
			writer.flush();
			System.out.println("Sent to server: " + sendCode);
			//Nhận danh sách tên miền
			//Đây là phần lấy ra input đề bài
			String domains= reader.readLine();
//			if(domains==null || domains.trim().isEmpty()){
//				System.out.println("No domains found");
//				return;
//			}
			System.out.println("Domains: " + domains);
			//Phần xử lý , thường là phần c trong đề bài
			String[] domainList=domains.split(",\\s*");
			List<String> edu=new ArrayList<>();
			for(String d:domainList){
				if(d!=null && d.trim().toLowerCase().endsWith(".edu")) edu.add(d.trim());
			}
			//Ghép lại thành chuỗi
			//MdpIzhxDVtTFTF.edu, 4hXfJe9giAA.edu : ghép với dấu ,
			String kq=String.join(", ",edu);
			writer.write(kq);
			writer.newLine();
			writer.flush();
			System.out.println("Result :" + kq);
			//(d) Đóng kết nối
			writer.close();
			reader.close();
			socket.close();
			System.out.println("Connection closed.");
		}
		catch(SocketTimeoutException e){
			System.out.println("Socket timed out"+e.getMessage());
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
