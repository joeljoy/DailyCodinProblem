//Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.
//
//        Do this in linear time and in-place.
//
//        For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].


import java.util.Scanner;

public class Source {

    private static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static char[] sortRgb(char[] arr) {
        int l = 0, m = 0, h = arr.length - 1;
        while (m <= h) {
            switch (arr[m]) {
                case 'R':
                    swap(arr, l, m);
                    l++;
                    m++;
                    break;
                case 'G':
                    m++;
                    break;
                case 'B':
                    swap(arr, m, h);
                    m++;
                    h--;
                    break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();

        for (char e :
                sortRgb(arr)) {
            System.out.print(e);
        }
    }
}
