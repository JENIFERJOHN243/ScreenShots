package task;

import java.util.*;

public class TwoCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        int maxPattern = 0;
        
        if(s.length() == 1)
        {
            System.out.println(maxPattern);
            return;
        }
        
        for(int i = 0; i < 26; i++)
        {
            nextLetter:
            for(int j = i + 1; j < 26; j++)
            {
                char one = (char) ('a' + i); 
                char two = (char) ('a' + j); 
                char lastSeen = '\u0000';
                int patternLength = 0;
                
                for(char letter : s.toCharArray())
                {
                    if(letter == one || letter == two)
                    {
                        if(letter == lastSeen)
                        {
                            continue nextLetter;
                        }
                        patternLength++;
                        lastSeen = letter;
                    }
                }
                maxPattern = (patternLength > maxPattern) ? patternLength : maxPattern;    
            }
        }       
        System.out.println(maxPattern);   
    }
}
