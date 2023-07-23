Question 1: Cumulative Multiple of an Array with exception handling
Skill Mapping: Basic
Description: Consider an Array with N number of integers.
Task 1- WAP in Java to calculate cumulative multiple at each index.
Task 2 – Push the result into the same Array and Print.
Task 3 - Handle the exceptions in program
Sample input: arrNum = [5, 3, 4, 2, 0, 8]


import java.util.Scanner;

public class CMA{
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Task 1: Read input array
            System.out.print("Enter the number of elements in the array: ");
            int length = scanner.nextInt();
            int[] array18 = new int[length];

            System.out.println("Enter " + length + " integers:");
            for (int i = 0; i < length; i++) {
                array18[i] = scanner.nextInt();
            }

            // Task 2: Calculate cumulative multiple and push into the same array
            int multiple = 1;
            for (int i = 0; i < length; i++) {
                multiple*= array18[i];
                array18[i] = multiple;
            }

            // Task 3: Print the resulting array
            System.out.println("\nResulting array with cumulative multiples:");
            for (int i = 0; i < length; i++) {
                System.out.print(array18[i] + " ");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
