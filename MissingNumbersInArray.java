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
        int n = scanner.nextInt();
        int[] arrNum = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arrNum[i] = scanner.nextInt();
        }

        System.out.println("Missing numbers in the array:");
        findAndPrintMissingNumbers(arrNum);
    }

    private static void findAndPrintMissingNumbers(int[] arr) {
        int expectedNumber = arr[0];
        int index = 0;

        while (index < arr.length) {
            if (arr[index] != expectedNumber) {
                System.out.print(expectedNumber);
                if (index <arr.length-1) {
                    System.out.print(" , ");
                }
            } else {
                index++;
            }
            expectedNumber++;
        }
    }
}
