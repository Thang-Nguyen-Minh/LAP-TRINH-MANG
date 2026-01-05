package REVIEWTCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class Byte_Stream_p9AWaSIO {
	public static void main(String[] args) throws IOException,SocketTimeoutException{
		String host="203.162.10.109";
		int port=2206;
		String studentCode="B22DCVT525";
		String qCode="p9AWaSIO";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			String sendCode=studentCode+";"+qCode;
			out.write(sendCode.getBytes());
			out.flush();
			byte[] buf=new byte[1024];
			int br=in.read(buf);
			String input=new String(buf,0,br);
			String[] num=input.split(",");
			List<Integer> a=new ArrayList<>();
			for(String x:num) a.add(Integer.parseInt(x.trim()));
			int sum=0;
			for(int x:a) sum+=x;
			int n=a.size();
			double tb=(double)sum*2/n;
			int n1=0,n2=0;
			double minDiff=Double.MAX_VALUE;
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					int x=a.get(i);
					int y=a.get(j);
					double diff=Math.abs(tb-x-y);
					if(diff<minDiff){
						minDiff=diff;
						n1=x;
						n2=y;
					}
				}
			}
			int min=Math.min(n1,n2);
			int max=Math.max(n1,n2);
			String kq=min+","+max;
			out.write(kq.getBytes());
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
	}
}
