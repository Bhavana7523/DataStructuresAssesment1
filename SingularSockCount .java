Description: Consider data with assorted details of socks pair IDs. Each element in the array represents a number of similar pairs. You will have to find out how many singular socks are present which do not have any pair left.

Sample input: arrNum = {10, 20, 20, 10, 10, 30, 50, 10, 20}

Output: Count of singular socks = 3




import java.util.Scanner;

public class SingularSockCount {
	
	    public static int singularSocks(int[] arr) {
	        int sc= 0;
	        int[] socks = new int[200]; // Assuming sock IDs range from 1 to 100

	        // Count the occurrences of each sock pair ID
	        for (int num : arr) {
	            socks[num]++;
	        }

	        // Find the count of singular socks
	        for (int count : socks) {
	            sc += count % 2;
	        }

	        return sc;
	    }

	    public static void main(String[] args)
	    {
	    	Scanner sc=new Scanner(System.in);
	    	try {
	    		int n=sc.nextInt();
	    		int arr[]=new int[n];
	    		for(int i=0;i<n;i++) {
	    			arr[i]=sc.nextInt();
	    			
	    		}
	    		int count = singularSocks(arr);
	    		System.out.println("Count of singular socks = " + count);
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    	}
	    }
}
