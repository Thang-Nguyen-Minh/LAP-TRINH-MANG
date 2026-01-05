package REVIEWTCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Data_Stream_9eVuWekv {
	public static void main(String[] args) throws IOException,SocketTimeoutException{
		String host="203.162.10.109";
		int port=2207;
		String studentCode="B22DCVT525";
		String qCode="9eVuWekv";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			DataInputStream in=new DataInputStream(socket.getInputStream());
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			String sendCode=studentCode+";"+qCode;
			out.writeUTF(sendCode);
			out.flush();
			int a=in.readInt();
			int b=in.readInt();
			int tong=a+b,tich=a*b;
			out.writeInt(tong);
			out.writeInt(tich);
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
	}
}
