package BAITYLECAO.ThuatToan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SxTheoDoDai2 {
	public static void main(String[] arg){
		String[] s = {"java","python","c","C++"};
		//Sắp xếp theo thứ tự xuất hiện và độ dài
		List<String> kq = Arrays.stream(s).sorted(Comparator.comparingInt(String::length)).toList();
		//Sắp xếp String ngược không phân biệt hoa thường
		Arrays.sort(s,String.CASE_INSENSITIVE_ORDER.reversed());
		System.out.println(kq);
		for(String x:s) System.out.println(x);
	}
}
