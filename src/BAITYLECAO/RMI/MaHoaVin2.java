package BAITYLECAO.RMI;

import RMI.CharacterService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MaHoaVin2 {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String msv="b22dcvt525";
		String qc="minhthang04";
		Registry rs = LocateRegistry.getRegistry(host,port);
		CharacterService cs = (CharacterService) rs.lookup("RMICharacterService");
		String input=cs.requestCharacter(msv,qc);
		String[] a=input.split(";");
		String kq=maHoa(a[0],a[1]);
		cs.submitCharacter(msv,qc,kq);
		//System.out.println(maHoa("KEY","HELLO"));
	}
	public static String maHoa(String key,String text){
		StringBuilder sb = new StringBuilder();
		key=key.toUpperCase();
		text=text.toUpperCase();
		for (int i=0;i<text.length();i++){
			char p=text.charAt(i);
			char k=key.charAt(i%key.length());
			if(p>='A' && p<='Z'){
				char en=(char) ((p-'A'+(k-'A'))%26+'A');
				sb.append(en);
			}
			else sb.append(p);
		}
		return sb.toString().toLowerCase();
	}
}
