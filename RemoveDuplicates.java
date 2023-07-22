package link;
import java.util.Scanner;

public class RemoveDuplicates {
    // Node class representing individual elements in the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // LinkedList class to perform operations
    static class LinkedList {
        Node head;

        LinkedList() {
            head = null;
        }

        // Method to remove duplicates from the linked list
        void removeDuplicates() {
            if (head == null) {
                return;
            }

            Node current = head;
            while (current != null) {
                Node runner = current;
                while (runner.next != null) {
                    if (runner.next.data == current.data) {
                        runner.next = runner.next.next;
                    } else {
                        runner = runner.next;
                    }
                }
                current = current.next;
            }
        }

        // Method to display the linked list
        void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + "->");
                current = current.next;
            }
            System.out.print("null");
        }
    }

    // Method to create a linked list with the given elements
    static LinkedList createLinkedList() {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        System.out.print("Enter the elements separated by spaces: ");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (list.head == null) {
                list.head = newNode;
            } else {
                Node current = list.head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        LinkedList linkedList = createLinkedList();

        System.out.print("Input Linked-List: ");
        linkedList.display();

        linkedList.removeDuplicates();

        System.out.print("\nOutput Linked-List after removing duplicates: ");
        linkedList.display();
    }
}
