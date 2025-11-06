import java.util.*;

public class tut03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello World");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a == b) {
            System.out.println("Equal");
        } else {
            if (a > b) {
                System.out.println("A is greater");
            } else {
                System.out.println("B is greater");
            }
        }


        if(a == b){
            System.out.println("Equal");
        }
        else if(a > b){
            System.out.println("A is greater");
        }
        else{
            System.out.println("B is greater");
        }

        switch(a){
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            default:
                System.out.println("Invalid");
                break;
        }

        sc.close();
    }
}