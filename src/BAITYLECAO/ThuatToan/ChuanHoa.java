package BAITYLECAO.ThuatToan;

public class ChuanHoa {
	public static void main(String[] args){
		String s = "aabbbcccddaaefgg";
		String kq=chuanHoa(s);
		System.out.println(kq);
	}
	public static String chuanHoa(String s){
		String kq="";
		int cnt=1;
		//Cứ so sánh 2 thg kề nhau, giống thì tăng cnt, không thì cho cả cnt và 2 thg vào kq
		//cnt>1 thì mới cộng vào vì bản thân cnt=1 rồi
		//Mẹo duyệt đến i=s.length() sau đó khi so sánh thêm điều kiện i<s.length() => không phải xử lý thằng cuối
		for(int i=1;i<=s.length();i++){
			if(i<s.length() && s.charAt(i)==s.charAt(i-1)) ++cnt;
			else{
				kq+=s.charAt(i-1);
				if(cnt>1) kq+=cnt;
				cnt=1;
			}
		}
//		kq+=s.charAt(s.length()-1);
//		if(cnt>1) kq+=cnt;
		return kq;
	}
}
