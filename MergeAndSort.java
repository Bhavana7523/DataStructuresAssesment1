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
            Node c1 = list1.head;
            Node c2 = list2.head;
            Node mer = null;
            Node tail = null;

            while (c1 != null && c2 != null) {
                if (c1.data <= c2.data) {
                    if (mer == null) {
                        mer = c1;
                        tail = c1;
                    } else {
                        tail.next = c1;
                        tail = tail.next;
                    }
                    c1 = c1.next;
                } else {
                    if (mer == null) {
                        mer = c2;
                        tail = c2;
                    } else {
                        tail.next = c2;
                        tail = tail.next;
                    }
                    c2 = c2.next;
                }
            }

            if (c1 != null) {
                tail.next = c1;
            } else {
                tail.next = c2;
            }

            this.head = mer;
        }

        // Method to perform merge sort on the linked list
        Node mS(Node head) {
            if (head == null || head.next == null) {
                return head;
            }

            Node middle = fM(head);
            Node nextOfMiddle = middle.next;
            middle.next = null;

            Node left = mS(head);
            Node right = mS(nextOfMiddle);

            return mergeSortedLists(left, right);
        }

        Node fM(Node head) {
            Node sP = head;
            Node fP = head;

            while (fP.next != null && fP.next.next != null) {
                sP = sP.next;
                fP = fP.next.next;
            }

            return sP;
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
        mergedList.head = mergedList.mS(mergedList.head);

        System.out.print("Output: ");
        mergedList.display();
    }
}
