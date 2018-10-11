//A number is considered perfect if its digits sum up to exactly 10.
//
//        Given a positive integer n, return the n-th perfect number.
//
//        For example, given 1, you should return 19. Given 2, you should return 28.

public class DailyCodingProblem {


    private int findNthPerfectNumber(int a) {
        int count = 0;

        for (int currNum = 19; ; currNum += 9) {
            int sum = 0;
            for (int x = currNum; x > 0; x = x / 10) {
                sum = sum + x % 10;
            }

            if (sum == 10) {
                count++;
            }

            if (count == a) {
                return currNum;
            }
        }
    }

    public static void main(String[] args) {
        DailyCodingProblem problem = new DailyCodingProblem();
        System.out.println(problem.findNthPerfectNumber(2));
    }
}
