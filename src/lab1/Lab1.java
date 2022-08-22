package lab1;

/**
 * SDET University
 *
 * Lab 1 – Basics of Programming
 *
 * There are 3 lab assignments that will demonstrate your ability to understand and apply basic concepts of programming, arrays, functions, and data manipulation.
 *
 * Questions for this assignment
 * 1. Write a function that takes a value n returns the sum of numbers 1 to n
 *
 * 2. Write a function that computes the factorial value
 * Definition: n! = n*(n-1)! , where 0! = 1
 * 1! = 1
 * 2! = 2 * 1! = 2 * 1
 * 3! = 3 * 2! = 3 * 2 * 1! = 3 * 2 * 1
 * 4! = 4 * 3! = 4 * 3 * 2! = 4 * 3 * 2 * 1! = 4 * 3 * 2 * 1
 * Hint: use the recursive method that was used to calculate Fibonnaci number
 *
 * 3. Write 3 functions that take an array as a parameter and return the minimum, average, and maximum values of that array.
 * Hint: this should be static functions with a return type of the same data type as the array declaration.
 */

public class Lab1 {

    public static int sumOfNToOne(int n) {
        if (n <= 0) return 0;
        return n + sumOfNToOne(n - 1);
    }

    public static int factorial(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static double avg(double[] arr) {
        double sum = 0;

        for (double n : arr) {
            sum += n;
        }
        return sum / arr.length;
    }

}
