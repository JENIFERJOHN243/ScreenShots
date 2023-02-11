package task;

public class CountTheGap {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		int k = 3,sum=0;
		for(int i=0;i<a.length;i=i+k) {
//			int j=i,sum=0;
//			while(j<a.length) {
//				sum+=a[j];
//				j+=k;
//			}
			
			sum+=a[i];
			
		System.out.print(sum+" ");	
		}
		
//		StringBuffer sb = new StringBuffer();
//		StringBuilder ss = new StringBuilder();
	}
}
