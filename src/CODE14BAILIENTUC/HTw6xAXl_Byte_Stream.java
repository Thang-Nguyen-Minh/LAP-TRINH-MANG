package CODE14BAILIENTUC;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HTw6xAXl_Byte_Stream {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2206;
		String msv="B22dcvt525";
		String qc="HTw6xAXl";
		try(Socket socket=new Socket(host,port)){
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			String sd=msv+";"+qc;
			out.write(sd.getBytes());
			out.flush();
			byte[] buf=new byte[8192];
			int len=in.read(buf);
			String input=new String(buf,0,len).trim();
			String[] so=input.split(",");
			int n=so.length;
			int[] a=new int[n];
			for(int i=0;i<n;i++) a[i]=Integer.parseInt(so[i].trim());
			int[] dp=new int[n];
			int[] parent=new int[n];
			Arrays.fill(dp,1);
			Arrays.fill(parent,-1);
			int maxVal=Integer.MIN_VALUE;
			int lastIdx=-1;
			for(int i=0;i<n;i++){
				for(int j=0;j<i;j++){
					if(a[i]>a[j] && dp[i]<dp[j]+1){
						dp[i]=dp[j]+1;
						parent[i]=j;
					}
				}
				if(dp[i]>maxVal){
					maxVal=dp[i];
					lastIdx=i;
				}
			}
			int cur=lastIdx;
			List<String> kq=new ArrayList<>();
			while (cur!=-1){
				kq.add(String.valueOf(a[cur]));
				cur=parent[cur];
			}
			Collections.reverse(kq);
			String rs=String.join(",",kq)+";"+maxVal;
			out.write(rs.getBytes());
			out.flush();
		}
	}
}
