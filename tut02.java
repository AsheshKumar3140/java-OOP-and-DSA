import java.util.*;

class tut02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //output
        System.out.print("Hello World with java\n");
        System.out.println("Hello World with java");
        System.out.printf("Hello World with java\n I am Ashesh\n");


        //Variables
        int a = 10;
        int b = 20;
        int sum = a + b;
        int diff = a - b;
        int mul = a * b;
        int div = a / b;
        int mod = a % b;
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(mul);
        System.out.println(div);
        System.out.println(mod);

        System.out.println("Enter you name: ");
        String name = sc.nextLine();
        System.out.println("Hello " + name);
    }
}