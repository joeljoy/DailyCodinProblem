//Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.
//
//        Do this faster than the naive method of repeated multiplication.
//
//        For example, pow(2, 10) should return 1024.

import java.util.Scanner;

public class DailyCodingProblem {

    private Integer pow(int a, int b) {
        if (b < 0) {
            return 1;
        }
        int res = a;
        for (int i = 1; i < b; i++) {
            res = multiply(res, a);
        }
        return res;
    }

    private int multiply(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        DailyCodingProblem problem = new DailyCodingProblem();
        System.out.print(problem.pow(a, b));
    }
}
