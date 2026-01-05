package TCPPP;

import java.io.*;
import java.net.*;

public class ByteStream {
	public static void main(String[] args) {
		String host="203.162.10.109";
		int port=2206;
		String studentCode="B22DCVT525";
		String qCode="cp12rc9Z";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			//InputStream/OutputStream
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//a. "studentCode;qCode"
			String sendCode=studentCode+";"+qCode;
			out.write(sendCode.getBytes());
			out.flush();
			System.out.println("Code: "+sendCode);
			//b. Nhận dữ liệu từ server (input)
			byte[] buffer=new byte[1024];
			int bytesRead=in.read(buffer);
			if(bytesRead==-1){
				System.out.println("Not Found");
				return;
			}
			String input=new String(buffer,0,bytesRead);
			System.out.println("input: "+input);
			//c. tìm giá trị tổng của các số nguyên trong chuỗi
			int sum=0;
			String[] num=input.split("\\|");
			for(String x:num){
				try{
					sum+=Integer.parseInt(x);
				}
				catch(NumberFormatException e){
					System.out.println("Not Found");
				}
			}
			String kq=String.valueOf(sum);
			out.write(kq.getBytes());
			out.flush();
			System.out.println("kq: "+kq);
			socket.close();
			System.out.println("Done");
		}
		catch(SocketTimeoutException e){
			System.out.println(e);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
