//Given a list of integers, return the largest product that can be made by multiplying any three integers.
//
//        For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

public class DailyCodingProblem {


    private double findLargestProduct(int[] a) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE, thirdLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = a[i];
            } else if (a[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = a[i];
            } else if (a[i] > thirdLargest) {
                thirdLargest = a[i];
            }

            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i] < secondSmallest) {
                secondSmallest = a[i];
            }
        }

        return Math.max((largest * secondLargest * thirdLargest), (smallest * secondSmallest * largest));
    }

    public static void main(String[] args) {
        int[] a = {1, -4, 3, -6, 7, 0};

        DailyCodingProblem problem = new DailyCodingProblem();
        System.out.println(problem.findLargestProduct(a));
    }
}
