package TCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class Byte_Frame {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2206;
		String stc="B22DCVT525";
		String qc="pVqD4ou2";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			String sc=stc+";"+qc;
			out.write(sc.getBytes());
			out.flush();
			byte[] data=new byte[1024];
			int byteRead=in.read(data);
			String input=new String(data,0,byteRead);
			String[] a=input.split("\\|");
			int sum=0;
			for(String x:a){
				sum+=Integer.parseInt(x);
			}
			String kq=String.valueOf(sum);
			out.write(kq.getBytes());
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
