package java;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MyQueue queue = new MyQueue();
        int k = scanner.nextInt();
        int id;
        String operation;
        for(int i = 0;i < k;i++){
            operation = scanner.next();
            if(operation.equals("enqueue") ){
                id = scanner.nextInt();
                queue.enqueue(id);

            }else if(operation.equals("cancel")){
                id = scanner.nextInt();
                queue.cancel(id);
            }else if(operation.equals("dequeue")){
                System.out.println(queue.dequeue());
            }else if(operation.equals("reverse")){
                queue.reverse();
            }else if(operation.equals("front")){
                System.out.println(queue.front());
            }else if(operation.equals("size")){
                System.out.println(queue.size());
            }
        }
        
    }
}


class MyQueue{
    private Node head;
    private Node tail;
    private int size;

    MyQueue(){
        head = null;
        tail = null;
        size = 0;
    }
    int dequeue(){
        if(size == 0) return -1;
        Node temp = this.head;
        head = head.next;
        int tempValue = temp.value;
        temp = null;
        this.size--;
        return tempValue;
    }

    void enqueue(int value){
        
        Node newNode = new Node(value);
        if(size == 0){
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        size++;
        tail.next = newNode;
        tail = newNode;

    }

    void cancel(int value){
        if (size == 0){
            return;
        }
        Node current = head;
        
        if(current.value == value) {
            head = current.next;
            current = null;
            this.size--;
            return;
        }
        Node prev = head;
        while (current.next != null && current.value != value){
            prev = current;
            current = current.next;
        }
        if (current.next == null){
            if (current.value == value){
                this.size--;
                tail = prev;
                prev.next = null;
                current = null;
                return;
            }else return;
        }
        this.size--;
        prev.next = current.next;
        current = null;
    }

    void reverse(){
        if (size == 0 || size == 1) return;
        Node prev = this.head;
        Node next;
        Node current = this.head.next;
        this.head.next = null;
        while(current.next != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
    }

    int size(){
        return this.size;
    }

    int front(){
        if (size == 0){
            return -1;
        }
        return this.head.value;
    }
}

class Node{
    public int value;
    public Node next;
    Node(int value){
        this.value = value;
        this.next = null;
    }

}