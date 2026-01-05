package CODE14BAILIENTUC;

import RMI.CharacterService;
import RMI.ObjectService;
import RMI.ProductX;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class iIGxFOcg_Character {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String msv="b22dcvt525";
		String qc="iIGxFOcg";
		Registry rs= LocateRegistry.getRegistry(host,port);
		CharacterService cs = (CharacterService) rs.lookup("RMICharacterService");
		String s = cs.requestCharacter(msv,qc);
		int[] cnt=new int[1000001];
		for(char x:s.toCharArray()) cnt[x]++;
		String kq="";
		for(char x:s.toCharArray()){
			if(cnt[x]!=0){
				kq+=x+""+cnt[x];
				cnt[x]=0;
			}
		}
		cs.submitCharacter(msv,qc,kq);
	}
}
