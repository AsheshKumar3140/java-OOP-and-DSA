package utils;

import java.util.*;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder strbuilder = new StringBuilder();

    public static void print(String s) {
        System.out.println(s);
    }

    public static void printWithoutLine(String s){
        System.out.print(s);
    }

    public static int intInput(String s) {
        print(s);
        try {
            int result = scanner.nextInt();
            scanner.nextLine();
            return result;
        } catch (Exception e) {
            print("Invalid input");
            return intInput(s);
        }
    }

    public static int[] intArrayInput(String s, int n) {
        print(s);
        try {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = scanner.nextInt();
            }
            return result;
        } catch (Exception e) {
            print("Invalid input");
            return intArrayInput(s, n);
        }
    }

    public static int[][] int2DArrrayInput(String s, int r, int c) {
        print(s);
        try {
            int[][] result = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    result[i][j] = scanner.nextInt();
                }
            }
            return result;
        } catch (Exception e) {
            print("Invalid input");
            return int2DArrrayInput(s, r, c);
        }
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String strInput(String s) {
        print(s);
        try {
            String result = scanner.nextLine();
            return result;
        } catch (Exception e) {
            print("Invalid input");
            return strInput(s);
        }
    }

    public static StringBuilder strBuilderInput(String s) {
        print(s);
        try {
            strbuilder.append(scanner.nextLine());
            return strbuilder;
        } catch (Exception e) {
            print("Invalid input");
            return strBuilderInput(s);
        }
    }

    public static StringBuilder strBuilderReverse(StringBuilder sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(sb.length() - i - 1));
            sb.setCharAt(sb.length() - i - 1, temp);
        }
        return sb;
    }

    public static boolean getBit(int n, int pos) {
        int bitMask = 1 << pos;
        if ((n & bitMask) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int setBit(int n, int pos) {
        int bitMask = 1 << pos;
        return n | bitMask;
    }

    public static int clearBit(int n, int pos) {
        int bitMask = ~(1 << pos);
        return n & bitMask;
    }

    public static int updateBit(int n, int pos, int bit) {
        if (bit == 0) {
            n = clearBit(n, pos);
        } else {
            n = setBit(n, pos);
        }
        return n;
    }

    public static int[] intArrayBubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] += arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }
        return arr;
    }

    public static int[] intArraySelectionSort(int[] arr) {
        // 5, 4, 2, 3, 1
        // 1, 4, 2, 3, 5
        // 1, 2, 4, 3, 5
        // 1, 2, 3, 4, 5
        // 1, 2, 3,
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            if (smallest != i) {
                arr[smallest] += arr[i]; // arr[smallest] = 4, arr[i] = 4, arr[smallest] = 8 smallest == i, arr[i] = 8
                arr[i] = arr[smallest] - arr[i]; // i=4, 8 - 8 = 0
                arr[smallest] = arr[smallest] - arr[i]; // smallest = 0 - 0 = 0
                // int temp = arr[smallest];
                // arr[smallest] = arr[i];
                // arr[i] = temp;
            }
        }
        return arr;
    }

    public static int[] intArrayInsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        return arr;
    }
}
