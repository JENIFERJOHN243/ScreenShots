package task;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		int[] result = new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            result[i]=nums[i];
            result[i+nums.length]=nums[i];
        }
        for(int i=0;i<result.length;i++) {
        	System.out.print(result[i]+" ");
        }
	}

}