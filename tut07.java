import static utils.InputUtils.*;
import java.util.*;

public class tut07 {
    public static void main(String[] args) {
       int r = intInput("Enter number of rows: ");
       int c = intInput("Enter number of columns: ");
       int[][] arr = int2DArrrayInput("Enter the elements of the array: ", r, c);
       print2DArray(arr);
    //    print("Elements of the array: " + Arrays.toString(arr[0]));


        int element = intInput("Enter the element to search: ");
        boolean found = false;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(arr[i][j] == element){
                    print("Element found at index: " + i + ", " + j);
                    found = true;
                    break;
                }
            }
        }
        if(!found){
            print("Element not found");
        }
    }
}
