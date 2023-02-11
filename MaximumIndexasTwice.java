package task;

public class MaximumIndexasTwice {

	public static void main(String[] args) {
		int[] a = {1,2,6,3,5};
		int max=a[0],index=0,count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>max) {
				max=a[i];
				index=i;
			}
		}
		//System.out.println(max);
		for(int i=0;i<a.length;i++) {
			if(a[i]<=max/2) {
				count++;
			}
		}
		if(count==a.length-1) System.out.println(index);
		else System.out.println(-1);
	}

}
