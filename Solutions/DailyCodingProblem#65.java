//Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
//
//        For example, given the following matrix:
//
//        [[1,  2,  3,  4,  5],
//        [6,  7,  8,  9,  10],
//        [11, 12, 13, 14, 15],
//        [16, 17, 18, 19, 20]]

public class DailyCodingProblem {

    private static void printSpriralArray(int[][] arr, int rEnd, int cEnd) {

        int rStart = 0, cStart = 0, i;
        while (rStart < rEnd && cStart < cEnd) {
            for (i = cStart; i < cEnd; ++i) {
                System.out.println(arr[rStart][i]);
            }
            rStart++;

            for (i = rStart; i < rEnd; ++i) {
                System.out.println(arr[i][cEnd - 1]);
            }
            cEnd--;

            if (rStart < rEnd) {
                for (i = cEnd - 1; i >= cStart; --i) {
                    System.out.println(arr[rEnd - 1][i]);
                }
                rEnd--;
            }

            if (cStart < cEnd) {
                for (i = rEnd; i >= rStart; --i) {
                    System.out.println(arr[i][cStart]);
                }
                cStart++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 26}
        };
        printSpriralArray(a, a.length, a[0].length);
    }
}
