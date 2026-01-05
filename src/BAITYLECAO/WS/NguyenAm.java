//package BAITYLECAO.WS;
//
//import RMI.CharacterService;
//
//import javax.xml.stream.events.Characters;
//import java.util.*;
//
//public class NguyenAm {
//	public static void main(String[] args){
//		try{
//			String msv="b22dcvt525";
//			String qc="minhthang04";
//			CharacterService_Service cs = new CharacterService_Service();
//			CharacterService port=cs.getCharacterServicePort();
//			//Nhận input
//			List<String> a=port.requestStringArray(msv,qc);
//			//Map Lưu nhóm và Set lấy ra nguyên âm
//			Set<Character> se = new HashSet<>(Arrays.asList('a','u','o','i','e','A','U','O','I','E'));
//			Map<Integer,List<String>> mp=new TreeMap<>();
//			for(String w:a){
//				int cnt=0;
//				//["banana", "apple", "grape", "kiwi", "egg"]
//				for(char c:w.toCharArray()){
//					if(se.contains(c)) ++cnt;
//				}
//				//banana : cnt=3, apple,grape,kiwi : cnt=2, egg: cnt=1
//				//Chia ngăn từng từ với cnt tương ứng.
//				// 1 : [egg]
//				// 2 : [apple,grape,kiwi]
//				// 3 : [banana]
//				//Với mỗi biến cnt, tạo 1 mảng mới chứa các từ với cnt tương ứng
//				mp.computeIfAbsent(cnt,k->new ArrayList<>()).add(w);
//			}
//			//Sắp xếp trong nhóm và Định dạng chuỗi kết quả
//			List<String> kq=new ArrayList<>();
//			for(Map.Entry<Integer,List<String>> e : mp.entrySet()){
//				List<String> group=e.getValue();
//				//Sort lại các mảng theo từ điển, điền dấu phảy và cho vào kết quả
//				Collections.sort(group);
//				String rs=String.join(", ",group);
//				kq.add(rs);
//			}
//			port.submitCharacterStringArray(msv, qc, kq);
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//	}
//}
