package task;
import java.util.Scanner;
public class MatrixMutliplication {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int arr1[][]=new int[2][2];
		int arr2[][]=new int[2][3];
		int arr3[][]=new int[2][3];
    
    System.out.println("2x2 Matrix");
		for(int i=0;i<arr1.length;i++) 
    {
			for(int j=0;j<arr1[i].length;j++)
      {
				System.out.println("Enter no for "+i+j+" position");
				arr1[i][j]=s.nextInt();
        }
		}
    
    System.out.println("2x3 Matrix");
		for(int i=0;i<arr2.length;i++)
    {
			for(int j=0;j<arr2[i].length;j++) 
      {
				System.out.println("Enter no for "+i+j+" position");
				arr2[i][j]=s.nextInt();
        }
		}
    
    
		for(int i=0;i<arr1.length;i++) 
    {
			for(int j=0;j<arr2[i].length;j++) 
      {
				for(int k=0;k<arr1.length;k++)
        {
					arr3[i][j]+=arr1[i][k]*arr2[k][j];}
			  	System.out.print(arr3[i][j]+" ");
        }
			    System.out.println();
		}
	}
}