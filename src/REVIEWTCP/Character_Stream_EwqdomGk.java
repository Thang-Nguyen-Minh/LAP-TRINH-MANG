import java.io.*;
import java.net.*;
import java.util.*;

public class Character_Stream_EwqdomGk {
	public static void main(String[] args) throws IOException,SocketTimeoutException{
		String host="203.162.10.109";
		int port=2208;
		String studentCode="B22DCVT525";
		String qCode="EwqdomGk";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String sendCode=studentCode+";"+qCode;
			writer.write(sendCode);
			writer.newLine();
			writer.flush();
			String input=reader.readLine();
			String[] a=input.split("\\s+");
			List<String> list=new ArrayList<>();
			for(String x:a){
				String dao=new StringBuilder(x).reverse().toString();
				list.add(chuanHoa(dao));
			}
			String kq="";
			for(String x:list) kq+=x.trim()+" ";
			writer.write(kq.trim());
			writer.newLine();
			writer.flush();
			reader.close();
			writer.close();
			socket.close();
		}
	}
	private static String chuanHoa(String s){
		String kq="";
		int cnt=1;
		for(int i=1;i<=s.length();i++){
			if(i<s.length() && s.charAt(i)==s.charAt(i-1)) ++cnt;
			else{
				kq+=s.charAt(i-1);
				if(cnt>1) kq+=cnt;
				cnt=1;
			}
		}
		return kq.toString();
	}
}
