package BAITYLECAO.ThuatToan;

public class DiemCanBang {
	public static void main(String[] args){
		int[] a={-7, 1, 5, 2, -4, 3, 0};
		int sum=0;
		for(int x:a) sum+=x;
		int minDiff=Integer.MAX_VALUE;
		int bestIdx=-1;
		int sumLeft=0;
		//Ở mỗi bước bỏ đi phần tử a[i], sau đó tính toán lại cho đến khi tìm ra min
		//Mục tiêu vòng lặp là tìm bestIdx và minDiff
		for(int i=0;i<a.length;i++){
			int cur=a[i];
			int sumRight=sum-sumLeft-cur;//Bỏ phần tử ở a[i];
			int diff=Math.abs(sumLeft-sumRight);
			if(diff<minDiff){
				minDiff=diff;
				bestIdx=i;
			}
			sumLeft+=cur;//Cập nhật sumLeft cho bước sau
		}
		sumLeft=0;
		for(int i=0;i<bestIdx;i++) sumLeft+=a[i];
		int sumRight=0;
		for(int i=bestIdx+1;i<a.length;i++) sumRight+=a[i];
		String result = bestIdx + "," + sumLeft + "," + sumRight + "," + minDiff;
		System.out.println(result);
	}
}
