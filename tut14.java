import static utils.InputUtils.*;

import java.util.*;

public class tut14 {
    public static int placeTiles(int n, int m){
        if(n == m){
            return 2;
        }
        if(n < m){
            return 1;
        }
        return placeTiles(n-1, m) + placeTiles(n-m, m);
    }

    public static int countWays(int n){
        if(n <= 1){
            return 1;
        }
        return countWays(n-1) + ((n-1) * countWays(n-2));
    }

    public static void findSubsets(int n, ArrayList<Integer> subset){
        if(n == 4){
            print("Subset: " + Arrays.toString(subset.toArray()));
            return;
        }
        subset.add(n);
        findSubsets(n+1, subset);
        subset.remove(subset.size()-1);
        findSubsets(n+1, subset);
    }

    public static void main(String[] args) {
        // int n = intInput("Enter the length of the board: ");
        // int m = intInput("Enter the length of the tile: ");
        // print("Number of ways to place the tiles: " + placeTiles(n, m));
        // int n = intInput("Enter the number of guests: ");
        // print("Number of ways to climb the guests: " + countWays(n));

        int n = intInput("Enter the number of elements: ");
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(1, subset);
    }
} 
