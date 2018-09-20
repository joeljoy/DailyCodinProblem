//Given an array of integers, return a new array such that each element at index i of the new array is the product of
// all the numbers in the original array except the one at i.
//
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
// If our input was [3, 2, 1], the expected output would be [2, 3, 6].

import java.util.Scanner;


public class Source {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = productArray(arr);
        for (int i : res) {
            System.out.print(i + ",");
        }
    }

    private static int[] productArray(int[] arr) {
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] prod = new int[len];

        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = arr[i - 1] * left[i - 1];
        }

        for (int j = len - 2; j >= 0; j--) {
            right[j] = arr[j + 1] * right[j + 1];
        }

        for (int i = 0; i < len; i++) {
            prod[i] = left[i] * right[i];
        }
        return prod;
    }

}