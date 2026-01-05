package TCPPP;
import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ByteStream3 {
	public static void main(String[] args) throws IOException, SocketTimeoutException {
		String host="203.162.10.109";
		int port=2206;
		String studentCode="B22DCVT525";
		String qCode="hiGFRDuE";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			//a. studentCode;qCode
			String sendCode=studentCode+";"+qCode;
			out.write(sendCode.getBytes());
			out.flush();
			System.out.println("Send code : "+sendCode);
			//b. Nhận dữ liệu từ server
			byte[] buffer=new byte[1024];
			int byteRead=in.read(buffer);
			String input=new String(buffer,0,byteRead);
			System.out.println(input);
			//c. Tính tổng của tất cả các số nguyên tố trong chuỗi và gửi kết quả lên server.
			String[] list=input.split(",");
			int sum=0;
			for(String x:list){
				if(nt(Integer.parseInt(x))) sum+=Integer.parseInt(x);
			}
			System.out.println(sum);
			String kq=sum+"\n";
			out.write(kq.getBytes());
			out.flush();
			System.out.println("kq : "+kq);
		}
	}
	private static boolean nt(int x){
		if(x<2) return false;
		for(int i=2;i<Math.sqrt(x);i++){
			if(x%i==0) return false;
		}
		return true;
	}
}
