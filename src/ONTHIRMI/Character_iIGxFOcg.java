package ONTHIRMI;

import RMI.CharacterService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Character_iIGxFOcg {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String msv="b22dcvt525";
		String qc="iIGxFOcg";
		Registry rs= LocateRegistry.getRegistry(host,port);
		CharacterService cs = (CharacterService) rs.lookup("RMICharacterService");
		String input=cs.requestCharacter(msv,qc);
		int[] cnt=new int[1000001];
		for(char c:input.toCharArray()) cnt[c]++;
		String kq="";
		for(char c:input.toCharArray()){
			if(cnt[c]!=0){
				//Cộng thêm dấu "" vào giữa thì máy mới hiểu là String
				kq+=c+""+cnt[c];
				cnt[c]=0;
			}
		}
		cs.submitCharacter(msv,qc,kq);
	}
}
