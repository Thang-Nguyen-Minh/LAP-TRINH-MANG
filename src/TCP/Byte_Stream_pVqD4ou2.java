package TCP;
import java.io.*;
import java.net.*;
public class Byte_Stream_pVqD4ou2 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2206;
		String stc="B22DCVT525";
		String qc="pVqD4ou2";
		try(Socket socket=new Socket(host,port)){
			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			String sc=stc+";"+qc;
			out.write(sc.getBytes());
			out.flush();
			byte[] buffer=new byte[1024];
			int byteRead=in.read(buffer);
			String input=new String(buffer,0,byteRead).trim();
			String[] a=input.split("\\|");
			int sum=0;
			for(String x:a){
				sum+=Integer.parseInt(x);
			}
			out.write(String.valueOf(sum).getBytes());
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
