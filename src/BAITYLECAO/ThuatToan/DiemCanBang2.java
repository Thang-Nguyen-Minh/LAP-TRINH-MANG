package BAITYLECAO.ThuatToan;

public class DiemCanBang2 {
	public static void main(String[] args){
		int[] a={-7,2,3,4,7,-9,5,2};
		int totalSum=0;
		for(int x:a) totalSum+=x;
		int sumLeft=0,minDiff=Integer.MAX_VALUE,bestIdx=-1;
		for(int i=0;i<a.length;i++){
			int cur=a[i];
			int sumRight=totalSum-sumLeft-cur;
			int diff=Math.abs(sumLeft-sumRight);
			if(diff<minDiff){
				minDiff=diff;
				bestIdx=i;
			}
			sumLeft+=cur;
		}
		sumLeft=0;
		for(int i=0;i<bestIdx;i++) sumLeft+=a[i];
		int sumRight=0;
		for(int i=bestIdx+1;i<a.length;i++) sumRight+=a[i];
		String kq=minDiff+","+bestIdx+","+sumLeft+","+sumRight;
		System.out.println(kq);
	}
}
