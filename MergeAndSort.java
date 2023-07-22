package link;
import java.util.Scanner;

public class MergeAndSort {
    // Node class representing individual elements in the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // LinkedList class to perform merging and sorting
    static class LinkedList {
        Node head;

        LinkedList() {
            head = null;
        }

        // Method to merge two linked lists
        void merge(LinkedList list1, LinkedList list2) {
            Node current1 = list1.head;
            Node current2 = list2.head;
            Node merged = null;
            Node tail = null;

            while (current1 != null && current2 != null) {
                if (current1.data <= current2.data) {
                    if (merged == null) {
                        merged = current1;
                        tail = current1;
                    } else {
                        tail.next = current1;
                        tail = tail.next;
                    }
                    current1 = current1.next;
                } else {
                    if (merged == null) {
                        merged = current2;
                        tail = current2;
                    } else {
                        tail.next = current2;
                        tail = tail.next;
                    }
                    current2 = current2.next;
                }
            }

            if (current1 != null) {
                tail.next = current1;
            } else {
                tail.next = current2;
            }

            this.head = merged;
        }

        // Method to perform merge sort on the linked list
        Node mergeSort(Node head) {
            if (head == null || head.next == null) {
                return head;
            }

            Node middle = findMiddle(head);
            Node nextOfMiddle = middle.next;
            middle.next = null;

            Node left = mergeSort(head);
            Node right = mergeSort(nextOfMiddle);

            return mergeSortedLists(left, right);
        }

        Node findMiddle(Node head) {
            Node slowPtr = head;
            Node fastPtr = head;

            while (fastPtr.next != null && fastPtr.next.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }

            return slowPtr;
        }

        Node mergeSortedLists(Node a, Node b) {
            Node result = null;

            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }

            if (a.data <= b.data) {
                result = a;
                result.next = mergeSortedLists(a.next, b);
            } else {
                result = b;
                result.next = mergeSortedLists(a, b.next);
            }

            return result;
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

    // Method to take dynamic input from the user and create a linked list
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
        LinkedList list1 = createLinkedList();
        LinkedList list2 = createLinkedList();

        LinkedList mergedList = new LinkedList();
        mergedList.merge(list1, list2);

        // Performing merge sort on the merged list
        mergedList.head = mergedList.mergeSort(mergedList.head);

        System.out.print("Output: ");
        mergedList.display();
    }
}
