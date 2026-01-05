package BAITYLECAO.ThuatToan;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SapXepTheoDoDai {
	public static void main(String[] args){
		String[] a={"Java", "C", "Python", "Go"};
		List<String> kq= Arrays.stream(a).sorted(Comparator.comparingInt(String::length)).toList();
		List<String> kq2=Arrays.stream(a).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		String list=String.join(", ",kq);
		System.out.println(list);//C, Go, Java, Python
		//Sx String ngược không phân biệt hoa thường
		Arrays.sort(a,String.CASE_INSENSITIVE_ORDER.reversed());
		/*
		1. Nếu sắp xếp thường (Arrays.sort(names)):
			Nó phân biệt hoa thường (Hoa đứng trước thường theo bảng mã ASCII).
			Kết quả: An, Cường, bình, dung (C đứng trước b vì C hoa).
		2. Nếu dùng String.CASE_INSENSITIVE_ORDER:
			Nó coi b và B như nhau.
			Kết quả: An, bình, Cường, dung (A -> b -> C -> d).
		3. Nếu dùng code của bạn (.reversed()):
			Nó đảo ngược lại kết quả trên.
			Kết quả: dung, Cường, bình, An (d -> C -> b -> A).
		 */
	}
}
