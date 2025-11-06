import static utils.InputUtils.*;
import java.util.*;

public class tut13 {

    public static void printPermutations(String str, int index, String permutations, boolean[] used) {
        if (index == str.length()) {
            print("Permutation: " + permutations);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                printPermutations(str, index + 1, permutations + str.charAt(i), used);
                used[i] = false; // Backtrack
            }
        }
    }

    public static void printPermutations(String str, String permutations) {
        if(str.length() == 0){
            print("Permutation: " + permutations);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char currentChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPermutations(newStr, permutations + currentChar);
        }
    }

    public static int countPaths(int i, int j, int n, int m){
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(i == n || j == m){
            return 0;
        }

        return countPaths(i+1, j, n, m) + countPaths(i, j+1, n, m);
    }

    public static void main(String[] args) {
        // String str = strInput("Enter a string: ");
        // boolean[] used = new boolean[str.length()];
        // // printPermutations(str, 0, "", used);
        // printPermutations(str, "");

        int n = intInput("Enter the number of rows: ");
        int m = intInput("Enter the number of columns: ");
        print("Number of paths: " + countPaths(0, 0, n, m));
    }
}
