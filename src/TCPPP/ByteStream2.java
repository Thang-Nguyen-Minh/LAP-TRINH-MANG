package TCPPP;
import java.io.*;
import java.net.*;
public class ByteStream2 {
	public static void main(String[] args) throws IOException,SocketTimeoutException{
		String host="203.162.10.109";
		int port=2206;
		String studentCode="B22DCVT525";
		String qCode="p9AWaSIO";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//a. "studentCode;qCode"
			String sendCode=studentCode+";"+qCode;
			out.write(sendCode.getBytes());
			out.flush();
			System.out.println("Send code: "+sendCode);
			//b. Nhận dữ liệu từ server là một chuỗi các số nguyên được phân tách bởi ký tự ",".
			byte[] buffer=new byte[1024];
			int bytesRead=in.read(buffer);
			if(bytesRead==-1){
				System.out.println("No data");
				return;
			}
			String input=new String(buffer,0,bytesRead);
			System.out.println(input);
			//c. Xác định hai số trong dãy có tổng gần nhất
			String[] num=input.split(",");
			int sum=0;
			for(String x:num){
				try{
					sum+=Integer.parseInt(x.trim());
				}
				catch(NumberFormatException e){
					System.out.println(e);
				}
			}

			double tb = (double) sum/ num.length;
			double target = 2 * tb;
			int n1=0,n2=0;
			double minDiff=Double.MAX_VALUE;
			for(int i=0;i<num.length;i++){
				for(int j=i+1;j<num.length;j++){
					int a=Integer.parseInt(num[i].trim());
					int b=Integer.parseInt(num[j].trim());
					double diff=Math.abs((a+b)-target);
					if(diff<minDiff){
						minDiff=diff;
						n1=a;
						n2=b;
					}
				}
			}
			int min=Math.min(n1,n2);
			int max=Math.max(n1,n2);
			String kq=min+","+max +"\n";
			out.write(kq.getBytes());
			out.flush();
			System.out.println("Kq: "+kq);
			in.close();
			out.close();
			socket.close();
		}
	}
}
