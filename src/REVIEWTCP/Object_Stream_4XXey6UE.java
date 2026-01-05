package REVIEWTCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Object_Stream_4XXey6UE {
	public static void main(String[] args) throws IOException,SocketTimeoutException,ClassNotFoundException{
		String host="203.162.10.109";
		int port=2209;
		String studentCode="B22DCVT525";
		String qCode="4XXey6UE";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
			String sendCode=studentCode+";"+qCode;
			out.writeObject(sendCode);
			out.flush();
			Object obj=in.readObject();
			if(obj instanceof Product){
				Product product=(Product) obj;
				int disCount=calc(product.getPrice());
				product.setDiscount(disCount);
				out.writeObject(product);
				out.flush();
			}
			else System.out.println("Obj not found");
			in.close();
			out.close();
			socket.close();
		}
	}
	public static int calc(double price){
		int sum=0,n=(int)price;
		while(n>0){
			sum+=n%10;
			n/=10;
		}
		return sum;
	}
}
