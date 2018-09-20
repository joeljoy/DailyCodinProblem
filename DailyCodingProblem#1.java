//Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Source {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.print(findPairSum(arr, k));
    }

    private static boolean findPairSum(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            int compliment = Math.abs(k - i);
            if (set.contains(compliment)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

}