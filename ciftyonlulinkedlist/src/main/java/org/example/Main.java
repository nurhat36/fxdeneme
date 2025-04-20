package org.example;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtBeginning(5);
        dll.insertAtPosition(15, 3);
        dll.insertAtPosition(25, 5);
        dll.display();
        dll.deleteNode(15);
        dll.display();
    }
}