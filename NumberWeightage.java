
public class NumberWeightage {

    public static boolean square(int num)
{
    double number=Math.sqrt(num);
    if(number-Math.floor(number)==0)
    {
        return true;
    }
    return false;
}
public static boolean multiple(int num)
{
    if(num%4==0&&num%6==0)
        return true;
    else
        return false;
    
}
public static boolean even (int num)
{
    if(num%2==0)
        return true;
    return false;
}
    public static void main(String[] args) {
         int arr[]={49,36,8,10,12};
        int n=arr.length;
        int i=0,j,k,temp,temp1,temp2;
        int res[]=new int[arr.length];
        for(int num:arr)
        {
           temp=0;
           if(square(num))
           {
               temp+=5;
           }
           if(multiple(num))
           {
               temp+=4;
           }
           if(even(num))
           {
               temp+=3;
           }
           res[i]=temp;
           i++;
        }
    
        for(j=0;j<n;j++) {
        	for(k=j+1;k<n;k++) {
        		if(res[j]<res[k]) {
        			temp1=res[j];
        			res[j]=res[k];
        			res[k]=temp1;
        			temp2=arr[j];
        			arr[j]=arr[k];
        			arr[k]=temp2;
        			
        		}
        	}
        }
        for(j=0;j<n;j++) {
        	System.out.print("<"+arr[j]+"," + res[j]+">"+" ");
        }
       
       
            }
    
}