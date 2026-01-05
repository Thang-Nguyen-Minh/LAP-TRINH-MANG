package TCPPP;
import java.io.*;
import java.net.*;

public class ObjectStream {
	public static void main(String[] args) throws IOException, ClassNotFoundException,SocketTimeoutException {
		String host="203.162.10.109";
		int port=2209;
		String studentCode="B22DCVT525";
		String qCode="4XXey6UE";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			//a. "studentCode;qCode".
			String code=studentCode+";"+qCode;
			out.writeObject(code);
			out.flush();
			System.out.println("Code: "+code);
			//b. Nhận một đối tượng là thể hiện của lớp TCP.Product từ server
			Object obj = in.readObject();
			if(obj instanceof Product){
				Product product=(Product) obj;
				System.out.println("Product: "+product);
				// (c) Tính discount
				System.out.println("Price: "+product.getPrice());
				int discount=calc(product.getPrice());
				product.setDiscount(discount);
				System.out.println("Discount: "+discount);
				// Gửi lại đối tượng Product
				out.writeObject(product);
				out.flush();
			}
			else{
				System.out.println("Object not found");
			}
			// (d) Đóng kết nối
			in.close();
			out.close();
			socket.close();
		}
	}
	private static int calc(double price) {
		int sum=0;
		int n=(int) price;
		while(n>0){
			sum+=n%10;
			n=n/10;
		}
		return sum;
	}
}
