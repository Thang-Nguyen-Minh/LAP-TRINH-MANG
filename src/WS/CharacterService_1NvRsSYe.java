//package WS;
//import java.util.*;
//public class CharacterService_1NvRsSYe {
//	public static void main(String[] args){
//		String stc="B22DCVT525";
//		String qc="1NvRsSYe";
//		try{
//			CharacterService_Service cs=new CharacterService_Service();
//			CharacterService port=cs.getCharacterServicePort();
//			//Solve
//			List<String> a=port.requestStringArray(stc,qc);
//			System.out.println(a);
//			Map<Integer,List<String>> mp=new TreeMap<>();
//			Set<Character> se=new HashSet<>(Arrays.asList(
//					'a','u','o','i','e','A','U','O','I','E'
//			));
//			for(String w:a){
//				int cnt=0;
//				for(char c:w.toCharArray()){
//					if(se.contains(c)) ++cnt;
//				}
//				mp.computeIfAbsent(cnt, k->new ArrayList<>()).add(w);
//			}
//			List<String> kq=new ArrayList<>();
//			for(Map.Entry<Integer,List<String>> e:mp.entrySet()){
//				List<String> group=e.getValue();
//				Collections.sort(group);
//				String rs=String.join(", ",group);
//				kq.add(rs);
//			}
//			System.out.println(kq);
//			//submit
//			port.submitCharacterStringArray(stc, qc, kq);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//}
