package TCPPP;
import java.io.*;
import java.net.*;
public class ObjectStream2 {
	public static void main(String[] args) throws IOException,ClassNotFoundException,SocketTimeoutException {
		String host="203.162.10.109";
		int port=2209;
		String studentCode="B22DCVT525";
		String qCode="kuD4Q8zZ";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
			//a. "studentCode;qCode"
			String sendCode=studentCode+";"+qCode;
			out.writeObject(sendCode);
			out.flush();
			System.out.println("Send code: "+sendCode);
			//b. Chuẩn hóa thông tin addressLine
			Object obj=in.readObject();
			if(obj instanceof Address){
				Address a=(Address) obj;
				String newAddressLine=chuanHoa(a.getAddressLine());
				a.setAddressLine(newAddressLine);
				System.out.println("New address line: "+newAddressLine);
				String newpostalCode=chuanHoa2(a.getPostalCode());
				a.setPostalCode(newpostalCode);
				System.out.println("New postal code: "+newpostalCode);
				out.writeObject(a);
				out.flush();
			}
			else{
				System.out.println("Not Found");
			}
			in.close();
			out.close();
			socket.close();
		}
	}
	private static String chuanHoa(String addressLine){
		// 1. Xóa ký tự đặc biệt (chỉ giữ chữ cái, số và khoảng trắng)
		String x=addressLine.replaceAll("[^a-zA-Z0-9\\s]","");
		String[] words = x.split("\\s+");
		String kq="";
		for(String w:words){
			if(!w.isEmpty()) kq+=Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase()+" ";
		}
		return kq.trim();
	}
	private static String chuanHoa2(String s){
		return s.replaceAll("[^0-9-]","");
	}
}
