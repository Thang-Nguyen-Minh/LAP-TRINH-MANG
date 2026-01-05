package REVIEWTCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class Byte_Stream_1YWKfT1a {
	public static void main(String[] args) throws IOException,SocketTimeoutException{
		String host="203.162.10.109";
		int port=2206;
		String studentCode="B22DCVT525";
		String qCode="1YWKfT1a";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			String sendCode=studentCode+";"+qCode;
			out.write(sendCode.getBytes());
			out.flush();
			byte[] buf=new byte[1024];
			int br=in.read(buf);
			String input=new String(buf,0,br).trim();
			String[] a=input.split(",");
			List<Integer> list=new ArrayList<>();
			for(String x:a) list.add(Integer.parseInt(x.trim()));
			int sum=0;
			for(int x:list) sum+=x;
			int sumLeft=0,minDiff=Integer.MAX_VALUE,best=-1;
			int n=list.size();
			for(int i=0;i<n;i++){
				int cur=list.get(i);
				int sumRight=sum-sumLeft-cur;
				int diff=Math.abs(sumLeft-sumRight);
				if(diff<minDiff){
					minDiff=diff;
					best=i;
				}
				sumLeft+=cur;
			}
			sumLeft=0;
			int sumRight=0;
			for(int i=0;i<best;i++) sumLeft+=list.get(i);
			for(int i=best+1;i<n;i++) sumRight+=list.get(i);
			String kq=best+","+sumLeft+","+sumRight+","+minDiff;
			out.write(kq.getBytes());
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
	}
}
