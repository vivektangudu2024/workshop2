package com.workshop2;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();


        list.display();

        list.appendAtLast(16);
        list.appendAtLast(42);
        list.appendAtLast(31);


        System.out.print("Original List: ");
        list.display();

        list.reverse();

        list.appendAtLast(45);
        list.appendAtLast(22);
        System.out.print("reversed list: ");
        list.display();


    }
}
