import static utils.InputUtils.print;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Stack;

// class Queue {
//     static int arr[];
//     int size;
//     static int rear = -1;
//     Queue(int n){
//         arr = new int[n];
//         this.size = n;
//     }
//     public boolean isEmpty(){
//         return rear == -1;
//     }
//     public boolean isFull(){
//         return rear == size-1;
//     }
//     public void enqueue(int data){
//         if(isFull()){
//             return;
//         }
//         arr[++rear] = data;
//     }
//     public void dequeue(){
//         if(isEmpty()) return;
//         for(int i=0; i<rear; i++){
//             arr[i] = arr[i+1];
//         }
//         rear--;
//     }
//     public int front(){
//         return rear!=-1 ? arr[0] : -1;
//     }
//     public void printInfo(){
//         for(int i=0; i<=rear; i++){
//             print("index" + i + " : " + arr[i]);
//         }
//     }
// }

class CircularQueue{
    public static int arr[];
    int size;
    static int rear = -1;
    static int front = -1;
    CircularQueue(int n){
        arr = new int[n];
        size = n;
    }
    public boolean isEmpty(){
        return rear == -1;
    }
    public boolean isFull(){
        return (rear + 1) % size == front;
    }
    public void enqueue(int d){
        if(isFull()) return;
        else if(isEmpty()) front++;
        arr[(rear+1)%size] = d;
        rear = (rear+1) % size;
    }
    public void dequeue(){
        if(isEmpty()) return;
        if(rear == front){
            rear = front = -1;
            return;
        }
        front = (front + 1) % size;
    }
    public int front(){
        return arr[front];
    }
    public void printInfo(){
        if(isEmpty()){
            print("Queue is empty");
            return;
        }
        int temp = front;
        int count = (rear >= front) ? (rear - front + 1) : (size - front + rear + 1);
        for(int i=0; i<count; i++){
            print("Element: " + arr[temp]);
            temp = (temp+1) % size;
        }
    }
}

class QueueLL{
    public Node rear;
    public Node front;
    QueueLL(){
        rear = null;
        front = null;
    }
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    public boolean isEmpty(){
        return rear == null && front == null;
    }

    public void enqueue(int d){
        Node temp = new Node(d);
        if (isEmpty()) {
            rear = temp;
            front = temp;
            return;
        }
        rear.next = temp;
        rear = rear.next;
    }

    public void dequeue(){
        if(isEmpty()) return;
        front = front.next != null? front.next : null;
    }

    public void printInfo(){
        Node curr = front;
        while(curr!=null){
            print("Element: " + curr.data);
            curr = curr.next;
        }
    }
}

class QueueWithStack{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public boolean isEmpty(){
        return s1.isEmpty();
    }
    public void enqueue(int d){
        while (!isEmpty()) {
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(d);
        while(!s2.isEmpty()){
            s1.push(s2.peek());
            s2.pop();
        }
    }
    public void dequeue(){
        if (s1.isEmpty()) return;
        s1.pop();
    }
    public void printInfo(){
        for(int i = s1.size()-1; i>=0; i--){
            print("Element at index " + i + ": " + s1.get(i));
        }
    }
}

public class tut21 {
    // public static void printInfo(Queue q){
    //     while (!q.isEmpty()) {
    //         print("element: " + q.peek());
    //         q.remove();
    //     }
    // }
    public static void main(String[] args) {

        // Queue q = new Queue(3);
        // q.enqueue(0);
        // q.enqueue(1);
        // q.enqueue(2);
        // q.enqueue(3);
        // q.printInfo();
        // q.dequeue();
        // q.dequeue();
        // q.printInfo();
        // print("Top : " + q.front());


        // CircularQueue cq = new CircularQueue(4);
        // cq.enqueue(0);
        // cq.enqueue(1);
        // cq.enqueue(2);
        // cq.enqueue(3);
        // // cq.enqueue(4);
        // cq.printInfo();

        // cq.dequeue();
        // cq.printInfo();

        // cq.enqueue(4);
        // cq.dequeue();
        // cq.dequeue();
        // cq.dequeue();
        // cq.dequeue();
        // print("front: " + cq.front + "rear: " + cq.rear);
        // cq.dequeue();
        // cq.printInfo();


        // QueueLL q = new QueueLL();
        // q.enqueue(1);
        // q.enqueue(2);
        // q.enqueue(3);
        // q.printInfo();
        // q.dequeue();
        // q.printInfo();
        // q.rear.next = q.front;
        // q.printInfo();


        // Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // printInfo(q);

        QueueWithStack q = new QueueWithStack();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.printInfo();
        q.dequeue();
        q.printInfo();

    }
}
