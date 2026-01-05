package ONTHITCP;
import TCP.Laptop;

import java.io.*;
import java.util.*;
import java.net.*;
public class nwFJUD0G_TCP_Object_Stream {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2209;
		String msv="B22DCVT525";
		String qc="nwFJUD0G";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			ObjectInputStream obj = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			String sd=msv+";"+qc;
			oos.writeObject(sd);
			oos.flush();
			Laptop laptop=(Laptop) obj.readObject();
			laptop.Solve();
            oos.writeObject(laptop);
			oos.flush();
			obj.close();
			oos.close();
			socket.close();

		}
	}
}
