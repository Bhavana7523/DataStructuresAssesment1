import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int freq=0;
        int length=sc.nextInt();
        int arr1[] = new int[length];
        
        for( int a=0;a<length;a++)
        {
            arr1[a]=sc.nextInt();
        }
        for(int b=0;b<length;b++)
        {
            int total=0;
           for(int k=b;k<length;k++)
           {
              total+=arr1[k];
              if(total<0)
              {
                  freq++;
              } 
           } 
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        System.out.println(freq);
    }
}
