package RMIClient;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.CharacterService;
public class Character_137k0ZlA {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String stc="B22DCVT525";
		String qc="137k0ZlA";
		//1. Kết nối đến RMI Registry của Server
		Registry rs=LocateRegistry.getRegistry(host,port);
		//2. Tra cứu (lookup) đối tượng từ xa
		CharacterService cs=(CharacterService) rs.lookup("RMICharacterService");
		//3. Nhan input
		String input=cs.requestCharacter(stc,qc);
		System.out.println(input);
		//4. Solve
		int[] cnt=new int[1000001];
		for(char c:input.toCharArray()){
			cnt[c]++;
		}
		String kq="";
		for(char c:input.toCharArray()){
			if(cnt[c]!=0){
				kq+=c+""+cnt[c];
				cnt[c]=0;
			}
		}
		System.out.println(kq);
		//Submitdata
		cs.submitCharacter(stc,qc,kq);
	}
}
