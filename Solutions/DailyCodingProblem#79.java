//Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.
//
//        For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.
//


public class DailyCodingProblem {


    private static boolean checkPossibility(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length - 1 && count <= 1; i++) {
            if (a[i] > a[i + 1]) {
                if (i > 0) {
                    if (a[i - 1] <= a[i + 1]) {
                        a[i] = a[i - 1];
                    }
                } else {
                    a[i + 1] = a[i];
                }
            }
            count++;
        }

        return count <= 1;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,2,3};
        System.out.print(checkPossibility(arr));
    }
}
