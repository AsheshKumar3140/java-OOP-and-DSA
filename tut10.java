import static utils.InputUtils.*;
import java.util.*;
public class tut10 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 3, 1};
        // arr = intArrayBubbleSort(arr);
        // arr = intArraySelectionSort(arr);
        arr = intArrayInsertionSort(arr);
        print("Sorted array: " + Arrays.toString(arr));
    }
}
