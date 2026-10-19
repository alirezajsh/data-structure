import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 0;i < m;i++){
            
        }
    }
}



class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
    }
}


class LinkList{
    Node head;
    Node tail;
    int size;

    LinkList(int size){
        this.size = size;
        Node prev = new Node(1);
        this.head = prev;
        Node curr;
        for (int i = 1; i < size; i++) {
            curr = new Node(i+1);
            prev.next = curr;
            prev = curr;
        }
        this.tail = prev;
    }
}