package task;

public class LargestFact  
{  
// assuming that the digits of the factorial of a  
// number can not exceed 400.  
// If the digits of the output, which is the factorial   
// of a large number exceeds 400, then change the   
// number accordingly.  
int result[] = new int[400];  
  
// a method that finds the factorial of  
// the large numbers and then   
// returns the number of digits present in the factorial  
public int factorial(int num)  
{  
// Initialize the result  
result[0] = 1;  
int resultSize = 1;  
  
// Applying the simple formula of factorial   
// f! = 1 x 2 x 3 x 4 ... x f  
for (int f = 2; f <= num; f++)  
{  
resultSize = multiply(f, result, resultSize);  
}  
  
return resultSize;  
}  
  
// The following method multiplies x with the number  
// represented by the result[] array. resultSize is the size of the result[] array   
// or the number of digits resent in the number that is represented by result[].  
// The method uses the basic school mathematics for  
// the multiplication. The method may increase the value of resultSize  
// and returns a new value of the resultSize  
static int multiply(int y, int result[], int resultSize)  
{  
int c = 0; // Initializing the carry  
// performing the basic multiplication  
// and updating the result array  
for (int j = 0; j < resultSize; j++)  
{  
int product = result[j] * y + c;  
result[j] = product % 10; // Storing the last digit of  
        // 'product' in the result[] array  
c = product / 10; // Put the rest in c  
}  
// Putting the carry in the result[] array and increase the result size resultSize  
while (c != 0)  
{  
result[resultSize] = c % 10;  
c = c / 10;  
resultSize = resultSize + 1;  
}  
return resultSize;  
}  
// main method  
public static void main(String argvs[])  
{  
int num = 110;  
// creating an object of the class LargeNumFact  
LargeNumFact obj = new LargeNumFact();  
// storing the result of the method factorial()  
int resSize = obj.factorial(num);  
System.out.println("The factorial of the number " + num + " is: ");  
// printing the result  
for(int j = resSize - 1; j >= 0; j--)  
{  
System.out.print(obj.result[j]);  
}  
}  
}  







/ important import statement  
import java.math.BigInteger;  
  
public class LargeNumFact2   
{  
  
// Returning the Factorial of num  
public BigInteger factorial(int num)  
{  
// Initializing the result  
// by instantiating the BigInteger class   
BigInteger bi = new BigInteger("1");   
  
// Multiplying bi with 2, then 3, then 4, ..., then num  
for (int j = 2; j <= num; j++)  
{  
bi = bi.multiply(BigInteger.valueOf(j));  
}  
  
return bi;  
}  
  
// main method  
public static void main(String argvs[]) throws Exception  
{  
int num = 110;  
  
// creating an object of the class LargeNumFact2  
LargeNumFact2 obj = new LargeNumFact2();  
  
// storing the answer   
BigInteger bi = obj.factorial(num);  
  
System.out.println("The factorial of the number " + num + " is: " + " \n" + bi);  
}  
}  