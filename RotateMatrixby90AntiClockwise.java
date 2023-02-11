package task;

import java.util.Arrays;

public class RotateMatrixby90AntiClockwise {

	public static void main(String[] args) {
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		//System.out.println(Arrays.deepToString(a));
		
		System.out.println("Clockwise");
		
		for (int i = 0; i < a.length; i++)
        {
            for (int j = a[0].length- 1; j >= 0; j--)
                System.out.print(a[j][i] + " ");
            System.out.println();
        }
		
		System.out.println("Anti-Clockwise");
		
		for (int i =a.length-1; i>=0; i--)
        {
            for (int j = 0; j <a[0].length; j++)
                System.out.print(a[j][i] + " ");
            System.out.println();
        }
	}

}
