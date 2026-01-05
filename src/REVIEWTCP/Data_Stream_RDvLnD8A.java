package REVIEWTCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class Data_Stream_RDvLnD8A {
	public static void main(String[] args) throws IOException, SocketTimeoutException{
		String host="203.162.10.109";
		int port=2207;
		String studentCode="B22DCVT525";
		String qCode="RDvLnD8A";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			DataInputStream in=new DataInputStream(socket.getInputStream());
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			String sendCode=studentCode+";"+qCode;
			out.writeUTF(sendCode);
			out.flush();
			int k=in.readInt();
			String num=in.readUTF();
			String[] list=num.split(",");
			List<Integer> a=new ArrayList<>();
			for(String x:list) a.add(Integer.parseInt(x.trim()));
			int n=a.size();
			for(int i=0;i<n;i+=k){
				int start=i;
				int end=Math.min(i+k-1,n-1);
				while(start<end){
					Collections.swap(a,start,end);
					start++;end--;
				}
			}
			String kq="";
			for(int i=0;i<n;i++){
				if(i<n-1) kq+=a.get(i)+",";
				else kq+=a.get(i);
			}
			out.writeUTF(kq);
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
	}
}
