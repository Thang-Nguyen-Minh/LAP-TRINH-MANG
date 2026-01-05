package ONTHITCP;

import java.io.*;
import java.util.*;
import java.net.*;

public class Byte_Stream_HTw6xAXl {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2206;
		String msv="b22dcvt525";
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
			String input = new String(buf,0,len).trim();
			String[] tach=input.split(",");
			int n=tach.length;
			int[] a=new int[n];
			for(int i=0;i<n;i++) a[i]=Integer.parseInt(tach[i].trim());
			int[] dp=new int[n];
			int[] parent=new int[n];
			Arrays.fill(dp,1);
			Arrays.fill(parent,-1);
			int maxLen=0,lastIdx=-1;
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
			List<Integer> rs =new ArrayList<>();
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
/*
10, 22 ,9 , 33
dp=[1,1,1,1]
parent=[-1,-1,-1,-1]
i=0
dp=[1,1,1,1]
parent=[-1,-1,-1,-1]

i=1
(a[1]=22 > a[0]=10 && dp[1] = 1  < dp[0] + 1=2)
dp[1]=dp[0]+1=2;
parent[1]=0;
dp[i]=2>maxLength => maxLength=2; lastIndex=1
dp=[1,2,1,1]
parent=[-1,0,-1,-1]

i=2
a[2]=9 < a[1]=22 , < a[0]=10
=> bo qua

i=3
a[3]>a[0]=10 && dp[3]=1 < dp[0]+1=2
dp[3]=2
parent[3]=0

a[3]>a[1]=22 && dp[3]=2 < dp[1]+1=3
dp[3]=3
parent[3]=1

a[3]>a[2]=9 ; dp[3]=3 > dp[2]+1=2 => bo qua

dp[3]=3 > maxLength=2
=> maxLength=3; lastIndex=i=3;

dp[1,2,1,3]
parent[-1,0,-1,1]

cur=3
while(3!=-1)
kq=a[3],a[1],a[0]
cur=parent[3]=1; gán thg cur vào parent chứ không phải gán parent vào cur, mẹ cứ nghĩ thế xong dhs nó giảm về -1 được.
}
kq=a[3],a[1],a[0] => reverse lại là xong.
 */