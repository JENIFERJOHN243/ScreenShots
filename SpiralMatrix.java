package task;

import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
      
      int a[][] = { { 1,   2,  3, 4 },
                    { 14, 15, 16, 5 },
                    { 13, 20, 17, 6 },
                    { 12, 19, 18, 7 },
                    { 11, 10, 9,  8 }};
      int b[][] = new int[5][4];
      int value=1;
     
       int rowStart = 0, rowEnd = b.length;
       int colStart = 0, colEnd = b[0].length;
       
       while(rowStart < rowEnd && colStart < colEnd)
       {
         //print top row (left to right)
         for(int i= colStart;i<colEnd;i++) {
        	 b[rowStart][i]=value++;
             System.out.print(a[rowStart][i]+ " ");
         }        
          rowStart+=1;
           
         //print right column (top to bottom)
         for(int i=rowStart;i<rowEnd;i++) {
        	 b[i][colEnd - 1]=value++; 
           System.out.print(a[i][colEnd - 1] + " ");
       }
          colEnd-=1;
          
         // print bottom row (right to left)
         for(int i = colEnd - 1;i >= colStart;i--) {
        	 b[rowEnd - 1][i]=value++; 
             System.out.print(a[rowEnd - 1][i] + " ");
       }
          rowEnd-=1;
           
          // print left column (bottom to top)
          for(int i = rowEnd - 1;i >= rowStart;i--) {
        	  b[i][colStart]=value++;
              System.out.print(a[i][colStart]+ " ");
       }
          colStart+=1;
          
       }
       for (int i = 0; i<b.length; i++) {
    	    for (int j = 0; j<b[0].length; j++) {
    	        System.out.print(b[i][j]+" ");
    	   }
    	    System.out.println();
    	}

       System.out.println(Arrays.deepToString(b));
    }
}