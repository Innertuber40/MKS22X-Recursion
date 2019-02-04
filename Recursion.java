// Math for the absolute value function and ArrayList because it is absolutely necessary
import java.lang.Math;
import java.util.ArrayList;

public class Recursion {
    // to make the javadoc better
    private Recursion(){}

    /**
     * Finds the square root of a given number by constantly bringing a guess of one closer and closer to the actual square root
     * by changing the guess to the average of the guess and the quotient of the original number and that guess, within
     * a specified range of error.
     * @param n The number to be square-rooted
     * @param tolerance The percent error allowed for the calculation
     * @return The square root of the input
     * @throws IllegalArgumentException If the number entered is negative, and thus can't be used
     */
    public static double sqrt(double n, double tolerance) {
        if (n == 0.0) {
            return 0;
        }
        if (n < 0.0) {
            throw new IllegalArgumentException("You can't take the square root of a negative number like " + n + '.');
        }
        return sqrtCompare(n, 1.0, tolerance / 100.0);
    }
    private static double sqrtCompare(double n, double g, double t) {
        if (Math.abs(n - g*g) / n <= t) {
            return g;
        }
        return sqrtCompare(n, (n/g + g) / 2, t);
    }

    /**
     * Displays the value of the Fibonacci sequence at a specified index
     * @param n The index of the Fibonacci number desired
     * @return The value of the Fibonacci sequence at n
     */
    public static int fib(int n) {
        return fibber(n, 0, 1);
    }
    private static int fibber(int n, int oneB, int twoB) {
        if (n == 0) {
            return oneB;
        }
        return fibber(n - 1, twoB, oneB + twoB);
    }

    /**
     * Returns an ArrayList containing all the possible sums that can be made using any combination of the values
     * 1 to a given value (works on negatives).
     * @param n The number furthest from 0 that you can add to the sum
     * @return An ArrayList containing all possible sums
     */
    public static ArrayList<Integer> makeAllSums(int n) {
        ArrayList<Integer> returns = new ArrayList<Integer>();
        return allSums(n, returns, 0);
    }
    private static ArrayList<Integer> allSums(int n, ArrayList<Integer> returns, int sum) {
        int direction = -1;
        if (n < 0) {
            direction = 1;
        }
        if (n == 0) {
            returns.add(sum);
            if (returns.get(0) < 0) {
                returns.add(sum + 1);
            }
            return returns;
        }
        allSums(n + direction, returns, sum + n);
        return allSums(n + direction, returns, sum);
    }

    /**
     * The main method; runs when the program is run, for testing
     * @param args Arguments that can be passed into the main at the command line, to no avail in this case
     */
    public static void main(String[] args) {
        System.out.println(sqrt(0, 0.000001));
        System.out.println(sqrt(1, 0.000001));
        System.out.println(sqrt(100, 0.000001));
        System.out.println(sqrt(2, 0.000001));
        System.out.println(sqrt(0.25, 0.000001));
        try {
            sqrt(-1, 0.000001);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(40));
        System.out.println(makeAllSums(3));
        System.out.println(makeAllSums(6));
        System.out.println(makeAllSums(0));
        System.out.println(makeAllSums(2));
        System.out.println(makeAllSums(1));
        System.out.println(makeAllSums(-1));
        System.out.println(makeAllSums(-3));
    }
}