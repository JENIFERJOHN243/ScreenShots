package task;

import java.util.Arrays;

public class LonelyNumber {

	public static void main(String[] args) {
		int[] nums = {1,3,5,3,7};
		//ArrayList<Integer> list = new ArrayList<>();
		int len = nums.length;
		int[] array = new int[nums.length];
		int index=0;
		Arrays.sort(nums);
		for(int i=0;i<len;i++) {
            if((i == 0 || (nums[i - 1] != nums[i] - 1 && nums[i] != nums[i-1])) && (i == len - 1 || (nums[i] + 1 != nums[i + 1] && nums[i] != nums[i+1]))){
            	array[index++]=nums[i];
            }
			}
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0) {
				System.out.print(array[i]+" ");
			}
		} 
		}
	}
