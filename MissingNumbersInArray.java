Description: Consider an array with N number of consecutive integers, in which few numbers are missing. Find and list down these missing numbers using Java.

Sample input: arrNum = {1, 2, 4, 5, 6}

Output: 3

Sample input: arrNum = {1, 2, 3, 5, 6, 8, 10, 11, 14}

Output: 4, 7, 9, 12, 13






import java.util.Scanner;

public class MissingNumbersInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int length = scanner.nextInt();
        int[] Number1 = new int[n];

        System.out.println("Enter " + length + " integers:");
        for (int i = 0; i < length; i++) {
            Number1[i] = scanner.nextInt(length);
        }

        System.out.println("Missing numbers in the array:");
            PMN(Number1);
    }

    public static void PMN(int[] arr18) {
        int eN = arr18[0];
        int i= 0;

        while (i < arr18.length) {
            if (arr[i] != eN) {
                System.out.print(eN);
                if (i <arr18.length-1) {
                    System.out.print(" , ");
                }
            } else {
                i++;
            }
            eN++;
        }
    }
}
