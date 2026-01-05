package REVIEWTCP;
import java.io.*;
import java.net.*;
public class Byte_Stream_cp12rc9Z {
	public static void main(String[] args) throws IOException,SocketTimeoutException{
		String host="203.162.10.109";
		int port=2206;
		String studentCode="B22DCVT525";
		String qCode="cp12rc9Z";
		try(Socket socket = new Socket(host,port)){
			socket.setSoTimeout(5000);
			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			String sendCode=studentCode+";"+qCode;
			out.write(sendCode.getBytes());
			out.flush();
			byte[] buffer=new byte[1024];
			int byteRead=in.read(buffer);
			String input=new String(buffer,0,byteRead);
			String[] a=input.split("\\|");
			int sum=0;
			for(String x:a) sum+=Integer.parseInt(x.trim());
			String kq=sum+"\n";
			out.write(kq.getBytes());
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
	}


}
