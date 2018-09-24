//Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.
//
//        For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.
//
//        Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DailyCodingProblem {

    private int[][] partition(int[] arr) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        int lSum = arr[0], rSum = arr[r];
        int[] lArr = new int[arr.length], rArr = new int[arr.length];
        int[][] res = new int[2][arr.length];
        lArr[0] = arr[l];
        rArr[0] = arr[r];
        int i = 0, j = 0;
        while (l <= r) {
            if (lSum < rSum) {
                lSum += arr[++l];
                lArr[++i] = arr[l];
            } else if (lSum > rSum) {
                rSum += arr[--r];
                rArr[++j] = arr[r];
            } else {
                res[0] = lArr;
                res[1] = rArr;
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DailyCodingProblem problem = new DailyCodingProblem();
        int[][] res = problem.partition(arr);
        if (res != null) {
            for (int i = 0; i < res.length; i++) {
                System.out.print("{");
                for (int j = 0; j < res[i].length; j++) {
                    if (res[i][j] != 0)
                        System.out.print(res[i][j] + ", ");
                }
                System.out.print("}");
                if (i != res.length - 1) {
                    System.out.print(" and ");
                }
            }
        }else {
            System.out.print("False");
        }
    }
}
