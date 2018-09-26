//Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
//
//        For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.


import java.util.Scanner;

public class PowerSet {


    private static int findMissingPositiveInteger(int[] a) {
        int size = 0;
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                size++;
                sum += a[i];
            }
        }

        int n = size + 1;
        int actualSum = (n * (n + 1)) / 2;
        return actualSum - sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(findMissingPositiveInteger(arr));
    }
}
