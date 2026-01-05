//package BAITYLECAO.WS;
//
//import RMI.CharacterService;
//
//import javax.xml.stream.events.Characters;
//import java.util.*;
//
//public class NguyenAm2 {
//	public static void main(String[] arg){
//		String msv="b22dcvt525";
//		String qc="minhthang04";
//		try{
//			CharacterService_Service cs = new CharacterService_Sevice();
//			CharacterService port=cs.getCharacterServicePort();
//			List<String> input=port.requestStringArray(msv,qc);
//			Set<Character> set=new HashSet<>(Arrays.asList('a','o','u','i','e','A','O','U','I','E'));
//			Map<Integer,List<String>> mp= new TreeMap<>();
//			for(String w:input){
//				int cnt=0;
//				for(char c:w.toCharArray()){
//					if(set.contains(c)) ++cnt;
//				}
//				mp.computeIfAbsent(cnt,k->new ArrayList<>()).add(w);
//			}
//			List<String> kq=new ArrayList<>();
//			for(Map.Entry<Integer,List<String>> e : mp.entrySet()){
//				List<String> gr=e.getValue();
//				Collections.sort(gr);
//				String rs=String.join(", ",gr);
//				kq.add(rs);
//			}
//			port.submitStringArray(msv,qc,kq);
//		}
//		catch (Exception e){
//			e.printStackTrace();
//		}
//	}
//}
