package BAITYLECAO.ThuatToan;

public class TongGanNhatVoiTarget {
	public static void main(String[] args){
		int[] a={2,3,4,9,10,11};
		int sum=0,n=a.length;
		for(int x:a) sum+=x;
		double tbc=(double) sum/n;
		double target=tbc*2;
		int n1=0,n2=0;
		int di=Integer.MAX_VALUE;
		double minDiff=Double.MAX_VALUE;
		for(int i = 0;i<n;i++){
			for(int j=i+1;j<n;j++){
				int x=a[i],y=a[j];
				double diff=Math.abs(x+y-target);
				int dii=Math.abs(x-y);
				if(diff<minDiff){
					minDiff=diff;
					n1=x;
					n2=y;
				}
				else if(diff==minDiff){
					if(dii<di){
						di=dii;
						n1=x;
						n2=y;
					}
				}
			}
		}
		int min=Math.min(n1,n2);
		int max=Math.max(n1,n2);
		System.out.println(target);
		System.out.println(min+";"+max);
	}
}
