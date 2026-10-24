import java.util.Scanner;


public class Main{
    public static void main(String[] main){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        DoublyLinkList dlln = new DoublyLinkList();
        DoublyLinkList dllm = new DoublyLinkList();
        for (int i = 0;i < n;i++){
            dlln.add(scanner.nextInt());
        }
        for(int i = 0;i < m;i++){
            dllm.add(scanner.nextInt());
        }
        Node ptrn = dlln.head;
        Node ptrm = dllm.head;
        Node start, x;
        Node temp1 = null, temp2 = null;
        while(ptrn.next.value < ptrn.value){
            ptrn = ptrn.next;
        }
        start = ptrn;
        while(ptrm.next.value < ptrm.value){
            ptrm = ptrm.next;
        }
        while(ptrm.next != ptrm){
            if(ptrn.value > ptrm.value) {
                temp1 = ptrn.prev;
                temp2 = ptrm.next;
                ptrn.prev = ptrm;
                ptrm.next.prev = ptrm.prev;
                ptrm.prev.next = ptrm.next;
                ptrm.prev = temp1;
                temp1.next = ptrm;
                ptrm.next = ptrn;
                ptrm = temp2;
                start = ptrn;
            }else if(ptrn.value == ptrm.value){
                ptrn.value++;
                temp2 = ptrm.next;
                ptrm.next.prev = ptrm.prev;
                ptrm.prev.next = ptrm.next;
                ptrm = null;
                ptrm = temp2;
                while(ptrn.next.value == ptrn.value){
                    ptrn.prev.next = ptrn.next;
                    ptrn.next.prev = ptrn.prev;
                    ptrn = ptrn.next;
                    ptrn.value++;
                }
            }else{
                temp1 = ptrn.next;
                temp2 = ptrm.next;
                ptrn.next = ptrm;
                ptrm.next.prev = ptrm.prev;
                ptrm.prev.next = ptrm.next;
                ptrm.prev = ptrn;
                ptrm.next = temp1;
                temp1.prev = ptrm;
                ptrm = temp2;
                ptrn = ptrn.next;
            }
            
            
        }
        if(ptrn.value > ptrm.value) {
            temp1 = ptrn.prev;
            temp2 = ptrm.next;
            ptrn.prev = ptrm;
            ptrm.prev = temp1;
            temp1.next = ptrm;
            ptrm.next = ptrn;
        }else if(ptrn.value == ptrm.value){
            ptrn.value++;
        }else{
            temp1 = ptrn.next;
            temp2 = ptrm.next;
            ptrn.next = ptrm;
            ptrm.prev = ptrn;
            ptrm.next = temp1;
            temp1.prev = ptrm;
        }

        System.out.print(start.value + " ");
        ptrm = start.next;
        while(ptrm != start){
            System.out.print(ptrm.value + " ");
            ptrm = ptrm.next;
        }
        System.out.println();
        System.out.print(start.value + " ");
        ptrm = start.prev;
        while(ptrm != start){
            System.out.print(ptrm.value + " ");
            ptrm = ptrm.prev;
        }
        System.out.println();
    }
}

class Node{
    int value;
    Node prev;
    Node next;
    Node(int value){
        this.value = value;
    }
}

class DoublyLinkList{
    Node head;
    Node tail;
    int size;

    void add(int value){
        Node newNode = new Node(value);
        if(tail == null){
            head = newNode;
            tail = newNode;
            head.prev = tail;
            tail.next = head;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        head.prev = tail;
        tail.next = head;
    }


    void remove(Node node){
        node.prev.value++;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
    }
    
}