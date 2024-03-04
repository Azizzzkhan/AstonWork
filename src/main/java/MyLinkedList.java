import java.util.LinkedList;

public class MyLinkedList {
    private Node head;

    public MyLinkedList() {
        head = null;

    }

    public class Node {
        public int count;
        public Node next;

        public Node(int count) {
            this.count = count;
            next = null;
        }
    }

    public void add(int count) {
        Node newNode = new Node(count);
        Node currentNode = head;

        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void remove(int count) {
        Node currentNode = head;
        Node previousNode = null;

        while (currentNode.next != null) {

            if (currentNode.count == count) {
                if (currentNode == head) {
                    head = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }

            }


            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void display() {
        Node currentNode = head;

        if (head != null) {
            System.out.print(head.count + " ");
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.print(currentNode.count + " ");
        }
    }
}
