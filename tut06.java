import java.util.*;
import static utils.InputUtils.*;

public class tut06 {
    public static void main(String[] args) {
        // print("Hello World");
        // int a = intInput("Enter a number: ");
        // print("You entered: " + a);
        // String b = strInput("Enter a string: ");
        // print("You entered: " + b);

        int n = intInput("Enter the number of elements: ");
        int[] c = intArrayInput("Enter " + n + " numbers: ", n);
        print("You entered: " + Arrays.toString(c));

        int number = intInput("Enter a number: ");
        for(int element : c){
            try{
                if(element == number){
                    print("Number found");
                    break;
                }
            }catch(Exception e){
                print("Number not found");
            }
        }

        for(int i=0; i<n; i++){
            try {
                if(c[i] == number){
                    print("index: " + i);
                    break;
                }
            }catch(Exception e){
                print("Number not found");
            }
        }

        
    }
}