package task;

import java.util.Arrays;

public class SortArrayWithPowers {

	public static void main(String[] args) {
		int[] nums = { -2, 1, 3, 4, 5};
		int pow = 2;
		int[] answer = new int[nums.length];
		int start =0, end=(nums.length)-1,index=(answer.length)-1;
        while(start<=end){
            if(Math.abs(nums[start])>Math.abs(nums[end])){
                answer[index--]=nums[start]*nums[start];//*nums[start];
                start++;
            }else{
                answer[index--]=nums[end]*nums[end];//*nums[end];
                end--;
            }
        }
        System.out.println(Arrays.toString(answer));
	}

}
