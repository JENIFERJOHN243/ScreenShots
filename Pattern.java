package task;


import java.util.Scanner;
class Pattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = s.nextLine();
        int size = str.length();
        int i,j;
        for(i=0;i<size;i++)
        {
            for(j=0;j<size;j++)
            {
                if(i==j){
                    System.out.print(str.charAt(j));
                }
                else if((i+j==size-1)&&i!=j)
                {
                    System.out.print(str.charAt(j));
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

                