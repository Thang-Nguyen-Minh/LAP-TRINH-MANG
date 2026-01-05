package RMIClient;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.CharacterService;

public class Character_Hvi5OQov {
	public static void main(String[] args) throws Exception {
		String host = "203.162.10.109";
		int port = 1099;
		String stc = "B22DCVT525";   // Mã sinh viên
		String qc  = "Hvi5OQov";     // Mã câu hỏi

		// 1️⃣ Kết nối đến Registry và lấy service
		Registry registry = LocateRegistry.getRegistry(host, port);
		CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");

		// 2️⃣ Nhận chuỗi từ server
		String received = cs.requestCharacter(stc, qc);
		System.out.println("Received from server: " + received);

		// 3️⃣ Tách từ khóa và chuỗi đầu vào
		String[] parts = received.split(";");
		String keyword = parts[0].trim();
		String plaintext = parts[1].trim();
		System.out.println("Keyword: " + keyword);
		System.out.println("Plaintext: " + plaintext);

		// 4️⃣ Mã hóa Vigenère
		String encrypted = vigenereEncrypt(plaintext, keyword);
		System.out.println("Encrypted text: " + encrypted);

		// 5️⃣ Gửi chuỗi mã hóa về server
		cs.submitCharacter(stc, qc, encrypted);
		System.out.println("Encrypted text submitted successfully.");
	}

	// Hàm mã hóa Vigenère (chỉ áp dụng cho chữ in hoa A-Z)
	private static String vigenereEncrypt(String text, String key) {
		StringBuilder result = new StringBuilder();
		int n = text.length();
		key = key.toUpperCase();
		text = text.toUpperCase();

		for (int i = 0; i < n; i++) {
			char t = text.charAt(i);
			char k = key.charAt(i % key.length());
			if (t >= 'A' && t <= 'Z') {
				char c = (char) ((t - 'A' + (k - 'A')) % 26 + 'A');
				result.append(c);
			} else {
				result.append(t); // giữ nguyên nếu không phải chữ cái
			}
		}
		return result.toString().toLowerCase();
	}
}
