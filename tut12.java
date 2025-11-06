import static utils.InputUtils.*;

import java.util.*;

public class tut12 {
    static int first = -1;
    static int last = -1;
    static int[] arr = new int[26];
    static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 1){
            print("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        print("Transfer disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n-1, helper, src, dest);
    }

    public static StringBuilder stringReverse(StringBuilder sb, int index, StringBuilder newStr){
        if(index >= sb.length()){
            print("Index is greater than length of string");
            return newStr;
        }
        if(index == -1){
            return newStr;
        }
        newStr.append(sb.charAt(index));
        return stringReverse(sb, index-1, newStr);
    }

    public static int[] stringOccurrence(StringBuilder sb, int index, char c){
        if(index == -1){
            return new int[]{first, last};
        }
        if(sb.charAt(index) == c && last == -1){
            last = index;
            first = index;
        }
        else if(sb.charAt(index) == c && last != -1){
            first = index;
        }
        return stringOccurrence(sb, index-1, c);
    }

    public static boolean isStrictlyIncreasing(int[] arr, int index){
        if(index >= arr.length-1){
            return true;
        }
        if(arr[index] >= arr[index+1]){
            return false;
        }
        return isStrictlyIncreasing(arr, index+1);
    }

    public static StringBuilder moveAllX(StringBuilder sb, int index, StringBuilder newStr, int c, char c1){
        if(index == sb.length()){
            for(int i=0; i<c; i++){
                newStr.append(c1);
            }
            return newStr;
        }
        if(sb.charAt(index) == c1){
            c++;
        }
        else{
            newStr.append(sb.charAt(index));
        }
        return moveAllX(sb, index+1, newStr, c, c1);
    }

    public static StringBuilder removeDuplicates(StringBuilder sb, int index, StringBuilder newStr){
        if(index == sb.length()){
            return newStr;
        }
        if(arr[sb.charAt(index) - 'a'] == 0){
            newStr.append(sb.charAt(index));
            arr[sb.charAt(index) - 'a'] = 1;
        }
        return removeDuplicates(sb, index+1, newStr);

    }

    public static void printSubstrings(StringBuilder sb, int index, StringBuilder newStr){
        if(index == sb.length()){
            print("Substring: " + newStr);
            return;
        }
        
        // Include current character
        newStr.append(sb.charAt(index));
        printSubstrings(sb, index+1, newStr);
        
        // Backtrack: remove the character we just added
        newStr.deleteCharAt(newStr.length() - 1);
        
        // Exclude current character
        printSubstrings(sb, index+1, newStr);
    }

    public static void printSubstrings(StringBuilder sb, int index, StringBuilder newStr, HashSet<String> set){
        if(index == sb.length()){
           if(!set.contains(newStr.toString())){
            print("Substring: " + newStr);
            set.add(newStr.toString());
           }
           return;
        }
        
        // Include current character
        newStr.append(sb.charAt(index));
        printSubstrings(sb, index+1, newStr, set);
        
        // Backtrack: remove the character we just added
        newStr.deleteCharAt(newStr.length() - 1);
        
        // Exclude current character
        printSubstrings(sb, index+1, newStr, set);
    }

    public static void keypadCombinations(String digits, int index, String combinations){

        if(index == digits.length()){
            print("Combination: " + combinations);
            return;
        }
        char currentDigit = digits.charAt(index);
        String currentCombinations = keypad[currentDigit - '0'];
        for(int i=0; i<currentCombinations.length(); i++){
            keypadCombinations(digits, index+1, combinations + currentCombinations.charAt(i));
        }
    }

    public static void main(String[] args) {
        // int n = intInput("Enter the number of disks: ");
        // towerOfHanoi(n, "Source", "Helper", "Destination");

        // StringBuilder sb = strBuilderInput("Enter a string: ");
        // print("You entered: " + stringReverse(sb, sb.length()-1, new StringBuilder()));

        // int[] arr = stringOccurrence(sb, sb.length()-1, 'a');
        // print("First occurrence: " + arr[0] + " Last occurrence: " + arr[1]);

        // int[] arr = intArrayInput("Enter the elements of the array: ", 5);
        // print("Is strictly increasing: " + isStrictlyIncreasing(arr, 0));

        // StringBuilder sb = strBuilderInput("Enter a string: ");
        // print("You entered: " + moveAllX(sb, 0, new StringBuilder(), 0, 'x'));
    
        // StringBuilder sb = strBuilderInput("Enter a string: ");
        // print("You entered: " + removeDuplicates(sb, 0, new StringBuilder()));

        // StringBuilder sb = strBuilderInput("Enter a string: ");
        // printSubstrings(sb, 0, new StringBuilder(), new HashSet<String>());

        String digits = strInput("Enter the digits: ");
        keypadCombinations(digits, 0, "");
    }
}
