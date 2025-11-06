import static utils.InputUtils.*;
import java.util.*;
public class tut08 {
    public static void main(String[] args) {
        // String s = strInput("Enter a string: ");
        // print("You entered: " + s);

        // String s1 = "Bashu";
        // String s2 = "Aashu";
        // if(s1.compareTo(s2) == 0){
        //     print("Strings are equal");
        // }
        // else if(s1.compareTo(s2) > 0){
        //     print(s2 + " " + s1);
        // }
        // else{
        //     print(s1 + " " + s2);
        // }

        
        // String str1 = "Hello Aashu";
        // print(str1.substring(6));


        // String number = "32";
        // int convertedNumber = Integer.parseInt(number);
        // print("you entered: " + ((Object)convertedNumber).getClass().getSimpleName());


        //String Builder Class 
        StringBuilder sb = strBuilderInput("Enter a string: ");
        print("You entered: " + sb);
        // sb.setCharAt(1, 'A');
        // print("You entered: " + sb);
        // sb.insert(0, "Hello ");
        // print("You entered: " + sb);
        // sb.delete(0, 6);
        // print("You entered: " + sb);


        sb = strBuilderReverse(sb);

        print("You entered: " + sb);
    }
}

