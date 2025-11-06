import static utils.InputUtils.*;
import java.util.LinkedList;

public class tut19 {
    private int size = 0;
    tut19(){size = 0;}
    static class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    public void addFirst(String data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(String data){
        Node newNode = new Node(data);
        Node currNode = head;
        size++;
        if(head == null){
            head = newNode;
            return;
        }
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public void printList(){
        Node currNode = head;
        while (currNode!=null) {
            printWithoutLine(currNode.data + " -> ");
            currNode = currNode.next;
        }
        print("NULL");
    }
    public void deleteFirst(){
        if(head==null){
            print("Linked list is empty");
            return;
        }
        size--;
        head = head.next;
    }
    public void deleteLast(){
        if(head == null){
            print("Linked list is empty"); return;
        }
        size--;
        Node currNode = head;
        if(currNode.next == null){
            head = null;
        }
        while (currNode.next.next != null) {
            currNode = currNode.next;
        }
        currNode.next = null;
    }
    public void getSize(){
        print("Size: " + this.size);
    }
    public void reverseIterative(){
        if(head == null || head.next == null){
            return;
        }
        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        while(curr.next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        head = curr;
    }
    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public void deleteNthNode(int n){
        int size = this.size;
        if(n<1 || n > size){
            print("Index is greater than size of linked list");
            return;
        }
        if(n == size){
            head = head.next;
            size--;
            return;
        }
        int indexToDelete = size - n;
        Node currNode = head;
        Node prevNode = null;
        for(int i=0; i<indexToDelete; i++){
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = currNode.next;
        size--;

    }
    public Node getMiddleNode(Node head){
        // for(int i=0; i<size/2; i++){
        //     head = head.next;
        // }
        // return head;

        Node hare = head;
        Node turtle = head;
        while(hare.next!=null && hare.next.next!=null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }
    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node middleNode = getMiddleNode(head);
        Node secondHalfStart = reverseRecursive(middleNode.next);
        Node firstHalfStart = head;
        while(secondHalfStart != null){
            if(firstHalfStart.data != secondHalfStart.data){
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
    public boolean isCycle(){
        if(head == null || head.next == null){
            return false;
        }
        Node hare = head;
        Node turtle = head;
        while(hare!=null && hare.next!=null){
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare == turtle){
                return true;
            }
        }
        return false;
    }
    public void removeCycle(){
        // Step 1: Detect if cycle exists using Floyd's algorithm
        Node hare = head;
        Node turtle = head;
        boolean hasCycle = false;
        
        while(hare!=null && hare.next!=null){
            hare = hare.next.next;  // Hare moves 2 steps
            turtle = turtle.next;   // Turtle moves 1 step
            if(hare == turtle){
                hasCycle = true;
                break;  // They met! Cycle detected
            }
        }
        
        if(!hasCycle){
            return;  // No cycle to remove
        }
        
        // Step 2: Find where the cycle starts
        // Move turtle back to head, keep hare at meeting point
        // Move both one step at a time - they'll meet at cycle start
        turtle = head;
        while(turtle != hare){
            turtle = turtle.next;
            hare = hare.next;  // Now both move 1 step at a time
        }
        // Now turtle and hare are both at the cycle start node
        
        // Step 3: Break the cycle
        // Find the last node in the cycle (the one pointing to cycle start)
        Node cycleStart = turtle;  // This is where cycle starts
        Node lastNode = cycleStart;
        while(lastNode.next != cycleStart){
            lastNode = lastNode.next;
        }
        // Break the link - set the last node's next to null
        lastNode.next = null;
    }



    public static void main(String[] args){
        tut19 LL = new tut19();
        // LL.addFirst("is");
        // LL.addFirst("This");
        // LL.printList();
        // LL.getSize();
        // LL.addLast("a");
        // LL.addLast("Linked List");
        // LL.addLast("Temp");
        // LL.addFirst("Temp");
        // LL.printList();
        // LL.getSize();
        // LL.deleteFirst();
        // LL.deleteLast();
        // LL.printList();
        // LL.getSize();

        // LL.reverseIterative();
        // LL.head = LL.reverseRecursive(LL.head);
        // LL.deleteNthNode(1);


        // LL.addFirst("a");
        // LL.addLast("b");
        // LL.addLast("c");
        // LL.addLast("b");
        // LL.addLast("a");
        // LL.printList();
        // if(LL.isPalindrome(LL.head)){
        //     print("Linked list is a palindrome");
        // }
        // else{
        //     print("Linked list is not a palindrome");
        // }
        // LL.printList();


        LL.addFirst("a");
        LL.addLast("b");
        LL.addLast("c");
        LL.addLast("b");
        LL.addLast("a");
        LL.head.next.next.next.next.next = LL.head.next;
        // LL.printList();
        if(LL.isCycle()){
            print("Linked list is a cycle");
        }
        else{
            print("Linked list is not a cycle");
        }
        LL.removeCycle();
        if(LL.isCycle()){
            print("Linked list is a cycle");
        }
        else{
            print("Linked list is not a cycle");
        }
        LL.printList();

        //Collections framwork linked list
        // LinkedList<String> LL = new LinkedList<String>();
        // LL.addFirst("is");
        // LL.addFirst("This");
        // print("List: " + LL);
        // print("Size: " + LL.size());
        // LL.addLast("a");
        // LL.add("Linked List");
        // LL.addLast("Temp");
        // LL.addFirst("Temp");
        // print("List: " + LL);
        // print("Size: " + LL.size());
        // // LL.removeFirst();
        // LL.remove(0);
        // LL.removeLast();
        // print("List: " + LL);
        // print("Size: " + LL.size());

    }
}
