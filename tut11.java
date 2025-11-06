import static utils.InputUtils.*;
import java.util.*;
public class tut11 {

    public static int sum(int n){
        if(n == 0){
            return 0;
        }
        return n + sum(n-1);
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void fibonacciSeries(int a, int b, int currentIndex, int maxIndex){
        if(currentIndex >= maxIndex){
            print("F(" + currentIndex + ") = " + a);
            return;
        }
        print("F(" + currentIndex + ") = " + a);
        fibonacciSeries(b, a + b, currentIndex + 1, maxIndex);
    }

    public static int powern(int x, int n){
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        return x * powern(x, n-1);
    }

    public static int calcPow(int x, int n){
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n%2 == 0){
            return calcPow(x, n/2) * calcPow(x, n/2);
        }
        else{
            return calcPow(x, n/2) * calcPow(x, n/2) * x;
        }
    }

    public static void main(String[] args) {
        int n = intInput("Enter a number: ");
        print("Sum till " + n + " is " + sum(n));
        print("Factorial of " + n + " is " + factorial(n));
        print("Fibonacci of " + n + " is " + fibonacci(n));
        
        // Print Fibonacci series
        // print("Fibonacci series up to " + n + " terms:");
        // for(int i = 0; i <= n; i++){
        //     print("F(" + i + ") = " + fibonacci(i));
        // }
    
        print("Fibonacci series up to " + n + " terms:");
        fibonacciSeries(0, 1, 0, n);

        print("Power of 2 ^ " + n + " is " + powern(2, n));
        print("Power of 2 ^ " + n + " is " + calcPow(2, n));
    }
}