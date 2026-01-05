package TCPPP;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class DataStream3 {
	public static void main(String[] args) throws IOException,SocketTimeoutException {
		String host = "203.162.10.109";
		int port = 2207;
		String studentCode="B22DCVT525";
		String qCode="Uu50V8dN";
		try(Socket socket=new Socket(host,port)){
			DataInputStream in=new DataInputStream(socket.getInputStream());
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			String sendCode=studentCode+";"+qCode;
			out.writeUTF(sendCode);
			out.flush();
			String input=in.readUTF();
			System.out.println(input);
			String[] a=input.split(",");
			List<Integer> list=new ArrayList<>();
			for (String x : a) {
				x = x.trim();
				if (!x.isEmpty()) {   // kiểm tra chuỗi rỗng
					list.add(Integer.parseInt(x));
				}
			}
			int dc=0,dbt=0,n=list.size();
			int prevDiff = 0; // 0 = chưa xác định, 1 = tăng, -1 = giảm

			for (int i = 1; i < n; i++) {
				int diff = list.get(i) - list.get(i - 1);
				if (diff > 0) {
					if (prevDiff < 0) dc++; // trước giảm, giờ tăng
					prevDiff = 1;
				} else if (diff < 0) {
					if (prevDiff > 0) dc++; // trước tăng, giờ giảm
					prevDiff = -1;
				}
			}
			for(int i=0;i<n-1;i++) dbt+=Math.abs(list.get(i)-list.get(i+1));
			out.writeInt(dc);
			out.writeInt(dbt);
			out.flush();
			System.out.println(dc+" "+dbt);
			out.close();
			in.close();
			socket.close();
		}
	}
}
