import java.util.*;
public class tut05 {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void print(String s){
        System.out.println(s);
    }

    public static int intInput(String s){
        System.err.println(s);
        int result = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline
        return result;
    }

    public static String strInput(String s){
        System.err.println(s);
        return scanner.nextLine();
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        else if(n < 0){
            return -1;
        }
        else{
            int fac = 1;
            while(n>0){
                fac *= n;
                n--;
            }
            return fac;
        }
    }

    public static void main(String[] args) {
        print("Hello World");
        int a = intInput("Enter a number: ");
        print("You entered: " + a);
        String b = strInput("Enter a string: ");
        print("You entered: " + b);


        int c = intInput("Enter a number for factorial: ");
        print("Factorial of " + c + " is " + factorial(c));
    }
}