package BAITYLECAO.RMI;

import RMI.CharacterService;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MaHoaVigenère {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String msv="b22dcvt525";
		String qc="Hvi5OQov";
		Registry rs = LocateRegistry.getRegistry(host,port);
		CharacterService cs = (CharacterService) rs.lookup("RMICharacterService");
		String input=cs.requestCharacter(msv,qc);
		String[] pa=input.split(";");
		String keyword=pa[0].trim();
		String plaintext=pa[1].trim();
		String encrypt=MaHoa(keyword,plaintext);
		cs.submitCharacter(msv,qc,encrypt);
	}
	public static String MaHoa(String keyword,String plaintext){
		StringBuilder sb = new StringBuilder();
		// 1. Viết hoa hết để dễ tính toán
		keyword=keyword.toUpperCase();
		plaintext=plaintext.toUpperCase();
		for(int i=0;i<plaintext.length();i++){
			char p=plaintext.charAt(i);
			// 2. Lấy ký tự từ khóa tương ứng (Dùng phép % để lặp lại từ khóa)
			char k=keyword.charAt(i%keyword.length());
			if(p>='A' && p<='Z'){
				// 3. Công thức thần thánh:
				// (Ký tự văn bản - 'A') đưa về số từ 0-25
				// (Ký tự từ khóa - 'A') đưa về số từ 0-25
				// Cộng lại rồi % 26 để đảm bảo nó vẫn nằm trong khoảng 0-25
				char shift=(char)((p-'A'+(k-'A'))%26+'A');
				sb.append(shift);
			}
			else sb.append(p);
		}
		return sb.toString().toLowerCase();
	}
}
