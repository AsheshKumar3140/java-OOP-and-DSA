import static utils.InputUtils.print;
import java.util.ArrayList;
// import java.util.Stack;

class Stack {
    private Node top;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (top == null || top.next == null) {
            top = null;
            return;
        }
        top = top.next;
    }

    public int peek() {
        return top != null ? top.data : -1;
    }

    public void pushAtBottom(int data) {
        if (top == null) {
            push(data);
            return;
        }
        Node newNode = new Node(data);
        Node currNode = top;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void pushAtBottomRecurrsive(int data){
        if(top == null){
            push(data);
            return;
        }
        int top = peek();
        pop();
        pushAtBottomRecurrsive(data);
        push(top);
    }

    public void reverseStack(){
        if(top==null) return;
        int top = peek();
        pop();
        reverseStack();
        pushAtBottom(top);
    }

    public void printInfo() {
        Node temp = top;
        while (temp != null) {
            print("Element : " + temp.data);
            temp = temp.next;
        }
    }

}

class StackUsingArrayList {
    private ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0 ? true : false;
    }

    public void push(int data) {
        list.add(data);
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public int peek() {
        return isEmpty() ? -1 : list.get(list.size() - 1);
    }

    public void pushAtBottom(int data){
        if(isEmpty()){
            push(data);
            return;
        }
        //Recurrsion
        // int top = peek();
        // pop();
        // pushAtBottom(data);
        // push(top);

        list.add(0, data);
    }

    public void reverseStackRecurrsive(){
        if(isEmpty()) return;
        int top = peek();
        pop();
        reverseStackRecurrsive();
        pushAtBottom(top);
    }

    public void printInfo() {
        for (int i = list.size() - 1; i >= 0; i--) {
            print("Element: " + list.get(i));
        }
    }
}

public class tut20 {

    // public static void printStack(Stack<Integer> s) {
    //     for (int i = s.size() - 1; i >= 0; i--) {
    //         print("Element: " + s.get(i));
    //     }
    // }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.printInfo();

        // s.pushAtBottom(40);
        s.pushAtBottomRecurrsive(40);
        s.printInfo();
        s.reverseStack();
        s.printInfo();

        // s.pop();
        // print("Peek: " + s.peek());
        // s.pop();
        // s.pop();
        // print("Peek: " + s.peek());
        // s.printInfo();

        // StackUsingArrayList s = new StackUsingArrayList();
        // print("Is Empty: " + s.isEmpty());
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // s.printInfo();

        // s.pushAtBottom(40);
        // s.printInfo();

        // s.pop();
        // print("Peek: " + s.peek());
        // s.pop();
        // s.pop();
        // print("Peek: " + s.peek());
        // s.printInfo();

        // Stack<Integer> s = new Stack<Integer>();
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // printStack(s);
        // s.pop();
        // print("Peek: " + s.peek());
        // s.pop();
        // print("Peek: " + s.peek());
        // s.pop();
        // printStack(s);
    }
}