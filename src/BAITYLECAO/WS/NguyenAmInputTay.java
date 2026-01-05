package BAITYLECAO.WS;

import java.lang.reflect.Array;
import java.util.*;

public class NguyenAmInputTay {
	public static void main(String[] args){
		String[] input={"banana","grape","kiwi","apple","egg"};
		Set<Character> set=new HashSet<>(Arrays.asList('a','u','i','o','e','A','U','I','O','E'));
		Map<Integer,List<String>> mp=new TreeMap<>();
		for(String w:input){
			int cnt=0;
			for (char c:w.toCharArray()){
				if(set.contains(c)) ++cnt;
			}
			mp.computeIfAbsent(cnt,k->new ArrayList<>()).add(w);
		}
		List<String> kq=new ArrayList<>();
		for (Map.Entry<Integer,List<String>> e : mp.entrySet()){
			List<String> gr=e.getValue();
			Collections.sort(gr);
			String rs=String.join(", ",gr);
			kq.add(rs);
		}
		System.out.println(kq);
	}
}
