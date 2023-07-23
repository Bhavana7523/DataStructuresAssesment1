Description: Consider an array with N number of consecutive integers, in which few numbers are missing. Find and list down these missing numbers using Java.

Sample input: arrNum = {1, 2, 4, 5, 6}

Output: 3

Sample input: arrNum = {1, 2, 3, 5, 6, 8, 10, 11, 14}

Output: 4, 7, 9, 12, 13


import java.util.*;
	public class MNr {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			int length=sc.nextInt();
			int arrNum1[]=new int[length];
			for(int i=0;i<length;i++) {
				arrNum1[i]=sc.nextInt();
				
			}
			int num1=arrNum1[0];
			for(int i=1;i<length;i++) {
				num1=num1+1;
				if(arrNum1[i]==num1) {
					continue;
				}
				else {
					int difference=arrNum1[i]-num1+1;
					if(difference>1) {
						while(difference>1) {
							System.out.print(num1+" ");
							num1=num1+1;
							difference--;
						}
						
					}
					else {
						System.out.print(num1+" ");
						num1=arrNum1[i];
					}
								
				}
				
			}
			

		}

	}


			
					
