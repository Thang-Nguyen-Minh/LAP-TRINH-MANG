package BAITYLECAO.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class PhuongSai {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2207;
		String msv="b22dcvt525";
		String qc="M6aegP5W";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String sd=msv+";"+qc;
			dos.writeUTF(sd);
			dos.flush();
			//Đọc một số nguyên n từ Server (số lượng phần tử của mảng)
			//Đọc tiếp n số nguyên và lưu vào một mảng hoặc danh sách
			int n=dis.readInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) arr[i]=dis.readInt();
			//Tính tổng, trung bình cộng và phương sai
			int sum=0;
			for(int x:arr) sum+=x;
			float tbc=(float) sum/n;
			float ps=0;
			for(int x:arr){
				ps+=(x-tbc)*(x-tbc);
			}
			ps/=n;
			dos.writeInt(sum);
			dos.writeFloat(tbc);
			dos.writeFloat(ps);
			dos.flush();
			dis.close();
			dos.close();
			socket.close();
		}
	}
}
