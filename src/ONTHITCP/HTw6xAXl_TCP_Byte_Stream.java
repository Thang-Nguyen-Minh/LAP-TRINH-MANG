package ONTHITCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class HTw6xAXl_TCP_Byte_Stream {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2206;
		String msv="B22DCVT525";
		String qc="HTw6xAXl";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			String sd=msv+";"+qc;
			out.write(sd.getBytes());
			out.flush();
			//Đọc độ dài 1 mảng byte và đó chính là input bài toán.
			byte[] buf=new byte[8192];
			int len=in.read(buf);
			String input=new String(buf,0,len).trim();
			String[] tach=input.split(",");
			int n=tach.length;
			int[] a=new int[n];
			for(int i=0;i<n;i++) a[i]=Integer.parseInt(tach[i].trim());
			int[] dp=new int[n];
			int[] parent=new int[n];
			Arrays.fill(dp,1);
			Arrays.fill(parent,-1);
			int maxLen=0;
			//1 biến lưu chỉ số kết thúc của dãy có nữa
			int lastIdx=-1;
			for(int i=0;i<n;i++){
				for(int j=0;j<i;j++){
					if(a[i]>a[j] && dp[i]<dp[j]+1){
						dp[i]=dp[j]+1;
						parent[i]=j;
					}
				}
				if(dp[i]>maxLen){
					maxLen=dp[i];
					lastIdx=i;
				}
			}
			List<Integer> rs=new ArrayList<>();
			//Lấy ra các phần tử trong dãy con từ cuối về bằng thứ tự ngược
			int cur=lastIdx;
			while (cur!=-1){
				rs.add(a[cur]);
				cur=parent[cur];
			}
			Collections.reverse(rs);
			String kq="";
			for(int i=0;i<rs.size();i++){
				kq+=rs.get(i);
				if(i<rs.size()-1) kq+=",";
			}
			kq+=";"+maxLen;
			out.write(kq.getBytes());
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
	}
}
