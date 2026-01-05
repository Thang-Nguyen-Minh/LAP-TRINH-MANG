package REVIEWTCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Object_Stream_kuD4Q8zZ {
	public static void main(String[] args) throws IOException,SocketTimeoutException,ClassNotFoundException{
		String host="203.162.10.109";
		int port=2209;
		String studentCode="B22DCVT525";
		String qCode="kuD4Q8zZ";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
			String sendCode=studentCode+";"+qCode;
			out.writeObject(sendCode);
			out.flush();
			Object obj=in.readObject();
			if(obj instanceof Address){
				Address a=(Address) obj;
				String newAddress=chuanHoa(a.getAddressLine());
				a.setAddressLine(newAddress);
				String newCode=chuanHoa2(a.getPostalCode());
				a.setPostalCode(newCode);
				out.writeObject(a);
				out.flush();
			}
			else System.out.println("Not Found");
			in.close();
			out.close();
			socket.close();
		}
	}
	public static String chuanHoa(String s){
		String kq=s.replaceAll("[^a-zA-Z0-9\\s]","");
		String[] a=kq.split("\\s+");
		String ans="";
		for(String x:a){
			if(!x.isEmpty()) ans+=Character.toUpperCase(x.charAt(0))+x.substring(1).toLowerCase()+" ";
		}
		return kq.trim();
	}
	public static String chuanHoa2(String s){
		String kq=s.replaceAll("[^0-9-]","");
		return kq;
	}
}
