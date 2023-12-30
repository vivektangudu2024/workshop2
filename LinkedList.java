package com.workshop2;



class LinkedList<T> {
     Node<T> head;

    public LinkedList() {
        this.head = null;
    }



    // Append at the end
    public void appendAtLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }


    // Display the linked list
    public void display() {
        Node<T> temp = head;
        if(head == null)System.out.print("List is Empty");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node<T> current = head;
        Node<T> prev = null;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

}
